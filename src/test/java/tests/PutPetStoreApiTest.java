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
import static org.junit.Assert.assertNotEquals;

public class PutPetStoreApiTest extends PetStoreBaseUrl {
    @Test
    public void test(){
        PetStoreTestData petStoreTestData=new PetStoreTestData();
        JSONObject expectedData =petStoreTestData.setupPutRequestData();

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedData.toString()).
                when().
                put();
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        assertEquals(expectedData.get("StatusCode"), response.getStatusCode());
        //positive scenario
        assertEquals(expectedData.get("status"),jsonPath.get("status"));
        //negative scenario
        assertNotEquals(expectedData.get("oldStatus"),jsonPath.get("status"));

    }
}
