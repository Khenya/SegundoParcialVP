package apiTest.testSuiteFilab;

import apiTest.config.Configuration;
import apiTest.factory.FactoryRequest;
import apiTest.factory.RequestInfo;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Base64;

public class TestBaseAuthBasic {
    public String post ="post";
    public String put = "put";
    public String get ="get";
    public String delete ="delete";

    public RequestInfo requestInfo;
    public Response response;
    @BeforeEach
    public void before(){
        requestInfo = new RequestInfo();
        String credential= Configuration.user+":"+Configuration.password;
        requestInfo.setHeaders("Authorization","Basic "+ Base64.getEncoder().encodeToString(credential.getBytes()).toString());
        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make("get").send(requestInfo);
        String token =response.then().extract().path("TokenString");
        // request get token
        requestInfo = new RequestInfo();
        requestInfo.setHeaders("Token",token);
    }

    @AfterEach
    public void after(){

    }

}
