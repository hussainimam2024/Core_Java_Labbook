package TestNG_Pac.API_REST_ASSURED;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Get_AllBooks {
    @Test
    public void getAllBooks(){
        Response res = RestAssured.get("http://192.168.5.80:3000/api/v1/book/getAllBook" );
        System.out.println("Status code: " + res.getStatusCode());
        System.out.println("Responsebody"+res.getBody().asPrettyString());
        System.out.println("header:"+res.contentType());
        System.out.println("status line:"+res.getStatusLine());
    }
}
