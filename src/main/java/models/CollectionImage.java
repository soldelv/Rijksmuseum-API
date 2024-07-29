package models;

import lombok.Data;

import java.util.List;

@Data
public class CollectionImage {
    List<Level> levels;

    @Data
    public static class Level {
        String name;
        int width;
        int height;
        List<Tile> tiles;
    }

    @Data
    public static class Tile {
        int x;
        int y;
        String url;
    }
}
