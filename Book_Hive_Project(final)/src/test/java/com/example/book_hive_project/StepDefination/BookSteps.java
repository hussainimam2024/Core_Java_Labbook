package com.example.book_hive_project.StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;

public class BookSteps {
    private String baseUrl;
    private Response response;

    @Given("the API endpoint is {string}")
    public void the_api_endpoint_is(String endpoint) {
        System.out.println(endpoint);
        this.baseUrl = endpoint;

    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String path) {
        System.out.println("working");
        response = RestAssured.given().get(baseUrl+path);
        System.out.println(response.toString());
        System.out.println(response.jsonPath().getString("title"));


    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer statusCode) {
        Assert.assertEquals(statusCode.intValue(), response.getStatusCode());
    }

    @Then("the response should contain a list of books")
    public void the_response_should_contain_a_list_of_books() {
        List<?> books = response.jsonPath().getList("$");
        Assert.assertTrue("Expected response to contain a list of books", books.size() > 0);
    }

    @Given("a book with ID {int} exists in the database")
    public void a_book_with_id_exists_in_the_database(Integer bookId) {
        response = RestAssured.given().get(baseUrl + "/books/" + bookId);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("the response should contain the book details")
    public void the_response_should_contain_the_book_details() {
        String bookName = response.jsonPath().getString("name");
        Assert.assertNotNull("Expected book details in the response", bookName);
        System.out.println("Book Details: " + response.body().asString());
    }
}
