import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class QbertMap extends JPanel implements KeyListener {
    int[][] map = {
            {1},
            {1, 1},
            {1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1}
    };

    int cubeSize = 40;
    private Image player;
    private int playerRow = 0;
    private int playerCol = 0;
    private int xOffset = 300;
    private int yOffset = 50;

    public QbertMap() {
        player = new ImageIcon(getClass().getResource("/playerdownright.png")).getImage();
        setFocusable(true);
        addKeyListener(this);
    }

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

        int playerX = xOffset + playerCol * cubeSize - playerRow * cubeSize / 2 + 10;
        int playerY = yOffset + playerRow * cubeSize - 10;
        g.drawImage(player, playerX, playerY, 40, 40, this);
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

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (playerRow > 0) {
                    int newCol = Math.min(playerCol, map[playerRow - 1].length - 1);
                    playerRow--;
                    playerCol = newCol;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (playerRow < map.length - 1) {
                    int newCol = Math.min(playerCol, map[playerRow + 1].length - 1);
                    playerRow++;
                    playerCol = newCol;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (playerCol > 0) {
                    playerCol--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (playerCol < map[playerRow].length - 1) {
                    playerCol++;
                }
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Q*bert Map");
        QbertMap panel = new QbertMap();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.BLACK);
        frame.setVisible(true);
    }
}
