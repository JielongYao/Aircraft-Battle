import java.awt.*;

public class LittleBoss2BulletObj extends GameObj{//class of the bullet of the second type of boss plane in the game

    public LittleBoss2BulletObj(){
        super();
    }

    public LittleBoss2BulletObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public LittleBoss2BulletObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        
        //achieve tracking functionality
        y += speed;
        this.x -= (this.x - GameUtils.gameObjList.get(GameWin.planeindex).getX()) / 30;//track the player's plane in x direction
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}