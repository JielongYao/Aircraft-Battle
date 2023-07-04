import java.awt.*;

public class TripleShellObj extends GameObj{//class of shell of the plane at player's side after getting 2 gifts

    public TripleShellObj(){
        super();
    }

    public TripleShellObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public TripleShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y -= speed; //shell is moving upward
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}