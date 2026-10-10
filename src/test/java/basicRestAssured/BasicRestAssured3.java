package basicRestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class BasicRestAssured3 {


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
                .body("Icon",equalTo(5))
                .body(matchesJsonSchemaInClasspath("createProjectSchema1.json"));

        int idProject= response.then().extract().path("Id");
        int icon= response.then().extract().path("Icon");
        System.out.println("idProject: "+idProject);
        System.out.println("icon: "+icon);

    }

}
