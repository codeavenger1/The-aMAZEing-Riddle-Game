import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class mazeRiddleMAIN {
	static JFrame frame;
	MazeRiddlePANEL panel;
	static int height = 655;
	static int width = 1000;
	BufferedImage test1;

	public mazeRiddleMAIN() {
		// TODO Auto-generated constructor stub
		this.frame = new JFrame();
		this.panel = new MazeRiddlePANEL();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mazeRiddleMAIN main = new mazeRiddleMAIN();
		// test1easyMAZE maze = new test1easyMAZE(0, 0 , width, height);
		main.setup();
	}

	void setup() {
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		panel.startGame();
	}

}