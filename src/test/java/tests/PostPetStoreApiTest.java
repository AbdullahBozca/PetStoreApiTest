package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testBase.PetStoreBaseUrl;
import testData.PetStoreTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PostPetStoreApiTest extends PetStoreBaseUrl {
    @Test
    public void test(){
        PetStoreTestData petStoreTestData=new PetStoreTestData();
        JSONObject expectedData =petStoreTestData.setUpTestAndRequestData();

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedData.toString()).
                when().
                post();
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        assertEquals(expectedData.get("StatusCode"), response.getStatusCode());
        //positive scenario
        assertEquals(expectedData.get("id"),jsonPath.get("id"));
        //negative scenario
        assertNotEquals(expectedData.get("notId"),jsonPath.get("id"));

    }

}
