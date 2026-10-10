package basicRestAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BasicRestAssured {

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
                        "  \"Icon\":4\n" +
                        "}")
                .log()
                .all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log()
                .all();
    }


}
