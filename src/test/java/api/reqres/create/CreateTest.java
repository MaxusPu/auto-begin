package api.reqres.create;

import api.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import utils.client.ReqresClient;
import utils.data.ReqresResponsePath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdata.UserData.SHAGAL;

public class CreateTest extends BaseTest {

    @Test
    void createSuccess(){
        CreateRequestModel body = new CreateRequestModel(SHAGAL.getName(), SHAGAL.getJob());
        ValidatableResponse response = ReqresClient.create(body);
        assertEquals(201, response.extract().statusCode());
        assertEquals("mark", response.extract().path(ReqresResponsePath.NAME));
        assertEquals("shagal", response.extract().path(ReqresResponsePath.JOB));
    }
}
