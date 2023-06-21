import java.awt.*;

public class ShellObj extends GameObj{
    public ShellObj(){
        super();
    }

    public ShellObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public ShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}