package com.coding.web.notice;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hamcrest.core.IsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.coding.platform.util.CommonUtil;
import com.coding.platform.util.file.FileUtil;
import com.coding.platform.util.paging.Paging;
import com.coding.platform.util.paging.PagingM;
import com.coding.web.notice.service.noticeService;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/notice")
@Controller
public class noticeController {

	@Autowired
	private noticeService noticeService;
	
	@Resource(name="fileUtil")
	FileUtil fileUtil;

	@Inject
	private FileSystemResource fsResource;	//DI

	private static final Logger logger = LoggerFactory.getLogger(noticeController.class);
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 list
	 */
	@RequestMapping(value = "/noticeList.do")
	public String noticeList(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = "";
		String grade = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			grade = CommonUtil.isNull(sessionMap.get("GRADE"), "");
			model.addAttribute("userName", userName);
			model.addAttribute("grade", grade);
		}
		
		List<HashMap<String, Object>> list = null;
		// 검색조건
		String SEARCHTYPE = CommonUtil.isNull(request.getParameter("SEARCHTYPE"), "");
		String SEARCHKEYWORD = CommonUtil.isNull(request.getParameter("SEARCHKEYWORD"), "");
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String sToday = sdf.format(today);  
		
		String sdate = CommonUtil.isNull(request.getParameter("sdate"), sToday);
		String edate = CommonUtil.isNull(request.getParameter("edate"), sToday);
		String sdatet = sdate; 
		String edatet = edate;

		int currentPage = Integer.parseInt(CommonUtil.isNull(request.getParameter("currentPage"), "1"));
		int pageRow = Integer.parseInt(CommonUtil.isNull(request.getParameter("pageRow"), "15"));
		
		int startNo = (currentPage - 1) * pageRow;
		int endNo = startNo + pageRow;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("SEARCHTYPE", SEARCHTYPE);
		params.put("SEARCHKEYWORD", URLDecoder.decode(SEARCHKEYWORD,"UTF-8"));
		
		params.put("currentPage", currentPage);
		params.put("pageRow", pageRow);
		params.put("startNo", String.valueOf(startNo));
		params.put("endNo", String.valueOf(endNo));
		
		// 총 건수 -회원
		int listCount = noticeService.noticeListCount(params);

		// 공지사항 리스트
		list = noticeService.noticeList(params);
		
		String pagingHtml = new Paging(currentPage, listCount, pageRow).getPagingHtml().toString();

		model.addAttribute("list", list);
		model.addAttribute("params", params);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("totalCount", listCount);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageRow", pageRow);
		model.addAttribute("SEARCHTYPE", SEARCHTYPE);
		model.addAttribute("SEARCHKEYWORD", SEARCHKEYWORD);
		model.addAttribute("totalPage", (int) Math.ceil((double) listCount / pageRow));

		return "/notice/notice";
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 view
	 */
	@RequestMapping(value = "/noticeView.do")
	public String noticeView(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		List<HashMap<String, Object>> file = null;

		String userName = "";
		String grade = "";
		String userID = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			grade = CommonUtil.isNull(sessionMap.get("GRADE"), "");
			userID = CommonUtil.isNull(sessionMap.get("USERID"), "");
			model.addAttribute("userName", userName);
			model.addAttribute("userID", userID);
			model.addAttribute("grade", grade);
		}
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		String wrtType = CommonUtil.isNull(request.getParameter("wrtType"), "");
		params.put("IDX", idx);
		String brd_name = "CD_NOTICE";

		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		params.put("BRDNAME", brd_name);
		
		noticeService.noticeListReadUpdate(params);
		
		file = noticeService.noticeFileList(params);
		String fileName = "";
		String virtualFilePath = "Files/" + brd_name + "/Images/";
		StringBuilder returnMessage = new StringBuilder("");

		if(!file.isEmpty())
		{
			for(int i=0; i<file.size(); i++)
			{
				fileName = file.get(i).get("FILENAME").toString();
				if(fileName.substring(fileName.length()-3).equals("jpg") || fileName.substring(fileName.length()-3).equals("gif") || fileName.substring(fileName.length()-3).equals("bmp") || fileName.substring(fileName.length()-3).equals("png") || fileName.substring(fileName.length()-4).equals("jpeg"))
				{
					//returnMessage.append("<p class='txt_cnt'><img src='/ZIANEDU/coding/resources" + virtualFilePath + fileName + "' width='600px'  /><p/><br />"); //운영 루트
					returnMessage.append("<p class='txt_cnt'><img src='/resources/" + virtualFilePath + fileName + "' width='600px'  /><p/><br />"); //개발 루트
				}
			}
		}

