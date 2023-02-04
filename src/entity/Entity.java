package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x;
    public int y;
    public int speed;

    public BufferedImage still1, still2, up1, up2, up3, down1, down2, left1, left2, left3, right1, right2, right3;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
}
