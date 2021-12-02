// package breakout;

import java.awt.Color;

import Graphics.CanvasWindow;
import Graphics.GraphicsGroup;
import Graphics.Rectangle;

/**
 * A class that is used to create and access borders on canvas.
 */

public class Borders {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 750;
    private Rectangle paddle;

    public GraphicsGroup borders = new GraphicsGroup();

     /**
     * Creates borders. 
     */
    public void createBorders(CanvasWindow canvas) {
        Rectangle border;
        // Left Side Rectangle
        border = new Rectangle(0, 0, 10, CANVAS_HEIGHT);
        border.setFillColor(Color.MAGENTA);
        borders.add(border);

        // Top Side
        border = new Rectangle(0, 0, CANVAS_WIDTH, 10);
        border.setFillColor(Color.MAGENTA);
        borders.add(border);

        // Right Side
        border = new Rectangle(CANVAS_WIDTH - 10, 0, 10, CANVAS_HEIGHT);
        border.setFillColor(Color.MAGENTA);
        borders.add(border);

        // Bottom Side
        border = new Rectangle(0, CANVAS_HEIGHT - 10, CANVAS_WIDTH, 10);
        border.setFillColor(Color.MAGENTA);
        borders.add(border);
        canvas.add(borders);

    }
     /**
     * Returns borders.
     */

    public GraphicsGroup getBorders() {
        return borders;
    }
     /**
     * Returns paddle
     */

    public Rectangle getPaddle() {
        return paddle;
    }
}

