package restassured;

import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.StringHelper;
import org.junit.jupiter.api.Test;
import restassured.pojos.ResponsePojo;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTests extends BaseTests {

    @Test
    public void deleteTest() {
        _response = delete(_deletePath);


        _response.then().statusCode(200)
                .assertThat().body("url", equalTo(_baseUri + _deletePath))
                .extract().response();
    }

    @Test
    public void wrongHttpMethodUsedForDelete() {
        _response = post(_deletePath);

        _response.then().statusCode(405);

        assertTrue(_response.asString().contains("Method Not Allowed"));
    }

    @Test
    public void postTest() {
        _response = post(_postPath);

        _response.then().statusCode(200)
                .assertThat().body("url", equalTo(_baseUri + _postPath));
    }

    @Test
    public void putTest() {
        _response = put(_putPath);

        _response.then().statusCode(200)
                .assertThat().body("url", equalTo(_baseUri + _putPath));

    }

    @Test
    public void getBearerTest() {
        String token = StringHelper.getRandomBearerToken();
        _response = given().header("Authorization", "Bearer " + token)
                .when().get(_bearerPath);

        _response.then().statusCode(200)
                .assertThat().body("authenticated", equalTo(true))
                .body("token", equalTo(token));
    }

    //todo: wrong path param
    @Test
    public void wrongPathParameter() {
        String token = StringHelper.getRandomBearerToken();
        _response = given().header("Authorization", "Bearer " + token)
                .when().get("/bearrer");

        _response.then().statusCode(404);

        assertTrue(_response.asString().contains("The requested URL was not found on the server."));
    }

    @Test
    public void jsonTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //We get the response from a hardcoded file because the successfull response is always the same
        ResponsePojo expectedResponse = objectMapper.readValue(new File("src/test/java/restassured/testData/expectedResponse.json"),
                ResponsePojo.class);
        _response = get(_jsonPath);

        ResponsePojo responsePojo = _response.as(ResponsePojo.class);

        //Compare files. Possible due to lombok's @EqualsAndHashCode annotation
        assertEquals(expectedResponse, responsePojo);
    }
}
