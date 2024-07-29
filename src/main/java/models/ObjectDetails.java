package models;

import lombok.Data;

@Data
public class ObjectDetails {
    ArtObjectDetails artObjectDetails;

    @Data
    public static class ArtObjectDetails {
        String id;
        String title;
    }
}
