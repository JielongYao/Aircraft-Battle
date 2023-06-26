import java.awt.*;

public class Enemy1Obj extends GameObj{//class of the first type of enemy plane in the game
    public Enemy1Obj(){
        super();
    }

    public Enemy1Obj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public Enemy1Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
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