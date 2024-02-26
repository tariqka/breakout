package lab3;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
public class Game {
	
	public static HandleBalls bollhanterare;
	public static Bat bat;
	public static Boll boll;
	public static mywalls wall;
	public static handlebricks bricklayer;
	
	
	public Game(GameBoard board) {
		
		wall = new mywalls();
		bricklayer = new handlebricks();
		 bat = new Bat(konstanter.threetow, konstanter.fiveeee, konstanter.elevenz, konstanter.ten, 0,konstanter.sevennine);
		 
		 bollhanterare = new HandleBalls();
		}
	
	public void update(Keyboard keyboard) throws InterruptedException {
		wall.update(keyboard);
		bricklayer.update(keyboard, bollhanterare);
		bat.update(keyboard);
		bollhanterare.update(keyboard);
		
	}

	public void draw(Graphics2D graphics) {
		wall.draw(graphics);
		bricklayer.draw(graphics);
		bat.draw(graphics);
		bollhanterare.draw(graphics);
	}
}
