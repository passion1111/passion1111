package image2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class qwdwqd {
	public static void main(String[] args) throws IOException {
		 File outputfile = new File("Chrysanthemum .jpg");
		    FileInputStream fis = new FileInputStream(outputfile);
//		    ImageIO.write(img, "jpg", outputfile);
		    System.out.println(ImageIO.read(outputfile));
//		    ImageIO.write(,  "jpg", outputfile);
//		    fos.flush();
//		    fos.close();
		    
		    try{ 
		        BufferedImage image = ImageIO.read(new File("C:\\kss\\work space\\personal\\Chrysanthemum .jpg")); 

		        image.getGraphics().drawLine(1, 1, image.getWidth()-1, image.getHeight()-1); 
		        image.getGraphics().drawLine(1, image.getHeight()-1, image.getWidth()-1, 1); 

		        ImageIO.write(image, "jpg", new File("Chrysanthemum .jpg")); 
		      } 
		      catch (IOException e){ 
		       e.printStackTrace(); 
		      } 
		      } 
		   
	}
	

