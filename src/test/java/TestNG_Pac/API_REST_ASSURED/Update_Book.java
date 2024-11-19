package TestNG_Pac.API_REST_ASSURED;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Update_Book {
    @Test
    public void updateBookName() {
        String requestBody = "{\"id\":10,\"name\":\"Backbenchers memories\",\"authorName\":\"Sachin and Nalluri\",\"publishedYear\":\"25/07/2023\",\"price\":1230}";

        Response res = RestAssured.given().contentType(ContentType.JSON).body(requestBody).patch("http://192.168.5.80:3000/api/v1/book/updateBook/3");
        System.out.println("Status code: " + res.getStatusCode());
        System.out.println("Response body: " + res.getBody().asPrettyString());
    }
}
