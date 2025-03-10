/*
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;


public class qbert extends JPanel {
    private Image playerdownright;
    HashSet<Block>

    class Block {
        int x;
        int y;
        int width;
        int height;
        Image image;

        int startX;
        int startY;
        char direction = 'U'; // U D L R
        int velocityX = 0;
        int velocityY = 0;


        Block(Image image, int x, int y, int width, int height) {
            this.image = image;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.startX = x;
            this.startY = y;
        }
    }

        qbert() {

            //load images
            playerdownright = new ImageIcon(getClass().getResource("./playerdownright.png")).getImage();

        }

        public void draw(Graphics g) {
            g.drawImage(playerdownright.image, playerdownright.x, playerdownright.y, playerdownright.width, playerdownright.height, null);

        }
    }

 */