
import java.awt.Color;
import java.util.List;
import java.util.Set;
import Graphics.*;
import Graphics.events.Key;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 750;
    private Ellipse ball;
    int paddleWidth = 130;
    int PADDLE_Y = 580;
    private int lives = 0;
    private Bricks brick = new Bricks();
    private Paddle myPaddle;
    private GraphicsGroup bricks = brick.getBricks();
    private List<Rectangle> BrickList = brick.getBrickList();
    private Borders borders = new Borders();
    private int totalAttempts = 3;
    private GraphicsText livesCounter = new GraphicsText("Attempts : " + totalAttempts, CANVAS_WIDTH * 0.8,
        CANVAS_HEIGHT * 0.04);
    private CanvasWindow canvas;
    private int dx = 2, dy = -5;


    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        myPaddle = new Paddle(canvas);
        canvas.setBackground(Color.BLACK);
        borders.createBorders(canvas);
        brick.CreateBricks(canvas);
        livesCounter.setFillColor(Color.white);
        livesCounter.setFontSize(13);
        canvas.add(livesCounter);
        ball = new Ellipse(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, 20, 20);
        ball.setFillColor(Color.MAGENTA);
        canvas.add(ball);
        canvas.draw();
        canvas.pause(3000);

        /**
         * Takes in different methods and animates them on the canvas accoringly. If all bricks have been
         * destroyed by the user, the user wins and the game ends.
         */
        canvas.animate(() -> {
            movePaddle();
            checkforCollision();
            if (brick.getBrickList().size() == 0) {
                canvas.closeWindow();
            }
            WinorLose();
        });
    }


    /**
     * Checks for any collision between the borders, the paddle, or the bricks with one of the 4 sides
     * of the ball. If the ball collides with the paddle, it bounces back up. If it collides with a
     * border wall it bounces back to the opposite x direction. However, if the ball collides with a
     * brick, it bounces back to the opposite direction but also destroy's the brick it collides with.
     */
    private void checkforCollision() {
        GraphicsObject brick;
        ball.moveBy(dx, dy);
        double x = ball.getCenter().getX();
        double y = ball.getCenter().getY();
        List<Point> listOfPoints = List.of(new Point(x, y - 10), new Point(x + 10, y), new Point(x - 10, y),
            new Point(x, y + 10));
        if (borders.getBorders().getElementAt(listOfPoints.get(0)) != null
            || borders.getBorders().getElementAt(listOfPoints.get(3)) != null) {
            dy = -dy;
        }
        if (canvas.getElementAt(listOfPoints.get(3)) == myPaddle.getPaddle()) {
            dy = -dy;
        }
        if (borders.getBorders().getElementAt(listOfPoints.get(1)) != null
            || borders.getBorders().getElementAt(listOfPoints.get(2)) != null) {
            dx = -dx;
        }
        brick = bricks.getElementAt(listOfPoints.get(0));
        if (brick != null) {
            dy = -dy;
            bricks.remove(brick);
            BrickList.remove(brick);
        }
        brick = bricks.getElementAt(listOfPoints.get(3));
        if (brick != null) {
            dy = -dy;
            bricks.remove(brick);
            BrickList.remove(brick);
        }
        brick = bricks.getElementAt(listOfPoints.get(1));
        if (brick != null) {
            dx = -dx;
            bricks.remove(brick);
            BrickList.remove(brick);
        }
        brick = bricks.getElementAt(listOfPoints.get(2));
        if (brick != null) {
            dx = -dx;
            bricks.remove(brick);
            BrickList.remove(brick);
        }

    }

    /**
     * Moves paddle on the x-axis using either the left or right keyboard keys.
     */
    private void movePaddle() {

        Set<Key> keys = canvas.getKeysPressed();
        if (keys.contains(Key.LEFT_ARROW)) {
            if (myPaddle.getPaddle().getCenter().getX() - 65 - 15 > 10) { // (B)
                myPaddle.getPaddle().moveBy(-10, 0);
            }
        }

        if (keys.contains(Key.RIGHT_ARROW)) {
            if (myPaddle.getPaddle().getCenter().getX() + 65 + 15 < CANVAS_WIDTH - 10) { // (B)
                myPaddle.getPaddle().moveBy(10, 0);
            }
        }
    }
    /**
     * Checks if the ball goes below the height of the paddle. If this happens 3 times, the user loses
     * and the game ends.
     */
    private void WinorLose() {
        if (ball.getCenter().getY() > 620) {
            // ball.pause();
            ball.setCenter(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
            checkforCollision();
            lives += 1;
            totalAttempts--;
            livesCounter.setText("Attempts: " + totalAttempts);
            canvas.draw();
            canvas.pause(3000);
        }
        if (lives == 3) {
            canvas.closeWindow();

        }
    }
    
    public static void main(String[] args) {
        new BreakoutGame();
    }
}
