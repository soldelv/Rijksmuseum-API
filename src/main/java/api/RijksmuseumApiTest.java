package api;

import models.CollectionDetails;
import models.CollectionImage;
import models.CollectionResponse;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;

public class RijksmuseumApiTest {

    private static final String API_KEY = "0fiuZFh4";

    public RijksmuseumService client() {
        return RetrofitClient.getApi();
    }

    public Response<CollectionResponse> getAllCollections() {
        try {
            return client().getAllCollections(API_KEY, "json").execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Response<CollectionResponse> getAllCollectionsWithInvalidApiKey() {
        try {
            return client().getAllCollections("INVALID", "json").execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Response<CollectionDetails> getCollectionDetails(String collectionId) {
        try {
            return client().getCollectionDetails(collectionId, API_KEY).execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Response<CollectionDetails> getCollectionDetailsWithInvalidApiKey(String collectionId) {
        try {
            return client().getCollectionDetails(collectionId, "API_KEY").execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Response<CollectionImage> getCollectionImage(String collectionId) {
        try {
            return client().getOCollectionImage(collectionId, API_KEY).execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ResponseBody getErrorBody(Response response) {
        return response.errorBody();
    }
}