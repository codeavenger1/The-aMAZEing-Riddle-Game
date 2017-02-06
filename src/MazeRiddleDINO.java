import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazeRiddleDINO extends mazeRiddleGameOBJECT implements KeyListener {
	int speed;

	public MazeRiddleDINO(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 5;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void moveRight() {
		// TODO Auto-generated method stub
		x += speed;
	}

	void moveLeft() {
		// TODO Auto-generated method stub
		x -= speed;
	}

	void moveDown() {
		// TODO Auto-generated method stub
		y += speed;
	}

	void moveUp() {
		// TODO Auto-generated method stub
		y -= speed;
	}
}
