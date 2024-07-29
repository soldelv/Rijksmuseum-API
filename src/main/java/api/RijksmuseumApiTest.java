package api;

import models.CollectionDetails;
import models.CollectionImage;
import models.CollectionResponse;
import models.ObjectDetails;
import retrofit2.Response;

import java.io.IOException;

public class RijksmuseumApiTest {

    private static final String API_KEY = "0fiuZFh4";

    public RijksmuseumService client() {
        return RetrofitClient.getApi();
    }

    // TODO: IMPLEMENT INVALID COLLECTION TEST
    public Response<CollectionResponse> getAllCollections() {
        try{
            return client().getAllCollections(API_KEY, "json").execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Response<CollectionDetails> getCollectionDetails(String collectionId) {
        try{
            return client().getCollectionDetails(collectionId, API_KEY).execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Response<CollectionImage> getCollectionImage(String collectionId) {
        try{
            return client().getOCollectionImage(collectionId, API_KEY).execute();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }





//    @Test
//    public void testGetObjectDetails() throws Exception {
//        String collectionId = "some_valid_collection_id";
//        String objectId = "some_valid_object_id";
//        Response<ObjectDetails> response = api.getObjectDetails(collectionId, objectId, API_KEY).execute();
//        assertTrue(response.isSuccessful());
//        assertNotNull(response.body());
//        assertNotNull(response.body().getArtObjectDetails());
//    }
//
//    @Test

//
//    @Test
//    public void testNonExistentCollection() throws Exception {
//        String collectionId = "non_existent_collection_id";
//        Response<CollectionDetails> response = api.getCollectionDetails(collectionId, API_KEY).execute();
//        assertFalse(response.isSuccessful());
//        assertEquals(404, response.code());
//    }
}