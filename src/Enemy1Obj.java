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

                GameUtils.removeList.add(shellObj);// this object still exists, but no longer drawn
                GameUtils.removeList.add(this);

                GameWin.score++;
            }
        }

        //the enemy1 object collides with player's doubleshell object. Both objects will disappear
        for(DoubleShellObj doubleshellObj: GameUtils.doubleShellObjList){
            if(this.getRec().intersects(doubleshellObj.getRec())){
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                doubleshellObj.setX(-100);
                doubleshellObj.setY(-100);//the player's plane's doubleshell object is removed from the game window

                this.x = -200;
                this.y = -200;//the enemy1 object is removed from the game window

                GameUtils.removeList.add(doubleshellObj);// this object still exists, but no longer drawn
                GameUtils.removeList.add(this);

                GameWin.score++;
            }
        }

        //the enemy1 object collides with player's tripleshell object. Both objects will disappear
        for(TripleShellObj tripleshellObj: GameUtils.tripleShellObjList){
            if(this.getRec().intersects(tripleshellObj.getRec())){
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                tripleshellObj.setX(-100);
                tripleshellObj.setY(-100);//the player's plane's tripleshell object is removed from the game window

                this.x = -200;
                this.y = -200;//the enemy1 object is removed from the game window

                GameUtils.removeList.add(tripleshellObj);// this object still exists, but no longer drawn
                GameUtils.removeList.add(this);

                GameWin.score++;
            }
        }
        
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