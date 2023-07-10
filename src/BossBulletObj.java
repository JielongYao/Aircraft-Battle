import java.awt.*;

public class BossBulletObj extends GameObj{//class of the bullet of the final boss in the game

    public BossBulletObj(){
        super();
    }

    public BossBulletObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public BossBulletObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y += speed; 

        if(y > 800){
            GameUtils.removeList.add(this); //reduce plotting pressure after removeing game elements which is out of the game window
        }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}