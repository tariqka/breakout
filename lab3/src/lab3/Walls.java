package lab3;

import java.awt.Color;
import java.awt.Graphics2D;

public class Walls extends Sprite{

	public Walls(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void update(Keyboard keyboard) {
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.black);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
	public boolean intersects(Boll boll, HandleBalls bollhanterare) {
		for (Boll ball : bollhanterare.getbolls()) {
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
