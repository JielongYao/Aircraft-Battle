import javax.swing.*; 
import java.awt.*;

public class GameWin extends JFrame{

    public void launch(){
        
        this.setVisible(true);

        this.setSize(600, 800); //width, height

        this.setLocationRelativeTo(null); // game window centered on screen

        this.setTitle("Aircraft Battle"); //set game window visible
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application when clicking the clsoe button
    }

    public void paint(Graphics g){
        Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg"); //access the background picture
        g.drawImage(bgImg, 0, 0 , null); //x = 0, y = 0
    }
 
}

