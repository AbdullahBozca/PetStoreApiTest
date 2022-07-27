package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testBase.PetStoreBaseUrl;
import testData.PetStoreTestData;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetPetStoreApiTest extends PetStoreBaseUrl {
    @Test
    public void test() {
        spec01.pathParams("first", "findByStatus", "second", "status=available");
        Response response = given().
                spec(spec01).
                contentType(ContentType.JSON).
                when().
                get("/{first}?{second}");
        response.prettyPrint();

        PetStoreTestData expectedObj = new PetStoreTestData();
        HashMap<String, Object> expectedData = expectedObj.setUpTestData();

        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedData.get("StatusCode"), response.getStatusCode());
        List<String> statusList = jsonPath.getList("status");
        //positive scenarios
        for (String each : statusList) {
            assertEquals(expectedData.get("status"), each);
        }
        //negative scenarios
        for (String each : statusList) {
            assertNotEquals(expectedData.get("negativeStatus"), each);
        }
    }
}
