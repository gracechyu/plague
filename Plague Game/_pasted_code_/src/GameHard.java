import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;
import javax.swing.*;
public class GameHard extends JPanel implements MouseListener, ActionListener//panel class contains the panel of actual game
{         
    boolean insideCircle;
    JButton button1,button2;
    Timer timer;
    JPanel cards;
    JPanel buttonpanel;
    Circle[] circles = new Circle[12];//circle class
    Circle redCircle;
    Circle blueCircle;
    boolean gamestarted=true;
    Circle lastSelectedCircle;
    int pointsBank;
    int timerCounter = 10;
    
   public GameHard(JPanel cards){
	   
   this.cards=cards;
	 System.out.println("game started"); 
	 addMouseListener(this);
	 timer=new Timer(1000,this);
	 //timer.start();
   } 
       
   
   public void paintComponent(Graphics g)
            {    //draw circles
                super.paintComponent(g);
                        int x,y;              
        
                        g.setFont(new Font("Serif", Font.BOLD, 20));
                        
                        g.setColor(Color.blue);
                        g.fillOval(0,200,120,120);
                        if(gamestarted==true)
                        	blueCircle= new Circle(0,200,60,120,120,"blue source");//add circle values to blueCircle in circle class array
                        
                        g.setColor(Color.red);
                        g.fillOval(700,200,120,120); 
                        if(gamestarted==true)
                        	redCircle= new Circle(700,200,60,120,120,"red source");//add circle values to redCircle in circle class array
                        g.setColor(Color.black);
                        g.drawString(redCircle.value +"",765, 265);
                        g.setColor(Color.black);
                        g.drawString(blueCircle.value+"",65, 265);

                        if(gamestarted==true){
                        for(int i =0; i<12;i++){//draw 12 random circles
                            g.setColor(Color.gray);
                            x= (int)(Math.random()*750); 
                            y= (int)(Math.random()*520);
                           /* while(!isValidCircle(x,y,80,i)){
                            	x= (int)(Math.random()*750); 
                            	y= (int)(Math.random()*520);
                            }*/
                            g.fillOval(x,y,80,80);
                            g.setColor(Color.black);
                            
                            	circles[i]= new Circle( x,y,0,80,80,"neutral");//add circle values to circle class array
                            g.drawString(circles[i].value +"", x+35, y+35);
                            
                        }
                        timer.start();
                        }
                        else{
                        	 for(int i =0; i<12;i++){//draw 12 random circles
                        		 if(circles[i].team.equals("neutral"))
                                 g.setColor(Color.gray);
                        		 if(circles[i].team.equals("blue"))
                                     g.setColor(Color.blue);
                        		 if(circles[i].team.equals("red"))
                                     g.setColor(Color.red);
                                 g.fillOval(circles[i].x,circles[i].y,80,80);
                                 g.setColor(Color.black);
                                 
                                 g.drawString(circles[i].value +"", circles[i].x+35, circles[i].y+35);
                             }	
                        }
                        //timer.start();
                        gamestarted=false;
            }
   						public boolean isValidCircle(int x, int y, int length, int numCircles)
   						{
   							//if new circle's x between blue circle's x and x+width
   						 if(blueCircle.x<x && x<blueCircle.x +blueCircle.width && blueCircle.y<y && y<blueCircle.y+blueCircle.height){//check if mouse is in x,y,width and height of shape
   			                return false;
   			            }
   						 //if new circle's x+width is between blue circle's x and x+width
   						 if(blueCircle.x<x+length && x+length<blueCircle.x +blueCircle.width && blueCircle.y<y+length && y+length<blueCircle.y+blueCircle.height){//check if mouse is in x,y,width and height of shape
    			                return false;
    			            }
   			            if(redCircle.x<x && x<redCircle.x +redCircle.width && redCircle.y<y && y<redCircle.y+redCircle.height){//check if mouse is in x,y,width and height of shape
   			                return false;
   			            }
   			         if(redCircle.x<x+length && x+length<redCircle.x +redCircle.width && redCircle.y<y+length && y+length<redCircle.y+redCircle.height){//check if mouse is in x,y,width and height of shape
			                return false;
			            }
   			            for(int i =0; i<numCircles;i++){
   			                if(circles[i].x<x && x<circles[i].x +circles[i].width && circles[i].y<y && y<circles[i].y+circles[i].height){
   			                    return false;
   			                }
   			                if(circles[i].x<x+length && x+length<circles[i].x +circles[i].width && circles[i].y<y+length && y+length<circles[i].y+circles[i].height){
   			                    return false;
   			                }
   			            }
   			            
   			            return true;
   						}
   					
