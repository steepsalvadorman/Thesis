package snake;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public final class Snake implements ActionListener, KeyListener {

    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
    public static final int SCREEN_WIDTH = 805;
    public static final int SCREEN_HEIGHT = 700;
    public static final int TILE_WIDTH = 79;
    public static final int TILE_HEIGHT = 66;
    public static final int TIMER_DELAY = 20;

    public static Snake snake = new Snake();

    private JFrame jframe;
    public RenderPanel renderPanel;
    public Timer timer = new Timer(TIMER_DELAY, this);
    public ArrayList<Point> snakeParts = new ArrayList<>();
    public int ticks = 0, direction = DOWN, score, tailLength = 10, time;
    public Point head, cherry;
    public Random random;
    public boolean over = false, paused;
    public Dimension dim;

    public Snake() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(805, 700);
        jframe.setResizable(false);
        jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
        renderPanel = new RenderPanel();
        jframe.add(renderPanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addKeyListener(this);
        startGame();
    }

    public void startGame() {
        over = false;
        paused = false;
        time = 0;
        score = 0;
        tailLength = 14;
        ticks = 0;
        direction = DOWN;
        head = new Point(0, -1);
        random = new Random();
        snakeParts.clear();
        cherry = new Point(random.nextInt(79), random.nextInt(66));
        timer.start();
    }

   @Override
public void actionPerformed(ActionEvent e) {
    renderPanel.repaint();
    ticks++;

    if (ticks % 2 == 0 && !over && !paused && head != null) {
        time++;
        snakeParts.add(new Point(head.x, head.y));

        int x = head.x;
        int y = head.y;
        if (direction == UP) {
            y--;
        } else if (direction == DOWN) {
            y++;
        } else if (direction == LEFT) {
            x--;
        } else if (direction == RIGHT) {
            x++;
        }

        if (x < 0 || x >= 80 || y < 0 || y >= 67 || snakeParts.contains(new Point(x, y))) {
            over = true;
        } else {
            head = new Point(x, y);
        }

        if (snakeParts.size() > tailLength) {
            snakeParts.remove(0);
        }

        // Comprobación de la fruta
        if (cherry != null && head.equals(cherry)) {
            score += 10;
            tailLength++;
            cherry.setLocation(random.nextInt(79), random.nextInt(66));
        }
    }
}



    public boolean noTailAt(int x, int y) {
        for (Point point : snakeParts) {
            if (point.equals(new Point(x, y))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        snake = new Snake();
    }

@Override
public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();

    if ((keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) && direction != RIGHT) {
        direction = LEFT;
    }

    if ((keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) && direction != LEFT) {
        direction = RIGHT;
    }

    if ((keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) && direction != DOWN) {
        direction = UP;
    }

    if ((keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) && direction != UP) {
        direction = DOWN;
    }

    if (keyCode == KeyEvent.VK_SPACE) {
        if (over) {
            startGame();
        } else {
            paused = !paused;
        }
    }
}


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
