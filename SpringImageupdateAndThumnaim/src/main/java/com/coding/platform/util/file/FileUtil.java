package com.coding.platform.util.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.coding.platform.util.CommonUtil;
import com.coding.platform.util.file.service.MultipartFileService;

@Component("fileUtil")
public class FileUtil {
	@Autowired
	private MultipartFileService multipartFileservice;
	@Inject
	private FileSystemResource fsResource;	//DI
	
	public List<HashMap<String, Object>> uploadFiles(List<MultipartFile> uploadFileList, String rootPath, String subPath) throws IllegalStateException, IOException {
		List<HashMap<String, Object>> fileInfoList = new ArrayList<HashMap<String, Object>>();
		
		for(MultipartFile file:uploadFileList) {
			HashMap<String, Object> info = uploadFile(file, rootPath, subPath);
			
			//info.size()가 0이라는것은  파일을 첨부하지않았다는의미
			if(info.size()==0) continue;
			
			
			fileInfoList.add(info);
		}
		
		return fileInfoList;
	}
	
	public HashMap<String, Object> uploadFile(MultipartFile uploadFile, String rootPath, String subPath) throws IllegalStateException, IOException {
		HashMap<String, Object> info = new HashMap<String, Object>();
		String path = rootPath + subPath;
		if(!uploadFile.isEmpty()) {
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			String originalFileName = uploadFile.getOriginalFilename();
			
			String originalFileExt =originalFileName.substring(originalFileName.lastIndexOf("."));
			String newFileName = CommonUtil.getCurrentDateTime() + originalFileExt;
			
			String fileFullPath = path + newFileName;
			String fileSubPath = subPath + newFileName;

			File newFile = new File(fileFullPath);
			uploadFile.transferTo(newFile);

			info.put("fileName", 		originalFileName);
			info.put("newFileName", 	newFileName);
			info.put("fileFullPath", 	fileSubPath);
			info.put("fileSize", 		String.valueOf(uploadFile.getSize()));
		}
		
		return info;
	}
	
	public HashMap<String, Object> uploadFileForRealName(MultipartFile uploadFile, String rootPath, String subPath) throws IllegalStateException, IOException {
		HashMap<String, Object> info = new HashMap<String, Object>();
		String path = rootPath + subPath;
		if(!uploadFile.isEmpty()) {
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			String originalFileName = uploadFile.getOriginalFilename();
			
			String fileFullPath = path + originalFileName;
			String fileSubPath = subPath + originalFileName;

			File newFile = new File(fileFullPath);
			uploadFile.transferTo(newFile);

			info.put("fileName", 		originalFileName);
			info.put("fileFullPath", 	fileSubPath);
			info.put("fileSize", 		String.valueOf(uploadFile.getSize()));
		}
		
		return info;
	}
	
	public void deleteFile(String fileFullPath) throws IllegalStateException, IOException {	
		File f = new File(fileFullPath);
	   	if(f.exists())
	   		f.delete();
	}	
	
    /** + 
     * MethodName   : filemake(String filename, String msg)
     * Description  : 파일 업로드
     * @param       :
     * @return      : 
     * @exception   :
    */
    public void filemake(String filename, String desc, String subPath)
    {
        PrintWriter logfile = null;
        boolean isappend = true; //new Boolean(DirectoryBundle.getProperty("DEBUG_APPEND","false")).booleanValue();
        try {
    		String rootPath = fsResource.getPath() + subPath;
			File dir = new File(rootPath);
			if(!dir.exists()) dir.mkdirs();
            logfile = new PrintWriter(new FileWriter(rootPath + filename, isappend), true);
            logfile.println(desc);
            logfile.flush();
        } catch (Exception e)  {
            if(logfile != null) logfile.close();
            e.printStackTrace();
        } finally {
            if(logfile != null) logfile.close();
        }
    }		
}