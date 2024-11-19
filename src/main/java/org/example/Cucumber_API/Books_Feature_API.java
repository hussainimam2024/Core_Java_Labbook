package org.example.Cucumber_API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Books_Feature_API {

    private RequestSpecification request;
    private Response response;
    private String baseUrl = "http://192.168.5.80:3000/api";

    @Given("Enter the url")
    public void enter_the_url() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        System.out.println("heeeeee");
    }

    @Given("enter book details")
    public void enter_book_details() {
        request.body("{ \"name\": \"something in the world\", \"authorName\": \"pandu\", \"publishedYear\": \"1986-10-10T00:00\", \"price\": 2020 }").header("Content-Type", "application/json");
        System.out.println("working");
    }


    @When("post the book details")
    public void post_the_book_details() {
        response = request.post("/v1/addBook");
    }

    @Then("validate the status code")
    public void validate_status_code() {
        response.then().statusCode(200);
    }
    @Then("validate the book namre")
    public void validate_book_name() {
        response.then().body("name",equalTo("Book Name"));

    }
    @When("get the book details")
    public void get_the_book_details() {
        response = RestAssured.get("/getBook/1");
    }

    @When("patch the book details")
    public void patch_the_book_details() {
        String updatedDetails = "{ \"name\": \"something in the world - updated\", \"price\": 2100 }";
        response = RestAssured.given().header("Content-Type", "application/json").body(updatedDetails).patch("/updateBook/1");
    }

    @Then("validate the status code")
    public void validate_the_status_code() {
        assertEquals(200, response.getStatusCode());
    }

    @Then("validate the price")
    public void validate_the_price() {
        Integer price = response.jsonPath().getInt("price");
        assertNotNull("Price field is missing in the response", price);
        assertEquals(2020, price.intValue());
    }

    @Then("validate the Author")
    public void validate_the_author() {
        String authorName = response.jsonPath().getString("authorName");
        assertNotNull("Author field is missing in the response", authorName);
        assertEquals("pandu", authorName);
    }
}
