package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseTest {
    static String reqresurl;

    static String tipsurl;
    static String usersurl;
    static String tipsdburl;
    static String username;
    static String password;

    public static void readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("app.properties");
        properties.load(inputStream);
        tipsurl = properties.getProperty("tipsurl");
        tipsdburl = properties.getProperty("tipsdburl");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static void setupReqres() {
        RestAssured.baseURI = reqresurl;
    }

    @BeforeAll
    static void initSetup() throws IOException {
        readProperties();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(tipsdburl, username, password);
    }
}
