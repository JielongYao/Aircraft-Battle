import java.awt.*;

public class LittleBoss1Obj extends GameObj{//class of the first type of little boss in the game

    int health = 30;

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

        //when littleboss1 object collides with player's plane's shell object, player's shell disappear
        //after 15 times of collision (health == 0), littleboss1 will disappear
        for(ShellObj shell: GameUtils.shellObjList){
            if(this.getRec().intersects(shell.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));
                shell.setX(-100);
                shell.setY(-100);
                GameUtils.removeList.add(shell);
                
                if(health > 0){
                    health--;
                }else{
                    if(this.x < 60){
                        GiftObj gift = new GiftObj(60, this.y);
                        GameUtils.giftObjList.add(gift);
                        GameUtils.gameObjList.add(gift);
                    }else if(this.x > 540){
                        GiftObj gift = new GiftObj(540, this.y);
                        GameUtils.giftObjList.add(gift);
                        GameUtils.gameObjList.add(gift);
                    }else{
                        GiftObj gift = new GiftObj(this.x, this.y);//gift (supply) will appear where the littleboss1 was destroyed
                        GameUtils.giftObjList.add(gift);
                        GameUtils.gameObjList.add(gift);
                    }
                
                    this.x = -200;
                    this.y = -200;
                    GameUtils.removeList.add(this);
                }
            }
        }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}