package TestNG_Pac.API_REST_ASSURED;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

//Used to fully update an existing resource or create a new resource if it doesn’t exist.
public class put_books {
    @Test
    public void postBooks() {
        RestAssured.baseURI = "http://192.168.5.80:3000/api";
        JSONObject req = new JSONObject();

        req.put("name", "World adventure");
        req.put("authorName", "S.Murthi");
        req.put("publishedYear", "01/11/2005");
        req.put("price", 1011);

        Response response = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .patch("/v1/book/updateBook/10") //if api is created using put then we can't use patch for updating a sepecific values
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        System.out.println("Response body: " + response.getBody().asPrettyString());
    }
}
