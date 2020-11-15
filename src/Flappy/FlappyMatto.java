package Flappy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by admin on 12/9/2017.
 */
public class FlappyMatto {
    public static final int WIDTH=540,HEIGHT=700;
     private static JFrame frame;
     public static Timer timer,timer1;
     private int count=4;
    public FlappyMatto(){
        frame=new JFrame("FlappyMatto");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void render(){
        FirstState st=new FirstState();
        GameState gs=new GameState();
        timer=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gs.repaint();
                gs.Move();
            }
        });
        frame.add(st);
        frame.setVisible(true);
        while(st.running==false){
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        frame.remove(st);
        frame.add(gs);
        gs.setVisible(true);
        frame.revalidate();
        //timer.start();
        timer1=new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                GameState.count=count;
                GameState.start=true;
                gs.repaint();
                if(count==0){
                    timer1.stop();
                    timer.start();
                    GameState.start=false;
                }

            }
        });
        timer1.start();

    }
    public static JFrame getFrame(){
        return frame;
    }
    public static void main(String[] args) {
        FlappyMatto Matto=new FlappyMatto();
        Matto.render();
    }


}
