import java.awt.*;

public class BossObj extends GameObj{//class of the final boss in the game

    int health = 180;

    public BossObj(){
        super();
    }

    public BossObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public BossObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(y < 40){//when the boss hasn't moved into the game window completely
            y += speed;
        }else{
            x += speed;
            if(x < 0 || x > 360){
                speed = -speed;
            }
        }

        //when boss object collides with player's plane's shell object, player's shell disappear
        //after 60 times of collision (health == 0), final will disppear
        for(ShellObj shell: GameUtils.shellObjList){
            if(this.getRec().intersects(shell.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x + 80, y + 70)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));
                shell.setX(-100);
                shell.setY(-100);
                GameUtils.removeList.add(shell);
                
                if(health > 0){
                    health -= 3;
                }else{
                    this.x = -200;
                    this.y = -200;
                    GameUtils.removeList.add(this);
                    GameWin.score += 10;
                    GameWin.state = 4;
                }
            }
        }

        //when boss object collides with player's plane's doubleshell object, player's doubleshell disappear
        //after 45 times of collision (health == 0), final boss will disappear
        for(DoubleShellObj doubleshell: GameUtils.doubleShellObjList){
            if(this.getRec().intersects(doubleshell.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x + 80, y + 70)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));
                doubleshell.setX(-100);
                doubleshell.setY(-100);
                GameUtils.removeList.add(doubleshell);
                
                if(health > 0){
                    health -= 4;
                }else{
                    this.x = -200;
                    this.y = -200;
                    GameUtils.removeList.add(this);
                    GameWin.score += 10;
                    GameWin.state = 4;
                }
            }
        }

        //when boss object collides with player's plane's tripleshell object, player's tripleshell disappear
        //after 36 times of collision (health == 0), finalboss will disappear
        for(TripleShellObj tripleshell: GameUtils.tripleShellObjList){
            if(this.getRec().intersects(tripleshell.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x + 80, y + 70)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));
                tripleshell.setX(-100);
                tripleshell.setY(-100);
                GameUtils.removeList.add(tripleshell);
                
                if(health > 0){
                    health -= 5;
                }else{
                    this.x = -200;
                    this.y = -200;
                    GameUtils.removeList.add(this);
                    GameWin.score += 10;
                    GameWin.state = 4;
                }
            }
        }

        //implement boss's lifebar
        //white rectangle
        g.setColor(Color.WHITE);
        g.fillRect(200, 40, 200, 10); //x, y, width, height
        //red rectangle
        g.setColor(Color.RED);
        g.fillRect(200, 40, 200 * health / 180, 10); //x, y, width, height

    }

    public Rectangle getRec(){
        return super.getRec();
    }
}