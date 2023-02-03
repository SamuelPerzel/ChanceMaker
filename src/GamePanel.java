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

    Thread gameThread;
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // sets the screen size
        this.setDoubleBuffered(true); // makes game render better
        this.setBackground(Color.black);
    }

    public void startGameThread() { // method for starting a game thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) { // game loop
            update();
            repaint();
        }
    }

    public void update() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
