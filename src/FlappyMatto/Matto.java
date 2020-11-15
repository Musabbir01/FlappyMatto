package FlappyMatto;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by admin on 12/10/2017.
 */
public class Matto implements Runnable {
    private Display display;
    private Thread thread;
    private String title;
    private int weidth,height;
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage image;
    public Matto(String title,int weidth,int height){
        this.weidth=weidth;
        this.height=height;
        this.title=title;

    }
    private void init(){
        display =new Display(title,weidth,height);
        image=LoadImage.loadImage("/FirstState.png");
    }
    private void update(){}
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        g.clearRect(0,0,weidth,height);
        g.drawImage(image,0,0,null);

        bs.show();
        g.dispose();
    }
    public void run(){
        init();
        while (running){
            update();
            render();
        }
        stop();
    }
    public synchronized void start(){
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}
