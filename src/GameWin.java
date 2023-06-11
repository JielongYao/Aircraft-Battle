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
        //Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg"); //another method to access the background picture
        Image bgImg = new ImageIcon(this.getClass().getResource("imgs/bg.jpg")).getImage(); //access the background picture
        g.drawImage(bgImg, 0, 0 , null); //x = 0, y = 0

        Image bossImg = new ImageIcon(this.getClass().getResource("imgs/boss.png")).getImage(); //access the boss picture
        g.drawImage(bossImg, 190, 70 , null); //x = 190, y = 70

        Image explodeImg = new ImageIcon(this.getClass().getResource("imgs/explode/e6.gif")).getImage(); //access the background picture
        g.drawImage(explodeImg, 270, 350 , null); //x = 270, y = 350

        Image planeImg = new ImageIcon(this.getClass().getResource("imgs/plane.png")).getImage(); //access the background picture
        g.drawImage(planeImg, 280, 470 , null); //x = 280, y = 470
    }
 
}

