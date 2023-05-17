package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    private static final Color GREEN = new Color(1666073);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Snake snake = Snake.snake;

        g.setColor(GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLUE);

        int scale = Snake.SCALE;

        for (Point point : snake.snakeParts) {
            g.fillRect(point.x * scale, point.y * scale, scale, scale);
        }

        Point head = snake.head;
        g.fillRect(head.x * scale, head.y * scale, scale, scale);

        g.setColor(Color.RED);

        Point cherry = snake.cherry;
        g.fillRect(cherry.x * scale, cherry.y * scale, scale, scale);

        g.setColor(Color.white);

        String scoreString = "Score: " + snake.score;
        String lengthString = "Length: " + snake.tailLength;
        String timeString = "Time: " + (snake.time / 20);

        int stringX = (int) (getWidth() / 2f - scoreString.length() * 2.5f);
        int stringY = 10;

        g.drawString(scoreString, stringX, stringY);
        g.drawString(lengthString, stringX, stringY + 15);
        g.drawString(timeString, stringX, stringY + 30);

        if (snake.over || snake.paused) {
            String statusString = snake.over ? "Game Over!" : "Paused!";
            g.drawString(statusString, (int) (getWidth() / 2f - statusString.length() * 2.5f), (int) (getHeight() / 4f));
        }
    }
}
