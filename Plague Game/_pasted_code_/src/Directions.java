import java.awt.*;//import abstract windowing toolkit, including Graphics, Image, Color, Font
import javax.swing.*;//import JFrame, JPanel, JLabel
import java.awt.event.*;//import the events and their listeners
import javax.swing.event.*;
public class Directions extends JPanel{//panel class that has the directions
 
Image pic;JButton button1;
   JPanel cards;
     public Directions(JPanel cards)
        {
this.cards=cards;
        setBackground(Color.white);
        buttons();
    }
      public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
				pic = Toolkit.getDefaultToolkit().getImage("background.jpg");
g.drawImage( pic, 0, 0, 900, 600,this );//add online image to fit jframe
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("Directions", 285, 75);
        g.setFont(new Font("Serif", Font.PLAIN, 15));//prints directions with drawString
        g.drawString("You have your own host virus with 60 points. ", 55, 110);   
          g.drawString("The enemy also has 60 points. ", 55, 140); 
            g.drawString("Your host virus is blue while the enemy is red.  ", 55, 180); 
            g.drawString("You'll have to click on your virus and  ", 55, 220); 

          g.drawString("a plain cell in order to infect it. ", 55, 260); 
          g.drawString(" You can select any of your own blue viruses to infect other ones. ", 55, 300); 
           
        g.drawString(" In order to win, you'll have to make all the cells infected with YOUR blue virus. ",55,340);
        g.drawString("You will lose the game if the other red virus conquered all of the cells.", 55, 380);
        g.drawString("all the other cells will have a max of 20 points. ", 55,420);
        
    }    
    public void buttons(){
        button1 = new JButton("Return back");        // construct button
        Button1Handler b1handler = new Button1Handler();    // this is so the actionPerformed is dedicated to this button only
        button1.addActionListener( b1handler );         // add listener to button
        button1.setBounds(0,0,120,30);
		add(button1);
     
		}
        
    class Button1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CardLayout cl= (CardLayout)(cards.getLayout());//changes cardlayout panels
            cl.show(cards, "Start Panel");
        }
    }    // end class Button1Handler    
    
}
 

