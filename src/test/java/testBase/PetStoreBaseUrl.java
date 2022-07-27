package testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetStoreBaseUrl {
    protected RequestSpecification spec01;

    @Before
    public void setUp() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2/pet").
                build();
    }
}
