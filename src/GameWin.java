import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWin extends JFrame{//game windows class in the game
    
    //variable to record the game state
    //0: unstarted, 1: in the game, 2: paused, 3: defeat, 4: victory
    public static int state = 0; 

    BgObj bgObj = new BgObj(GameUtils.bgImg, 0, -1800, 2); //background object

    Image offScreenImage = null;
    
    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 37, 41, 290, 550, 0, this); //the plane object on the player's side

    LittleBoss1Obj littleBoss1Obj = new LittleBoss1Obj(GameUtils.littleBoss1Img, 172, 112, -200, 250, 3, this);//the first type of little boss object

    LittleBoss2Obj littleBoss2Obj = new LittleBoss2Obj(GameUtils.littleBoss2Img, 172, 112, 300, -150, 2, this);//the second type of little boss object

    BossObj bossObj = new BossObj(GameUtils.bossImg, 240, 174, 180, -180, 3, this);//final boss

    WarningObj warningObj = new WarningObj(GameUtils.warningImg, 599, 90, 0, 350, 0, this);//warning mark object

    int count = 0;// number of times to invoke createObj()

    public static int planeindex = 0; //the index of planeObj in the gameObjList

    public static int score = 0; //scores the player gains in the game

    UnstartedMusicPlayer unstartedMusicPlayer = new UnstartedMusicPlayer("audio/unstarted.wav");

    GamePausedMusicPlayer gamePausedMusicPlayer = new GamePausedMusicPlayer("audio/respite.wav");

    InTheGameMusicPlayer inTheGameMusicPlayer = new InTheGameMusicPlayer("audio/in the game.wav");

    DefeatMusicPlayer defeatMusicPlayer = new DefeatMusicPlayer("audio/defeat.wav");

    public static VictoryMusicPlayer victoryMusicPlayer = new VictoryMusicPlayer("audio/victory.wav");

    public void launch(){

        this.setSize(600, 800); //width, height

        this.setLocationRelativeTo(null); // game window centered on screen

        this.setTitle("Aircraft Battle"); //set game window visible
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application when clicking the clsoe button

        this.setVisible(true);

        GameUtils.gameObjList.add(bgObj); //add background object to the list of all objects in the game

        GameUtils.gameObjList.add(planeObj); ////add plane object at the player side to the list of all objects in the game

        planeindex = GameUtils.gameObjList.indexOf(planeObj);//access index of planeObj in the gameObjList; will be used in tracking functionality in LittleBoss2BulletObj class

        unstartedMusicPlayer.play();

        this.addMouseListener(new MouseAdapter(){//click mouse to start game

            public void mouseClicked(MouseEvent e){
                if(e.getButton() == 1 && state == 0){//when left mouse click and game is in unstarted state
                    unstartedMusicPlayer.stop();
                    state = 1; //set game state to "in the game" state
                    repaint(); //call paint()
                    inTheGameMusicPlayer.play();
                }
            }
        });

        this.addMouseMotionListener(new MouseAdapter(){//make the player's airplane move following mouse's movement
            @Override
            public void mouseMoved(MouseEvent e){
                planeObj.x = e.getX() - 19;
                planeObj.y = e.getY() - 20;
            }
        });

        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 32){//when space key is pressed
                    if(state == 1){
                        inTheGameMusicPlayer.pause();
                        state = 2;
                        gamePausedMusicPlayer.play();
                    }else if(state == 2){
                        gamePausedMusicPlayer.stop();
                        inTheGameMusicPlayer.resume();
                        state = 1;
                    }
                }
            }
        });

        while(true){
            if(state == 1){
                createObj();
            }
            repaint();
            try{
                Thread.sleep(25); //prevent from repainting too fast; let thread sleep for 25 ms
            }catch(Exception e){ //there will be an error without this exception handling
                e.printStackTrace();
            }
        }
    }
    

    @Override
    public void paint(Graphics g){
        //The paint method is called by the Event Dispatch Thread (EDT) and is basically out of my control. I never invoke paint mathod myself. 
        //When I realize a user interface such as call setVisible(true), Swing starts the EDT. This EDT thread then runs in the background and, whenever my component needs to be painted, it calls the paint method with an appropriate Graphics instance for me to use for painting.
        //For example, when window is resized, when the component is made visible, when repaint() is called... it will be called, whenever it is necessary.
        if (offScreenImage == null){
            offScreenImage = this.createImage(600, 800);
        }
        Graphics gOff = offScreenImage.getGraphics();

        if(state == 0){//game is unstarted
            
            //Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg"); //another method to access the background picture here without GameUtils.java
            //Image bgImg = new ImageIcon(this.getClass().getResource("imgs/bg.jpg")).getImage(); //access the background picture here without GameUtils.java
            gOff.drawImage(GameUtils.bgImg, 0, 0 , null); //x = 0, y = 0

            gOff.drawImage(GameUtils.bossImg, 190, 70 , null); //x = 190, y = 70

            gOff.drawImage(GameUtils.explodeImg, 270, 350, null); //x = 270, y = 350

            gOff.drawImage(GameUtils.planeImg, 280, 470 , null); //x = 280, y = 470

            //Draw the bold italic words "Left Click to Start" on the game start interface
            gOff.setColor(Color.BLUE); // set font color
            gOff.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 30)); //set font name and size
            gOff.drawString("Left Click to Start", 180, 320); //x = 160, y = 320
        }

        if(state == 1){//game is going
            // bgObj.paintSelf(gOff);
            // planeObj.paintSelf(gOff);
            // shellObj.paintSelf(gOff);
            
            //delete all game onjects which has been removed from the game window to reduce pressure to paint game elements
            GameUtils.gameObjList.removeAll(GameUtils.removeList);

            // Game objects are no longer drawn individually line by line
            // Instead, after adding all the objects in the game into the list, we can iterate over the list and make each object to paint itself to reduce code repetition
            for(int i = 0; i < GameUtils.gameObjList.size(); i++){
                GameUtils.gameObjList.get(i).paintSelf(gOff);
            } 
        }

        if(state == 2){//game is paused
            gOff.drawImage(GameUtils.bgImg, 0, 0 , null);
            GameUtils.writeWord(gOff, "Game Paused", Color.YELLOW, 30, 200, 330);   

        }

        if(state == 3){//defeat
            gOff.drawImage(GameUtils.bgImg, 0, 0 , null);
            GameUtils.writeWord(gOff, "Defeat", Color.RED, 30, 240, 360);
        }

        if(state == 4){//victory
            gOff.drawImage(GameUtils.bgImg, 0, 0 , null);
            GameUtils.writeWord(gOff, "Victory", Color.GREEN, 30, 240, 360);
        }
        
        GameUtils.writeWord(gOff, "Score: " + score, Color.GREEN, 20, 30, 70);//write player's current score in the game window

        g.drawImage(offScreenImage, 0, 0, null);
    }


    public void createObj(){
        if(count % 10 == 0){//create a shell of our side every 10 times invoking createObj(); otherwise the shell (or other objects) generation rate will be very high
            if(planeObj.times == 0){//the player's plane haven't collided with any gift
                GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX() + 12, planeObj.getY() - 20, 6, this)); // create new shell object at the player's side
                GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
            }
            if(planeObj.times == 1){//the player's plane collided with 1 gift
                GameUtils.doubleShellObjList.add(new DoubleShellObj(GameUtils.doubleShellImg, 32, 64, planeObj.getX() + 3, planeObj.getY() - 20, 8, this)); 
                GameUtils.gameObjList.add(GameUtils.doubleShellObjList.get(GameUtils.doubleShellObjList.size() - 1));
            }
            if(planeObj.times == 2){//the player's plane collided with 2 gifts
                GameUtils.tripleShellObjList.add(new TripleShellObj(GameUtils.tripleShellImg, 64, 182, planeObj.getX() - 10, planeObj.getY() - 100, 15, this)); 
                GameUtils.gameObjList.add(GameUtils.tripleShellObjList.get(GameUtils.tripleShellObjList.size() - 1));
            }
        }

        if(count % 30 == 0){//control the generation rate of the object of the first type of enemy 
            GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img, 32, 24, (int)(Math.random() * 10) * 60, 0, 5, this)); // create a new plane object of the first enemy plane type
            GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size() - 1));
        }

        if(count % 20 == 0){//control the generation rate of the object of the bullet of the second type of enemy 

            if(count % 140 == 0){//control the generation rate of the object of the second type of enemy 
                GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img, 44, 67, (int)(Math.random() * 10) * 60, 0, 3, this)); // create a new plane object of the first enemy plane type
                GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1));
            }

            if(GameUtils.enemy2ObjList.size() > 0){
                int x = GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1).getX(); //x coordinate of the location of the very newly generated enemy2 object
                int y = GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1).getY(); //y coordinate of the location of the very newly generated enemy2 object
                GameUtils.enemy2BulletObjList.add(new Enemy2BulletObj(GameUtils.enemy2BulletImg, 14, 25, x + 15, y + 51, 7, this)); // create a new plane object of the first enemy plane type
                GameUtils.gameObjList.add(GameUtils.enemy2BulletObjList.get(GameUtils.enemy2BulletObjList.size() - 1));
            }

        }
        
        if(count % 200 == 0){
            if(count == 1800){//littleboss2 will appear
                GameUtils.littleBoss2ObjList.add(littleBoss2Obj);
                GameUtils.gameObjList.add(littleBoss2Obj);
            }
            if(GameUtils.gameObjList.contains(littleBoss2Obj)){
                int x = littleBoss2Obj.getX();
                int y = littleBoss2Obj.getY();
                GameUtils.littleBoss2BulletObjList.add(new LittleBoss2BulletObj(GameUtils.littleBoss2BulletImg, 21, 59, x + 78, y + 100, 3, this)); 
                GameUtils.gameObjList.add(GameUtils.littleBoss2BulletObjList.get(GameUtils.littleBoss2BulletObjList.size() - 1));
            }
        }
        
        if(count % 40 == 0){
            if(count == 2000){//littleboss1 will appear
                GameUtils.littleBoss1ObjList.add(littleBoss1Obj);
                GameUtils.gameObjList.add(littleBoss1Obj);
            }
            if(GameUtils.gameObjList.contains(littleBoss1Obj)){
                int x = littleBoss1Obj.getX();
                int y = littleBoss1Obj.getY();
                GameUtils.littleBoss1BulletObjList.add(new LittleBoss1BulletObj(GameUtils.littleBoss1BulletImg, 42, 42, x + 75, y + 100, 4, this)); 
                GameUtils.gameObjList.add(GameUtils.littleBoss1BulletObjList.get(GameUtils.littleBoss1BulletObjList.size() - 1));
            }
        }
        
        if(count == 3300){//warning mark will appear before the final boss appears, because 3300 < 3600
            GameUtils.gameObjList.add(warningObj);
        }

        if(count == 3500){//warning mark disppear
            GameUtils.removeList.add(warningObj);
        }

        if(count % 30 == 0){
            if(count == 3600){//final boss will appear
                GameUtils.gameObjList.add(bossObj);
            }
            if(GameUtils.gameObjList.contains(bossObj)){
                int x = bossObj.getX();
                int y = bossObj.getY();
                //final boss will also generate littleboss1bullet
                GameUtils.littleBoss1BulletObjList.add(new LittleBoss1BulletObj(GameUtils.littleBoss1BulletImg, 42, 42, x + 10, y + 130, 6, this)); 
                GameUtils.gameObjList.add(GameUtils.littleBoss1BulletObjList.get(GameUtils.littleBoss1BulletObjList.size() - 1));
                
                if(count % 90 == 0){//final boss will also generate littleboss2bullet
                    GameUtils.littleBoss2BulletObjList.add(new LittleBoss2BulletObj(GameUtils.littleBoss2BulletImg, 21, 59, x + 220, y + 130, 3, this)); 
                    GameUtils.gameObjList.add(GameUtils.littleBoss2BulletObjList.get(GameUtils.littleBoss2BulletObjList.size() - 1));
                }

                //final boss will generate bossbullet
                GameUtils.bossBulletObjList.add(new BossBulletObj(GameUtils.bossBulletImg, 51, 72, x + 90, y + 100, 9, this)); 
                GameUtils.gameObjList.add(GameUtils.bossBulletObjList.get(GameUtils.bossBulletObjList.size() - 1));
            }
        }

        count++;
    }

}