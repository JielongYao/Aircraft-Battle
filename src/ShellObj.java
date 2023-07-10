import java.awt.*;

public class ShellObj extends GameObj{//class of shell of the plane at player's side in the game

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
        y -= speed; //shell is moving upward

        // if(y < 0){
        //     GameUtils.removeList.add(this); //reduce plotting pressure after removeing game elements which is out of the game window
        // }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}