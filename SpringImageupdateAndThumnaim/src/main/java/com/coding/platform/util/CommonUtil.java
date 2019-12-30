package com.coding.platform.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ser.JdkSerializers.FileSerializer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coding.domain.BoardFile;
import com.coding.platform.util.file.FileUtil;

public class CommonUtil {

	public static String isNull(String param) {
		return isNull(param, "");
	}
	
	public static String isNull(String param, String ref) {
		String result = param;
		if(param == null || "".equals(param) ||"null".equals(param)) result = ref;
		return result;
	}

	public static String getCurrentDate() {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentDate = new Date ( );
		String mDate = mSimpleDateFormat.format ( currentDate );
		
		return mDate;
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMddHHmmssSSS", Locale.KOREA );
		Date currentTime = new Date ( );
		String mTime = mSimpleDateFormat.format ( currentTime );
		
		return mTime;
	}
	
	public static Boolean isEmail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = email.matches(EMAIL_REGEX);
		return b;
	}
	
	public static String rmStringKor(String Str, int limit){
		int len = Str.length();
		int cnt = 0;
		int index = 0;

		while (index < len && cnt < limit) {
			if (Str.charAt(index++) < 256) {
				cnt++;
			}else {
				cnt += 2;
			}
		}
		if (index < len) {
			Str = Str.substring(0, index) + "...";
		}
		return Str;
	}

	public static List<BoardFile> createFiles(FileSystemResource fsResource, MultipartHttpServletRequest multiRequest, FileUtil fileUtil, String fileInputName, String regId, int boardType, int boardSeq, int isImageItem) throws IllegalStateException, IOException{
			List<BoardFile> bFiles = new ArrayList<BoardFile>();
		String rootPath = fsResource.getPath();
		String subPath = "100"+File.separator+"bbs"+File.separator;   // 이전 "100/bbs/"
		List<MultipartFile> uploadFile = multiRequest.getFiles(fileInputName);
		for(MultipartFile uf : uploadFile) {
			if(uf != null && !uf.isEmpty()) {
				HashMap<String, Object> fileMap = fileUtil.uploadFile(uf, rootPath, subPath);
				String file_path =  String.valueOf(fileMap.get("fileFullPath"));
//				bFiles.add(new BoardFile(boardType, boardSeq, uf.getOriginalFilename().toString(), isImageItem, regId,file_path));
			}
		}
		return bFiles;
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> setParameterValue(HttpServletRequest request) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		Enumeration<String> _enum = request.getParameterNames();

		String parameterName = null;
		String[] parameterValues = null;

		while(_enum.hasMoreElements()){
			parameterName = _enum.nextElement().toString();
			parameterValues = request.getParameterValues(parameterName);

			for(int i=0; i<parameterValues.length; i++){
				if(parameterValues[i] == null){
					parameterValues[i] = "";
				}

				params.put(parameterName, parameterValues[i]);
			}
		}

		HashMap<String, String> sessionMap = (HashMap<String, String>)request.getSession().getAttribute("AdmUserInfo");
		params.put("LGOIN_USER_ID", CommonUtil.isNull(sessionMap.get("USER_ID")));
		params.put("LGOIN_USER_NM", CommonUtil.isNull(sessionMap.get("USER_NM")));
		return params;
	}

	static String[] fileExtension = { 
			"zip", "mp4","avi",
			"txt", 
			"bmp", "png", "gif", "jpg", "jpeg",
			"avi", "mpg", "wmv",
			"pdf", 
			"doc", "xls", "ppt", "swf","htm","html",
			"docx", "xlsx", "pptx", 
			"hwp"
		};

	static String[] fileExtensionImg = { 
		"bmp", "png", "gif", "jpg", "jpeg"
	};
	
	static String[] fileExtensionApply = { 
		"doc", "docx", "hwp", "pdf", ""
	};
	
	//파일업로드 공통메소드 20180427.kdk
	public static boolean ValidUploadFileExtension(List<MultipartFile> uploadFile){
		boolean rtnVal = false;
		
		if (uploadFile.size() > 0)
		{
			for(MultipartFile file:uploadFile)
			{
				String allFile = file.getOriginalFilename();
				
				if("".equals(allFile)) rtnVal=true;
				
				String ext = allFile.substring(allFile.lastIndexOf(".")+1,allFile.length());

				for(int i=0; i<fileExtension.length; i++)
				{
					if(fileExtension[i].equals(ext))
					{
						rtnVal = true;
					}
				}
			}
		}
		return rtnVal;
	}

	//img파일
	public static boolean ValidUploadFileImgExtension(List<MultipartFile> uploadFile){
		boolean rtnVal = false;
		
		if (uploadFile.size() > 0)
		{
			for(MultipartFile file:uploadFile)
			{
				String imgFile = file.getOriginalFilename();
				
				
				if("".equals(imgFile)) rtnVal=true;
				
				String ext = imgFile.substring(imgFile.lastIndexOf(".")+1,imgFile.length());

				for(int i=0; i<fileExtensionImg.length; i++)
				{
					if(fileExtensionImg[i].equals(ext))
					{
						rtnVal = true;
					}
				}
			}
		}
		return rtnVal;
	}

	//지원서파일
	public static boolean ValidUploadFileApplyExtension(List<MultipartFile> uploadFile){
		boolean rtnVal = false;
		
		if (uploadFile.size() > 0)
		{
			for(MultipartFile file:uploadFile)
			{
				String applyFile = file.getOriginalFilename();
				
				if("".equals(file)) rtnVal=true;
				
				String ext = applyFile.substring(applyFile.lastIndexOf(".")+1,applyFile.length());

				for(int i=0; i<fileExtensionApply.length; i++)
				{
					if(fileExtensionApply[i].equals(ext))
					{
						rtnVal = true;
					}
				}
			}
		}
		return rtnVal;
	}
	//파일업로드 공통메소드 20180427.kdk
	
}