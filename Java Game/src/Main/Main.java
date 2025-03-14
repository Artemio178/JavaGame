package Main;


import javax.swing.*;
import java.awt.*;

public class Main {
    private static JFrame window;



    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.add(panel);
        window.setResizable(false);
        window.setTitle("Qbert");
        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();


    }





//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Q*bert Map");
//        Map panel = new Map();
//        frame.add(panel);
//        frame.setSize(800, 800);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        panel.setBackground(Color.BLACK);
//        frame.setVisible(true);
//        gamePanel.startGameThread();
//
//
//    }

}