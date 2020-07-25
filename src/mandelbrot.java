import java.util.Set;

public class mandelbrot {

	private static int maxIter = 1000;
	private static int resX = 3840, resY = 2160;
	private static double minX = -2, minY = -1.5, maxX = 0.5, maxY = 1.5;

	// Range shifting (screenspace range) / xResolution * xInput + xMinimum
	public double mapX(int screenX) {
		return ((Math.abs(maxX - minX) / resX) * screenX) + minX;
	}

	public double mapY(int screenY) {
		return ((Math.abs(maxY - minY) / resY) * screenY) + minY;
	}
	
	public int mandelbrot(double real, double imag) {
		complexNum c = new complexNum(real, imag);
		complexNum z = new complexNum(0, 0);
		for (int i = 0; i < maxIter; i++) {
			z = z.add(z.multiply(z, z), c);
			if (Math.hypot(z.getReal(), z.getImaginary()) >= 4.0) {
				return i;
			}
		}
		return maxIter;
	}
}
