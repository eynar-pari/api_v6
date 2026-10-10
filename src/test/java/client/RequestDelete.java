package client;

import config.Configuration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestDelete implements IRequest{
    @Override
    public Response send(RequestInfo info) {
        return given()
                    .auth()
                    .preemptive()
                    .basic(Configuration.USER,Configuration.PASSWORD)
                    .log()
                    .all()
                .when()
                    .delete(info.getUrl());
    }
}
