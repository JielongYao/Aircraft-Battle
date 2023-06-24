import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GameUtils{
    
    public static Image bgImg = new ImageIcon("imgs/bg.jpg").getImage(); //access the background picture
    
    public static Image bossImg = new ImageIcon("imgs/boss.png").getImage(); //access the boss picture

    public static Image explodeImg = new ImageIcon("imgs/explode/e6.gif").getImage(); //access the explosion picture

    public static Image planeImg = new ImageIcon("imgs/plane.png").getImage(); //access the plane picture 

    public static Image shellImg = new ImageIcon("imgs/shell.png").getImage(); //access the picture of the shell of the plane of the player

    public static ArrayList<ShellObj> shellObjList = new ArrayList<>(); //a collection of shell object of the plane at our side

    public static ArrayList<GameObj> gameObjList = new ArrayList<>(); //a collection of all the objects in the game

}