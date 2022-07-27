package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testBase.PetStoreBaseUrl;
import testData.PetStoreTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeletePetStoreApiTest extends PetStoreBaseUrl {
    @Test
    public void test(){
        spec01.pathParams("first","1");
        PetStoreTestData petStoreTestData =new PetStoreTestData();
        JSONObject expectedData=petStoreTestData.setupDeleteRequestData();

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedData.toString()).
                when().
                delete("/{first}");
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        assertEquals(expectedData.get("code"), jsonPath.get("code"));
        assertEquals(expectedData.get("type"),jsonPath.get("type"));
        assertEquals(expectedData.get("message"),jsonPath.get("message"));

    }
}
