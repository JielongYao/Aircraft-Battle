import java.awt.*;

public class Enemy2Obj extends GameObj{//class of the second type of enemy plane in the game
    
    int health = 4;

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
        //After the enemy2 object collides with player's shell object 4 times, then enemy2 object will disappear
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

                    GameWin.score += 2;
                }
            }
        }

        //After the enemy2 object collides with player's doubleshell object 2 times, then enemy2 object will disappear
        for(DoubleShellObj doubleshellObj: GameUtils.doubleShellObjList){
            if(this.getRec().intersects(doubleshellObj.getRec())){

                doubleshellObj.setX(-100);
                doubleshellObj.setY(-100);//the player's plane's doubleshell object is removed from the game window

                GameUtils.removeList.add(doubleshellObj);
                health-=2;

                if(health <= 0){
                    GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after enemy2 collide 3 times with our shell, so we create a new explosion object
                    GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                    this.x = -200;
                    this.y = -200;//the enemy2 object is removed from the game window
                    GameUtils.removeList.add(this);

                    GameWin.score += 2;
                }
            }
        }

        //After the enemy2 object collides with player's tripleshell object 1 time, then enemy2 object will disappear
        for(TripleShellObj tripleshellObj: GameUtils.tripleShellObjList){
            if(this.getRec().intersects(tripleshellObj.getRec())){

                tripleshellObj.setX(-100);
                tripleshellObj.setY(-100);//the player's plane's tripleshell object is removed from the game window

                GameUtils.removeList.add(tripleshellObj);
                health-=4;

                if(health <= 0){
                    GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after enemy2 collide 3 times with our shell, so we create a new explosion object
                    GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                    this.x = -200;
                    this.y = -200;//the enemy2 object is removed from the game window
                    GameUtils.removeList.add(this);

                    GameWin.score += 2;
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