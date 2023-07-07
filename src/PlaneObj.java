import java.awt.*;
import java.awt.event.*;

public class PlaneObj extends GameObj{//class of the plane at player's side in the game

    public static int times = 0;//number of times the player's plane collides with gift

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

                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

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
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

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

                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                enemy2BulletObj.setX(-100);
                enemy2BulletObj.setY(-100);//the enemy object is removed from the game window

                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window
                
                GameUtils.removeList.add(enemy2BulletObj);
                GameUtils.removeList.add(this);
            }
        }

        //the fourth case: the player's plane object collides with little boss1's object. Player's plane will disappear, little boss won't.
        for(LittleBoss1Obj littleboss1: GameUtils.littleBoss1ObjList){
            if(this.getRec().intersects(littleboss1.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window
                
                GameUtils.removeList.add(this);
            }
        }

        //the fifth case: the player's plane object collides with little boss2's object. Player's plane will disappear, little boss won't.
        for(LittleBoss2Obj littleboss2: GameUtils.littleBoss2ObjList){
            if(this.getRec().intersects(littleboss2.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window
                
                GameUtils.removeList.add(this);
            }
        }

        //the sixth case: the player's plane object collides with littleboss1's bullet object. Both objects will disappear
        for(LittleBoss1BulletObj littleboss1bullet: GameUtils.littleBoss1BulletObjList){
            if(this.getRec().intersects(littleboss1bullet.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                littleboss1bullet.setX(-100);
                littleboss1bullet.setY(-100);

                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window

                GameUtils.removeList.add(littleboss1bullet);
                GameUtils.removeList.add(this);
            }
        }

        //the seventh case: the player's plane object collides with littleboss2's bullet object. Both objects will disappear
        for(LittleBoss2BulletObj littleboss2bullet: GameUtils.littleBoss2BulletObjList){
            if(this.getRec().intersects(littleboss2bullet.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                littleboss2bullet.setX(-100);
                littleboss2bullet.setY(-100);

                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window

                GameUtils.removeList.add(littleboss2bullet);
                GameUtils.removeList.add(this);
            }
        }
        
        //the eighth case: the player's plane object collides with finalboss's bullet object. Both objects will disappear
        for(BossBulletObj bossbullet: GameUtils.bossBulletObjList){
            if(this.getRec().intersects(bossbullet.getRec())){
                
                GameUtils.explosionObjList.add(new ExplosionObj(x, y)); // explosion effect appears after objects collide, so we create a new explosion object
                GameUtils.gameObjList.add(GameUtils.explosionObjList.get(GameUtils.explosionObjList.size() - 1));

                bossbullet.setX(-100);
                bossbullet.setY(-100);

                this.x = -200;
                this.y = -200;//the player's plane object is removed from the game window

                GameUtils.removeList.add(bossbullet);
                GameUtils.removeList.add(this);
            }
        }

        //when the player's plane collides with gift, the plane won't disappear, but the gift will disppear
        for(GiftObj gift: GameUtils.giftObjList){
            if(this.getRec().intersects(gift.getRec())){

                gift.setX(-100);
                gift.setY(-100);
                GameUtils.removeList.add(gift);
                times++;
            }
        }

        super.paintSelf(g);
    }

    public Rectangle getRec(){
        return super.getRec();
    }

}