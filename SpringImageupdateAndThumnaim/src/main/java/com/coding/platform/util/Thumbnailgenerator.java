package com.coding.platform.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Component
public class Thumbnailgenerator {
	
	
	public  HashMap<String,Object> ThumbnailGenarate(MultipartRequest multipartrequest,HttpServletRequest request,String subroot) throws Exception {
		HashMap<String,Object> thumbnailinfo=new HashMap<String,Object>();
		 List<MultipartFile> mf = multipartrequest.getFiles("uploadFile");       
		  for (int i = 0; i < mf.size(); i++) {
			  
			if(mf.get(i).isEmpty()) continue;
         	 // 파일 중복명 처리
              String genId = UUID.randomUUID().toString();
              // 본래 파일명
              String originalfileName = mf.get(i).getOriginalFilename();
              // 저장되는 파일 이름
              String saveFileName = "chalkack-" + genId + "." + originalfileName;
              // 리사이징되는 파일 이름
              String resizeFileName = "Thumb_" + saveFileName;
              
              
              String FileExt=originalfileName.substring(originalfileName.lastIndexOf(".")+1,originalfileName.length());
              System.out.println(FileExt);
              
              // 원본 이미지의 width,height
              BufferedImage image = ImageIO.read(mf.get(i).getInputStream());
              double getWidth = image.getWidth();
              double getHeight = image.getHeight();

              // 비율
              double resizeRatio = getWidth / getHeight;

              // 지정한 높이, 높이와 비율로 구한 너비
              int mediumHeight = 150;           
              //비율로 구한값 
//              int mediumWidth = (int) (resizeRatio * mediumHeight);
              int mediumWidth = (int) 150;
              
              
              
              BufferedImage thumbnail_medium = Thumbnails.of(image).size(mediumWidth,mediumHeight).asBufferedImage();
            
              
              String thumbName = request.getServletContext().getRealPath("/");
              String[] rootarray=subroot.split("/");
              for (int j = 0; j < rootarray.length; j++) {
              	thumbName+= (j==0)?rootarray[j]:File.separator+rootarray[j];
              	
              		if(j==rootarray.length-1)thumbName +=File.separator+"Thumb"+File.separator;
             
				}
              
              
				File check=new File(thumbName);
				if(!check.exists()){
					check.mkdirs();
				}
						
            thumbName+= resizeFileName; 
      	    File thumbFile = new File(thumbName);
      	    ImageIO.write(thumbnail_medium, FileExt, thumbFile);
      	    System.out.println(thumbFile.length());
      	    
      	    String FILEPATH=subroot+"/Thumb/"+resizeFileName;
      	    String BRDNAME=subroot+"_Thumb";
    	    thumbnailinfo.put("FILENAME", originalfileName);
    	    thumbnailinfo.put("INXNAME", resizeFileName);
    	    thumbnailinfo.put("FILESIZE", thumbFile.length());
    	    thumbnailinfo.put("FILEPATH", FILEPATH);
    	    thumbnailinfo.put("BRDNAME" , BRDNAME);
  }      
	      
//	            for (int i = 0; i < mf.size(); i++) {
//	            	 // 파일 중복명 처리
//	                String genId = UUID.randomUUID().toString();
//	                // 본래 파일명
//	                String originalfileName = mf.get(i).getOriginalFilename();
//	                // 저장되는 파일 이름
//	                String saveFileName = "chalkack-" + genId + "." + originalfileName;
//	                // 리사이징되는 파일 이름
//	                String resizeFileName_medium = "medium-" + saveFileName;
//	                
//	                
//	                String FileExt=originalfileName.substring(originalfileName.lastIndexOf("."),originalfileName.length());
//	                
//	                
//	                // 리사이징되는 파일 이름
//	                String resizeFileName = "THUMB_" + genId + "." + originalfileName;
//	                
//	                
//	                // 원본 이미지의 width,height
//	                BufferedImage image = ImageIO.read(mf.get(i).getInputStream());
//	                double getWidth = image.getWidth();
//	                double getHeight = image.getHeight();
//
//	                // 비율
//	                double resizeRatio = getWidth / getHeight;
//
//	                // 지정한 높이, 높이와 비율로 구한 너비
//	                int mediumHeight = 550;             
//	                int mediumWidth = (int) (resizeRatio * mediumHeight);
//
//	                //thumbnailator의 메소드를 이용해 썸네일을 bufferdimage로 만든다
//	                BufferedImage thumbnail_medium = Thumbnails.of(image).size(mediumWidth,mediumHeight).asBufferedImage();
//	                
//	                String thumbName = request.getServletContext()
//							.getRealPath("/"); 
//	                
//	                String[] rootarray=subroot.split("/");
//	                for (int j = 0; j < rootarray.length; j++) {
//	                	thumbName+= (j==0)?rootarray[j]:File.separator+rootarray[j];
//	                	
//	                		if(j==rootarray.length-1)thumbName +=File.separator+"Thumb"+File.separator;
//	               
//					}
//	                File folder=new File(thumbName);
//	                
//	                if(!folder.exists()){
//	                	folder.mkdirs();
//	                }
//	                
//	                
//	                
//	                thumbName +=resizeFileName;
//	                String FILEPATH=subroot+"/Thumb/"+resizeFileName;
//	                System.out.println(thumbName);
//	                
//	                	
//
//	          
//	        	    File thumbFile = new File(thumbName);
//	        	    
//	        	    ImageIO.write(thumbnail_medium, FileExt, thumbFile);
//	        	    System.out.println(thumbFile.length());
//	        	    thumbnailinfo.put("FILENAME", originalfileName);
//	        	    thumbnailinfo.put("INXNAME", resizeFileName);
//	        	    thumbnailinfo.put("FILESIZE", thumbFile.length());
//	        	    thumbnailinfo.put("FILEPATH", FILEPATH);
	//    }
	            
	      return thumbnailinfo;
	}     
}
