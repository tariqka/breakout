package lab3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public class handlebricks {
    private ArrayList<bricklayer> bricklayers;
    
    private int totalScore = 0;
    public handlebricks()
    {
    	
        bricklayers = new ArrayList<> ();
        int size = konstanter.eleven;
        for (int i = 0; i<size; i++)
        {
            bricklayer greenBox = new GreenBox(konstanter.fifty + (i * konstanter.seventy), konstanter.towfive, konstanter.fourfive, konstanter.ten);
            greenBox.setHitsRequired(4); // Set hits required for GreenBox
            bricklayers.add(greenBox);
            
            bricklayer redBox1 = new RedBox(konstanter.fifteen + (i * konstanter.seventy), konstanter.sixty, konstanter.fourfive, konstanter.ten);
            redBox1.setHitsRequired(2); // Set hits required for RedBox
            bricklayers.add(redBox1);
            
            bricklayer whiteBox = new WhiteBox(konstanter.fifty + (i * konstanter.seventy), konstanter.ninefive, konstanter.fourfive, konstanter.ten);
            whiteBox.setHitsRequired(3); // Set hits required for WhiteBox
            bricklayers.add(whiteBox);
            
            bricklayer redBox2 = new RedBox(konstanter.fifteen + (i * konstanter.seventy), konstanter.onethree, konstanter.fourfive, konstanter.ten);
            redBox2.setHitsRequired(2); // Set hits required for RedBox
            bricklayers.add(redBox2);
            
            bricklayer greenBox1 = new GreenBox(konstanter.fifty + (i * konstanter.seventy), konstanter.onesixfive, konstanter.fourfive, konstanter.ten);
            greenBox1.setHitsRequired(4); // Set hits required for GreenBox
            bricklayers.add(greenBox1);
            
            
            
            
            
        }
        
    }
    
    public ArrayList<bricklayer> getbricklayers(){
        return bricklayers;
    }
    
    
    
    public void update(Keyboard keyboard, HandleBalls bollhanterare) throws InterruptedException {
        Iterator<bricklayer> iterator = bricklayers.iterator();
        while (iterator.hasNext()) {
            bricklayer brick = iterator.next();
            for (Boll boll : bollhanterare.getbolls()) {
                if (brick.intersects(boll)) {
                	boolean isVertical = brick.getWidth() < brick.getHeight();
                    if (isVertical) {
                        boll.setVelocityX(-boll.getVelocityX());
                    } else {
                        boll.setVelocityY(-boll.getVelocityY());
                    }
                	brick.incrementHitsTaken();
                	brick.incrementPoint();
                	totalScore += brick.getPoint(); // Accumulate points
                	if(boll.isAtBottom()) {
                		System.out.print("eri");
                		brick.lostscore(totalScore);
                	}
                		
                   if (brick.getHitsTaken() >= brick.getHitsRequired()) {
                        iterator.remove();
                        break;
                    }
                   
                    

                    
                    
                }
            }
           
            brick.update(keyboard);
            if (bricklayers.isEmpty()) {
                
            	Thread.sleep(konstanter.thousand);
            	System.exit(0);
            }
            	
                
            }
            
            
        }
    
    
    public void draw(Graphics2D graphics) {
    	  
         for (bricklayer box : bricklayers) {
             box.draw(graphics);
             
         }
         if (bricklayers.isEmpty()) {
        	 graphics.setColor(Color.white);
        		 graphics.drawString("wallahi du vann" , konstanter.threetow, konstanter.oneeighty);
                 graphics.drawString("Score: " + totalScore, konstanter.threetow, konstanter.towhun);
             }
         graphics.setColor(Color.white);
         graphics.drawString("Score: " + totalScore, konstanter.twenty, konstanter.fivefifty); 
         
        	 
         
    }
    
}
