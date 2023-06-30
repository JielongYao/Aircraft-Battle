import java.awt.*;
import javax.swing.*;

public class ExplosionObj extends GameObj{//class of explosion in the game

    static Image[] explosionPics = new Image[16];//store a collection of explosion pictures

    int explosionCount = 0;//number of times to play explosion gifs; need to be up to 16 to complete a explosion

    static{//only executed once when this class is loaded to memory
        for(int i = 0; i < explosionPics.length; i++){
            explosionPics[i] = new ImageIcon("imgs/explode/e" + (i + 1) + ".gif").getImage();
        }
    }
    

    public ExplosionObj(int x, int y){
        super(x, y);
    }

    public void paintSelf(Graphics g){
        if(explosionCount < 16){
            super.img = explosionPics[explosionCount];
            super.paintSelf(g);
            explosionCount++;
        }
        
    }

}