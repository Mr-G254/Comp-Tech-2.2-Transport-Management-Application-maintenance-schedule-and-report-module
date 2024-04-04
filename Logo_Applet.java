import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

@SuppressWarnings("removal")
public class Logo_Applet extends Applet {
    private Image logo;

    public void init() {
        try {
            // Load the image from file path
            File file = new File("logo.png"); // Replace "path/to/your/logo.png" with the actual file path
            logo = ImageIO.read(file);
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (logo != null) {
            // Draw the image at (0, 0)
            g.drawImage(logo, 0, 0, this);
        } else {
            // Image not loaded, display a message
            g.drawString("Image not loaded", 20, 20);
        }
    }
}