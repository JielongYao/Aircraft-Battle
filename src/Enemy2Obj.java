import java.awt.*;

public class Enemy2Obj extends GameObj{//class of the second type of enemy plane in the game
    
    int health = 3; //

    public Enemy2Obj(){
        super();
    }

    public Enemy2Obj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public Enemy2Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        
        //collision detection
        //After the enemy2 object collides with player's shell object 3 times, then enemy2 object will disappear
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){

                shellObj.setX(-100);
                shellObj.setY(-100);//the player's plane's shell object is removed from the game window

                GameUtils.removeList.add(shellObj);
                health--;

                if(health <= 0){
                    GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after enemy2 collide 3 times with our shell, so we create a new explosion object
                    GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                    this.x = -200;
                    this.y = -200;//the enemy2 object is removed from the game window
                    GameUtils.removeList.add(this);
                }
            }
        }

        super.paintSelf(g);
        y += speed;
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}