   public void actionPerformed(ActionEvent e){
	   System.out.println("action performed " +e.getActionCommand());
	   if(blueCircle.value<60){
		   blueCircle.value=blueCircle.value+1;
	   
		repaint();
	   }
	   if(redCircle.value<60){
		   redCircle.value=redCircle.value+1;
	   
		repaint();
	   }
	   System.out.println("incgggggggggggggggggggggggggggr");

	   //red source circle
	   if(timerCounter==10){
		   System.out.println("10 timer");

		   timerCounter=1;
		   redCircle.value=redCircle.value/2;
		   int randomcircle=(int)(Math.random()*12);
		   Circle c= circles[randomcircle];
		   if(c.team.equals("red")){
			   c.value=c.value+redCircle.value;
		   }
		   
		   else if (c.team.equals("neutral")){
			   c.value=c.value+redCircle.value;
			   c.team="red";
		   }
		   else if (c.team.equals("blue")){
			   c.value=c.value-redCircle.value;
			   if(c.value>0){
		       		c.team="blue";
		       	}
		       	
		       	else if(c.value<0){
		       		c.team="red"; 
		       		c.value=c.value*-1;
		       	}
		       	else if(c.value==0){
		       		c.team="neutral";
		       	}
				   
			   }
		   repaint();
		   }
		
		   
	   
	   //red game circles
	   else if (timerCounter%3==0){
		   timerCounter++;
		   System.out.println(" timer 3");
		   if(hasCircleOnTeam("red")){
			   
		   
		   int randomcircle=(int)(Math.random()*12);
		   int randomcircle2=(int)(Math.random()*12);			  
		   Circle c = circles[randomcircle];

		   
		   while(!c.team.equals("red")){
			    randomcircle=(int)(Math.random()*12);
			     c = circles[randomcircle];
		   }
		   Circle x= circles[randomcircle2];
		   while(randomcircle==randomcircle2){
			   randomcircle2=(int)(Math.random()*12);
			     x = circles[randomcircle2];
		   }
		   
		   if(c.team.equals("red")){
			   c.value=c.value/2;
		   }
		   //check destination circle's team
		   if (x.team.equals("neutral")){
			   x.value=x.value+c.value;
			   x.team="red";
		   }
		   else if (x.team.equals("blue")){
			   x.value=x.value-c.value;
			   if(x.value>0){
		       		x.team="blue";
		       	}
		       	
		       	else if(x.value<0){
		       		x.team="red"; 
		       		x.value=x.value*-1;
		       	}
		       	else if(x.value==0){
		       		x.team="neutral";
		       	}
				   
		   }	  
	  }
		  repaint();
		  if(!checkWinner().equals(""))
        	  end();
		  
}
	   else {
		   timerCounter++;
		   System.out.println("increment timer");
	   }
	}
   		public boolean hasCircleOnTeam(String team){
   			for(int i =0; i<12; i++){
   				if(circles[i].team.equals(team)){
   					return true;
   				}
   			}
   			return false;
   		}
   
   /*
            public void redCircle(){
				timer.setActionCommand(spreadred,200,1000);//red source circle spreads its points every 10 seconds
				timer.setActionCommand(spreadred,100,300);//other red circle spreads its points every 3 seconds
				//selects random red circle to spread
				
				if(redCircle.value<0){
					//redcircle cannot spread if value is 0
				}
				redCircle=new Circle(x,y,value,80,80,"red");
				
				if(redCircle.equals("red")){
					//does not spread to other infected cells
				}
				redCirclevalue=redCircle.value/2;//circle value divides by 2 when spread
				c.value=c.value-redCircle.value/2;//neutral circles  values are negative
				if(c.value<0) //if value is negative, circle is red
                //color changes to red, computer can manipulate this circle now to spread
                blueCircle= new Circle(x,y,c.value,80,80,"blue");
			}*/
			public String checkWinner(){
				int redcount = 0;int bluecount = 0;
			
				for(int i=0; i<12; i++){
					if(circles[i].team.equals("blue")){
						bluecount++;
					}
					if(circles[i].team.equals("red")){
						redcount++;
					}
				}
				if(redcount==12){
					if(blueCircle.value<=1){
						return "red wins";
					}
				}
				if(bluecount==12){
					if(redCircle.value<=1){
						return "blue wins";
					}
				}
				return "";
			}
		 	public void end(){
				
				System.out.print("Good job! You have won the game!");
				button1 = new JButton("Play again");        // construct button
     Button1Handler b1handler = new Button1Handler();    // this is so the actionPerformed is dedicated to this button only
        button1.addActionListener( b1handler );         // add listener to button
       buttonpanel.add( button1);
        button2 = new JButton("Quit");        // construct button
        Button2Handler b2handler = new Button2Handler();    // this is so the actionPerformed is dedicated to this button only
        button2.addActionListener( b2handler );         // add listener to button
        buttonpanel.add( button2);
	
				System.out.print("Oh no! You lost the game!");
		
	}
			
		
        
