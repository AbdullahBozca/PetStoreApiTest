package testData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetStoreTestData {
    public HashMap<String, Object> setUpTestData() {
        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("StatusCode", 200);
        expectedData.put("status", "available");
        expectedData.put("negativeStatus", "sold");
        return expectedData;
    }

    /*
    {
        "id": 9223372036854164999,
        "category": {
            "id": 0,
            "name": "string"
        },
        "name": "qqqqqq",
        "photoUrls": [
            "string"
        ],
        "tags": [
            {
                "id": 0,
                "name": "string"
            }
        ],
        "status": "available"
    }
     */
    public JSONObject setUpTestAndRequestData() {
        JSONObject category = new JSONObject();
        category.put("id",1);
        category.put("name", "string");

        JSONObject tags=new JSONObject();
        tags.put("id",0);
        tags.put("name", "string");

        List<String> photoUrls=new ArrayList<String>();
        photoUrls.add("string");

        HashMap<String,Object> tagsMap=new HashMap<String,Object>();
        tagsMap.put("id",1);
        tagsMap.put("name", "string");
        List<HashMap> tagsList=new ArrayList<HashMap>();
        tagsList.add(tagsMap);
        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("id",922337299);
        expectedRequest.put("category", category);
        expectedRequest.put("name","qqqqqq");
        expectedRequest.put("photoUrls",photoUrls);
        expectedRequest.put("tags",tagsList);
        expectedRequest.put("status","available");
        expectedRequest.put("StatusCode", 200);
        expectedRequest.put("notId",1);
        return expectedRequest;
    }

    public JSONObject setupPutRequestData(){
        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("StatusCode", 200);
        expectedRequest.put("status","sold");
        expectedRequest.put("oldStatus","available");
        return expectedRequest;
    }
}
