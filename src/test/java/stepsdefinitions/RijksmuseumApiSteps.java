package stepsdefinitions;

import api.RijksmuseumApiTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.CollectionDetails;
import models.CollectionImage;
import models.CollectionResponse;
import okhttp3.ResponseBody;
import org.junit.Assert;
import retrofit2.Response;

import java.io.IOException;

public class RijksmuseumApiSteps {

    RijksmuseumApiTest api = new RijksmuseumApiTest();

    /**
     * I know this is not the best practice to use static variables, but I use it just for the sake of simplicity
     * and to show more detailed steps on cucumber feature file
     * I normally use Context Store variables to store data between steps
     */
    public static Response<CollectionResponse> collectionResponse;
    public static Response<CollectionDetails> collectionDetailResponse;
    public static Response<CollectionImage> collectionImage;
    public static String objectNumber;
    public static int statusCode;
    public static ResponseBody errorBody;

    @Given("GET all collections")
    public void getAllCollections() {
        collectionResponse = api.getAllCollections();
        Assert.assertNotNull("Collections response is null", collectionResponse);
        statusCode = collectionResponse.code();
        errorBody = api.getErrorBody(collectionResponse);
    }

    @Given("GET all collections with invalid API key")
    public void getAllCollectionsWithInvalidAPIKey() {
        collectionResponse = api.getAllCollectionsWithInvalidApiKey();
        Assert.assertNotNull("Collections response is null", collectionResponse);
        statusCode = collectionResponse.code();
        errorBody = api.getErrorBody(collectionResponse);
    }

    @Then("the api response  status code should be {int}")
    public void theApiResponseStatusCodeShouldBe(int code) {
        Assert.assertEquals("Response status codes doesn't match!", code, statusCode);
    }

    @And("response body for collections is correct")
    public void responseBodyForCollectionsIsCorrect() {
        Assert.assertTrue("Response is not successful", collectionResponse.isSuccessful());
        Assert.assertNotNull("Response body is null", collectionResponse.body());
        Assert.assertFalse("Art objects list is empty", collectionResponse.body().getArtObjects().isEmpty());
        System.out.println("Collection response: " + collectionResponse.body());
    }

    @When("retrieve one collection from the list")
    public void retrieveOneCollectionFromTheList() {
        Assert.assertNotNull("Response body is null", collectionResponse.body());
        objectNumber = collectionResponse.body().getArtObjects().get(2).getObjectNumber();
        System.out.println("Collection id: " + objectNumber);
        Assert.assertNotNull("Collection id is null", objectNumber);
    }

    @And("GET the collection details from the collection")
    public void getTheCollectionDetailsFromTheCollection() {
        collectionDetailResponse = api.getCollectionDetails(objectNumber);
        Assert.assertNotNull("Collection detail response is null", collectionDetailResponse);
        System.out.println("collectionDetailResponse: " + collectionDetailResponse.body());
        statusCode = collectionDetailResponse.code();
        errorBody = api.getErrorBody(collectionDetailResponse);
    }

    @And("response body for collection details is correct")
    public void responseBodyForCollectionDetailsIsCorrect() {
        Assert.assertTrue("Response is not successful", collectionDetailResponse.isSuccessful());
        Assert.assertNotNull("Response body is null", collectionDetailResponse.body());
        System.out.println("Collection body: " + collectionDetailResponse.body());
        Assert.assertNotNull("ArtObject id is null", collectionDetailResponse.body().getArtObject().getId());
        Assert.assertNotNull("ArtObject title is null", collectionDetailResponse.body().getArtObject().getSubTitle());
    }

    @And("GET the collection image from the collection retrieved")
    public void getTheCollectionImageFromTheCollectionRetrieved() {
        collectionImage = api.getCollectionImage(objectNumber);
        System.out.println("collectionImage: " + collectionImage);
        System.out.println("collectionImage Body: " + collectionImage.body());
        Assert.assertNotNull("Collection image response is null", collectionImage);
        statusCode = collectionImage.code();
        errorBody = api.getErrorBody(collectionImage);
    }

    @And("response body for collection image is correct")
    public void responseBodyForCollectionImageIsCorrect() {
        Assert.assertTrue("Response is not successful", collectionImage.isSuccessful());
        Assert.assertNotNull("Response body is null", collectionImage.body());
        System.out.println("Collection body: " + collectionImage.body());
        Assert.assertFalse("Object Image id is empty", collectionImage.body().getLevels().isEmpty());
        Assert.assertNotNull("Object Image name is null", collectionImage.body().getLevels().get(0).getName());
        Assert.assertFalse("Object Image title is empty", collectionImage.body().getLevels().get(0).getTiles().isEmpty());
    }

    @Given("set an invalid object number")
    public void setAnInvalidObjectNumber() {
        objectNumber = "null";
        System.out.println("Invalid object number: " + objectNumber);
    }

    @And("the response should contain an error message {}")
    public void theResponseShouldContainAnErrorMessageInvalidKey(String message) throws IOException {
        String actualMessage = errorBody.string();
        System.out.println("Error message: " + actualMessage);
        Assert.assertEquals("Error message doesn't match", message, actualMessage);
    }

    @Given("GET the collection details from the collection with invalid API key")
    public void getTheCollectionDetailsFromTheCollectionWithInvalidAPIKey() {
        collectionDetailResponse = api.getCollectionDetailsWithInvalidApiKey(objectNumber);
        Assert.assertNotNull("Collection detail response is null", collectionDetailResponse);
        System.out.println("collectionDetailResponse: " + collectionDetailResponse.body());
        statusCode = collectionDetailResponse.code();
        errorBody = api.getErrorBody(collectionDetailResponse);
    }
}
