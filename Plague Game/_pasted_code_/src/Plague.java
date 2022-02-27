/* Grace Chyu
 * 4-16-17
 *Plague.java
 */
import java.awt.*;//import abstract windowing toolkit, including Graphics, Image, Color, Font
import javax.swing.*;//import JFrame, JPanel, JLabel
import java.awt.event.*;//import the events and their listeners
import javax.swing.event.*;
public class Plague   {//this class contains the frame and start panel with all of the cardlayouts
    JFrame frame;
    Image pic,pic2;
    
        public Plague(){
        frame= new JFrame("Plague");
        
        frame.setSize(900, 600);                
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        frame.setLocation(400,50);
        frame.setResizable(true);
  }
    public static void main(String[]args)
    {
        Plague pl=new Plague();
        pl.run();

    }
    
    JPanel cards;
    JButton button1,button2;
     public void run()
        {
         
         cards = new JPanel(new CardLayout());//create panel with cardlayout
         
          
      
        PlagueDraw Spanel = new PlagueDraw(cards);
        cards.add(Spanel,"Start Panel");
        Difficulty diffpanel= new Difficulty( cards);
        cards.add(diffpanel,"Difficulty Panel");//added panel from Difficulty.java to cardlayout
        
        Directions dirpanel= new Directions(cards);
        cards.add(dirpanel,"Directions Panel");//added panel from Directions.java to cardlayout
        
		GameEasy Egamepanel= new GameEasy(cards);
        cards.add(Egamepanel,"EGame Panel");//added panel from GameEasy.java to cardlayout
        
        GameMedium Mgamepanel= new GameMedium(cards);
        cards.add(Mgamepanel,"MGame Panel");//added panel from GameMedium.java to cardlayout
        
        GameHard Hgamepanel= new GameHard(cards);
        cards.add(Hgamepanel,"HGame Panel");//added panel from GameHard.java to cardlayout
        
        frame.getContentPane().add(cards);
         frame.setVisible(true);
    }
        
 
   
}
	