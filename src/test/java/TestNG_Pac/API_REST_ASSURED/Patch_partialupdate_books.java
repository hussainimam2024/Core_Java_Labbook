package TestNG_Pac.API_REST_ASSURED;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

//patch is used to update a specific field in a resource
public class Patch_partialupdate_books {
    @Test
    public void postBooks() {
        RestAssured.baseURI = "http://192.168.5.80:3000/api";
        JSONObject req = new JSONObject();

        req.put("authorName", "Trade with imam");

        req.put("price", 1000);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .patch("/v1/book/updateBook/9")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        System.out.println("Response body: " + response.getBody().asPrettyString());
    }
}
