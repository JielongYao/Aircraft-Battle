import java.awt.*;

//superclass of all elements in the game(plane, enemy, boss, bullet..)
//Every element in the game has its size(width, height), its corresponding picture (these common things can be used to be attribtes of this class). This class is used to reduce code duplication 
public class GameObj{
    
    Image img; //corresponding picture of this element in the game
    
    //the size of this element in the game
    int width; 
    int height;
    
    //the location of this element in the game
    int x;
    int y;

    double speed; //movement speed of this element

    GameWin frame; //Game window

    
    //setters and getters
    public Image getImg(){
        return img;
    }

    public void setImg(Image img){
        this.img = img;
    }


    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }


    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }


    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }


    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }


    public double getSpeed(){
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }


    public GameWin getFrame(){
        return frame;
    }

    public void setFrame(GameWin frame){
        this.frame = frame;
    }


    //constructor
    
}