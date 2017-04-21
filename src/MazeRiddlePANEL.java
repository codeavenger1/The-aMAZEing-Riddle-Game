import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazeRiddlePANEL extends JPanel implements ActionListener, KeyListener, MouseListener {
	Timer timer;
	boolean test = false;
	public static BufferedImage maze1Img;
	public static BufferedImage dinoImg;
	public static BufferedImage LineImg;
	public static int MAZESTARTx = 417;
	public static int MAZESTARTy = 17;
	public static int Line1x = 406;
	public static int Line1y = 20;
	public static int Line2x = 407;
	public static int Line2y = 67;
	public static int Line3x = 231;
	public static int Line3y = 75;
	public static int Line4x = 110;
	public static int Line4y = 137;
	public static int Line5x = 406;
	public static int Line5y = 198;
	public static int Line6x = 405;
	public static int Line6y = 316;
	public static int Line7x = 885;
	public static int Line7y = 136;
	public static int Line8x = 590;
	public static int Line8y = 250;
	public static int Line9x = 829;
	public static int Line9y = 365;
	public static int Line10x = 710;
	public static int Line10y = 490;
	public static int Line11x = 710;
	public static int Line11y = 490;
	public static int Line12x = 530;
	public static int Line12y = 370;
	public static int Line13x = 295;
	public static int Line13y = 370;
	public static int Line14x = 288;
	public static int Line14y = 198;

	MazeRiddleDINO dino = new MazeRiddleDINO(MAZESTARTx, MAZESTARTy, 50, 50);
	RedLines line = new RedLines(Line1x, Line1y, 8, 55);
	RedLines line2 = new RedLines(Line2x, Line2y, 55, 8);
	RedLines line3 = new RedLines(Line3x, Line3y, 55, 8);
	RedLines line4 = new RedLines(Line4x, Line4y, 8, 55);
	RedLines line5 = new RedLines(Line5x, Line5y, 8, 55);
	RedLines line6 = new RedLines(Line6x, Line6y, 8, 55);
	RedLines line7 = new RedLines(Line7x, Line7y, 8, 55);
	RedLines line8 = new RedLines(Line8x, Line8y, 55, 8);
	RedLines line9 = new RedLines(Line9x, Line9y, 55, 8);
	RedLines line10 = new RedLines(Line10x, Line10y, 55, 8);
	RedLines line11 = new RedLines(Line11x, Line11y, 8, 55);
	RedLines line12 = new RedLines(Line12x, Line12y, 55, 8);
	RedLines line13 = new RedLines(Line13x, Line13y, 55, 8);
	RedLines line14 = new RedLines(Line14x, Line14y, 8, 55);

	public MazeRiddlePANEL() {
		// TODO Auto-generated constructor stub
		this.timer = new Timer(1000 / 60, this);

		try {
			maze1Img = ImageIO.read(this.getClass().getResourceAsStream("test1easyMaze.png"));
			dinoImg = ImageIO.read(this.getClass().getResourceAsStream("Dino.png"));
			LineImg = ImageIO.read(this.getClass().getResourceAsStream("redline1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(maze1Img, 0, 0, 1000, 633, null);
		g.drawImage(dinoImg, dino.x, dino.y, dino.width, dino.height, null);
		line.draw(g,LineImg);
		line2.draw(g,LineImg);
		line3.draw(g,LineImg);
		line4.draw(g,LineImg);
		line5.draw(g,LineImg);
		line6.draw(g,LineImg);
		line7.draw(g,LineImg);
		line8.draw(g,LineImg);
		line9.draw(g,LineImg);
		line10.draw(g,LineImg);
		line11.draw(g,LineImg);
		line12.draw(g,LineImg);
		line13.draw(g,LineImg);
		line14.draw(g,LineImg);
		
		
		canMoveTo(dino.x + (dino.width / 2), dino.y + (dino.height-10)); // top middle dot
		canMoveTo(dino.x, dino.y + (dino.height / 2)); // left middle dot
		canMoveTo(dino.x + (dino.width / 2), dino.y + (dino.height)); // bottom middle dot
		canMoveTo(dino.x + (dino.width-10), dino.y + (dino.height / 2)); // right middle dot

		g.fillRect(dino.x + (dino.width / 2 ), dino.y +(dino.height -3), 1, 1); // top middle dot
		g.fillRect(dino.x, dino.y + (dino.height / 2 ), 1, 1); // left middle dot
		g.fillRect(dino.x + (dino.width / 2), dino.y + (dino.height-2), 1, 1); // bottom middle dot
		g.fillRect(dino.x + (dino.width-10), dino.y + (dino.height / 2), 1, 1); // right middle dot
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

	public void canMoveTo(int x, int y) {
		int mazeColor = maze1Img.getRGB(x, y);
	
			
		if (mazeColor < -400000) {
		if (mazeColor < (x = 410) && (y == 44)) {
			
		}
			tellRiddle();
		}
//411,49
		if (mazeColor < -16000000) {
			dino.x = 417;
			dino.y = 17;
			System.out.println(mazeColor);
			System.out.println("collided");

			line.setVisible(true);
			line2.setVisible(true);
			line3.setVisible(true);
			line4.setVisible(true);
			line5.setVisible(true);
			line6.setVisible(true);
			line7.setVisible(true);
			line8.setVisible(true);
			line9.setVisible(true);
			line10.setVisible(true);
			line11.setVisible(true);
			line12.setVisible(true);
			line13.setVisible(true);
		
		}
		
	}

	public void tellRiddle() {
		timer.stop();

		if (dino.x > line.x - line.height && dino.x < line.x + line.width && dino.y > line.y && dino.y < line.y + line.height && line.visible) {
			System.out.println("line.x" + line.x);
			System.out.println("line.x + line.width" + (line.x + line.width));
			System.out.println("dino.x" + dino.x);
System.out.println("red line 1");

			String riddle1 = JOptionPane.showInputDialog("Answer this riddle to pass this line: \nWhat gets shorter, the older it becomes?");
			
			if (riddle1.equalsIgnoreCase("pencil")){
				line.setVisible(false);
				JOptionPane.showMessageDialog(null, "You are correct!");
				dino.x = Line1x - 17;
				dino.y = Line1y + 2;
			} else if (riddle1.equalsIgnoreCase("candle")) {
				line.setVisible(false);
				JOptionPane.showMessageDialog(null, "You are correct!");
				dino.x = Line1x - 17;
				dino.y = Line1y + 2;
				
			}
			else if (riddle1.equalsIgnoreCase("a pencil")) {
				line.setVisible(false);
				JOptionPane.showMessageDialog(null, "You are correct!");
				dino.x = Line1x - 17;
				dino.y = Line1y+2;
			}
			else if (riddle1.equalsIgnoreCase("a candle")) {
				line.setVisible(false);
				JOptionPane.showMessageDialog(null, "You are correct!");
				dino.x = Line1x - 17;
				dino.y = Line1y+2;
			}
			else {
				JOptionPane.showMessageDialog(null, "C'mon people! Know your facts!!! YOU ARE WRONG!!! \nStart again and answer this riddle to pass this line.");
				dino.x = 417;
				dino.y = 17;
				line.x = 406;
				line.y = 20;
			}

		}
		if (dino.x > line2.x - line2.height && dino.x < line2.x + line2.width && dino.y > line2.y && dino.y < line2.y + line2.height && line2.visible) {

			String riddle1 = JOptionPane.showInputDialog("Answer this riddle to pass this line: \nWhat gets wetter the more it dries?");
			if (riddle1.equalsIgnoreCase("towel")) {
				line2.setVisible(false);
				JOptionPane.showMessageDialog(null, "Correct! Great job!");
				dino.x = Line2x + 10;
				dino.y = Line2y + 17;
			}
			else if (riddle1.equalsIgnoreCase("a towel")) {
				line2.setVisible(false);
				JOptionPane.showMessageDialog(null, "Correct! Great job!");
				dino.x = Line2x + 10;
				dino.y = Line2y + 17;
			}
			else {
				JOptionPane.showMessageDialog(null, "Nice try, but....YOU ARE WRONG!!! \nStart again and answer this riddle to pass this line.");
				dino.x = 417;
				dino.y = 17;
				line2.x = 407;
				line2.y = 67;
			}

		}
		if (dino.x > line3.x - line3.height && dino.x < line3.x + line3.width && dino.y > line3.y && dino.y < line3.y + line3.height) {
			
			String riddle1 = JOptionPane.showInputDialog("Answer this riddle to pass this line: \nWhat has a face and two hands, but no arms or legs?");
			if (riddle1.equalsIgnoreCase("a clock")) {
				line3.setVisible(false);
				JOptionPane.showMessageDialog(null, "Yay! Nice job!");
				dino.x = Line3x;
				dino.y = Line3y+5;
			}
			else if (riddle1.equalsIgnoreCase("clock")) {
				line3.setVisible(false);
				JOptionPane.showMessageDialog(null, "Yay! Nice job!");
				dino.x = Line3x;
				dino.y = Line3y+5;
			}
			else {
				JOptionPane.showMessageDialog(null, "WRONG!!  \nStart again and answer this riddle to pass this line.");
				dino.x = 417;
				dino.y = 17;
				line3.x = 231;
				line3.y = 75;
			}
		
		}
		if (dino.x > line4.x - line4.height && dino.x < line4.x + line4.width && dino.y > line4.y && dino.y < line4.y + line4.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line5.x - line5.height && dino.x < line5.x + line5.width && dino.y > line5.y && dino.y < line5.y + line5.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line6.x - line6.height && dino.x < line6.x + line6.width && dino.y > line6.y && dino.y < line6.y + line6.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line7.x - line7.height && dino.x < line7.x + line7.width && dino.y > line7.y && dino.y < line7.y + line7.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line8.x - line8.height && dino.x < line8.x + line8.width && dino.y > line8.y && dino.y < line8.y + line8.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line9.x - line9.height && dino.x < line9.x + line9.width && dino.y > line9.y && dino.y < line9.y + line9.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line10.x - line10.height && dino.x < line10.x + line10.width && dino.y > line10.y && dino.y < line10.y + line10.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line11.x - line11.height && dino.x < line11.x + line11.width && dino.y > line11.y && dino.y < line11.y + line11.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}
		if (dino.x > line12.x - line12.height && dino.x < line12.x + line12.width && dino.y > line12.y && dino.y < line12.y + line12.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}

		if (dino.x > line13.x - line13.height && dino.x < line13.x + line13.width && dino.y > line13.y && dino.y < line13.y + line13.height) {

			String riddle1 = JOptionPane.showInputDialog("riddle");
			dino.x = 417;
			dino.y = 17;
		}

		if (dino.x > line14.x - line14.height && dino.x < line14.x + line14.width && dino.y > line14.y && dino.y < line14.y + line14.height) {

			String riddle14 = JOptionPane.showInputDialog(
					"A man lives on the 10th floor of an apartment building.\n Every morning he takes the elevator all the way down to the bottom and goes to work.\n In the evening, when he comes back from work, he gets into the elevator, and if there is someone else in it, he goes back to the 10th floor. \n On rainy days he also goes directly to his floor. \n On all other days, he goes to the 7th floor and walks up 3 flights of stairs to his apartment. \n Why?");
			if (riddle14.equals("He is a midget.")) {
				JOptionPane.showMessageDialog(null, "You are correct!");
			} else {
				JOptionPane.showMessageDialog(null, "C'mon people! Know your facts!!! YOU ARE WRONG!!!");
			}
			dino.x = 417;
			dino.y = 17;
		}
		timer.start();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("x is " + e.getX() + " y is " + e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}