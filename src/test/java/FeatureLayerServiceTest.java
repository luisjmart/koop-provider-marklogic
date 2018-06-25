import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.simple.parser.ParseException;

import org.junit.Test;
import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

public class FeatureLayerServiceTest extends AbstractFeatureServiceTest {

    @Before
    public void setupRestAssured() {
        super.setupRestAssured();

        String port = System.getProperty("rest.port");
        if (port == null) {
            port = "8095";
        }
        RestAssured.port = Integer.valueOf(port);
        RestAssured.urlEncodingEnabled = true;

        insertJsonResource("TestService.json", "/test/test-service.json", "http://marklogic.com/feature-services");
        insertJsonResource("TestKoopConfig80.json", "/koop/config.json", "test");
    }

    @After
    public void deleteServiceDescriptor() {
        deleteJsonResource("/test/test-service.json");
        deleteJsonResource("/koop/config.json");
    }

    @Test
    public void testUrlDefaultPorts() throws UnsupportedEncodingException, ParseException  {

        String path = "/LATEST/resources/KoopFeatureLayer";

        RestAssured
            .given()
                .parameter("rs:service", "TestService")
                .parameter("rs:layerName", "testing")
                .parameter("rs:layerDescription", "testing description")
                .parameter("rs:geometryType", "Point")
                .parameter("rs:schema", "GDeltGKG")
                .parameter("rs:view", "Article")
            .when()
                .log().uri()
                .put(path)
            .then()
                .log().ifError()
                .statusCode(200)
                .body("featureServiceUrl", is("http://localhost/marklogic/TestService/FeatureServer"))
            ;
    }

}
