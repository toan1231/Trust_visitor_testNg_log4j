package api_automation.TestingField;
import static io.restassured.RestAssured.given;
import api_automation.dataProviderClass.GorestDataProviderClass;
import api_automation.requestBuilder.GoreRequestBuilder;

//import api_automation.utils.Log;
import api_automation.utils.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import api_automation.utils.TestBase;

import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;

public class GoreTesting extends TestBase {

    @Test(dataProvider = "dataProvider", dataProviderClass = GorestDataProviderClass.class)
    public void user_create_requestData(String email, String name, String gender, String status) throws JsonProcessingException, InterruptedException {
        for (int i = 0; i < 3; i++) {


            Log.info("This is request builder");
            GoreRequestBuilder builder = new GoreRequestBuilder();
            Log.warn("this is setEmailhh");
            builder.setEmail(email);
            builder.setName(name);
            Log.trace("this is setEmailhh");
            builder.setGender(gender);
            builder.setStatus(status);
            ObjectMapper mapper = new ObjectMapper();
            String mappBuilder = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(builder);
            Log.info("This is the beginning of post request");
            Response response = given()
                    .auth()
                    .preemptive().basic("admin","118c3a520cc3839621fb468f841ffb7e7e")
                   .header("Authorization", "Bearer d923586bca288aef6e650810925a5426ad3a62d413a6501fe5cc0d97185d610c")
                    .contentType(ContentType.JSON)
                    .when()
                   .get("http://localhost:8080/job/testing2/build?token=chauthai123456789");
                 //   .get("https://gorest.co.in/public/v1/users?gender=male&status=inactive&id=4124");
            System.out.println(response.statusCode()+"chauthai5");
           //   http://localhost:8080/job/testing2/build?token=chau123456789
          //  https://gorest.co.in/public/v1/users?gender=male&status=inactive&id=4124
            response.prettyPrint();///////////////////////




        }
    }
}