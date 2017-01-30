import java.awt.Graphics;
import java.awt.Rectangle;

public class mazeRiddleGameOBJECT {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox = new Rectangle();
	public mazeRiddleGameOBJECT() {
		// TODO Auto-generated constructor stub
		collisionBox.setBounds(x, y, width, height);
	}
	void update(){
		collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics g){
		
	}
}
