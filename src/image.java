import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class image {

	private int width, height, alpha = 255;
	private BufferedImage img;
	private File f = null;

	image(int w, int h) {
		width = w;
		height = h;
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	image() {
		width = 1440 * 2;
		height = 900 * 2;
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

	public static void main(String args[]) throws IOException {
		//image dimension
		int width = 1920;
		int height = 1920;
		//create buffered image object img
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		//file object
		File f = null;
		//create random image pixel by pixel
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
//         int a = (int)(Math.random()*256); //alpha
				int a = 255;
//				int r = (int) (Math.random() * 256); //red
//				int g = (int) (Math.random() * 256); //green
//				int b = (int) (Math.random() * 256); //blue
				int r = x * (int) Math.sin(y % (y + 1));
				int g = x % (y + 1);
				int b = x + y;
				int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel
				//System.out.println("R: " + r + " G: " + g + " B: " + b +" A: " + a);
				img.setRGB(x, y, p);
			}
		}

		//write image
		try {
			f = new File("Output.png");
			ImageIO.write(img, "png", f);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
