package api.login;

import api.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import utils.client.ReqresClient;
import utils.data.ReqresResponsePath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdata.UserData.SHAGAL;

public class LoginTest extends BaseTest {

    @Test
    void loginUserNotFoundError(){
        LoginRequestModel body = new LoginRequestModel(SHAGAL.getEmail(), SHAGAL.getPassword());
        ValidatableResponse response = ReqresClient.login(body);
        assertEquals(400, response.extract().statusCode());
        assertEquals("user not found", response.extract().path(ReqresResponsePath.ERROR));
    }
}
