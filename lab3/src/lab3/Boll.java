package lab3;

import java.awt.Color;
import java.awt.Graphics2D;

public class Boll extends Sprite {
    private int velocityX;
    private int velocityY;
    

    public Boll(int x, int y, int diameter) {
        super(x, y, diameter, diameter);
        velocityX = 0;  // Set initial velocity values
        velocityY = -7;
    }

    @Override
    public void update(Keyboard keyboard) {
        // Update position based on velocity
        setX(getX() + velocityX);
        setY(getY() + velocityY);
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }
    
    // Getter and setter methods for velocity
    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
    public boolean isAtBottom() {
		 int screenHeight = 600;   
	        return getY() + getHeight() >= screenHeight;
		
	}
}
