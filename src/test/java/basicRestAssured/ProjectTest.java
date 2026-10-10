package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectTest {



    @Test
    public void crudProject() {
        // Create Project - POST
        JSONObject body = new JSONObject();
        body.put("Content","RestAssured01");
        body.put("Icon",5);

        Response response=given().
                                auth().
                                preemptive().
                                basic("ucb2026@ucb2026.com","12345")
                                .body(body.toString())
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

        // Leer Project - GET
        response=given().
                        auth().
                        preemptive().
                        basic("ucb2026@ucb2026.com","12345")
                        .log()
                        .all()
                .when()
                         .get("https://todo.ly/api/projects/" + idProject + ".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("RestAssured01"))
                .body("Icon",equalTo(5));

        // Actualizacion - PUT
        body.put("Content","Updated");
        response=given().
                        auth().
                        preemptive().
                        basic("ucb2026@ucb2026.com","12345")
                        .log()
                        .all()
                        .body(body.toString())
                .when()
                    .put("https://todo.ly/api/projects/" + idProject + ".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("Updated"))
                .body("Icon",equalTo(5));

        // Eliminacion - DELETE
        response=given().
                        auth().
                        preemptive().
                        basic("ucb2026@ucb2026.com","12345")
                        .log()
                        .all()
                .when()
                       .delete("https://todo.ly/api/projects/" + idProject + ".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("Updated"))
                .body("Icon",equalTo(5))
                .body("Deleted",equalTo(true));

    }

}
