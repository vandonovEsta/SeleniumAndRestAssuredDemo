package restassured;

import constants.TestConstants;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTests {
    protected Response _response;
    protected String _baseUri;
    protected String _deletePath;
    protected String _postPath;
    protected String _putPath;
    protected String _bearerPath;
    protected String _jsonPath;
    PropertiesHelper _propertiesHelper;

    @BeforeAll
    public void beforeAll() throws IOException {
        _propertiesHelper = new PropertiesHelper(TestConstants.RESTASSURED_CONFIG_LOCATION);
        _baseUri = _propertiesHelper.readProperty("baseUri");
        _deletePath = _propertiesHelper.readProperty("deletePath");
        _postPath = _propertiesHelper.readProperty("postPath");
        _putPath = _propertiesHelper.readProperty("putPath");
        _bearerPath = _propertiesHelper.readProperty("bearerPath");
        _jsonPath = _propertiesHelper.readProperty("jsonPath");
    }


    @BeforeEach
    public void init() {
        baseURI = _baseUri;
    }

    @AfterEach
    public void tearDown() {
        //Log response for troubleshooting
        System.out.println(_response.asString());
    }
}
