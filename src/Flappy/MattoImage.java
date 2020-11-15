package Flappy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by admin on 12/10/2017.
 */
public class MattoImage {
    private BufferedImage MattoImage;
    private static int MattoWidth=36;
    public static int x=(FlappyMatto.WIDTH/2)-MattoWidth/2;
    public static int y=(FlappyMatto.HEIGHT/2);
    private static int Matto_spd=2;
    private int accel=1;
    public MattoImage(){

        loadImage();
    }
    public void loadImage(){
        try {
            MattoImage = ImageIO.read(new File("C://Users//admin//IdeaProjects//FlappyMatto//Resource//NewGameRocket.png"));
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void paint(Graphics g){

        g.drawImage(MattoImage,x,y,null);
    }
    public void MattoMovement(){
        if(y>=0 && y<=FlappyMatto.HEIGHT){
            Matto_spd=Matto_spd+accel;
            y=y+Matto_spd;
        }else {
            boolean option = GameState.popUpMessege();
            if (option) {
                try {
                    Thread.sleep(600);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                reset();

            } else {
                JFrame frame=FlappyMatto.getFrame();
                frame.dispose();
                FlappyMatto.timer.stop();

            }
        }
    }

    public void goingUp(){

        Matto_spd=-12;
    }
    public static void reset(){
        try {
            Thread.sleep(600);

        }catch (Exception e){
            e.printStackTrace();
        }
        Matto_spd=2;
        y=(FlappyMatto.HEIGHT/2);
        GameState.GameOver=true;
    }
    public static Rectangle getMattoRect(){
        Rectangle MattoRect =new Rectangle(x,y,45,41);
        return MattoRect;

    }
}
