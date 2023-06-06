import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;  

public class GameFrame extends Frame{

    GameFrame(){
        
        setTitle("Aircraft Battle");
        setSize(500, 500);
        setLocation(300, 300);
        setVisible(true);

        //can't close game window without this
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });    
    }

}