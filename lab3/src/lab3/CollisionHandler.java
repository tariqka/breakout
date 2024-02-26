package lab3;
import java.util.Iterator;
import java.util.List;

public class CollisionHandler {
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


