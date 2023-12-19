package api.tips;

import api.BaseTest;
import io.qameta.allure.Link;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.client.TipsClient;
import utils.data.TipsResponcePath;

import java.sql.SQLException;

import static api.DBUtils.sqlGetRow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest extends BaseTest {

    @Test
    @Link("69654")
    void getStatusRegistered() throws SQLException {
        String profileId = sqlGetRow("select * from employee_profile p join sbertips_worker sw on p.profile_id = sw.profile_id where sw.status = 'REGISTERED';").get("profile_id");

        StatusRequestModel body = new StatusRequestModel(profileId);
        ValidatableResponse response = TipsClient.status(body);
        assertEquals("34224730", response.extract().path(TipsResponcePath.RECEIVER_CODE));
        assertEquals("REGISTERED", response.extract().path(TipsResponcePath.STATUS));
    }

    @Test
    @Link("69655")
    void getStatusRegisteredWithoutCard() throws SQLException {
        String profileId = sqlGetRow("select * from employee_profile p join sbertips_worker sw on p.profile_id = sw.profile_id where sw.status = 'REGISTERED_WITHOUT_CARD';").get("profile_id");

        StatusRequestModel body = new StatusRequestModel(profileId);
        ValidatableResponse response = TipsClient.status(body);
        assertEquals("39796305", response.extract().path(TipsResponcePath.RECEIVER_CODE));
        assertEquals("REGISTERED_WITHOUT_CARD", response.extract().path(TipsResponcePath.STATUS));
    }

    @Test
    @Link("69656")
    void getStatusNotRegistered() throws SQLException {
        String profileId = sqlGetRow("select * from employee_profile p join sbertips_worker sw on p.profile_id = sw.profile_id where sw.status = 'NOT_REGISTERED';").get("profile_id");

        StatusRequestModel body = new StatusRequestModel(profileId);
        ValidatableResponse response = TipsClient.status(body);
        assertEquals("16150835", response.extract().path(TipsResponcePath.RECEIVER_CODE));
        assertEquals("NOT_REGISTERED", response.extract().path(TipsResponcePath.STATUS));
    }
}
