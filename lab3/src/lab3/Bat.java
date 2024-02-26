package lab3;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bat extends Sprite {
    private int leftBoundary;
    private int rightBoundary;

    public Bat(int x, int y, int width, int height, int leftBoundary, int rightBoundary) {
        super(x, y, width, height);
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
    }

    @Override
    public void update(Keyboard keyboard) {
        int newX = getX();

        if (keyboard.isKeyDown(Key.Left) && newX > leftBoundary) {
            newX -= konstanter.SPEED;
        } else if (keyboard.isKeyDown(Key.Right) && newX + getWidth() < rightBoundary) {
            newX += konstanter.SPEED;
        }

        setX(newX);
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.white);
        graphics.drawString("TKHA", getX() + (getWidth() - konstanter.twenty) / 2, getY() + getHeight());
    }
    public static void handleBatCollision(HandleBalls bollhanterare, Bat bat) {
    	for (Boll boll : bollhanterare.getbolls()) {
    		int batCenterX = Game.bat.getX() + Game.bat.getWidth() / 2;
        int ballCenterX = boll.getX() + boll.getWidth() / 2;
        int reflectionAngle = ballCenterX - batCenterX;
        boll.setVelocityX(reflectionAngle / konstanter.ten); 
        boll.setVelocityY(-boll.getVelocityY()); 
    	}
    }
	public boolean intersects(Boll boll) {
		for (Boll ball : Game.bollhanterare.getbolls()) {
            if (getX() < ball.getX() + ball.getWidth() &&
               getX() + getWidth() > ball.getX() &&
               getY() < ball.getY() + ball.getHeight() &&
               getY() + getHeight() > ball.getY()) {
                return true; // Collision detected
            }
        }
        return false;
    }
	
}
