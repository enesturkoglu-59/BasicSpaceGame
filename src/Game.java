import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;

class Fire{
	
	private int x;
	
	private int y;
	
	public Fire(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}

public class Game extends JPanel implements KeyListener,ActionListener {
	
	Timer timer = new Timer(5,this);
	
	
	private int elapsedTime = 0;
	
	private int spentBullet = 0;
	
	private BufferedImage image;
	
	private ArrayList<Fire> fires = new ArrayList<Fire>();
	
	private int fireDirectionY = 1;
	
	private int targetX = 0;
	
	private int targetDirectionX = 4;
	
	private int spaceshipX = 0;
	
	private int spaceshipDirectionX = 20;
	
	public Game(){
		try {
			image = ImageIO.read(new FileImageInputStream(new File("images/spaceship.png")));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		setBackground(Color.BLACK);
		
		timer.start();
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(targetX, 0, 20, 20);
		g.drawImage(image, spaceshipX,470,image.getWidth()/10,image.getHeight()/10,this);
	}



	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int c = e.getKeyCode();
		
		if(c==KeyEvent.VK_LEFT) {
			
			if(spaceshipX<=0) {
				
				spaceshipX = 0;
				
				
			}
			else {
				
				spaceshipX-=spaceshipDirectionX;
			}
		}
		
		if(c==KeyEvent.VK_RIGHT) {
			
			if(spaceshipX>=700) {
				
				spaceshipX = 700;
			}
			else {
				
				spaceshipX+=spaceshipDirectionX;
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		targetX+=targetDirectionX;
		
		if(targetX>=750) {
			targetDirectionX = -targetDirectionX;
		}
		
		if(targetX<=0) {
			targetDirectionX = -targetDirectionX;
		}
		
		repaint();
		
	}
	
	

}
