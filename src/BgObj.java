import java.awt.*;

public class BgObj extends GameObj{
    public BgObj(){
        super();
    }

    public BgObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public BgObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y += speed;
        if(y >= 0){
            y = -1800;
        }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}