package Flappy;

/**
 * Created by admin on 12/10/2017.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
public class Pillar {
    private Random r=new Random();
    private int gapOf_pillar=150;
    public int X;
    public int Y=r.nextInt(FlappyMatto.HEIGHT-350)+gapOf_pillar; //max 550 min  200
    private int pillar_Width=52;
    private int pillar_Height=FlappyMatto.HEIGHT-Y;
    public static int PillarMoveSpeed=-4;
    private BufferedImage pillarImage;
    public Pillar(int X){
        this.X=X;
        LoadImage();

    }

    private void LoadImage() {
        try{
            pillarImage= ImageIO.read(new File("C://Users//admin//IdeaProjects//FlappyMatto//Resource//newWall.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void pillarMove(){
        X=X+PillarMoveSpeed;
        if(X<=-pillar_Width){
            X=FlappyMatto.WIDTH;
            Y=r.nextInt(FlappyMatto.HEIGHT-350)+gapOf_pillar;
            pillar_Height=FlappyMatto.HEIGHT-Y;
        }
        Rectangle bottomRect= new Rectangle(X,Y,pillar_Width,pillar_Height);
        Rectangle topRect = new Rectangle(X,0,pillar_Width,FlappyMatto.HEIGHT-(pillar_Height+gapOf_pillar));
        //IF Matto and wall get crash
        if(bottomRect.intersects(MattoImage.getMattoRect())||topRect.intersects(MattoImage.getMattoRect())){
            boolean option=GameState.popUpMessege();
            if(option){
            try {
                Thread.sleep(600);

            }catch (Exception e){
                e.printStackTrace();
            }
            MattoImage.reset();
            pillarReset();
            GameState.Score=0;

        }else {
                JFrame frame=FlappyMatto.getFrame();
                frame.dispose();
                FlappyMatto.timer.stop();

            }
        }
    }
    public void paint(Graphics g){

        g.drawImage(pillarImage,X,Y,null); //bottom
        g.drawImage(pillarImage,X,(-FlappyMatto.HEIGHT)+(Y-gapOf_pillar),null); //upper
    }
    public void pillarReset(){
          Y=r.nextInt(FlappyMatto.HEIGHT-200)+gapOf_pillar;
          pillar_Height=FlappyMatto.HEIGHT-Y;
          GameState.GameOver=true;

    }
}
