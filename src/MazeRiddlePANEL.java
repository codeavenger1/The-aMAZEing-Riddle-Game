import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazeRiddlePANEL extends JPanel implements ActionListener, KeyListener, MouseListener {
	Timer timer;
	Robot robot;
	boolean test = false;
	public static BufferedImage maze1Img;
	public static BufferedImage dinoImg;
	public static BufferedImage LineImg;
	public static int MAZESTARTx = 890;//417;
	public static int MAZESTARTy = 80; //17;
	public static int Line1x = 406;
	public static int Line1y = 20;
	public static int Line2x = 407;
	public static int Line2y = 75;
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
			robot = new Robot();
			maze1Img = ImageIO.read(this.getClass().getResourceAsStream("test1easyMaze.png"));
			dinoImg = ImageIO.read(this.getClass().getResourceAsStream("Dino.png"));
			LineImg = ImageIO.read(this.getClass().getResourceAsStream("redline1.png"));
		} catch (IOException | AWTException e) {
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
		
		
		canMoveTo(dino.x + (dino.width / 2), dino.y+10); // top middle dot
		canMoveTo(dino.x, dino.y + (dino.height / 2)); // left middle dot
		canMoveTo(dino.x + (dino.width / 2), dino.y + (dino.height-10)); // bottom middle dot
		canMoveTo(dino.x + (dino.width-20), dino.y + (dino.height / 2)); // right middle dot

//		g.setColor(Color.GREEN.darker().darker());
//		g.fillRect(dino.x + (dino.width / 2), dino.y+10, 2, 2); // top middle dot
//		g.fillRect(dino.x, dino.y + (dino.height / 2 ), 2, 2); // left middle dot
//		g.fillRect(dino.x + (dino.width / 2), dino.y + (dino.height-10), 2, 2); // bottom middle dot
//		g.fillRect(dino.x + (dino.width-10), dino.y + (dino.height / 2), 2, 2); // right middle dot
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
			dino.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			dino.moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			dino.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			dino.moveUp();
		}
	}

	public void canMoveTo(int x, int y) {
		Color color = robot.getPixelColor(x, y);
		int mazeColor = color.getRGB();
		System.out.println(mazeColor);
		int backgroundcolor = maze1Img.getRGB(x, y);
		//if (mazeColor < -400000) {
		//	System.out.println("riddle");
			tellRiddle(x, y);
		//}

		if (backgroundcolor == -16777216) {
			
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

	public void tellRiddle(int x, int y) {
		timer.stop();

		if (x > line.x - line.height && x < line.x + line.width && y > line.y && y < line.y + line.height && line.visible) {
			riddleChooser(1);

		}
		if (x > line2.x - line2.height && x < line2.x + line2.width && y > line2.y && y < line2.y + line2.height && line2.visible){
			riddleChooser(2);
		}
		
		if (x > line3.x - line3.height && x < line3.x + line3.width && y > line3.y && y < line3.y + line3.height && line3.visible) {
			riddleChooser(3);
		}
		
		if (x > line4.x && x < line4.x + line4.width && y > line4.y && y < line4.y + line4.height && line4.visible) {
			riddleChooser(4);
		}
		
		if (x > line5.x && x < line5.x + line5.width && y > line5.y && y < line5.y + line5.height && line5.visible) {
			riddleChooser(5);
		}
		
		if (x > line6.x && x < line6.x + line6.width && y > line6.y && y < line6.y + line6.height && line6.visible) {
			riddleChooser(6);
		}

		if (x > line7.x && x < line7.x + line7.width && y > line7.y && y < line7.y + line7.height && line7.visible) {
			riddleChooser(7);
		}

		if (x > line8.x - line8.height && x < line8.x + line8.width && y > line8.y && y < line8.y + line8.height && line8.visible) {
			riddleChooser(8);
		}
		
		if (x > line9.x && x < line9.x + line9.width && y > line9.y && y < line9.y + line9.height && line9.visible) {
			riddleChooser(9);
		}
		
		if (x > line10.x - line10.height && x < line10.x + line10.width && y > line10.y && y < line10.y + line10.height) {
			riddleChooser(10);	
		}
		
		if (x > line11.x - line11.height && x < line11.x + line11.width && y > line11.y && y < line11.y + line11.height) {
riddleChooser(11);
	}
//		if (x > line12.x - line12.height && x < line12.x + line12.width && y > line12.y && y < line12.y + line12.height) {
//
//			String riddle1 = JOptionPane.showInputDialog("riddle");
//			dino.x = 417;
//			dino.y = 17;
//		}
//
//		if (x > line13.x - line13.height && x < line13.x + line13.width && y > line13.y && y < line13.y + line13.height) {
//
//			String riddle1 = JOptionPane.showInputDialog("riddle");
//			dino.x = 417;
//			dino.y = 17;
//		}

//		if (x > line14.x - line14.height && x < line14.x + line14.width && y > line14.y && y < line14.y + line14.height) {
//
//			String riddle14 = JOptionPane.showInputDialog(
//					"A man lives on the 10th floor of an apartment building.\n Every morning he takes the elevator all the way down to the bottom and goes to work.\n In the evening, when he comes back from work, he gets into the elevator, and if there is someone else in it, he goes back to the 10th floor. \n On rainy days he also goes directly to his floor. \n On all other days, he goes to the 7th floor and walks up 3 flights of stairs to his apartment. \n Why?");
//			if (riddle14.equals("He is a midget.")) {
//				JOptionPane.showMessageDialog(null, "You are correct!");
//			} else {
//				JOptionPane.showMessageDialog(null, "C'mon people! Know your facts!!! YOU ARE WRONG!!!");
//			}
//			dino.x = 417;
//			dino.y = 17;
//		}
		timer.start();
	
	}
public void riddleChooser(int riddleNum){
	if (riddleNum == 1) {
		int rand = new Random().nextInt(3);
		String[]riddle1= {"Answer this riddle to pass this line: \nWhat gets shorter, the older it becomes?" , "Answer this riddle to pass this line: \nWhat gets wetter the more it dries?" , "Answer this riddle to pass this line: \nWhat has a face and two hands, but no arms or legs?" };
		String[]answer1= {"a candle" , "a towel" , "a clock"};
		String ans = JOptionPane.showInputDialog(riddle1[rand]);
		if (ans.equals(answer1[rand])) {
			JOptionPane.showMessageDialog(null, "You are correct!");
			line.setVisible(false);
			dino.x = Line1x - 17;
			dino.y = Line1y - 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "C'mon people! Know your facts!!! YOU ARE WRONG!!! \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}	
	}
	
	if (riddleNum == 2) {
	int randy = new Random().nextInt(3);
	String[]riddle2 = {"Answer this riddle to pass this line: \nTimmy's mother has three children. The first was named April, the next was neamed May. What is the third child's name?" , "Answer this riddle to pass this line: \nWhat belongs to you but is used more by others?" , "Answer this riddle to pass this line: \nWhat goes up but never comes down?" };
	String[]answer2 = {"Timmy" , "your name" , "your age"};
	String ansy = JOptionPane.showInputDialog(riddle2[randy]);
	if (ansy.equals(answer2[randy])) {
		JOptionPane.showMessageDialog(null, "Correct! Good job!");
		line2.setVisible(false);
		dino.x = Line2x + 10;
		dino.y = Line2y + 17;
	}
	else {
		JOptionPane.showMessageDialog(null, "Nice try, but....YOU ARE WRONG!!! \nStart again and answer this riddle to pass this line.");
		dino.x = 417;
		dino.y = 17;
	}
	}
	
	if (riddleNum == 3) {
		int rando = new Random().nextInt(3);
		String[]riddle3 = {"Answer this riddle to pass this line: \nWhat goes on four feet in the morning, two feet at noon, and three feet in the evening? (hint: one word answer)", "Answer this riddle to pass this line: \nWhat 5-letter word becomes shorter when you add two letters to it?" , "Answer this riddle to pass this line: \nWhat is full of holes but still holds water?"};
		String[]answer3 = {"human" , "short" , "a sponge"};
		String anso = JOptionPane.showInputDialog(riddle3[rando]);
		if (anso.equals(answer3[rando])) {
			JOptionPane.showMessageDialog(null, "Good job!!");
			line3.setVisible(false);
			dino.x = Line3x;
			dino.y = Line3y;
		}
		else {
			JOptionPane.showMessageDialog(null, "WRONGGG \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 4) {
		int randomm = new Random().nextInt(3);
		String[]riddle4 = {"Answer this riddle to pass this line: \nWhat goes up when rain comes down?", "Answer this riddle to pass this line: \nWhat travels around the world but stays in one spot?" , "Answer this riddle to pass this line: \nIf I have it, I don’t share it. If I share it, I don’t have it. What is it?" };
		String[]answer4 = {"an umbrella" , "a stamp" , "a secret"};
		String ansorr = JOptionPane.showInputDialog(riddle4[randomm]);
		if (ansorr.equals(answer4[randomm])) {
			JOptionPane.showMessageDialog(null, "AMAZING! On to your 5th round... (out of 15 hehe)");
			line4.setVisible(false);
			dino.x = Line4x;
			dino.y = Line4y;
		}
		else {
			JOptionPane.showMessageDialog(null, "TRY AGAIN LOL! \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 5) {
		int randomm = new Random().nextInt(3);
		String[]riddle5 = {"Answer this riddle to pass this line: \nWhat kind of room has no doors nor windows?", "Answer this riddle to pass this line: \nWhat gets broken without being held?" , "Answer this riddle to pass this line: \nWhat can you catch but not throw?" };
		String[]answer5 = {"a mushroom" , "a promise" , "a cold"};
		String ansorr = JOptionPane.showInputDialog(riddle5[randomm]);
		if (ansorr.equals(answer5[randomm])) {
			JOptionPane.showMessageDialog(null, "Nice job! Keep it up!");
			line5.setVisible(false);
			dino.x = Line5x;
			dino.y = Line5y;
		}
		else {
			JOptionPane.showMessageDialog(null, "HAHA NOPE! \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 6) {
		int randomm = new Random().nextInt(3);
		String[]riddle6 = {"Answer this riddle to pass this line: \nWhich weighs more: a pound of feathers or a pound of bricks?", "Answer this riddle to pass this line: \nWhat building has the most stories?" , "Answer this riddle to pass this line: \nWhat has four fingers and one thumb, but is not alive?" };
		String[]answer6 = {"neither" , "a library" , "a glove"};
		String ansorr = JOptionPane.showInputDialog(riddle6[randomm]);
		if (ansorr.equals(answer6[randomm])) {
			JOptionPane.showMessageDialog(null, "On to the next round.....");
			line6.setVisible(false);
			dino.x = Line6x;
			dino.y = Line6y;
		}
		else {
			JOptionPane.showMessageDialog(null, "Nice try but YOU ARE WRONG! \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 7) {
		int randomm = new Random().nextInt(3);
		String[]riddle7 = {"Answer this riddle to pass this line: \nThe more there is, the less you see. What is it?", "Answer this riddle to pass this line: \nDogs do it and trees have it. What is it?" , "Answer this riddle to pass this line: \nWhat come out at night without being called, and are lost in the day without being stolen?" };
		String[]answer7 = {"darkness" , "bark" , "stars"};
		String ansorr = JOptionPane.showInputDialog(riddle7[randomm]);
		if (ansorr.equals(answer7[randomm])) {
			JOptionPane.showMessageDialog(null, "Half way there!");
			line7.setVisible(false);
			dino.x = Line7x;
			dino.y = Line7y;
		}
		else {
			JOptionPane.showMessageDialog(null, "You are....NOT CORRECT! \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 8) {
		int randomm = new Random().nextInt(3);
		String[]riddle8 = {"Answer this riddle to pass this line: \nThe more you take, the more you leave behind. What am I?", "Answer this riddle to pass this line: \nWhat company makes billions of dollars selling Windows?" , "Answer this riddle to pass this line: \nMr. Blue lives in the blue house, Mr. Pink lives in the pink house, and Mr. Brown lives in the brown house. Who lives in the white house?" };
		String[]answer8 = {"footsteps" , "Microsoft" , "stars"};
		String ansorr = JOptionPane.showInputDialog(riddle8[randomm]);
		if (ansorr.equals(answer8[randomm])) {
			JOptionPane.showMessageDialog(null, "More than half way there!");
			line8.setVisible(false);
			dino.x = Line8x;
			dino.y = Line8y;
		}
		else {
			JOptionPane.showMessageDialog(null, "WRONG SORRY NOT SORRY! \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 9) {
		int randomm = new Random().nextInt(3);
		String[]riddle9 = {"Answer this riddle to pass this line: \nPoor people have it. Rich people need it. If you eat it you die. what is it?", "Answer this riddle to pass this line: \nFeed me and I live, yet give me a drink and I die. What am I?" , "Answer this riddle to pass this line: \nWhich vehicle is spelled the same forwards and backwards?" };
		String[]answer9 = {"nothing" , "fire" , "racecar"};
		String ansorr = JOptionPane.showInputDialog(riddle9[randomm]);
		if (ansorr.equals(answer9[randomm])) {
			JOptionPane.showMessageDialog(null, "Correct! So close!");
			line9.setVisible(false);
			dino.x = Line9x+5;
			dino.y = Line9y;
		}
		else {
			JOptionPane.showMessageDialog(null, "ummmmm, no. \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 10) {
		int randomm = new Random().nextInt(3);
		String[]riddle10 = {"Answer this riddle to pass this line: \nPoor people have it. Rich people need it. If you eat it you die. what is it?", "Answer this riddle to pass this line: \nFeed me and I live, yet give me a drink and I die. What am I?" , "Answer this riddle to pass this line: \nWhich vehicle is spelled the same forwards and backwards?" };
		String[]answer10 = {"nothing" , "fire" , "racecar"};
		String ansorr = JOptionPane.showInputDialog(riddle10[randomm]);
		if (ansorr.equals(answer10[randomm])) {
			JOptionPane.showMessageDialog(null, "Correct! So close to the end!");
			line9.setVisible(false);
			dino.x = Line10x;
			dino.y = Line10y;
		}
		else {
			JOptionPane.showMessageDialog(null, "ummmmm, no. \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	if (riddleNum == 11) {
		JOptionPane.showMessageDialog(null, "Congradulations! This is your 11th riddle. From this point on, there will be longer and harder riddles. Enjoy :)");
		int randomm = new Random().nextInt(3);
		String[]riddle11 = {"Answer this riddle to pass this line: \nWhat common English verb becomes its own past tense by rearranging its letters? List both words and use the word 'and' in the middle of them in your answer." };
		String[]answer11 = {"eat and ate"};
		String ansorr = JOptionPane.showInputDialog(riddle11[randomm]);
		if (ansorr.equals(answer11[randomm])) {
			JOptionPane.showMessageDialog(null, "Yeppers!");
			line9.setVisible(false);
			dino.x = Line11x;
			dino.y = Line11y;
		}
		else {
			JOptionPane.showMessageDialog(null, "ummmmm, no. \nStart again and answer this riddle to pass this line.");
			dino.x = 417;
			dino.y = 17;
		}
		}
	
	if (riddleNum == 12) {
		try {
			ScaryMaze maze = new ScaryMaze();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Surprise! To get passed this line, you must complete this smaller maze by dragging your mouse on the blue line.\nIf you fall off the path you have to restart ;)\nMake sure you get to the purple in order to win!\nGood luck! ");
		
			line12.setVisible(false);
			dino.x = Line11x;
			dino.y = Line11y;
		}
//		else {
//			JOptionPane.showMessageDialog(null, "ummmmm, no. \nStart again and answer this riddle to pass this line.");
//			dino.x = 417;
//			dino.y = 17;
//		}
		}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("x is " + e.getX() + " y is " + e.getY());
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