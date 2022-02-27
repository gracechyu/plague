import java.awt.*;//import abstract windowing toolkit, including Graphics, Image, Color, Font
import javax.swing.*;//import JFrame, JPanel, JLabel
import java.awt.event.*;//import the events and their listeners
import javax.swing.event.*;
public class Difficulty extends JPanel{//panel class that contains difficulty buttons
  JPanel cards;
   Image pic;
    JButton button1,button2,button3;
     public Difficulty(JPanel cards)
        {
         this.cards=cards;

	}
	
    class Button1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CardLayout cl2= (CardLayout)(cards.getLayout());//changes cardlayout panels
            cl2.show(cards, "EGame Panel");
        }
    }    // end class Button1Handler    
    
    class Button2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CardLayout cl2= (CardLayout)(cards.getLayout());//changes  to medium game panel
            cl2.show(cards, "MGame Panel");
        }
    }    // end class Button2Handler    
   class Button3Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CardLayout cl2= (CardLayout)(cards.getLayout());
            cl2.show(cards, "HGame Panel");//changes  to hard game panel
        }
    }    // end class Button2Handler    

      public void paintComponent(Graphics g)
    {
				pic = Toolkit.getDefaultToolkit().getImage("background.jpg");

        super.paintComponent(g);
        g.drawImage( pic, 0, 0 ,900,600,this );//add online image to fit jframe

        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("Select Difficulty", 285, 75);//prints text of description and title to panel
                g.setFont(new Font("Serif", Font.PLAIN, 15));
 g.drawString("The enemy virus develops", 120, 300);
  g.drawString("and spreads very slowly", 120, 325);

 g.drawString("The enemy virus develops", 300, 300);
  g.drawString("and spreads at a regular speed", 300,325);

 g.drawString("The enemy virus develops ", 500,300);
  g.drawString("and spreads at a high speed", 500, 325);

        buttons();
        
    }
public void buttons(){
        button1 = new JButton("Easy");        // construct button
        Button1Handler b1handler = new Button1Handler();    // this is so the actionPerformed is dedicated to this button only
        button1.addActionListener( b1handler );         // add listener to button
        button1.setBounds(100,200,175,50);
		add(button1);
        button2 = new JButton("Medium");        // construct button
        Button2Handler b2handler = new Button2Handler();    // this is so the actionPerformed is dedicated to this button only
        button2.addActionListener( b2handler );         // add listener to button
        button2.setBounds(300,200,175,50);
		add(button2);

        button3= new JButton("Hard");        // construct button
        Button3Handler b3handler = new Button3Handler();    // this is so the actionPerformed is dedicated to this button only
        button3.addActionListener( b3handler );         // add listener to button
	    button3.setBounds(500,200,175,50);
		add(button3);

		}
}


