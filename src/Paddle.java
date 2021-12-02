

import java.awt.Color;

import Graphics.CanvasWindow;
import Graphics.Rectangle;

/**
 * A class that is used to the canvas' paddle. 
 */

public class Paddle {
    private Rectangle paddle;
/**
 * Makes a paddle with stroke and fill color on the canvas.
 * @param canvas - the user-facing window.
 */
    public Paddle(CanvasWindow canvas) {
        paddle = new Rectangle(200, 600, 130, 20);
        paddle.setFillColor(Color.GREEN);
        paddle.setStrokeColor(Color.BLACK);
        canvas.add(paddle);
    }

/**
 * Returns paddle. 
 */
    public Rectangle getPaddle() {
        return paddle;
    }

}
