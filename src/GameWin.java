import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWin extends JFrame{
    
    //variable to record the game state
    //0: unstarted, 1: in the game, 2: paused, 3: defeat, 4: victory
    int state = 0; 

    BgObj bgObj = new BgObj(GameUtils.bgImg, 0, -1800, 2); //background object

    Image offScreenImage = null;
    
    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 37, 41, 290, 550, 0, this); //the plane object on the player's side

    int count = 0;// number of times to invoke createObj()

    public void launch(){

        this.setSize(600, 800); //width, height

        this.setLocationRelativeTo(null); // game window centered on screen

        this.setTitle("Aircraft Battle"); //set game window visible
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application when clicking the clsoe button

        this.setVisible(true);

        GameUtils.gameObjList.add(bgObj); //add background object to the list of all objects in the game

        GameUtils.gameObjList.add(planeObj); ////add plane object at the player side to the list of all objects in the game

        this.addMouseListener(new MouseAdapter(){//click mouse to start game

            public void mouseClicked(MouseEvent e){
                if(e.getButton() == 1 && state == 0){//when left mouse click and game is in unstarted state
                    state = 1; //set game state to "in the game" state
                    repaint(); //call paint()
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

        while(true){
            createObj();
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

        if(state == 0){
            
            //Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg"); //another method to access the background picture here without GameUtils.java
            //Image bgImg = new ImageIcon(this.getClass().getResource("imgs/bg.jpg")).getImage(); //access the background picture here without GameUtils.java
            gOff.drawImage(GameUtils.bgImg, 0, 0 , null); //x = 0, y = 0

            gOff.drawImage(GameUtils.bossImg, 190, 70 , null); //x = 190, y = 70

            gOff.drawImage(GameUtils.explodeImg, 270, 350, null); //x = 270, y = 350

            gOff.drawImage(GameUtils.planeImg, 280, 470 , null); //x = 280, y = 470

            //Draw the bold italic words "Left Click to Start" on the game start interface
            gOff.setColor(Color.BLUE); // set font color
            gOff.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 30)); //set font name and size
            gOff.drawString("Left Click to Start", 160, 320); //x = 160, y = 320
        }

        if(state == 1){
            // bgObj.paintSelf(gOff);
            // planeObj.paintSelf(gOff);
            // shellObj.paintSelf(gOff);

            // Game objects are no longer drawn individually line by line
            // Instead, after adding all the objects in the game into the list, we can iterate over the list and make each object to paint itself to reduce code repetition
            for(int i = 0; i < GameUtils.gameObjList.size(); i++){
                GameUtils.gameObjList.get(i).paintSelf(gOff);
            }
        }
        g.drawImage(offScreenImage, 0, 0, null);
        
    }


    public void createObj(){
        if(count % 10 == 0){//create a shell of our side every 15 times invoking createObj(); otherwise the shell (or other objects) generation rate will be very high
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX() + 12, planeObj.getY() - 20, 8, this)); // create new shell object at the player's side
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        count++;
    }

}