package apiTest.testSuiteFilab;
import apiTest.config.Configuration;
import apiTest.factory.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio1 extends  TestBaseAuthBasic{

    @Test
    public void createUpdateDeleteProject(){
        JSONObject body = new JSONObject();
        body.put("Email", "user@email.com");
        body.put("FullName", "Joe Blow");
        body.put("Password", "pASswoRd");


        this.createUsuer(Configuration.host + "/api/user.json", body, post);

//        int token = response.then().extract().path("token");
//
//        this.createProject(Configuration.host + "/api/projects.json", body, post);
//
//        this.deleteUser(token, delete,body);
//
//        this.createProject(Configuration.host + "/api/projects.json", body, post);
    }
    private void deleteUser(int token, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/0" + token + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Content")));
    }

    private void createUsuer(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("user@email.com")));
    }

    private void createProject(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

}
