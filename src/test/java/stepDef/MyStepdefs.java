package stepDef;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    RequestSpecification request;
    Response response;

    @Given("Set host of api")
    public void setHostOfApi() {
        String s = "a123b12a1";
        String str="";
        TreeMap<Character, Integer> map = new TreeMap<>();
        char key =Character.MAX_VALUE;
        int value = 0;
        String num = "";
        for(int i=0;i<s.length();i++){

            if(Character.isLetter(s.charAt(i))){
                key = s.charAt(i);
                value=0;
                continue;
            }
            else{
                value = value*10+Character.getNumericValue(s.charAt(i));
            }
            if(map.containsKey(key)){
                map.put(key, value);
            }
            else{
                map.put(key, value);
            }
            System.out.print(map.keySet());
            System.out.print(map.values());
        }

        for (char c : map.keySet()) {
            str+=c + map.get(c);
        }
        request = given().baseUri("http://universities.hipolabs.com");
    }

    @When("Call the api endpoint")
    public void callTheApiEndpoint() {
        response = request.get("/search?country=South Africa");
    }

    @Then("Validate the api response")
    public void validateTheApiResponse() {
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println();
    }

    @Then("Fetch the state name")
    public void fetchTheStateName() {

        JSONArray jsonArray = new JSONArray(response.prettyPrint());
        for (Object obj:
             jsonArray) {
            System.out.println(((JSONObject)obj).getString("name"));
        }
//        List<LinkedHashMap<String, String>> jsonPath = response.jsonPath().getList("$");
//
//        for (int i=0; i<jsonPath.size();i++){
//            System.out.println(jsonPath.get(i).get("name"));
//        }
    }
}
