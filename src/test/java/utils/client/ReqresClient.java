package utils.client;

import api.BaseTest;
import api.Endpoint;
import api.create.CreateRequestModel;
import api.login.LoginRequestModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static api.BaseRequestSpecification.reqresSpec;
import static io.restassured.RestAssured.given;

public class ReqresClient extends BaseTest {

    @Step("создание УЗ .../api/create")
    public static ValidatableResponse create(CreateRequestModel body) {
        return given().spec(reqresSpec)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(Endpoint.CREATE)
                .then();
    }

    @Step("авторизация .../api/login")
    public static ValidatableResponse login(LoginRequestModel body) {
        return given().spec(reqresSpec)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(Endpoint.LOGIN)
                .then();
    }

}
