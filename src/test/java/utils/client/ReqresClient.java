package utils.client;

import api.BaseTest;
import api.Endpoint;
import api.reqres.create.CreateRequestModel;
import api.reqres.login.LoginRequestModel;
import api.users.AddUserRequestModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static api.BaseRequestSpecification.reqresSpec;
import static api.BaseRequestSpecification.usersSpec;
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

    @Step("добавление пользователя .../users")
    public static ValidatableResponse addUser(AddUserRequestModel body) {
        return given().spec(usersSpec)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(Endpoint.ADD_USER)
                .then();
    }

}
