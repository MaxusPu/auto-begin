package api.create;

import api.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import utils.client.ReqresClient;
import utils.data.ReqresResponsePath;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTest extends BaseTest {

    @Test
    void createSuccess(){
        api.create.CreateRequestModel body = new api.create.CreateRequestModel("karl","shagal");
        ValidatableResponse response = ReqresClient.create(body);
        assertEquals(201, response.extract().statusCode());
        assertEquals("karl", response.extract().path(ReqresResponsePath.NAME));
        assertEquals("shagal", response.extract().path(ReqresResponsePath.JOB));
    }
}
