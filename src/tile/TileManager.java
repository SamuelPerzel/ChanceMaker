package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TileManager {
    GamePanel gamePanel;
    Tile[][] tiles;

    BufferedImage imgLeaves;
    BufferedImage imgGrass;
    BufferedImage imgWater;

    public TileManager(GamePanel gamepanel) {
        this.gamePanel = gamepanel;

        tiles = new Tile[12][16];

        getTileImages();
        loadMap("resources\\maps\\map_test.txt");
    }

    public void getTileImages() {
        try {
            imgLeaves = ImageIO.read(new FileInputStream("resources/tiles/leaves.png"));
            imgGrass = ImageIO.read(new FileInputStream("resources/tiles/grass.png"));
            imgWater = ImageIO.read(new FileInputStream("resources/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String dir) {

        try (Scanner sc = new Scanner(new File(dir))) { // loads up the map

            String line;
            String[] lineSplit;
            for (int i = 0; i < 12; i++) {
                line = sc.nextLine();
                lineSplit = line.split(" ");

                for (int j = 0; j < 16; j++) {
                    tiles[i][j] = new Tile();

                    switch (lineSplit[j]) {
                        case "L" -> tiles[i][j].image = imgLeaves;
                        case "G" -> tiles[i][j].image = imgGrass;
                        case "W" -> tiles[i][j].image = imgWater;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("File was not found!");
        }
    }

    public void draw(Graphics2D g2d) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                g2d.drawImage(tiles[i][j].image, j*gamePanel.TILE_SIZE, i*gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            }
        }
    }
}
