import java.awt.*;

public class LittleBoss1Obj extends GameObj{//class of the first type of little boss in the game

    public LittleBoss1Obj(){
        super();
    }

    public LittleBoss1Obj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public LittleBoss1Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        x += speed;
        if(x > 400){
            speed = -1;
        }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}