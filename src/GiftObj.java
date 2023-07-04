import java.awt.*;

public class GiftObj extends GameObj{//class of supply which the player's plane will get after defeating littleboss

    public GiftObj(){
        super();
    }

    public GiftObj(int x, int y){
        super(x, y);
    }

    public GiftObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public GiftObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.img = GameUtils.giftImg;
        super.width = 64;
        super.height = 62;
        super.paintSelf(g);
    }

    public Rectangle getRec(){
        return super.getRec();
    }

}