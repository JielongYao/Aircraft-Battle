import java.awt.*;

public class LittleBoss2BulletObj extends GameObj{//class of the bullet of the second type of boss plane in the game

    int health = 2;

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

        //when littleboss2bullet object collides with player's plane's shell object, player's shell disappear
        //after 2 times of collision (health == 0), littleboss2bullet will disappear
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
                    this.x = -200;
                    this.y = -200;
                    GameUtils.removeList.add(this);
                    GameWin.score += 1;
                }
            }
        }

        //when littleboss2bullet object collides with player's plane's doubleshell object, player's doubleshell disappear
        //after 1 time of collision, littleboss2bullet will disappear
        for(DoubleShellObj doubleshell: GameUtils.doubleShellObjList){
            if(this.getRec().intersects(doubleshell.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));
                doubleshell.setX(-100);
                doubleshell.setY(-100);
                GameUtils.removeList.add(doubleshell);
                
                this.x = -200;
                this.y = -200;
                GameUtils.removeList.add(this);
                GameWin.score += 1;
            }
        }

        //when littleboss2bullet object collides with player's plane's tripleshell object, player's tripleshell disappear
        //after 1 time of collision, littleboss2bullet will disappear
        for(TripleShellObj tripleshell: GameUtils.tripleShellObjList){
            if(this.getRec().intersects(tripleshell.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));
                tripleshell.setX(-100);
                tripleshell.setY(-100);
                GameUtils.removeList.add(tripleshell);
                
                this.x = -200;
                this.y = -200;
                GameUtils.removeList.add(this);

                GameWin.score += 1;
                
            }
        }
    }

    public Rectangle getRec(){
        return super.getRec();
    }
}