import static org.hamcrest.Matchers.is;

import org.junit.Test;

import io.restassured.RestAssured;


public class TimeTest extends AbstractFeatureServiceTest{

    @Test
    public void testGkgTimeTest1() {

        String path = request2path("gkgTimeQuery1.json");

        RestAssured
            .given()
            .when()
                .log().uri()
                .get(path)

            .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()
                .body("count", is(11782))
            ;
    }

    @Test
    public void testGkgTimeTest2() {

        String path = request2path("gkgTimeQuery2.json");

        RestAssured
            .given()
            .when()
                .log().uri()
                .get(path)

            .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()
                .body("count", is(5639))
            ;
    }

    @Test
    public void testGkgTimeTest3() {

        String path = request2path("gkgTimeQuery3.json");

        RestAssured
            .given()
            .when()
                .log().uri()
                .get(path)

            .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()
                .body("count", is(0))
            ;
    }

    @Test
    public void testGkgTimeTest4() {

        String path = request2path("gkgTimeQuery4.json");

        RestAssured
            .given()
            .when()
                .log().uri()
                .get(path)

            .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()
                .body("count", is(17085))
            ;
    }
    @Test
    public void testGkgTimeTest5() {

        String path = request2path("gkgTimeQuery5.json");

        RestAssured
            .given()
            .when()
                .log().uri()
                .get(path)

            .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()
                .body("count", is(33462))
            ;
    }

    @Test
    public void testGkgTimeTest6() {

        String path = request2path("gkgTimeQuery6.json");

        RestAssured
            .given()
            .when()
                .log().uri()
                .get(path)

            .then()
                .log().ifError()
                .statusCode(200)
                .log().ifValidationFails()
                .body("count", is(38765))
            ;
    }
}
