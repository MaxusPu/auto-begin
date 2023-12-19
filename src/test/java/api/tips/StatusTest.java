package api.tips;

import api.BaseTest;
import io.qameta.allure.Link;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import utils.client.TipsClient;
import utils.data.TipsResponcePath;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdata.UserData.*;

public class StatusTest extends BaseTest {

    @Test
    @Link("69654")
    void getStatusRegistered() throws SQLException {

        StatusRequestModel body = new StatusRequestModel(REGISTERED.getProfileId());
        ValidatableResponse response = TipsClient.status(body);
        assertEquals(REGISTERED.getQrUuid(), response.extract().path(TipsResponcePath.RECEIVER_CODE));
        assertEquals("REGISTERED", response.extract().path(TipsResponcePath.STATUS));
    }

    @Test
    @Link("69655")
    void getStatusRegisteredWithoutCard() throws SQLException {

        StatusRequestModel body = new StatusRequestModel(REGISTERED_WITHOUT_CARD.getProfileId());
        ValidatableResponse response = TipsClient.status(body);
        assertEquals(REGISTERED_WITHOUT_CARD.getQrUuid(), response.extract().path(TipsResponcePath.RECEIVER_CODE));
        assertEquals("REGISTERED_WITHOUT_CARD", response.extract().path(TipsResponcePath.STATUS));
    }

    @Test
    @Link("69656")
    void getStatusNotRegistered() throws SQLException {

        StatusRequestModel body = new StatusRequestModel(NOT_REGISTERED.getProfileId());
        ValidatableResponse response = TipsClient.status(body);
        assertEquals(NOT_REGISTERED.getQrUuid(), response.extract().path(TipsResponcePath.RECEIVER_CODE));
        assertEquals("NOT_REGISTERED", response.extract().path(TipsResponcePath.STATUS));
    }
}
