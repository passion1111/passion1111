package com.coding.platform.util.file.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.coding.domain.BoardFile;
import com.coding.platform.board.service.BoardService;

public class NewFileDownloadView extends AbstractView{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	public NewFileDownloadView(){
		setContentType("application/download; utf-8");
	}

	@Autowired
	private BoardService boardService;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,	HttpServletRequest request, HttpServletResponse response)throws Exception {
		File file;
		String orgFileName = "";
		@SuppressWarnings("unchecked")
		HashMap<String, Object> hm = (HashMap<String, Object>)model.get("downloadFile");
		file = (File)hm.get("file");
		BoardFile bf = boardService.getfileInfo((Integer)hm.get("fileNo"));
		orgFileName = bf.getINXNAME();
		
		String s= new String(orgFileName.getBytes("utf-8"));
		System.out.println(bf.getINXNAME());
		System.out.println(s);
		
		response.setContentType(getContentType());
        response.setContentLength((int) file.length());
        
        String userAgent = request.getHeader("User-Agent");
        
        boolean ie = userAgent.indexOf("MSIE") > -1;
        boolean newie = userAgent.indexOf("Trident") > -1;
        
        String fileName = null;
        
        if(ie){
        	//fileName = URLEncoder.encode(orgFileName.equals("") ? file.getName() : orgFileName, "utf-8").replaceAll("\\+", "%20"); //개발
        	fileName = URLEncoder.encode(orgFileName.equals("") ? file.getName() : orgFileName, "utf-8").replaceAll("\\+", "%20"); //운용
        }else if(newie){
        	fileName = URLEncoder.encode(orgFileName.equals("") ? file.getName() : orgFileName, "utf-8").replaceAll("\\+", "%20");
        }else {
        	//fileName = new String((orgFileName.equals("") ? file.getName() : orgFileName).getBytes("utf-8"), "ISO-8859-1"); //개발
        	fileName = URLEncoder.encode(orgFileName.equals("") ? file.getName() : orgFileName, "utf-8"); //운용
        } //end if 
        
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        
        response.setHeader("Content-Transfer-Encoding", "binary");
         
        OutputStream out = response.getOutputStream();
         
        FileInputStream fis = null;
        try {
			
        	fis = new FileInputStream(file);
        	FileCopyUtils.copy(fis, out);
        	
		} catch (Exception e) {
			logger.error("file error" , e);
		}finally{
			if(fis != null){
                try{
                    fis.close();
                }catch(Exception e){}
            }
		} //try end
        
        out.flush();
	}
	
}//end class