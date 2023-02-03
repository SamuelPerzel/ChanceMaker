import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // tiles
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 4;
    final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;

    // screen size
    final int SCREEN_TILE_WIDTH = 16;
    final int SCREEN_WIDTH = SCREEN_TILE_WIDTH * TILE_SIZE;
    final int SCREEN_TILE_HEIGHT = 12;
    final int SCREEN_HEIGHT = SCREEN_TILE_HEIGHT * TILE_SIZE;

    final double FPS = 60;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    int playerX = this.SCREEN_WIDTH / 2;
    int playerY = this.SCREEN_HEIGHT / 2;
    int DEFAULT_PLAYER_SPEED = 5;
    int playerSpeed = DEFAULT_PLAYER_SPEED;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // sets the screen size
        this.setDoubleBuffered(true); // makes game render better
        this.setBackground(Color.black);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() { // method for starting a game thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // calucates how many nanoseconds are in 1 frame
        double delta = 0;
        long lastTime = System.nanoTime(); // gets the current time as the last time
        long currentTime;

        while (gameThread != null) { // game loop
            currentTime = System.nanoTime(); // gets the current time
            delta += (currentTime - lastTime) / drawInterval; // calculates the delta between the times
            lastTime = currentTime; // sets the current time as the last one, so it can be used in another refresh

            if (delta >= 1) { // if the nanoseconds surpassed 1 second, the game is refreshed to maintain stable FPS
                update();
                repaint();

                delta--; // delta is put back by 1, so it can be refreshed again
            }
        }
    }

    public void update() {
        // player movement
        if (keyHandler.isPressedW) {
            playerY -= playerSpeed;
        }
        if (keyHandler.isPressedA) {
            playerX -= playerSpeed;
        }
        if (keyHandler.isPressedS) {
            playerY += playerSpeed;
        }
        if (keyHandler.isPressedD) {
            playerX += playerSpeed;
        }

        if (keyHandler.isPressedShift) {
            playerSpeed = 8;
        } else {
            playerSpeed = DEFAULT_PLAYER_SPEED;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
        g2.dispose();
    }
}
