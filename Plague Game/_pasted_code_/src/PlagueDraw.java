import java.awt.*;//import abstract windowing toolkit, including Graphics, Image, Color, Font
import javax.swing.*;//import JFrame, JPanel, JLabel
import java.awt.event.*;//import the events and their listeners
import javax.swing.event.*;
public class PlagueDraw extends JPanel{
	 JButton button1,button2;    Image pic,pic2;JPanel cards;
	 public PlagueDraw(JPanel cards){
		 this.cards=cards;
		 run();
	 }
	public void run(){
		setLayout(null);
	       button1 = new JButton("Start");        // construct button
        Button1Handler b1handler = new Button1Handler();    // this is so the actionPerformed is dedicated to this button only
        button1.setBounds(310,200,200,50);
       
          button1.addActionListener( b1handler );         // add listener to button
add(button1);
        button2 = new JButton("Directions");        // construct button
        Button2Handler b2handler = new Button2Handler();    // this is so the actionPerformed is dedicated to this button only
        button2.addActionListener( b2handler );         // add listener to button
              button2.setBounds(310,300,200,50);

        add(button2);

    }
        
    class Button1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CardLayout cl= (CardLayout)(cards.getLayout());//changes cardlayout panels
            cl.show(cards, "Difficulty Panel");
        }
    }    // end class Button1Handler    
    
    class Button2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
              CardLayout cl= (CardLayout)(cards.getLayout());//changes to directions panel
              cl.show(cards, "Directions Panel");
        }
    }    // end class Button2Handler    
    
      public void paintComponent(Graphics g)
    {
		pic = Toolkit.getDefaultToolkit().getImage("background.jpg");//add background image
	
        super.paintComponent(g);
g.drawImage( pic, 0, 0 ,900,600,this );//add online image to fit jframe
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("PLAGUE", 285, 75);//prints title with drawString
        
        
		}
   } 
   

