package com.coding.platform.util.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.coding.platform.util.CommonUtil;
import com.coding.platform.util.paging.Paging;

@Controller
public class FileDownloadController implements ApplicationContextAware{
	@Autowired(required = false)
	private WebApplicationContext context = null;
	
	@Inject
	private FileSystemResource fsResource;	//DI
	

	@RequestMapping("download.do")
	public ModelAndView download(@RequestParam("path")String path, HttpServletRequest request){

		if (!path.isEmpty()) {
			try {
				
				String rootPath = fsResource.getPath();
				
				File file = new File(rootPath + path);
			
				return new ModelAndView("fileDownloadView", "downloadFile" , file);
			} catch (Exception e) {
				return null;
			}
        } else {
        	return null;
        }

	}
	
	@RequestMapping(value="downloadNew.do", method=RequestMethod.GET)
	public ModelAndView downloadNew(@RequestParam("path")String path, @RequestParam("fno")int fileNo) throws UnsupportedEncodingException{
		
		if (!path.isEmpty()) {
			try {				
				String rootPath = fsResource.getPath();				
				File file = new File(rootPath + path);
				HashMap<String, Object> model = new HashMap<String, Object>();
				model.put("file", file);
				model.put("fileNo", fileNo);
				return new ModelAndView("newFileDownloadView", "downloadFile" , model);
			} catch (Exception e) {
				return null;
			}
        } else {
        	return null;
        }

	}
	

	@RequestMapping("downloadMoviefile.do")
	public ModelAndView downloadMoviefile(@RequestParam("path")String path, HttpServletRequest request){

		if (!path.isEmpty()) {
			try {
				
				String serverIP = InetAddress.getLocalHost().getHostAddress();
				System.out.println("#####################");
				System.out.println("serverIP ::::" + serverIP);
				System.out.println("#####################");
				String rootPath2 = "C:\\Tomcat_7.0\\webapps\\edu\\file\\";
				if (serverIP.equals("218.232.111.111") ){
					rootPath2 = "D:\\tomcat7\\webapps\\edu\\file\\";
				} else if (serverIP.equals("222.235.64.151") ){
					rootPath2 = "/\\222.235.64.153\\file\\";
				} else if (serverIP.equals("222.235.64.152") ){
					rootPath2 = "/\\222.235.64.153\\file\\";
				} else if (serverIP.equals("222.235.64.157") ){
//					rootPath2 = "D:\\Tomcat 7.0\\webapps\\edu\\file\\";
					rootPath2 = "/\\222.235.64.153\\file\\";
				} else if (serverIP.equals("222.235.64.155") ){
					rootPath2 = "D:\\Tomcat 7.0\\webapps\\edu\\file\\";
				}	
				
				File file = new File(rootPath2 + path);
				System.out.println("========================================= serverIP : "+serverIP);
				System.out.println("========================================= rootPath2 : "+rootPath2);
				System.out.println("========================================= path : "+path);
				return new ModelAndView("fileDownloadView", "downloadFile" , file);
			} catch (Exception e) {
				return null;
			}
        } else {
        	return null;
        }

	}

	
	@RequestMapping("imgFileView.do")
	public ResponseEntity<byte[]>  imgFileView(@RequestParam("path")String path) throws Exception{
		//path = new String(path.getBytes("UTF-8"), "UTF-8");
		String rootPath = fsResource.getPath();

		FileInputStream fin = new FileInputStream(new File(rootPath + path));
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);
	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(fin), headers, HttpStatus.CREATED);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.context = (WebApplicationContext)arg0;
	}
}