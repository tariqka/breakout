package lab3;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public class HandleBalls {
    private ArrayList<Boll> bolls;
    private int counter =0;
    private int bollen=3;
    public HandleBalls() {
        this.bolls = new ArrayList<>();
        this.counter=counter;
        addBall(); // Lägg till den första bollen vid start
        bolls.add(new Boll(200, konstanter.fourse, konstanter.twenty));
    }

    public ArrayList<Boll> getbolls() {
        return bolls;
    }

    public void update(Keyboard keyboard) throws InterruptedException {
        Iterator<Boll> iterator = bolls.iterator();
        boolean addNewBall = false;
        while (iterator.hasNext()) {
            Boll boll = iterator.next();
            boll.update(keyboard);
            if (boll.isAtBottom()) {
                addNewBall = true;
                bollcounter();
                countnuts();
                iterator.remove();
            }
            if(counter ==3)
            {
            	addNewBall = false;
            	Thread.sleep(konstanter.fivehun);
            	System.exit(0);
            }
        }
        
        if (addNewBall) {
            addBall(); // Lägg till en ny boll när den första bollen når botten
        }
    }
    private void countnuts() {
    	bollen--;
    }
    private void bollcounter() {
    	this.counter++;
    }
    private void addBall() {
        // Lägg till en ny boll i den befintliga listan av bollar
        bolls.add(new Boll(konstanter.thresi, konstanter.fourse, konstanter.twenty));
    }

    public void draw(Graphics2D graphics) {
        // Rita varje boll i listan
        for (Boll boll : bolls) {
            boll.draw(graphics);
        }
        if (counter ==3)
        	
        	graphics.drawString("lycka till nästa gång", konstanter.fourrhun, konstanter.threehun);
        graphics.setColor(Color.white);
        graphics.drawString("your balls: " + bollen, konstanter.sevenhun, konstanter.fivefifty);
    }
}
