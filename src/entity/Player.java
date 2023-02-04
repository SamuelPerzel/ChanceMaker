package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    final int DEFAULT_PLAYER_SPEED = 5;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        this.x = gamePanel.SCREEN_WIDTH / 2;
        this.y = gamePanel.SCREEN_HEIGHT / 2;

        this.speed = this.DEFAULT_PLAYER_SPEED;

        this.direction = "still";
    }

    public void getPlayerImage() {
        try {
            still1 = ImageIO.read(new FileInputStream("resources/player/player_still_1.png"));
            still2 = ImageIO.read(new FileInputStream("resources/player/player_still_2.png"));

            up1 = ImageIO.read(new FileInputStream("resources/player/player_walk_up_1.png"));
            up2 = ImageIO.read(new FileInputStream("resources/player/player_walk_up_2.png"));
            up3 = ImageIO.read(new FileInputStream("resources/player/player_walk_up_3.png"));

            down1 = ImageIO.read(new FileInputStream("resources/player/player_walk_down_1.png"));
            down2 = ImageIO.read(new FileInputStream("resources/player/player_walk_down_2.png"));

            left1 = ImageIO.read(new FileInputStream("resources/player/player_walk_left_1.png"));
            left2 = ImageIO.read(new FileInputStream("resources/player/player_walk_left_2.png"));
            left3 = ImageIO.read(new FileInputStream("resources/player/player_walk_left_3.png"));

            right1 = ImageIO.read(new FileInputStream("resources/player/player_walk_right_1.png"));
            right2 = ImageIO.read(new FileInputStream("resources/player/player_walk_right_2.png"));
            right3 = ImageIO.read(new FileInputStream("resources/player/player_walk_right_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // when player is idle
        if (!keyHandler.isPressedW && !keyHandler.isPressedA && !keyHandler.isPressedS && !keyHandler.isPressedD) {
            this.direction = "still";
        }

        // player movement
        if (keyHandler.isPressedA) {
            this.direction = "left";
            x -= speed;
        }
        if (keyHandler.isPressedD) {
            this.direction = "right";
            x += speed;
        }
        if (keyHandler.isPressedW) {
            this.direction = "up";
            y -= speed;
        }
        if (keyHandler.isPressedS) {
            this.direction = "down";
            y += speed;
        }

        // special keys
        if (keyHandler.isPressedShift) {
            speed = 8;
        } else {
            speed = this.DEFAULT_PLAYER_SPEED;
        }

        // player animation
        this.spriteCounter++;
        if (spriteCounter >= 20) { // activates after every n frames per second (currently 20)
            // changes sprite number in a cycle when it is activated (1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1)
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 3;
            } else if (spriteNumber == 3) {
                spriteNumber = 4;
            } else {
                spriteNumber = 1;
            }

            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2d) { // method for drawing the correct sprite
        BufferedImage image = null;

        switch (this.direction) {
            case "still": // if idle
                if (spriteNumber == 1 || spriteNumber == 3) {
                    image = still1;
                } else {
                    image = still2;
                }
                break;

            case "up": // if going up
                if (spriteNumber == 1 || spriteNumber == 3) {
                    image = up1;
                } else if (spriteNumber == 2) {
                    image = up2;
                } else {
                    image = up3;
                }
                break;

            case "down": // if going down
                if (spriteNumber == 1 || spriteNumber == 3) {
                    image = still1;
                } else if (spriteNumber == 2) {
                    image = down1;
                } else {
                    image = down2;
                }
                break;

            case "left": // if going left
                if (spriteNumber == 1 || spriteNumber == 3) {
                    image = left1;
                } else if (spriteNumber == 2) {
                    image = left2;
                } else {
                    image = left3;
                }
                break;

            case "right":
                if (spriteNumber == 1 || spriteNumber == 3) {
                    image = right1;
                } else if (spriteNumber == 2) {
                    image = right2;
                } else {
                    image = right3;
                }
                break;
        }

        g2d.drawImage(image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
    }
}
