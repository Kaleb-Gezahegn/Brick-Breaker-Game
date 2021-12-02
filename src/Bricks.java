

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Graphics.CanvasWindow;
import Graphics.GraphicsGroup;
import Graphics.Rectangle;

   /**
     * A class that is used to create and access bricks on canvas.
     */
public class Bricks {
    public GraphicsGroup bricks = new GraphicsGroup();
    public List<Rectangle> ListBricks = new ArrayList<>();

    /**
     * Produces lines of different colored bricks on the canvas.
     * @param canvas The user-visble window. 
     */
    public void CreateBricks(CanvasWindow canvas) {
        double j = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle redBrick = new Rectangle(j, 50, 60, 20);
            j = 70 + redBrick.getX();
            redBrick.setFillColor(Color.red);
            bricks.add(redBrick);
            ListBricks.add(redBrick);
        }
        double k = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle redBrick = new Rectangle(k, 80, 60, 20);
            k = 70 + redBrick.getX();
            redBrick.setFillColor(Color.red);
            bricks.add(redBrick);
            ListBricks.add(redBrick);

        }
        double l = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle blueBrick = new Rectangle(l, 110, 60, 20);
            l = 70 + blueBrick.getX();
            blueBrick.setFillColor(Color.blue);
            bricks.add(blueBrick);
            ListBricks.add(blueBrick);

        }
        double z = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle blueBrick = new Rectangle(z, 140, 60, 20);
            z = 70 + blueBrick.getX();
            blueBrick.setFillColor(Color.blue);
            bricks.add(blueBrick);
            ListBricks.add(blueBrick);

        }
        double e = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle cyanBrick = new Rectangle(e, 170, 60, 20);
            e = 70 + cyanBrick.getX();
            cyanBrick.setFillColor(Color.cyan);
            bricks.add(cyanBrick);
            ListBricks.add(cyanBrick);
        }
        double m = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle cyanBrick = new Rectangle(m, 200, 60, 20);
            m = 70 + cyanBrick.getX();
            cyanBrick.setFillColor(Color.cyan);
            bricks.add(cyanBrick);
            ListBricks.add(cyanBrick);
        }
        double g = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle orangeBrick = new Rectangle(g, 230, 60, 20);
            g = 70 + orangeBrick.getX();
            orangeBrick.setFillColor(Color.orange);
            bricks.add(orangeBrick);
            ListBricks.add(orangeBrick);
        }

        double p = 25;
        for (int i = 0; i < 8; i++) {
            Rectangle orangeBrick = new Rectangle(p, 260, 60, 20);
            p = 70 + orangeBrick.getX();
            orangeBrick.setFillColor(Color.orange);
            bricks.add(orangeBrick);
            ListBricks.add(orangeBrick);
        }

        canvas.add(bricks);

    }

    /**
     * Returns bricks.
     */
    public GraphicsGroup getBricks() {
        return bricks;
    }

    /**
     * Returns list of bricks. 
     */
    public List<Rectangle> getBrickList() {
        return ListBricks;
    }


}

