package api.users;

import api.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import utils.client.ReqresClient;
import utils.data.ReqresResponsePath;

import java.sql.SQLException;

import static api.DBUtils.sqlGetRow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AddUserTest extends BaseTest {

    @Test
    void createSuccess() throws SQLException {
        String userLogin = RandomStringUtils.randomAlphanumeric(10);
        assertNull(sqlGetRow("select * from users where login = '" + userLogin + "'").get("login"));

        AddUserRequestModel body = new AddUserRequestModel(userLogin, "2");
        ValidatableResponse response = ReqresClient.addUser(body);
        assertEquals(200, response.extract().statusCode());
        assertEquals("2", response.extract().path(ReqresResponsePath.PASSWORD));
        assertEquals(userLogin, response.extract().path("login"));

        assertEquals(userLogin, sqlGetRow("select * from users where login = '" + userLogin + "'").get("login"));
    }
}
