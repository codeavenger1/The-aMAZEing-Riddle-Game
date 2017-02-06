import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazeRiddlePANEL extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	public static BufferedImage maze1Img;
	public static BufferedImage dinoImg;
	public static int MAZESTARTx = 417;
	public static int MAZESTARTy = 17;
	MazeRiddleDINO dino = new MazeRiddleDINO(MAZESTARTx, MAZESTARTy, 50, 50);

	public MazeRiddlePANEL() {
		// TODO Auto-generated constructor stub
		this.timer = new Timer(1000 / 60, this);

		try {
			maze1Img = ImageIO.read(this.getClass().getResourceAsStream("test1easyMaze.png"));
			dinoImg = ImageIO.read(this.getClass().getResourceAsStream("Dino.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		System.out.println("action performed");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(maze1Img, 0, 0, 1000, 633, null);
		g.drawImage(dinoImg, dino.x, dino.y, dino.height, dino.width, null);
	}

	void startGame() {
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RightKeyPressed");
			dino.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LeftKeyPressed");
			dino.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DownKeyPressed");
			dino.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UpKeyPressed");
			dino.moveUp();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}