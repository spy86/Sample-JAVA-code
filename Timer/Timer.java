import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Timer extends JFrame implements Runnable{

    Thread watek;
    int x=0;
    int y=20;
    int z=12;
    boolean w= true;
  
    JPanel panel;
    JTextField pole;

    
    Timer(){
        super("Timer");
        setBounds(100,100,200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(watek==null)
        	watek=new Thread(this);
        watek.start();
             
        panel = new JPanel();
                
        pole = new JTextField();
        
        panel.add(pole);
        panel.setLayout (new GridLayout (1,1));
        setContentPane(panel);
        setVisible(true);
        
    }
        
    public static void main(String s[]){
        Timer clk = new Timer();
    }
    
    public void run(){
        while(true){     
                  
            pole.setText("Czas:"+z+":"+y+":"+x);
            x++;
            if (x==60) {
            y=y+1;
            x=0;
            }
            if (y==60){
            z=z+1;
            y=0;
            }
            if (z==24){
            z=0;
            }
           
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}         
	}
}
}