import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class RedLines extends mazeRiddleGameOBJECT {
	boolean visible = true; 

	public RedLines(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g, BufferedImage line){
		if (visible == true){
			//g.drawImage(line, x, y, width, height, null);
			g.setColor(Color.RED);
	g.fillRect(x, y, width, height);
		}
			}
	void setVisible(boolean visible){
		this.visible = visible;
	}
}
