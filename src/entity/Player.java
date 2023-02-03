package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    final int DEFAULT_PLAYER_SPEED = 5;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {
        this.x = gamePanel.SCREEN_WIDTH / 2;
        this.y = gamePanel.SCREEN_HEIGHT / 2;

        this.speed = this.DEFAULT_PLAYER_SPEED;
    }

    public void update() {
        // player movement
        if (keyHandler.isPressedW) {
            y -= speed;
        }
        if (keyHandler.isPressedA) {
            x -= speed;
        }
        if (keyHandler.isPressedS) {
            y += speed;
        }
        if (keyHandler.isPressedD) {
            x += speed;
        }

        if (keyHandler.isPressedShift) {
            speed = 8;
        } else {
            speed = this.DEFAULT_PLAYER_SPEED;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }
}
