package ex02.net.chat1;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class main1 class ImageReaderExample {

    public void main(String[] args) {
     try{
          BufferedImage image = ImageIO.read(new File("KakaoTalk_20190703_131844382.png"));

          image.getGraphics().drawLine(1, 1, image.getWidth()-1, image.getHeight()-1);
          image.getGraphics().drawLine(1, image.getHeight()-1, image.getWidth()-1, 1);

          ImageIO.write(image, "png", new File("/tmp/output.png"));
     }
     catch (IOException e){
         e.printStackTrace();
     }
    }
}
