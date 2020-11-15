package FlappyMatto;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;

/**
 * Created by admin on 12/10/2017.
 */

public class LoadImage {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(LoadImage.class.getResource(path));

        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);

        }
        return null;

    }
}
