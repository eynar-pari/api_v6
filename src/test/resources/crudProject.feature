Feature: Project
  Scenario:  CRUD Project

    Given tengo acceso a Todo.ly
    #create
    When envio POST request "https://todo.ly/api/projects.json" con el body
    """
    {
      "Content":"CucumberAPI"
    }
    """
    Then el codigo deberia ser 200
    And el nombre del project deberia ser "CucumberAPI"
    And guardo el id en ID_PROJECT
    #read
    When envio GET request "https://todo.ly/api/projects/ID_PROJECT.json"
    Then el codigo deberia ser 200
    And el nombre del project deberia ser "CucumberAPI"

    #update
    When envio PUT request "https://todo.ly/api/projects/ID_PROJECT.json" con el body
    """
    {
      "Content":"CucumberAPIUpdate"
    }
    """
    Then el codigo deberia ser 200
    And el nombre del project deberia ser "CucumberAPIUpdate"

    #delete
    When envio DELETE request "https://todo.ly/api/projects/ID_PROJECT.json"
    Then el codigo deberia ser 200
    And el nombre del project deberia ser "CucumberAPIUpdate"