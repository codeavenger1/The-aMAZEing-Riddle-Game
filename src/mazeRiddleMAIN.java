import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mazeRiddleMAIN {
	JFrame frame;
	JPanel panel;
	static int height = 1000;
	static int width = 633;
	BufferedImage test1;

	public mazeRiddleMAIN() {
		// TODO Auto-generated constructor stub
		this.frame = new JFrame();
		this.panel = new JPanel();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mazeRiddleMAIN main = new mazeRiddleMAIN();
		test1easyMAZE maze = new test1easyMAZE(0, 0 , width, height);
		 
	}

	void setup() {
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}