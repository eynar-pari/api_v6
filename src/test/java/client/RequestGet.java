package client;

import config.Configuration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGet implements IRequest{
    @Override
    public Response send(RequestInfo info) {
        return given()
                    .auth()
                    .preemptive()
                    .basic(Configuration.USER,Configuration.PASSWORD)
                    .log()
                    .all()
                .when()
                    .get(info.getUrl());
    }
}
