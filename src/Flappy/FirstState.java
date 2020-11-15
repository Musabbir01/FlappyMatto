package Flappy;

/**
 * Created by admin on 12/10/2017.
 */

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class FirstState extends JPanel {

    BufferedImage FirstStateImage;
    final static String imagePath="C://Users//admin//IdeaProjects//FlappyMatto//Resource//FirstState.png";
    public boolean running=false;
    public FirstState(){
        loadImage();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                running=true;
                GameSound.Music();
            }
        });
    }
    public void loadImage(){
        try{
            FirstStateImage=ImageIO.read(new File(imagePath));


        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(FirstStateImage,0,0,null);
    }
}
