import java.awt.*;
import java.awt.event.*;

public class PlaneObj extends GameObj{//class of the plane at player's side in the game

    public PlaneObj(){
        super();
    }

    public PlaneObj(Image img, int x, int y, double speed){
        super(img, x, y, speed);
    }

    public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame){
        super(img, width, height, x, y, speed, frame);
    }

    public void paintSelf(Graphics g){
        //collision detection
        //the first case: the player's plane object collides with enemy1 object. Both objects will disappear
        for(Enemy1Obj enemy1Obj: GameUtils.enemy1ObjList){
            if(this.getRec().intersects(enemy1Obj.getRec())){
                enemy1Obj.setX(-100);
                enemy1Obj.setY(-100);//the enemy object is removed from the game window
                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window
                GameUtils.removeList.add(enemy1Obj);
                GameUtils.removeList.add(this);
            }
        }

        //the second case: the player's plane object collides with enemy2 object. Both objects will disappear
        for(Enemy2Obj enemy2Obj: GameUtils.enemy2ObjList){
            if(this.getRec().intersects(enemy2Obj.getRec())){
                enemy2Obj.setX(-100);
                enemy2Obj.setY(-100);//the enemy object is removed from the game window
                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window
                GameUtils.removeList.add(enemy2Obj);
                GameUtils.removeList.add(this);
            }
        }

        //the third case: the player's plane object collides with enemy2's bullet object. Both objects will disappear
        for(Enemy2BulletObj enemy2BulletObj: GameUtils.enemy2BulletObjList){
            if(this.getRec().intersects(enemy2BulletObj.getRec())){
                enemy2BulletObj.setX(-100);
                enemy2BulletObj.setY(-100);//the enemy object is removed from the game window
                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window
                GameUtils.removeList.add(enemy2BulletObj);
                GameUtils.removeList.add(this);
            }
        }
        super.paintSelf(g);
    }

    public Rectangle getRec(){
        return super.getRec();
    }

}