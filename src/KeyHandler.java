import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean isPressedW, isPressedA, isPressedS, isPressedD;
    public boolean isPressedShift;

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();

        // WASD
        if (keyCode == KeyEvent.VK_W) {
            isPressedW = true;
        }
        if (keyCode == KeyEvent.VK_A) {
            isPressedA = true;
        }
        if (keyCode == KeyEvent.VK_S) {
            isPressedS = true;
        }
        if (keyCode == KeyEvent.VK_D) {
            isPressedD = true;
        }

        // other keys
        if (keyCode == KeyEvent.VK_SHIFT) {
            isPressedShift = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();

        // WASD
        if (keyCode == KeyEvent.VK_W) {
            isPressedW = false;
        }
        if (keyCode == KeyEvent.VK_A) {
            isPressedA = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            isPressedS = false;
        }
        if (keyCode == KeyEvent.VK_D) {
            isPressedD = false;
        }

        // other keys
        if (keyCode == KeyEvent.VK_SHIFT) {
            isPressedShift = false;
        }
    }
}
