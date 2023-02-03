import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame(); // creates new window

        window.setTitle("ChanceMaker");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes it so that the windows is closable by pressing "X"
        window.setResizable(false); // makes the window not resizable

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); // makes the window appear in the center of the screen
        window.setVisible(true); // makes the window visible

        gamePanel.startGameThread(); // starts the game thread
    }
}