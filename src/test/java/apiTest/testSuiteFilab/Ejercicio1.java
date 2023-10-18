package apiTest.testSuiteFilab;
import apiTest.config.Configuration;
import apiTest.factory.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio1 extends  TestBaseAuthBasic{

    @Test
    public void createUpdateDeleteProject(){

        this.createUser();
        this.authenticate();
        this.createProject();
        this.deleteToken();
        this.createProject();
    }
    private void createUser() {
        Configuration.password = "pASswoRd";
        JSONObject body = new JSONObject();
        body.put("Email", "user@email.com");
        body.put("FullName", "Joe Blow");
        body.put("Password", "pASswoRd");

        requestInfo.setUrl(Configuration.host + "/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("Email", equalTo(body.get("Email")))
                .body("FullName", equalTo(body.get("FullName")));
    }

    private void authenticate() {

    }

    private void createProject() {
        String randomContent = "Project ";

        JSONObject body = new JSONObject();
        body.put("Content", randomContent);

        requestInfo.setUrl(Configuration.host + "/api/projects.json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteToken() {
        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("UserEmail", equalTo(Configuration.user))
                .body("TokenString", equalTo(requestInfo.getHeaders().get("Token")));
    }
    private void createUsuer(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("user@email.com")));
    }
}
