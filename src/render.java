import java.util.concurrent.*;

class test implements Runnable {

	private int id, xMin, yMin, xMax, yMax;

	public test(int inId, int minX, int minY, int maxX, int maxY) {
		id = inId;
		xMin = minX;
		yMin = minY;
		xMax = maxX;
		yMax = maxY;
	}

	public void run() {
		System.out.println("Thread " + id + " Started");
		mandelbrot mn = new mandelbrot();

		for (int y = yMin; y < yMax; y++) {
			for (int x = xMin; x < xMax; x++) {
				int it = mn.mandelbrot(mn.mapX(x), mn.mapY(y));
				
				if (it == 0) {
					render.img.draw(0, 0, 0, x, y);
				} else if (it % 3 == 0) {
					render.img.draw(0, 128, 0, x, y);
				} else if (it % 2 == 0) {
					render.img.draw(0, 255, 0, x, y);
				} else if (it % 1 == 0) {
					render.img.draw(0, 128, 0, x, y);
				}
			}
		}
		System.out.println("thread " + id + " finished.");
	}
}

public class render {

	public static int resX = 3840, resY = 2160, div = 20, vDiv = 20;
	public static image img = new image(resX, resY);
	public void man() {
		ExecutorService excecutor = Executors.newFixedThreadPool(20);
		
		int iter = 0;
		for (int i = 0; i < vDiv; i++) {
			for (int j = 0; j < div; j++) {
				excecutor.submit(new test(iter, (resX/div) * j, (resY/vDiv) * i, (resX/div) * (j + 1), (resY/vDiv) * (i + 1)));
				iter++;
			}
		}
		excecutor.shutdown();

		System.out.println("All tasks submitted");

		try {
			excecutor.awaitTermination(1, TimeUnit.HOURS);
		} catch (Exception e) {
			System.out.println("Termination Failed. " + e.getLocalizedMessage());
		}

		img.writeFile("mnd.tiff");
		System.out.println("All threads complete");
	}

	public static void main(String[] args) {
		render rn = new render();
		rn.man();
	}
}
