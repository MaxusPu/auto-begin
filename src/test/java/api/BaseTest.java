package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    static String reqresurl;

    public static void readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("app.properties");
        properties.load(inputStream);
        reqresurl = properties.getProperty("reqresurl");
    }

    public static void setupReqres() {
        RestAssured.baseURI = reqresurl;
    }

    @BeforeAll
    static void initSetup() throws IOException {
        readProperties();
    }
}
