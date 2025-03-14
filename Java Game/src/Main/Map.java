package Main;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    int[][] map = {
            {1},
            {1, 1},
            {1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1}
    };

    int cubeSize = 40;
    // public Image player;
//    public int playerRow = 0;
//    public int playerCol = 0;
    public int xOffset = 300;
    public int yOffset = 50;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                int x = xOffset + col * cubeSize - row * cubeSize / 2;
                int y = yOffset + row * cubeSize;
                drawCube(g, x, y, cubeSize, map[row][col]);
            }
        }

//        int playerX = xOffset + playerCol * cubeSize - playerRow * cubeSize / 2 + 10;
//        int playerY = yOffset + playerRow * cubeSize - 10;
//        g.drawImage(player, playerX, playerY, 40, 40, this);
    }

    private void drawCube(Graphics g, int x, int y, int size, int type) {
        Color top = type == 1 ? Color.YELLOW : Color.GRAY;
        Color left = type == 1 ? Color.BLUE : Color.DARK_GRAY;
        Color right = type == 1 ? Color.GREEN : Color.BLACK;

        int[] topX = {x, x + size / 2, x + size, x + size / 2};
        int[] topY = {y + size / 2, y, y + size / 2, y + size};
        int[] leftX = {x, x + size / 2, x + size / 2, x};
        int[] leftY = {y + size / 2, y + size, y + size * 3 / 2, y + size};
        int[] rightX = {x + size / 2, x + size, x + size, x + size / 2};
        int[] rightY = {y + size, y + size / 2, y + size * 3 / 2, y + size * 2};

        g.setColor(top);
        g.fillPolygon(topX, topY, 4);
        g.setColor(left);
        g.fillPolygon(leftX, leftY, 4);
        g.setColor(right);
        g.fillPolygon(rightX, rightY, 4);

        g.setColor(Color.BLACK);
        g.drawPolygon(topX, topY, 4);
        g.drawPolygon(leftX, leftY, 4);
        g.drawPolygon(rightX, rightY, 4);
    }



}



