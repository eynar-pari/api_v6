package basicRestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicRestAssured2 {

  /*
  * given() --> headers()
  *             body()
  *             parameters()
  *             logs
  *             authentication
  *             cookies
  * when()  --> get / post / put /delete ....
  *             url (string) url base + endpoint
  *
  * then()  --> verificacion / extraccion de datos
  *             status
  *             body
  *             headers
  *             msg respuesta
  *             time
  *             schema
  *             logs
  * */

    @Test
    public void createProject() {

        given().
                auth().
                preemptive().
                basic("ucb2026@ucb2026.com","12345")
                .body("{\n" +
                        "  \"Content\":\"RestAssured01\",\n" +
                        "  \"Icon\":5\n" +
                        "}")
                .log()
                .all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("RestAssured01"))
                .body("Icon",equalTo(5));

    }


    @Test
    public void createProject2() {

        Response response=given().
                                auth().
                                preemptive().
                                basic("ucb2026@ucb2026.com","12345")
                                .body("{\n" +
                                        "  \"Content\":\"RestAssured01\",\n" +
                                        "  \"Icon\":5\n" +
                                        "}")
                                .log()
                                .all()
                        .when()
                                .post("https://todo.ly/api/projects.json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("RestAssured01"))
                .body("Icon",equalTo(5));

        int idProject= response.then().extract().path("Id");
        int icon= response.then().extract().path("Icon");
        System.out.println("idProject: "+idProject);
        System.out.println("icon: "+icon);

    }

}
