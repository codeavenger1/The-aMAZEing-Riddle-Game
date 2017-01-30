import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class test1easyMAZE extends mazeRiddleGameOBJECT {
	BufferedImage test1;

	public test1easyMAZE(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		try {
			test1 = ImageIO.read(this.getClass().getResourceAsStream("test1easyMaze.png"));
		} catch (Exception e) {
			System.out.println("cannot find test1easyMaze.png");
		}
	}

	void draw(Graphics g) {

		
		
		g.drawImage(test1, x, y, width, height, null);
		super.draw(g);
	}
}