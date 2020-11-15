package Flappy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;

/**
 * Created by admin on 12/9/2017.
 */
public class GameState extends JPanel {
    MattoImage mI=new MattoImage();
    Pillar pI=new Pillar(FlappyMatto.WIDTH);
    Pillar pI2=new Pillar(FlappyMatto.WIDTH+(FlappyMatto.WIDTH/2));
    private int xc=0;
    public static int Score=0;
    public static boolean GameOver=true;
    public static boolean start=false;
    public static int count=-1;
    BufferedImage BackGroundImage;

    public GameState(){
        loadImage();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mI.goingUp();
            }
        });

    }
    public void loadImage(){
        try {
            BackGroundImage = ImageIO.read(new File("C://Users//admin//IdeaProjects//FlappyMatto//Resource//galaxynew.png"));
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(BackGroundImage,xc,0,null);

        mI.paint(g);
        pI.paint(g);
        pI2.paint(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,120,40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("Score "+Score,20,30);
        if(start){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD,170));
            g.drawString(Integer.toString(count),FlappyMatto.WIDTH/2-70,350);
        }

    }
    public void Move(){
        mI.MattoMovement();
        pI.pillarMove();
        pI2.pillarMove();
        if(GameOver){
            pI.X=FlappyMatto.WIDTH;
            pI2.X=FlappyMatto.WIDTH+(FlappyMatto.WIDTH/2);
            GameOver=false;
        }
        //System.out.println(pI.X+"->"+MattoImage.x+" ; "+pI2.X+"->"+MattoImage.x);

        if(pI.X==MattoImage.x|| pI2.X==MattoImage.x){
            this.Score+=1;

        }
    }
    public static boolean popUpMessege() {
        int input = JOptionPane.showConfirmDialog(null, "Game Over,Score :" + Score + "\n Restart?", "   Gameover", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            return true;

        } else {
            return false;

        }
    }
}
