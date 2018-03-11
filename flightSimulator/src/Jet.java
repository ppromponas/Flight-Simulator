import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Παναγιώτης on 29/11/2017.
 */
public class Jet extends Airplane {

    public static int takeOffOnVelocity = 140; //knots
    public static int maxVelocity = 280;
    public static int maxFuel = 16000; //kg
    public static int maxHeight = 28000; //feet
    public static long[] sleepTimeInPhase = new long[6];
    public static double fuelPerPixel;


    public Jet(int x, int y, String orientation, int height) {
        super(x, y, orientation, height);
        this.setBounds(xPos - 8, yPos - 8, 50, 50);
        typeOfPlane = 3;
    }


    @Override
    public void paint(Graphics g) {
        // draw this plane
        super.paintComponent(g);
        g.drawImage(getImage(), 0, 0, this);
        this.setBounds(xPos - 8, yPos - 8, 50, 50);
    }


    private Image getImage() {
        // Get the image we need depending on orientation, and type
        // (Could be in Airplane class)
        String imageName = "big_" + this.orientation;
        Image myImage = null;
        try {
            if (this.orientation.equals("w") || this.orientation.equals("e") || this.orientation.equals("n") || this.orientation.equals("s")) {
                myImage = ImageIO.read(new File(imageName + ".png"));
            } else {
                myImage = ImageIO.read(new File("big_w.png"));
            }
            if (this.orientation.equals("sw")) {
                myImage = rotate((BufferedImage) myImage, -120);
            } else if (this.orientation.equals("se")) {
                myImage = rotate((BufferedImage) myImage, -90);
            } else if (this.orientation.equals("nw")) {
                myImage = rotate((BufferedImage) myImage, 120);
            } else if (this.orientation.equals("ne")) {
                myImage = rotate((BufferedImage) myImage, 90);
            }
        } catch (IOException ex) {
            System.out.println("cannot find " + imageName + ".png");
            System.exit(0);
        }
        return myImage;
    }


}