		list = noticeService.noticeListOne(params);
		
		String html = CommonUtil.isNull(String.valueOf(list.get(0).get("CONTENT")));
		html = html.replaceAll("&nbsp;", " ");
		html = html.replaceAll("&amp;nbsp;", " ");
		html = html.replaceAll("&quot;", "\"");
		html = html.replaceAll("&amp;quot;", "\"");
		html = html.replaceAll("&gt;", ">");
		html = html.replaceAll("&lt;", "<");
		html = html.replaceAll("&amp;gt;", ">");
		html = html.replaceAll("&amp;lt;", "<");
		

		String nIdx = list.get(0).get("NEXT_IDX").toString();
		params.put("NIDX", nIdx);
		List<HashMap<String, Object>> nList = noticeService.noticeListOneNext(params);
		
		String pIdx = list.get(0).get("PRE_IDX").toString();
		params.put("PIDX", pIdx);
		List<HashMap<String, Object>> pList = noticeService.noticeListOnePrev(params);

		model.addAttribute("list", list);
		model.addAttribute("CONTENT", html);
		model.addAttribute("nList", nList);
		model.addAttribute("pList", pList);
		model.addAttribute("wrtType", wrtType);
		model.addAttribute("file",file);
		model.addAttribute("returnMessage", returnMessage);

		return "/notice/noticeView";
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 write
	 */
	@RequestMapping(value = "/noticeWrite.do")
	public String noticeWrite(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		List<HashMap<String, Object>> file = null;

		String userName = "";
		String grade = "";
		String email = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			grade = CommonUtil.isNull(sessionMap.get("GRADE"), "");
			email = CommonUtil.isNull(sessionMap.get("USERID"), "");
			model.addAttribute("userName", userName);
			model.addAttribute("grade", grade);
			model.addAttribute("email", email);
		}

		String brd_name =  "CD_NOTICE";
		String wrtType = CommonUtil.isNull(request.getParameter("wrtType"), "");
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		
		params.put("BRDNAME",brd_name);
		params.put("IDX", idx);

		if(wrtType.equals("u"))
		{
			list = noticeService.noticeListOne(params);
			file = noticeService.noticeFileList(params);
		}

		model.addAttribute("list", list);
		model.addAttribute("file", file);
		model.addAttribute("wrtType", wrtType);

		return "/notice/noticeWrite";
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 update
	 */
	@RequestMapping(value = "/noticeUpdate.do")
	public String noticeUpdate(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		
		String userName = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			model.addAttribute("userName", userName);
		}
		
