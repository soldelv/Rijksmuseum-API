package models;

import lombok.Data;

import java.util.List;

@Data
public class CollectionDetails {
    int elapsedMilliseconds;
    ArtObject artObject;

    @Data
    public static class ArtObject {
        CollectionResponse.Links links;
        String id;
        String objectNumber;
        String title;
        boolean hasImage;
        String principalOrFirstMaker;
        String longTitle;
        boolean showImage;
        boolean permitDownload;
        CollectionResponse.Image webImage;
        CollectionResponse.Image headerImage;
        List<String> productionPlaces;

        // ** /
        String priref;
        String language;
        List<Color> colors;
        List<ColorsWithNormalization> colorsWithNormalization;
        List<Color> normalizedColors;
        List<String> titles;
        String description;
        List<String> objectTypes;
        List<String> objectCollection;
        List<PrincipalMakers> principalMakers;
        String plaqueDescriptionDutch;
        String plaqueDescriptionEnglish;
        String principalMaker;
        Dating dating;
        String physicalMedium;
        String subTitle;
        String scLabelLine;
        Label label;
        String location;

    }

    @Data
    public static class Color{
        int percentage;
        String hex;
    }

    @Data
    public static class ColorsWithNormalization {
        String originalHex;
        String normalizedHex;
    }

    @Data
    public static class PrincipalMakers {
        String name;
        String unFixedName;
        String placeOfBirth;
        String dateOfBirth;
        String dateOfDeath;
        String placeOfDeath;
        List<String> occupation;
        List<String> roles;
        String nationality;
        List<String> productionPlaces;
    }

    @Data
    public static class Dating {
        String presentingDate;
        int sortingDate;
        int period;
        int yearEarly;
        int yearLate;
    }

    @Data
    public static class Label {
        String title;
        String makerLine;
        String description;
        String notes;
        String date;
    }
}
