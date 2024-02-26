package lab3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;

public class bricklayer extends Sprite{
	private int hitsrequired;
	private Color color;
	private int hitstaken =0;
	private int point;

	public bricklayer(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
		//this.hitsrequired= hitsrequired;
		//this.point = point;
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

	 public void incrementHitsTaken() {
	        hitstaken++;
	        updatecolor();
	    }
	public int getHitsTaken() {
		// TODO Auto-generated method stub
		return hitstaken;
	}
	public void setHitsTaken(int hits) {
		// TODO Auto-generated method stub
		this.hitstaken = hits;
		updatecolor();
	}
	public int lostscore(int points) {
		return points-=25;
	}
	private void updatecolor() {
		if (this instanceof GreenBox) {
		if (hitstaken >= 1) 
            color = Color.yellow;
		if (hitstaken >= 2) 
            color = Color.red;
		if (hitstaken >= 3) 
            color = Color.darkGray;

	}
	 if (this instanceof RedBox) 
		if (hitstaken >= 1) 
            color = Color.darkGray;
	 if (this instanceof WhiteBox) {
		 if (hitstaken >= 1) 
	            color = Color.red;
			if (hitstaken >= 2) 
	            color = Color.darkGray;
		
	 }
	}
	public int getHitsRequired() {
		// TODO Auto-generated method stub
		return this.hitsrequired;
	}
	
	public void setHitsRequired(int hits) {
		// TODO Auto-generated method stub
		this.hitsrequired = hits;
	}
	
	public void incrementPoint() {
	    if (this instanceof GreenBox) {
	        this.point = 3; // GreenBox gives 3 points
	    } else if (this instanceof RedBox) {
	        this.point = 1; // RedBox gives 1 point
	    } else if (this instanceof WhiteBox) {
	        this.point = 2; // WhiteBox gives 2 points
	    }
	}


    public int getPoint() {
        return this.point;
    }

    public void setPoint(int points) {
        this.point = points;
    }
    @Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
    	
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
}
