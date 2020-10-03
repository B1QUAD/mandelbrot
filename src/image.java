import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class image {

	private int width, height, alpha = 255;
	private BufferedImage img;
	private File f;

	image(int w, int h) {
		width = w;
		height = h;
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	image() {
		width = 3840;
		height = 2160; // Should be changed to be object oriented.
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public void setAlpha(int a) {
		alpha = a;
	}

	public void draw(int r, int g, int b, int x, int y) {
		int p = (alpha << 24) | (r << 16) | (g << 8) | b; //pixel
		img.setRGB(x, y, p);
	}

	public void writeFile(String path) {
		try {
			f = new File(path);
			ImageIO.write(img, "tiff", f);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