		String returnUrl = "";
		String MESSAGE;
		String rootPath = fsResource.getPath();
		String subPath = "CD_NOTICE/Images/";
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		
		params.put("SUBJECT", CommonUtil.isNull(request.getParameter("txtSubject"), ""));
		params.put("WRITENAME", CommonUtil.isNull(request.getParameter("memberName"), ""));
		params.put("EMAIL", CommonUtil.isNull(request.getParameter("txtEmail"), ""));
		params.put("CONTENT", CommonUtil.isNull(request.getParameter("Contents"), ""));
		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));

		boolean booltf = false;

		List<MultipartFile> uploadFileList = multiRequest.getFiles("uploadFile");
		booltf = CommonUtil.ValidUploadFileExtension(uploadFileList);

		if(!uploadFileList.isEmpty())
		{
			if(booltf == true) {
				List<HashMap<String, Object>> fileInfoList = fileUtil.uploadFiles(uploadFileList, rootPath, subPath);
				for(int i=0; i<fileInfoList.size(); i++){
					String file_path =  String.valueOf(fileInfoList.get(i).get("fileFullPath"));
					String real_name =  String.valueOf(fileInfoList.get(i).get("fileName"));//원본파일이름
					String file_name =  String.valueOf(fileInfoList.get(i).get("newFileName"));//변경파일이름
					String file_size =  String.valueOf(fileInfoList.get(i).get("fileSize"));
					String brd_name =  "CD_NOTICE";
					
					params.put("BRDNAME",brd_name);
					params.put("FILE_PATH",file_path);
					params.put("FILENAME",file_name);//변경파일이름
					params.put("INXNAME",real_name);//원본파일이름
					params.put("FILESIZE",file_size);
					params.put("IDX", idx);
	
					noticeService.noticeFileInsert(params);
				}
			}else{
				MESSAGE = "등록할 수 없는 확장자 입니다.";
				returnUrl = "/notice/noticeView.do?idx=" + idx + "&wrtType=" + "w";
				model.addAttribute("MESSAGE", MESSAGE);
				model.addAttribute("URL", returnUrl);
				
				return "login/message";
			}
		}

		noticeService.noticeUpdate(params);
		
		return "redirect:/notice/noticeView.do?idx=" + idx;
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 insert
	 */
	@RequestMapping(value = "/noticeInsert.do")
	public String noticeInsert(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		
		String userName = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			model.addAttribute("userName", userName);
		}
		
		String returnUrl = "";
		String MESSAGE;

		params.put("SUBJECT", CommonUtil.isNull(request.getParameter("txtSubject"), ""));
		String content = CommonUtil.isNull(request.getParameter("Contents"), "");
		content = content.replaceAll(" ","&nbsp;");
		content = content.replaceAll(" " ,"&amp;nbsp;");
		content = content.replaceAll("\"","&quot;");
		content = content.replaceAll("\"","&amp;quot;");
		content = content.replaceAll(">","&gt;");
		content = content.replaceAll("<","&lt;");
		content = content.replaceAll(">","&amp;gt;");
		content = content.replaceAll("<","&amp;lt;");
		
		
		params.put("CONTENT", content);
		params.put("WRITENAME", CommonUtil.isNull(request.getParameter("memberName"), ""));
		params.put("EMAIL", CommonUtil.isNull(request.getParameter("txtEmail"), ""));
		
		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		String rootPath = fsResource.getPath();
		String subPath = "CD_NOTICE/Images/";

		noticeService.noticeInsert(params);
		int idx = noticeService.noticeReturnOne();

		boolean booltf = false;

		List<MultipartFile> uploadFileList = multiRequest.getFiles("uploadFile");
		booltf = CommonUtil.ValidUploadFileExtension(uploadFileList);
		
		
		
		if(!uploadFileList.isEmpty())
		{
			if(booltf == true) {
				List<HashMap<String, Object>> fileInfoList = fileUtil.uploadFiles(uploadFileList, rootPath, subPath);
				
				for(int i=0; i<fileInfoList.size(); i++){
					
			
					
					
					
					String file_path =  String.valueOf(fileInfoList.get(i).get("fileFullPath"));
					String real_name =  String.valueOf(fileInfoList.get(i).get("fileName"));//원본파일이름
					String file_name =  String.valueOf(fileInfoList.get(i).get("newFileName"));//변경파일이름
					String file_size =  String.valueOf(fileInfoList.get(i).get("fileSize"));
					String brd_name =  "CD_NOTICE";
					
					params.put("BRDNAME",brd_name);
					params.put("FILE_PATH",file_path);
					params.put("FILENAME",file_name);//변경파일이름
					params.put("INXNAME",real_name);//원본파일이름
					params.put("FILESIZE",file_size);
					params.put("IDX", idx);
	
					noticeService.noticeFileInsert(params);
				}
			}else{
				MESSAGE = "등록할 수 없는 확장자 입니다.";
				returnUrl = "/notice/noticeView.do?idx=" + idx;
				model.addAttribute("MESSAGE", MESSAGE);
				model.addAttribute("URL", returnUrl);
				
				return "login/message";
			}
		}
		
		return "redirect:/notice/noticeView.do?idx=" + idx;
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 delete
	 */
	@RequestMapping(value="/noticeDelete.do")
	public String noticeDelete(ModelMap model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> params = new HashMap<String, Object>();

		String brd_name = "CD_NOTICE";

		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		params.put("BRDNAME", brd_name);
		
		noticeService.noticeDelete(params);
		noticeService.noticeFileDelete(params);
		
		return "redirect:/notice/noticeList.do";
	}

	@RequestMapping(value="/noticeFileDelete.do")
	public String noticeFileDelete(ModelMap model, HttpServletRequest request) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		params.put("NUM", CommonUtil.isNull(request.getParameter("num"), ""));
		
		noticeService.noticeFileOneDelete(params);
		
		return "redirect:/notice/noticeView.do?idx=" + idx;
	}
	

	/*----------------------------------------mobile controller----------------------------------------*/
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 Mobilelist
	 */
	@RequestMapping(value = "/noticeListM.do")
	public String noticeMList(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = "";
		String grade = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			grade = CommonUtil.isNull(sessionMap.get("GRADE"), "");
			model.addAttribute("userName", userName);
			model.addAttribute("grade", grade);
		}
		
		List<HashMap<String, Object>> list = null;
		// 검색조건
		String SEARCHTYPE = CommonUtil.isNull(request.getParameter("SEARCHTYPE"), "");
		String SEARCHKEYWORD = CommonUtil.isNull(request.getParameter("SEARCHKEYWORD"), "");
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String sToday = sdf.format(today);  
		
		String sdate = CommonUtil.isNull(request.getParameter("sdate"), sToday);
		String edate = CommonUtil.isNull(request.getParameter("edate"), sToday);
		String sdatet = sdate; 
		String edatet = edate;
		
		int currentPage = Integer.parseInt(CommonUtil.isNull(request.getParameter("currentPage"), "1"));
		int pageRow = Integer.parseInt(CommonUtil.isNull(request.getParameter("pageRow"), "15"));
		
		int startNo = (currentPage - 1) * pageRow;
		int endNo = startNo + pageRow;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("SEARCHTYPE", SEARCHTYPE);
		params.put("SEARCHKEYWORD", URLDecoder.decode(SEARCHKEYWORD,"UTF-8"));
		
		params.put("currentPage", currentPage);
		params.put("pageRow", pageRow);
		params.put("startNo", String.valueOf(startNo));
		params.put("endNo", String.valueOf(endNo));
		
		// 총 건수 -회원
		int listCount = noticeService.noticeListCount(params);
		
		// 공지사항 리스트
		list = noticeService.noticeList(params);
		
		String pagingHtml = new PagingM(currentPage, listCount, pageRow).getPagingHtml().toString();
		
		model.addAttribute("list", list);
		model.addAttribute("params", params);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("totalCount", listCount);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageRow", pageRow);
		model.addAttribute("SEARCHTYPE", SEARCHTYPE);
		model.addAttribute("SEARCHKEYWORD", SEARCHKEYWORD);
		model.addAttribute("totalPage", (int) Math.ceil((double) listCount / pageRow));
		
		return "/mobile/notice/noticeM";
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 Mobileview
	 */
	@RequestMapping(value = "/noticeViewM.do")
	public String noticeViewM(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		List<HashMap<String, Object>> file = null;
		
		String userName = "";
		String grade = "";
		String userID = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			grade = CommonUtil.isNull(sessionMap.get("GRADE"), "");
			userID = CommonUtil.isNull(sessionMap.get("USERID"), "");
			model.addAttribute("userName", userName);
			model.addAttribute("userID", userID);
			model.addAttribute("grade", grade);
		}
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		String wrtType = CommonUtil.isNull(request.getParameter("wrtType"), "");
		params.put("IDX", idx);
		String brd_name = "CD_NOTICE";
		
		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		params.put("BRDNAME", brd_name);
		
		noticeService.noticeListReadUpdate(params);
		
		file = noticeService.noticeFileList(params);
		String fileName = "";
		String virtualFilePath = "/Files/" + brd_name + "/Images/";
		StringBuilder returnMessage = new StringBuilder("");
		
		if(!file.isEmpty())
		{
			for(int i=0; i<file.size(); i++)
			{
				fileName = file.get(i).get("FILENAME").toString();
				if(fileName.substring(fileName.length()-3).equals("jpg") || fileName.substring(fileName.length()-3).equals("gif") || fileName.substring(fileName.length()-3).equals("bmp") || fileName.substring(fileName.length()-3).equals("png") || fileName.substring(fileName.length()-4).equals("jpeg"))
				{
//					returnMessage.append("<p class='txt_cnt'><img src='/ZIANEDU/coding/resources" + virtualFilePath + fileName + "' width='600px'  /><p/><br />"); //운영 루트
					returnMessage.append("<p class='txt_cnt'><img src='/resources" + virtualFilePath + fileName + "' width='600px'  /><p/><br />"); //개발 루트
				}
			}
		}
		
		list = noticeService.noticeListOne(params);
		
		String html = CommonUtil.isNull((String)list.get(0).get("CONTENT"));
		html = html.replaceAll("&nbsp;", " ");
		html = html.replaceAll("&amp;nbsp;", " ");
		html = html.replaceAll("&quot;", "\"");
		html = html.replaceAll("&amp;quot;", "\"");
		html = html.replaceAll("&gt;", ">");
		html = html.replaceAll("&lt;", "<");
		html = html.replaceAll("&amp;gt;", ">");
		html = html.replaceAll("&amp;lt;", "<");
		
		String nIdx = list.get(0).get("NEXT_IDX").toString();
		params.put("NIDX", nIdx);
		List<HashMap<String, Object>> nList = noticeService.noticeListOneNext(params);
		
		String pIdx = list.get(0).get("PRE_IDX").toString();
		params.put("PIDX", pIdx);
		List<HashMap<String, Object>> pList = noticeService.noticeListOnePrev(params);
		
		model.addAttribute("list", list);
		model.addAttribute("CONTENT", html);
		model.addAttribute("nList", nList);
		model.addAttribute("pList", pList);
		model.addAttribute("wrtType", wrtType);
		model.addAttribute("returnMessage", returnMessage);
		
		return "/mobile/notice/noticeViewM";
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 write
	 */
	@RequestMapping(value = "/noticeWriteM.do")
	public String noticeWriteM(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		List<HashMap<String, Object>> file = null;
		
		String userName = "";
		String grade = "";
		String email = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			grade = CommonUtil.isNull(sessionMap.get("GRADE"), "");
			email = CommonUtil.isNull(sessionMap.get("USERID"), "");
			model.addAttribute("userName", userName);
			model.addAttribute("grade", grade);
			model.addAttribute("email", email);
		}
		
		String brd_name =  "CD_NOTICE";
		String wrtType = CommonUtil.isNull(request.getParameter("wrtType"), "");
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		
		params.put("BRDNAME",brd_name);
		params.put("IDX", idx);
		
		if(wrtType.equals("u"))
		{
			list = noticeService.noticeListOne(params);
			file = noticeService.noticeFileList(params);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("file", file);
		model.addAttribute("wrtType", wrtType);
		
		return "/mobile/notice/noticeWriteM";
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 Mobileupdate
	 */
	@RequestMapping(value = "/noticeUpdateM.do")
	public String noticeUpdateM(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		
		String userName = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			model.addAttribute("userName", userName);
		}
		
		String returnUrl = "";
		String MESSAGE;
		String rootPath = fsResource.getPath();
		String subPath = "CD_NOTICE/Images/";
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		
		params.put("SUBJECT", CommonUtil.isNull(request.getParameter("txtSubject"), ""));
		params.put("WRITENAME", CommonUtil.isNull(request.getParameter("memberName"), ""));
		params.put("EMAIL", CommonUtil.isNull(request.getParameter("txtEmail"), ""));
		params.put("CONTENT", CommonUtil.isNull(request.getParameter("Contents"), ""));
		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		
		boolean booltf = false;
		
		List<MultipartFile> uploadFileList = multiRequest.getFiles("uploadFile");
		booltf = CommonUtil.ValidUploadFileExtension(uploadFileList);
		
		if(!uploadFileList.isEmpty())
		{
			if(booltf == true) {
				List<HashMap<String, Object>> fileInfoList = fileUtil.uploadFiles(uploadFileList, rootPath, subPath);
				for(int i=0; i<fileInfoList.size(); i++){
					String file_path =  String.valueOf(fileInfoList.get(i).get("fileFullPath"));
					String real_name =  String.valueOf(fileInfoList.get(i).get("fileName"));//원본파일이름
					String file_name =  String.valueOf(fileInfoList.get(i).get("newFileName"));//변경파일이름
					String file_size =  String.valueOf(fileInfoList.get(i).get("fileSize"));
					String brd_name =  "CD_NOTICE";
					
					params.put("BRDNAME",brd_name);
					params.put("FILE_PATH",file_path);
					params.put("FILENAME",file_name);//변경파일이름
					params.put("INXNAME",real_name);//원본파일이름
					params.put("FILESIZE",file_size);
					params.put("IDX", idx);
					
					noticeService.noticeFileInsert(params);
				}
			}else{
				MESSAGE = "등록할 수 없는 확장자 입니다.";
				returnUrl = "/notice/noticeViewM.do?idx=" + idx + "&wrtType=" + "w";
				model.addAttribute("MESSAGE", MESSAGE);
				model.addAttribute("URL", returnUrl);
				
				return "/mobile/login/messageM";
			}
		}
		
		noticeService.noticeUpdate(params);
		
		return "redirect:/notice/noticeViewM.do?idx=" + idx;
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 Mobileinsert
	 */
	@RequestMapping(value = "/noticeInsertM.do")
	public String noticeInsertM(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;
		
		String userName = "";
		if(sessionMap != null)
		{
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			model.addAttribute("userName", userName);
		}
		
		String returnUrl = "";
		String MESSAGE;
		
		params.put("SUBJECT", CommonUtil.isNull(request.getParameter("txtSubject"), ""));
		String content = CommonUtil.isNull(request.getParameter("Contents"), "");
		content = content.replaceAll("&nbsp;", " ");
		content = content.replaceAll("&amp;nbsp;", " ");
		content = content.replaceAll("&quot;", "\"");
		content = content.replaceAll("&amp;quot;", "\"");
		content = content.replaceAll("&gt;", ">");
		content = content.replaceAll("&lt;", "<");
		content = content.replaceAll("&amp;gt;", ">");
		content = content.replaceAll("&amp;lt;", "<");
		params.put("CONTENT", content);
		params.put("WRITENAME", CommonUtil.isNull(request.getParameter("memberName"), ""));
		params.put("EMAIL", CommonUtil.isNull(request.getParameter("txtEmail"), ""));
		
		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		String rootPath = fsResource.getPath();
		String subPath = "CD_NOTICE/Images/";
		
		noticeService.noticeInsert(params);
		int idx = noticeService.noticeReturnOne();
		
		boolean booltf = false;
		
		List<MultipartFile> uploadFileList = multiRequest.getFiles("uploadFile");
		booltf = CommonUtil.ValidUploadFileExtension(uploadFileList);
		
		if(!uploadFileList.isEmpty())
		{
			if(booltf == true) {
				List<HashMap<String, Object>> fileInfoList = fileUtil.uploadFiles(uploadFileList, rootPath, subPath);
				for(int i=0; i<fileInfoList.size(); i++){
					String file_path =  String.valueOf(fileInfoList.get(i).get("fileFullPath"));
					String real_name =  String.valueOf(fileInfoList.get(i).get("fileName"));//원본파일이름
					String file_name =  String.valueOf(fileInfoList.get(i).get("newFileName"));//변경파일이름
					String file_size =  String.valueOf(fileInfoList.get(i).get("fileSize"));
					String brd_name =  "CD_NOTICE";
					
					params.put("BRDNAME",brd_name);
					params.put("FILE_PATH",file_path);
					params.put("FILENAME",file_name);//변경파일이름
					params.put("INXNAME",real_name);//원본파일이름
					params.put("FILESIZE",file_size);
					params.put("IDX", idx);
					
					noticeService.noticeFileInsert(params);
				}
			}else{
				MESSAGE = "등록할 수 없는 확장자 입니다.";
				returnUrl = "/notice/noticeViewM.do?idx=" + idx;
				model.addAttribute("MESSAGE", MESSAGE);
				model.addAttribute("URL", returnUrl);
				
				return "/login/messageM";
			}
		}
		
		return "redirect:/notice/noticeViewM.do?idx=" + idx;
	}
	
	/**
	 * @FileName   : noticeController.java
	 * @Project    : coding
	 * @Date       : 2018.07.17
	 * @Author     : 
	 * @변경이력    :
	 * @프로그램 설명 : 코딩플러스 공지사항 delete
	 */
	@RequestMapping(value="/noticeDeleteM.do")
	public String noticeDeleteM(ModelMap model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String brd_name = "CD_NOTICE";
		
		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		params.put("BRDNAME", brd_name);
		
		noticeService.noticeDelete(params);
		noticeService.noticeFileDelete(params);
		
		return "redirect:/notice/noticeListM.do";
	}
	
	@RequestMapping(value="/noticeFileDeleteM.do")
	public String noticeFileDeleteM(ModelMap model, HttpServletRequest request) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String idx = CommonUtil.isNull(request.getParameter("idx"), "");
		params.put("NUM", CommonUtil.isNull(request.getParameter("num"), ""));
		
		noticeService.noticeFileOneDelete(params);
		
		return "redirect:/notice/noticeViewM.do?idx=" + idx;
	}
	
	@RequestMapping(value = "/noticeDownload.do")
	public ModelAndView noticeDownload(HttpServletRequest request) throws Exception {
		String path=request.getParameter("path");
		int fileNo=Integer.parseInt(request.getParameter("fno"));
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
}
