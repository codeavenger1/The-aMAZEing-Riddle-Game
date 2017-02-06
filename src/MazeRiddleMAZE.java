import java.awt.Graphics;

public class MazeRiddleMAZE extends mazeRiddleGameOBJECT {
	public MazeRiddleMAZE(int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		this.x = 0;
		this.y = 0;
		this.width = width;
		this.height = height;
	}

	void draw(Graphics g) {
		g.drawImage(MazeRiddlePANEL.maze1Img, x, y, width, height, null);

	}

}
