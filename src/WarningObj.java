import java.awt.*;

public class WarningObj extends GameObj{//class of shell of the plane at player's side in the game

    public WarningObj(){
        super();
    }

    public WarningObj(int x, int y){
        super(x, y);
    }

    public WarningObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public WarningObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
    }

}