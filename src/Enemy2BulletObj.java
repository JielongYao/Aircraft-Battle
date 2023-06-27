import java.awt.*;

public class Enemy2BulletObj extends GameObj{//class of the bullet of the second type of enemy plane in the game

    public Enemy2BulletObj(){
        super();
    }

    public Enemy2BulletObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public Enemy2BulletObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y += speed; 
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}