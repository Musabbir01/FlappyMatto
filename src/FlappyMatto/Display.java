package FlappyMatto;

/**
 * Created by admin on 12/10/2017.
 */
import javax.swing.*;
import java.awt.*;

public class Display {
    JFrame frame;
    private Canvas canvas;
    private String title;
    private int width,height;
    public Display(String title,int width,int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
    }
    public void createDisplay(){
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        frame.add(canvas);
        frame.pack();

    }
    public Canvas getCanvas(){
        return canvas;
    }


}
