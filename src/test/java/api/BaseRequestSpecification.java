package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseRequestSpecification extends BaseTest {
    public static RequestSpecification tipsSpec = new RequestSpecBuilder().setBaseUri(tipsurl)
            .addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter()).build().relaxedHTTPSValidation();

//    public static RequestSpecification reqresSpec = new RequestSpecBuilder().setBaseUri(reqresurl)
//            .addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter()).build().
//            config(new RestAssuredConfig().sslConfig(new SSLConfig().keyStore("","").trustStore("",""))).
//            relaxedHTTPSValidation();

}