        public Circle isInsideCircle(int x, int y){//check if one of the circles are clicked
            System.out.println("mouse x: " + x + " y: " + y);
            System.out.println("circl x: " + blueCircle.x + " y: " + blueCircle.y);
            if(blueCircle.x<x && x<blueCircle.x +blueCircle.width && blueCircle.y<y && y<blueCircle.y+blueCircle.height){//check if mouse is in x,y,width and height of shape
                return blueCircle;
            }
            if(redCircle.x<x && x<redCircle.x +redCircle.width && redCircle.y<y && y<redCircle.y+redCircle.height){//check if mouse is in x,y,width and height of shape
                return redCircle;
            }
            for(int i =0; i<12;i++){
                if(circles[i].x<x && x<circles[i].x +circles[i].width && circles[i].y<y && y<circles[i].y+circles[i].height){
                    return circles[i];
                }
            }
            return null;
        }
    public void mouseClicked(MouseEvent e){
    	System.out.println("mouse clicked");
        int x=  e.getX();
        int y=  e.getY();
        Circle c = isInsideCircle(x,y);
        
        //System.out.println(c.team);
        //if c=null, do nothing
        if(c!=null){//if circle is clicked, value changes
            if( c.team.equals("blue source")&& (lastSelectedCircle!=blueCircle)&&pointsBank==0){
            	
                blueCircle.value=blueCircle.value/2;
                pointsBank=blueCircle.value;
                lastSelectedCircle=blueCircle;
            }
            else if( c.team.equals("blue")&&pointsBank>0){
                c.value=c.value+pointsBank; //to change
                pointsBank=0;
                lastSelectedCircle=c;
            }
            
            else if( c.team.equals("blue")&&pointsBank==0){
            	c.value=c.value/2;
            	pointsBank=c.value;
            	lastSelectedCircle=c;
            }
            
            else if(c.team.equals("neutral")&& (pointsBank>0)){
                c.value=c.value+pointsBank;//circle becomes positive
                c.team="blue";
                pointsBank=0;
                //color changes to blue, user can manipulate this circle now to spread
               // blueCircle= new Circle(x,y,c.value,80,80,"blue");
                lastSelectedCircle=c;
            }
            
            else   if(c.team.equals("red")&& (pointsBank>0)){
            	c.value=c.value-pointsBank;
            	if(c.value>0){
            		c.team="red";
            	}
            	
            	else if(c.value<0){
            		c.team="blue"; 
            		c.value=c.value*-1;
            	}
            	else if(c.value==0){
            		c.team="neutral";
            	}
            	pointsBank=0;
            	lastSelectedCircle=c;
            }
            else if(c.team.equals("red source")&&(pointsBank>0)){
            	c.value=c.value-pointsBank;
            	pointsBank=0;
            	lastSelectedCircle=c;
            }
            
            else if(lastSelectedCircle!=blueCircle&&lastSelectedCircle!=redCircle){
            	
            }
            
            
            
            
            else
            	lastSelectedCircle=c;
            
            if(c.value>30 && c!= redCircle && c!=blueCircle){
            	c.value=30;
            }
            
            
        }
        repaint();
          if(!checkWinner().equals(""))
        	  end();
          
        
    }
    

    public void mousePressed(MouseEvent e) {}//need create these methods to run even if not using
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
  class Button1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CardLayout cl2= (CardLayout)(cards.getLayout());//changes cardlayout panels
            cl2.show(cards, "Difficulty Panel");//brings to difficulty panel
        }
    }    // end class Button1Handler    
    
    class Button2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);//if user clicks on quit, frame exits
        }
    }    // end class Button2Handler    
    

}
