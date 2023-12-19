package utils.client;

import api.BaseTest;
import api.Endpoint;
import api.tips.StatusRequestModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static api.BaseRequestSpecification.tipsSpec;
import static io.restassured.RestAssured.given;

public class TipsClient extends BaseTest {

    @Step("получение статуса .../status")
    public static ValidatableResponse status(StatusRequestModel body) {
        return given().spec(tipsSpec)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(Endpoint.STATUS)
                .then();
    }
}
