package api;

import models.CollectionDetails;
import models.CollectionImage;
import models.CollectionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RijksmuseumService {

    @GET("collection")
    Call<CollectionResponse> getAllCollections(
            @Query("key") String apiKey,
            @Query("format") String format
    );

    @GET("collection/{collectionId}")
    Call<CollectionDetails> getCollectionDetails(
            @Path("collectionId") String collectionId,
            @Query("key") String apiKey
    );

    @GET("collection/{collectionId}/tiles")
    Call<CollectionImage> getOCollectionImage(
            @Path("collectionId") String collectionId,
            @Query("key") String apiKey
    );
}
