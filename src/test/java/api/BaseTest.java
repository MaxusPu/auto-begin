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
    static String usersurl;
    static String dburl;
    static String username;
    static String password;

    public static void readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("app.properties");
        properties.load(inputStream);
        reqresurl = properties.getProperty("reqresurl");
        usersurl = properties.getProperty("usersurl");
        dburl = properties.getProperty("dburl");
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
        return DriverManager.getConnection(dburl, username, password);
    }
}
