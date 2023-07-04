import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GameUtils{
    
    public static Image bgImg = new ImageIcon("imgs/bg.jpg").getImage(); //access the background picture
    public static Image bossImg = new ImageIcon("imgs/boss.png").getImage(); //access the boss picture
    public static Image explodeImg = new ImageIcon("imgs/explode/e6.gif").getImage(); //access the explosion picture
    public static Image planeImg = new ImageIcon("imgs/plane.png").getImage(); //access the plane picture 
    public static Image shellImg = new ImageIcon("imgs/shell.png").getImage(); //access the picture of the shell of the plane of the player
    public static Image enemy1Img = new ImageIcon("imgs/enemy1.png").getImage(); //access the picture of the first type of enemy plane
    public static Image enemy2Img = new ImageIcon("imgs/enemy2.png").getImage(); //access the picture of the second type of enemy plane
    public static Image enemy2BulletImg = new ImageIcon("imgs/enemy2bullet.png").getImage(); //access the picture of the bullet of the second type of enemy plane
    public static Image littleBoss1Img = new ImageIcon("imgs/littleboss1.png").getImage(); //access the picture of the first type of boss plane
    public static Image littleBoss2Img = new ImageIcon("imgs/littleboss2.png").getImage(); //access the picture of the second type of boss plane
    public static Image littleBoss1BulletImg = new ImageIcon("imgs/littleboss1bullet.png").getImage(); //access the picture of the bullet of boss1 plane
    public static Image littleBoss2BulletImg = new ImageIcon("imgs/littleboss2bullet.png").getImage(); //access the picture of the bullet of boss2 plane
    public static Image giftImg = new ImageIcon("imgs/gift.png").getImage(); //access the supply (gift) picture
    public static Image doubleShellImg = new ImageIcon("imgs/doubleshell.png").getImage(); //access the picture of the doubleshell
    public static Image tripleShellImg = new ImageIcon("imgs/tripleshell.png").getImage(); //access the picture of the tripleshell


    public static ArrayList<ShellObj> shellObjList = new ArrayList<>(); //a collection of shell object of the plane at our side
    public static ArrayList<Enemy1Obj> enemy1ObjList = new ArrayList<>(); //a collection of objects of the first type of enemy 
    public static ArrayList<Enemy2Obj> enemy2ObjList = new ArrayList<>(); //a collection of objects of the second type of enemy
    public static ArrayList<Enemy2BulletObj> enemy2BulletObjList = new ArrayList<>(); //a collection of objects of the bullet of the second type of enemy
    public static ArrayList<ExplosionObj> explosionObjList = new ArrayList<>(); //a collection of objects of explosion
    public static ArrayList<LittleBoss1Obj> littleBoss1ObjList = new ArrayList<>(); //the arraylist to store littleboss1 object
    public static ArrayList<LittleBoss2Obj> littleBoss2ObjList = new ArrayList<>(); //the arraylist to store littleboss2 object
    public static ArrayList<LittleBoss1BulletObj> littleBoss1BulletObjList = new ArrayList<>(); //a collection of objects of the bullet of boss1
    public static ArrayList<LittleBoss2BulletObj> littleBoss2BulletObjList = new ArrayList<>(); //a collection of objects of the bullet of boss2
    public static ArrayList<GiftObj> giftObjList = new ArrayList<>(); //a collection of gifts (supplies)
    public static ArrayList<DoubleShellObj> doubleShellObjList = new ArrayList<>(); //a collection of doubleshell objects
    public static ArrayList<TripleShellObj> tripleShellObjList = new ArrayList<>(); //a collection of tripleshell objects


    public static ArrayList<GameObj> removeList = new ArrayList<>(); //a collection of game objects which have been removed from the game window
    
    public static ArrayList<GameObj> gameObjList = new ArrayList<>(); //a collection of all the objects in the game


}