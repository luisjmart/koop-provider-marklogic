import io.restassured.RestAssured;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.hamcrest.Matchers.is;


public class ColumnMappingTest extends AbstractFeatureServiceTest {
    @Test
    public void testColumnMappingWithoutOutfields() {
        String path = request2path("ColumnMapping.json");

        RestAssured
                .given()
                .when()
                .log().uri()
                .get(path)

                .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()

                .body("features.size()", is(5))

                .body("features[0].attributes.Location", is("Aalborg, Nordjylland, Denmark"))
                .body("features[0].attributes.doc_url", is("http://satnews.com/story.php?number=1191513746"))
                .body("features[0].attributes.pubtime", is("2017-05-24T09:00:00Z"))
                .body("features[0].attributes.pubdate", is("2017-05-24Z"))
                .body("features[0].attributes.Location", is("Aalborg, Nordjylland, Denmark"))
                .body("features[0].attributes.urltone", is(2.67f))
                .body("features[0].attributes.domain", is("satnews.com"))
                .body("features[0].attributes.urllangcode", is("eng"))
                .body("features[0].attributes.geores", is(3))
        ;
    }

    @Test
    public void testColumnMappingWithOutfields() {
        String path = request2path("ColumnMappingWithOutfields.json");

        RestAssured
                .given()
                .when()
                .log().uri()
                .get(path)

                .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()

                .body("features.size()", is(5))

                .body("features[0].attributes.OBJECTID", is(20643))
                .body("features[0].attributes.doc_url", is("http://satnews.com/story.php?number=1191513746"))
                .body("features[0].attributes.pubtime", is("2017-05-24T09:00:00Z"))
                .body("features[0].attributes.pubdate", is("2017-05-24Z"))
                .body("features[0].attributes.Location", is("Aalborg, Nordjylland, Denmark"))
                .body("features[0].attributes.urltone", IsNull.nullValue())
                .body("features[0].attributes.domain", IsNull.nullValue())
                .body("features[0].attributes.urllangcode", IsNull.nullValue())
                .body("features[0].attributes.geores", IsNull.nullValue())
        ;
    }
}