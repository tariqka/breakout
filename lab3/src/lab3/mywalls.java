package lab3;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class mywalls {
    private ArrayList<Walls> wall;
    
    public mywalls() {
        wall = new ArrayList<>();
        wall.add(new Walls(0, 0, 1, konstanter.sixhun));
        wall.add(new Walls(konstanter.sevennine, 0, 1, konstanter.sixhun));
        wall.add(new Walls(0, 0, konstanter.eighthun, 1));
    }
    public ArrayList<Walls> getwalls(){
		return wall;
    	
    }

    public void update(Keyboard keyboard,HandleBalls bollhanterare,Bat bat, Boll boll,mywalls wall) {
        for (Walls color : wall.getwalls())
            color.update(keyboard);

        checkCollision(keyboard, bollhanterare, bat ,boll, wall);
    }

    public void draw(Graphics2D graphics) {
        for (Walls color : wall)
            color.draw(graphics);
    }

    private void checkCollision(Keyboard keyboard, HandleBalls bollhanterare, Bat bat, Boll boll, mywalls wall) {
        // Check for collision with the ball and the bat
        if (bat.intersects(boll, bollhanterare)) {
            Bat.handleBatCollision(bollhanterare, bat);
        }
        
           
            	handleWallCollision(bollhanterare, wall);
            
        
    }
	public static void handleWallCollision(HandleBalls bollhanterare, mywalls wall) {
	    for (Boll boll : bollhanterare.getbolls()) {
	        for (Walls vagg : wall.getwalls()) {
	            if (vagg.intersects(boll, bollhanterare)) {
	                boolean isVertical = vagg.getWidth() < vagg.getHeight();
	                if (isVertical) {
	                    boll.setVelocityX(-boll.getVelocityX());
	                } else {
	                    boll.setVelocityY(-boll.getVelocityY());
	                }
	            }
	        }
	    }
	}
}
