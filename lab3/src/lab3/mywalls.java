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

    public void update(Keyboard keyboard) {
        for (Walls color : wall)
            color.update(keyboard);

        checkCollision(keyboard);
    }

    public void draw(Graphics2D graphics) {
        for (Walls color : wall)
            color.draw(graphics);
    }

    private void checkCollision(Keyboard keyboard) {
        // Check for collision with the ball and the bat
        if (Game.bat.intersects(Game.boll)) {
            Bat.handleBatCollision(Game.bollhanterare, Game.bat);
        }
        for (Walls color : wall) {
            if (color.intersects(Game.boll)) {
                handleWallCollision(color);
            }
        }
    }
    private void handleWallCollision(Walls wall) {
        CollisionHandler.handleWallCollision(Game.bollhanterare, Game.wall);
    }
}
