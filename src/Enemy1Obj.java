import java.awt.*;

public class Enemy1Obj extends GameObj{//class of the first type of enemy plane in the game
    public Enemy1Obj(){
        super();
    }

    public Enemy1Obj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public Enemy1Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        //collision detection
        //the enemy1 object collides with player's shell object. Both objects will disappear
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                shellObj.setX(-100);
                shellObj.setY(-100);//the player's plane's shell object is removed from the game window

                this.x = -200;
                this.y = -200;//the enemy1 object is removed from the game window

                GameUtils.removeList.add(shellObj);// this objecr still exists, but no longer drawn
                GameUtils.removeList.add(this);
            }
        }
        
        super.paintSelf(g);
        y += speed;
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}