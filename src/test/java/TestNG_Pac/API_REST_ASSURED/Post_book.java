package TestNG_Pac.API_REST_ASSURED;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

//Used to create a new resource on the server
public class Post_book {
    @Test
    public void postBooks() {
        RestAssured.baseURI = "http://192.168.5.80:3000/api";
        JSONObject req = new JSONObject();
        req.put("name", "How we can make money ");
        req.put("authorName", "RJ");
        req.put("publishedYear", "01/11/2000");
        req.put("price", 1050);
        Response response = given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().post("/v1/book/addBook").then().statusCode(200).log().all().extract().response();
        System.out.println("Response body: " + response.getBody().asPrettyString());
    }
}
