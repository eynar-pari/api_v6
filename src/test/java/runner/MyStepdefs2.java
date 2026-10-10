package runner;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs2 {
    Response response;
    int idProject;
    @Given("tengo acceso a Todo.ly")
    public void tengoAccesoATodoLy() {
    }

    @When("envio POST request {string} con el body")
    public void envioPOSTRequestConElBody(String url, String body) {
         response=given().
                        auth().
                        preemptive().
                        basic("ucb2026@ucb2026.com","12345")
                        .body(body)
                        .log()
                        .all()
                  .when()
                         .post(url);
        response.then().log().all();
    }

    @Then("el codigo deberia ser {int}")
    public void elCodigoDeberiaSer(int expectedCode) {
        response.then()
                 .statusCode(expectedCode);
    }

    @And("el nombre del project deberia ser {string}")
    public void elNombreDelProjectDeberiaSer(String expectedName) {
        response.then()
                .body("Content",equalTo(expectedName));
    }

    @And("guardo el id en ID_PROJECT")
    public void guardoElIdEnID_PROJECT() {
        idProject= response.then().extract().path("Id");
    }

    @When("envio GET request {string}")
    public void envioGETRequest(String url) {
        response=given().
                        auth().
                        preemptive().
                        basic("ucb2026@ucb2026.com","12345")
                        .log()
                        .all()
                .when()
                        .get(url.replace("ID_PROJECT",idProject+""));
        response.then().log().all();
    }

    @When("envio PUT request {string} con el body")
    public void envioPUTRequestConElBody(String url, String body) {
        response=given().
                        auth().
                        preemptive().
                        basic("ucb2026@ucb2026.com","12345")
                        .body(body)
                        .log()
                        .all()
                .when()
                     .put(url.replace("ID_PROJECT",idProject+""));
        response.then().log().all();
    }

    @When("envio DELETE request {string}")
    public void envioDELETERequest(String url) {
        response=given().
                    auth().
                    preemptive().
                    basic("ucb2026@ucb2026.com","12345")
                    .log()
                    .all()
                .when()
                    .delete(url.replace("ID_PROJECT",idProject+""));

        response.then().log().all();
    }
}
