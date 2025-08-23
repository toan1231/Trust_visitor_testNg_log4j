package api_automation.TestingField;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class GoreTesting {

    @Test()
    public void user_create_requestData() throws InterruptedException {

        for (int i=0;i<10;i++) {
            String payload = "{\n" +
                    "  \"query\": \"{ users(limit: 5) { id name todos { id } }}\"\n" +
                    "}";
            Response response = given().log().all()
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY4YTIwN2VlNjg4MGNkYWJhYzFhODY1YyJ9LCJuaWNrbmFtZSI6ImNoYXUudGhhaSIsIm5hbWUiOiJjaGF1LnRoYWlAY2VydGlwYXRoLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci84M2MwYWIzMjg3MWNlNjYzNTY1MDZhYjE0MTk3ZGY3ZT9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmNoLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDI1LTA4LTE3VDE2OjQ4OjQ3LjM5MVoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsInN1YiI6ImF1dGgwfDY4YTIwN2VlNjg4MGNkYWJhYzFhODY1YyIsImlhdCI6MTc1NTQ2NDQ2MiwiZXhwIjoxNzU1NTAwNDYyLCJzaWQiOiItX1BTZkpRV2dSc203V3k5d05ZM3E5WTRjelJ0WU90USIsImF0X2hhc2giOiJydjViRzZKS0VaOC1oZENOekk4RTJRIiwibm9uY2UiOiIuWE9RUm9TMTJQY1NMRWlzWWY3dGZpWW5LTkYzRVFuRSJ9.ckLTskLhfl1PtDbOsynmxecCJg9mtBTMvHwhF-NaXT3vNcH6LbcmiDpZTZiGaJU7ECHV5lK-hD5auR4dadBCMOzbHfxP6pqcelYhEp4TfX1VXQAVvVCcanqsWpoya7mAjD4636zElQS1XbJJVil5z-aG2QURl-0e1WZwsLhFsP-btiBm9tAAMeDhh8vFQVbN9RZ5xUxa7-rPLkOauEtgYbDsq9cEMofi_Cnr3Uc2ylSjEfLS373qqh8d_Mmvxd6TFRPynxmxB_EOa7TP3fLyrYfQvya6I-WQCMqfiIfeXA6iu1oJgKtkHNP9-MtoJwblQf_HBEBNvMmFN1dvrEm4rw")
//                .contentType("application/json")
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when().log().all()
                    .post("https://hasura.io/learn/graphql");
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200);
            response.prettyPrint();
  Thread.sleep(4000);

        }
    }
}

