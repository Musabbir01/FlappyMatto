package Flappy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by admin on 12/27/2017.
 */
public class GameOverState extends JPanel {

    public BufferedImage GameOverImage;
    public GameOverState(){
        loadImage();

    }
    public void loadImage(){
        try{
        GameOverImage= ImageIO.read(new File("C://Users//admin//IdeaProjects//FlappyMatto//Resource//Untitled.png"));
    }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(GameOverImage,0,0,null);
        g.drawString("Score:"+GameState.Score,50,50);
    }
}
