import java.awt.*;

public class LittleBoss2Obj extends GameObj{//class of the second type of little boss in the game

    public LittleBoss2Obj(){
        super();
    }

    public LittleBoss2Obj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public LittleBoss2Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(y < 100){
            y += 2;
        }else{
            x += speed;
            if(x > 400 || x < 10){
                speed = -speed;
            }
        }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}