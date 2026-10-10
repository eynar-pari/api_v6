package runner;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    /*
    * {} ---> reemplazar cualquier valor de texto
    * {word}----> reemplazar una palabra de texto -> sin espacios
    * {int} ----> valor numerico entero
    * {string}---> reemplaza un valor que se encuentre en comillas dobles "valor"
    * {float}
    * {double}
    * */


    @Given("I have access to {}")
    public void iHaveAccessToFacebook(String app) {

    }

    @When("I enter my email: {word}")
    public void iEnterMyEmailFakeFakeCom(String email) {

    }

    @And("I enter my password: {int}")
    public void iEnterMyPassword(int password) {

    }

    @Then("I {string} be logged in successfully")
    public void iShouldBeLoggedInSuccessfully(String value) {

    }

    @And("the message should be displayed")
    public void theMessageShouldBeDisplayed(String value) {
        System.out.println(value);
    }
}
