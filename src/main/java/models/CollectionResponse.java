package models;

import lombok.Data;

import java.util.List;

@Data
public class CollectionResponse {
    int elapsedMilliseconds;
    int count;
    List<ArtObject> artObjects;

    @Data
    public static class ArtObject {
        Links links;
        String id;
        String objectNumber;
        String title;
        boolean hasImage;
        String principalOrFirstMaker;
        String longTitle;
        boolean showImage;
        boolean permitDownload;
        Image webImage;
        Image headerImage;
        List<String> productionPlaces;
    }

    @Data
    public static class Links {
        String self;
        String web;
    }

    @Data
    public static class Image {
        String guid;
        int offsetPercentageX;
        int offsetPercentageY;
        int width;
        int height;
        String url;
    }
}

