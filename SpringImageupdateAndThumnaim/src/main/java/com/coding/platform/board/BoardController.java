package com.coding.platform.board;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coding.domain.BoardFile;
import com.coding.platform.board.service.BoardService;
import com.coding.platform.util.CommonUtil;
import com.coding.platform.util.file.FileUtil;
import com.coding.platform.util.paging.Paging;

@RequestMapping(value="/board")
@Controller
public class BoardController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private FileSystemResource fsResource;	//DI

	@Resource(name="fileUtil")
	FileUtil fileUtil;

	
	@Autowired
	private BoardService boardService;	
	
		/**
		 * @Method Name : boardList
		 * @작성일 : 2013. 10
		 * @Method 설명 : 공지사항 게시판 리스트
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardList.pop")
		public String boardList(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, String> params = new HashMap<String, String>();
			
			int currentPage = Integer.parseInt(CommonUtil.isNull(request.getParameter("currentPage"), "1"));
			int pageRow = Integer.parseInt(CommonUtil.isNull(request.getParameter("pageRow"), "15"));
			
			int startNo = (currentPage - 1) * pageRow;
			int endNo = startNo + pageRow;
			
			params.put("startNo", String.valueOf(startNo));
			params.put("endNo", String.valueOf(endNo));
			
			params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
			
//			if(request.getParameter("BOARD_MNG_SEQ") == null && request.getParameter("BOARD_MNG_SEQ").equals("") &&request.getParameter("BOARD_MNG_SEQ")==null){
//				//파라미터의 게시판 정보
//				HashMap<String, String> boardInfoMap = boardService.getBoardKind(params);
//				params.put("BOARD_MNG_NAME",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_NAME"), ""));
//				params.put("BOARD_MNG_TYPE",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_TYPE"), ""));
//				params.put("ATTACH_FILE_YN",CommonUtil.isNull(boardInfoMap.get("ATTACH_FILE_YN"), ""));
//				params.put("OPEN_YN",CommonUtil.isNull(boardInfoMap.get("OPEN_YN"), ""));
//				params.put("REPLY_YN",CommonUtil.isNull(boardInfoMap.get("REPLY_YN"), ""));
//				params.put("ONOFF_DIV",CommonUtil.isNull(boardInfoMap.get("ONOFF_DIV"), ""));
//			
//			}else{
//				HashMap<String, String> boardInfoMap2 = boardService.getBoardKind(params);
//				params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), boardInfoMap2.get("BOARD_MNG_NAME")));
//				params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), boardInfoMap2.get("BOARD_MNG_TYPE")));
//				params.put("ATTACH_FILE_YN",CommonUtil.isNull(boardInfoMap2.get("ATTACH_FILE_YN"), ""));
//				params.put("OPEN_YN",CommonUtil.isNull(boardInfoMap2.get("OPEN_YN"), ""));
//				params.put("REPLY_YN",CommonUtil.isNull(boardInfoMap2.get("REPLY_YN"), ""));
//				params.put("ONOFF_DIV",CommonUtil.isNull(boardInfoMap2.get("ONOFF_DIV"), ""));
//			}
			
			HashMap<String, String> boardInfoMap = boardService.getBoardKind(params);
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_NAME"), ""));
			params.put("BOARD_MNG_TYPE",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_TYPE"), ""));
			params.put("ATTACH_FILE_YN",CommonUtil.isNull(boardInfoMap.get("ATTACH_FILE_YN"), ""));
			params.put("OPEN_YN",CommonUtil.isNull(boardInfoMap.get("OPEN_YN"), ""));
			params.put("REPLY_YN",CommonUtil.isNull(boardInfoMap.get("REPLY_YN"), ""));
			params.put("ONOFF_DIV",CommonUtil.isNull(boardInfoMap.get("ONOFF_DIV"), ""));
			
			//동적셀렉트 박스 구성을 위한 직급 리스트 가져오기
			List<HashMap<String, String>> rankList = boardService.getRankCode(params);
			
			
			logger.info("===== : " + request.getParameter("SEARCHCATEGORY"));
			//params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), rankList.get(0).get("CODE")));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), "SEARCHSUBJECT"));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));
			params.put("BOARD_TYPE", "1");
			//해당 게시판 글 리스트
			List<HashMap<String, String>> list = boardService.boardList(params);
			int listCount = boardService.listCount(params);
			
			String pagingHtml = new Paging(currentPage, listCount, pageRow).getPagingHtml().toString();
			
			model.addAttribute("rankList", rankList);
			model.addAttribute("list", list);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("totalCount", listCount);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("pageRow", pageRow);
			model.addAttribute("params", params);
			model.addAttribute("totalPage", (int) Math.ceil((double) listCount / pageRow));
			logger.info("게시판 리스트 : " + list);

			return "board/boardList";
		}		
		/**
		 * @Method Name : boardList
		 * @작성일 : 2013. 10
		 * @Method 설명 : FAQ 리스트
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardFAQList.pop")
		public String boardFAQList(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, String> params = new HashMap<String, String>();
			
			int currentPage = Integer.parseInt(CommonUtil.isNull(request.getParameter("currentPage"), "1"));
			int pageRow = Integer.parseInt(CommonUtil.isNull(request.getParameter("pageRow"), "15"));
			
			int startNo = (currentPage - 1) * pageRow;
			int endNo = startNo + pageRow;
			
			params.put("startNo", String.valueOf(startNo));
			params.put("endNo", String.valueOf(endNo));
			
			params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
			
//			if(request.getParameter("BOARD_MNG_SEQ") == null && request.getParameter("BOARD_MNG_SEQ")=="" &&request.getParameter("BOARD_MNG_SEQ")==null){
//				//파라미터의 게시판 정보
//				HashMap<String, String> boardInfoMap = boardService.getBoardKind(params);
//				params.put("BOARD_MNG_NAME",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_NAME"), "모의고사 공고"));
//				params.put("BOARD_MNG_TYPE",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_TYPE"), "TESTNOTICE"));
//				params.put("ATTACH_FILE_YN",CommonUtil.isNull(boardInfoMap.get("ATTACH_FILE_YN"), ""));
//				params.put("OPEN_YN",CommonUtil.isNull(boardInfoMap.get("OPEN_YN"), ""));
//				params.put("REPLY_YN",CommonUtil.isNull(boardInfoMap.get("REPLY_YN"), ""));
//				params.put("ONOFF_DIV",CommonUtil.isNull(boardInfoMap.get("ONOFF_DIV"), ""));
//				
//			}else{
//				HashMap<String, String> boardInfoMap2 = boardService.getBoardKind(params);
//				params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), boardInfoMap2.get("BOARD_MNG_NAME")));
//				params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), boardInfoMap2.get("BOARD_MNG_TYPE")));
//				params.put("ATTACH_FILE_YN",CommonUtil.isNull(boardInfoMap2.get("ATTACH_FILE_YN"), ""));
//				params.put("OPEN_YN",CommonUtil.isNull(boardInfoMap2.get("OPEN_YN"), ""));
//				params.put("REPLY_YN",CommonUtil.isNull(boardInfoMap2.get("REPLY_YN"), ""));
//				params.put("ONOFF_DIV",CommonUtil.isNull(boardInfoMap2.get("ONOFF_DIV"), ""));
//			}

			//파라미터의 게시판 정보
			HashMap<String, String> boardInfoMap = boardService.getBoardKind(params);
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_NAME"), "모의고사 공고"));
			params.put("BOARD_MNG_TYPE",CommonUtil.isNull(boardInfoMap.get("BOARD_MNG_TYPE"), "TESTNOTICE"));
			params.put("ATTACH_FILE_YN",CommonUtil.isNull(boardInfoMap.get("ATTACH_FILE_YN"), ""));
			params.put("OPEN_YN",CommonUtil.isNull(boardInfoMap.get("OPEN_YN"), ""));
			params.put("REPLY_YN",CommonUtil.isNull(boardInfoMap.get("REPLY_YN"), ""));
			params.put("ONOFF_DIV",CommonUtil.isNull(boardInfoMap.get("ONOFF_DIV"), ""));

			//동적셀렉트 박스 구성을 위한 직급 리스트 가져오기
			List<HashMap<String, String>> rankList = boardService.getRankCode(params);
			
			
			logger.info("===== : " + request.getParameter("SEARCHCATEGORY"));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), rankList.get(0).get("CODE")));
			params.put("SEARCHCATEGORY2",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY2"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), "SEARCHSUBJECT"));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));
			
			//해당 게시판 글 리스트
			List<HashMap<String, String>> list = boardService.boardFAQList(params);
			int listCount = boardService.boardFAQListCount(params);
			
			String pagingHtml = new Paging(currentPage, listCount, pageRow).getPagingHtml().toString();
			
			model.addAttribute("rankList", rankList);
			model.addAttribute("list", list);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("totalCount", listCount);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("pageRow", pageRow);
			model.addAttribute("params", params);
			model.addAttribute("totalPage", (int) Math.ceil((double) listCount / pageRow));
			logger.info("boardFAQList 리스트 : " + list);
			
			return "board/boardFAQList";
		}		
	
	/**
	 * @Method Name : offExamView
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 등록화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardWrite.pop")
	public String boardWrite(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		String boardMngSeq = CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), "");
		params.put("BOARD_MNG_SEQ",boardMngSeq);
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",request.getParameter("BOARD_MNG_NAME"));
		params.put("NOTICE_TOP_YN",CommonUtil.isNull(request.getParameter("NOTICE_TOP_YN"), ""));
		params.put("OPEN_YN",CommonUtil.isNull(String.valueOf(request.getParameter("OPEN_YN")), ""));
		params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));		
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USER_NM");
		String userId = sessionMap.get("USER_ID");
		
		if(boardMngSeq != "NOTICE_002") {
			params.put("USERNAME", userName);
			params.put("REG_ID", userId);
		}
		else {
			params.put("USERNAME", "");
			params.put("REG_ID", "");
		}
		params.put("UPD_ID", userId);
		
		List<HashMap<String, String>> list = boardService.getRankCode(params);
		// 게시판타입가져오기
		//HashMap<String, String> boardKind = boardService.getBoardKind(params);
		
		//FAQ 분류 코드 조회
		List<HashMap<String, String>> categoryList = boardService.getFaqCategoryCode(params);
		
		List<HashMap<String, String>> teacherList = new ArrayList<HashMap<String, String>>();
		
		model.addAttribute("params",params);
		model.addAttribute("gbList",list);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("teacherList", teacherList);
		
 		return "/board/boardWrite";
	}
	/**
	 * @Method Name : boardFAQWrite
	 * @작성일 : 2013. 11. 
	 * @Method 설명 : FAQ 등록화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardFAQWrite.pop")
	public String boardFAQWrite(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",request.getParameter("BOARD_MNG_NAME"));
		params.put("NOTICE_TOP_YN",CommonUtil.isNull(request.getParameter("NOTICE_TOP_YN"), ""));
		params.put("OPEN_YN",CommonUtil.isNull(String.valueOf(request.getParameter("OPEN_YN")), ""));
		params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));		
		
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USER_NM");
		String userId = sessionMap.get("USER_ID");
		params.put("USERNAME", userName);
		params.put("REG_ID", userId);
		params.put("UPD_ID", userId);
		
		List<HashMap<String, String>> list = boardService.getRankCode(params);
		// 게시판타입가져오기
		//HashMap<String, String> boardKind = boardService.getBoardKind(params);
		
		//FAQ 분류 코드 조회
		List<HashMap<String, String>> categoryList = boardService.getFaqCategoryCode(params);
		
		model.addAttribute("params",params);
		model.addAttribute("gbList",list);
		model.addAttribute("categoryList",categoryList);
		
		return "/board/boardFAQWrite";
	}
	
	/**
	 * @Method Name : boardInsertProcess
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 등록프로세스
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardInsertProcess.pop")
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public String boardInsertProcess(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, Object> params = new  HashMap<String, Object>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",request.getParameter("BOARD_MNG_NAME"));
		params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		
		//params.put("codeStr",request.getParameter("codeStr"));		
		params.put("CREATENAME",request.getParameter("CREATENAME"));		
		params.put("REG_ID",request.getParameter("REG_ID"));	
		
		params.put("NOTICE_TOP_YN",CommonUtil.isNull(request.getParameter("NOTICE_TOP_YN"), ""));	
		params.put("OPEN_YN",CommonUtil.isNull(request.getParameter("OPEN_YN"), ""));	
		params.put("ISSUE",CommonUtil.isNull(request.getParameter("ISSUE"), ""));	
		params.put("RECOMMEND",CommonUtil.isNull(request.getParameter("RECOMMEND"), ""));	
		
		params.put("SUBJECT",request.getParameter("SUBJECT"));		
		params.put("CONTENT",request.getParameter("CONTENT"));	
		
		params.put("HITS",CommonUtil.isNull(request.getParameter("HITS"), "0"));	
		
		//FAQ분류
		params.put("CATEGORY_CODE",CommonUtil.isNull(request.getParameter("FAQ_CATEGORY_CODE"), ""));	
				
		//정렬 번호
		params.put("SORT_NO",CommonUtil.isNull(request.getParameter("SORT_NO"), ""));	
		
		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));	
		
		params.put("boardFiles", CommonUtil.createFiles(fsResource, multiRequest, fileUtil, "uploadFile", request.getParameter("REG_ID"), 1, 0, 0));
		Object BOARD_SEQ = boardService.boardInsertProcess(params);
		System.out.println(BOARD_SEQ);
		logger.info("--------"+ params);
		//게시판에서 선택한 직급 구분 codeStr 배열화
		String [] code_arr = request.getParameter("codeStr").split("/");
		HashMap<String, Object> boardTestClassMap = new HashMap<String, Object>();
		for (int i = 0; i < code_arr.length; i++) {
			boardTestClassMap.put("BOARD_MNG_SEQ", params.get("BOARD_MNG_SEQ"));
			boardTestClassMap.put("BOARD_SEQ", params.get("BOARD_SEQ"));
			boardTestClassMap.put("CATEGORY_CODE", code_arr[i]);
			boardService.insertBoardCatInfo(boardTestClassMap);
		}
		
		
		model.addAttribute("params", params);
		System.out.println(params.get("BOARD_MNG_SEQ"));
		return "forward:/board/boardList.pop?BOARD_MNG_SEQ="+params.get("BOARD_MNG_SEQ");
	}
	/**
	 * @Method Name : boardFAQInsertProcess
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 등록프로세스
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardFAQInsertProcess.pop")
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public String boardFAQInsertProcess(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, Object> params = new  HashMap<String, Object>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",request.getParameter("BOARD_MNG_NAME"));
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		
		//params.put("codeStr",request.getParameter("codeStr"));		
		params.put("CREATENAME",request.getParameter("CREATENAME"));		
		params.put("REG_ID",request.getParameter("REG_ID"));	
		
		params.put("NOTICE_TOP_YN",CommonUtil.isNull(request.getParameter("NOTICE_TOP_YN"), ""));	
		params.put("OPEN_YN",CommonUtil.isNull(request.getParameter("OPEN_YN"), ""));	
		
		params.put("SUBJECT",CommonUtil.isNull(request.getParameter("SUBJECT"), ""));	
		params.put("ANSWER",CommonUtil.isNull(request.getParameter("ANSWER"), ""));	
		
		//FAQ분류
		params.put("CATEGORY_CODE",CommonUtil.isNull(request.getParameter("FAQ_CATEGORY_CODE"), ""));	
		
		//정렬 번호
		params.put("SORT_NO",CommonUtil.isNull(request.getParameter("SORT_NO"), ""));	
		
		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));	
		
		String rootPath = fsResource.getPath();
		String subPath = "100/bbs/";
		
		MultipartFile uploadFile = multiRequest.getFile("uploadFile");
		if(uploadFile != null && uploadFile.isEmpty() == false) {
			HashMap<String, Object> fileMap = fileUtil.uploadFile(uploadFile, rootPath, subPath);
			String file_path =  String.valueOf(fileMap.get("fileFullPath"));
			String file_name =  String.valueOf(fileMap.get("fileName"));
			
			params.put("FILE_PATH",file_path );
			params.put("FILE_NAME",file_name );
			params.put("REAL_FILE_NAME",uploadFile.getOriginalFilename().toString() );
		}else{
			params.put("FILE_PATH","" );
			params.put("FILE_NAME","" );
			params.put("REAL_FILE_NAME","");
		}
		Object BOARD_SEQ = boardService.boardFAQInsertProcess(params);
		
		logger.info("--------"+ params);
		//게시판에서 선택한 직급 구분 codeStr 배열화
		String [] code_arr = request.getParameter("codeStr").split("/");
		HashMap<String, Object> boardTestClassMap = new HashMap<String, Object>();
		for (int i = 0; i < code_arr.length; i++) {
			boardTestClassMap.put("BOARD_MNG_SEQ", params.get("BOARD_MNG_SEQ"));
			boardTestClassMap.put("BOARD_SEQ", params.get("BOARD_SEQ"));
			boardTestClassMap.put("CATEGORY_CODE", code_arr[i]);
			boardService.insertBoardCatInfo(boardTestClassMap);
		}
		
		
		model.addAttribute("params", params);
		return "redirect:/board/boardFAQList.pop?BOARD_MNG_SEQ="+params.get("BOARD_MNG_SEQ");
	}
	
	/**
	 * @Method Name : boardView
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 보기 화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardView.pop")
	public String boardView(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
		
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));		
		
		params.put("BOARDVIEW_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEW_SEQ"), ""));
		params.put("BOARDVIEWPARENT_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEWPARENT_SEQ"), ""));
		params.put("BOARDVIEWCODENAME",CommonUtil.isNull(request.getParameter("BOARDVIEWCODENAME"), ""));
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USER_NM");
		String userId = sessionMap.get("USER_ID");
		params.put("USERNAME", userName);
		params.put("REG_ID", userId);
		params.put("UPD_ID", userId);
		
		//조회수 증가
		//boardService.updateBoardHits(params);
		// 등록된 글 data 
		HashMap<String, Object> detailView = boardService.getBoardDetail(params);
		detailView.put("BOARD_TYPE", "1");
		model.put("files", boardService.getBoardFiles(detailView));
		
		
		detailView.put("ISIMAGE","N");
		
		if(detailView.get("FILE_NAME") != null && detailView.get("FILE_NAME").toString() !=""  ){
		String isImage = detailView.get("FILE_NAME").toString().split("[.]")[1];
		if(isImage.equals("jpg")||isImage.equals("JPG")||isImage.equals("jpeg")||isImage.equals("JPEG")||isImage.equals("png")||isImage.equals("PNG")||isImage.equals("bmp")||isImage.equals("BMP")||isImage.equals("gif")||isImage.equals("GIF")){
				detailView.put("ISIMAGE","Y");
			}
		}
		//해당글이 리플을 가지고있는지 여부
		int replyCount = boardService.getIsReply(params);
		params.put("ISBOARDREPLY", String.valueOf(replyCount));
		model.addAttribute("params",params);
		model.addAttribute("detailView",detailView);
 		return "/board/boardView";
	}
	/**
	 * @Method Name : boardFAQView
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 보기 화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardFAQView.pop")
	public String boardFAQView(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
		
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));		
		
		params.put("BOARDVIEW_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEW_SEQ"), ""));
		params.put("BOARDVIEWPARENT_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEWPARENT_SEQ"), ""));
		params.put("BOARDVIEWCODENAME",CommonUtil.isNull(request.getParameter("BOARDVIEWCODENAME"), ""));
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USER_NM");
		String userId = sessionMap.get("USER_ID");
		params.put("USERNAME", userName);
		params.put("REG_ID", userId);
		params.put("UPD_ID", userId);
		
		//조회수 증가
		//boardService.updateBoardHits(params);
		// 등록된 글 data 
		HashMap<String, Object> detailView = boardService.getBoardDetail(params);
		
		
		detailView.put("ISIMAGE","N");
		
		if(detailView.get("FILE_NAME") != null && detailView.get("FILE_NAME").toString() !=""  ){
			String isImage = detailView.get("FILE_NAME").toString().split("[.]")[1];
			if(isImage.equals("jpg")||isImage.equals("JPG")||isImage.equals("jpeg")||isImage.equals("JPEG")||isImage.equals("png")||isImage.equals("PNG")||isImage.equals("bmp")||isImage.equals("BMP")||isImage.equals("gif")||isImage.equals("GIF")){
				detailView.put("ISIMAGE","Y");
			}
		}
		//해당글이 리플을 가지고있는지 여부
		//int replyCount = boardService.getIsReply(params);
		//params.put("ISBOARDREPLY", String.valueOf(replyCount));
		model.addAttribute("params",params);
		model.addAttribute("detailView",detailView);
		return "/board/boardFAQView";
	}
	
	/**
	 * @Method Name : boardModify
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 수정 화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardModify.pop")
	public String boardModifiy(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
		params.put("REPLY_YN",CommonUtil.isNull(request.getParameter("REPLY_YN"), ""));
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));		
		
		params.put("BOARDVIEW_SEQ",request.getParameter("BOARDVIEW_SEQ"));
		params.put("BOARDVIEWPARENT_SEQ",request.getParameter("BOARDVIEWPARENT_SEQ"));
		params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USER_NM");
		String userId = sessionMap.get("USER_ID");
		params.put("USERNAME", userName);
		params.put("REG_ID", userId);
		params.put("UPD_ID", userId);
		
		//FAQ 분류 코드 조회
		List<HashMap<String, String>> categoryList = boardService.getFaqCategoryCode(params);
		model.addAttribute("categoryList",categoryList);
		
		HashMap<String, Object> detailView = new HashMap<String, Object>();
		if(params.get("BOARDVIEWPARENT_SEQ").toString().equals("0")){ //원글일때
			//수정 체크박스를 위한 코드리스트
			List<HashMap<String, String>> list = boardService.getRankCode(params);
			
			//해당글의 코드데이터
			List<HashMap<String, String>> boardCodeList = boardService.getboardCodeList(params);
			// 등록된 글 data 
			detailView = boardService.getBoardDetail(params);
			params.put("board_gubun", "ORIGIN");	
			model.addAttribute("params",params);
			model.addAttribute("detailView",detailView);
			model.addAttribute("gbList",list);
			model.addAttribute("boardCodeList",boardCodeList);
		}else{ //답변일때
			// 등록된 글 data 
			detailView = boardService.getBoardDetail(params);
			params.put("board_gubun", "REPLY");
			model.addAttribute("params",params);
			model.addAttribute("detailView",detailView);
		}
		detailView.put("BOARD_TYPE", "1");
		model.put("files", boardService.getBoardFiles(detailView));
 		return "/board/boardModify";
	}
	/**
	 * @Method Name : boardFAQModify
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 게시판글 수정 화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardFAQModify.pop")
	public String boardFAQModify(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
		params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
		params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
		params.put("REPLY_YN",CommonUtil.isNull(request.getParameter("REPLY_YN"), ""));
		params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
		
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));		
		
		params.put("BOARDVIEW_SEQ",request.getParameter("BOARDVIEW_SEQ"));
		params.put("BOARDVIEWPARENT_SEQ",request.getParameter("BOARDVIEWPARENT_SEQ"));
		params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USER_NM");
		String userId = sessionMap.get("USER_ID");
		params.put("USERNAME", userName);
		params.put("REG_ID", userId);
		params.put("UPD_ID", userId);
		
			//수정 체크박스를 위한 코드리스트
			List<HashMap<String, String>> list = boardService.getRankCode(params);
			
			//FAQ 분류 코드 조회
			List<HashMap<String, String>> categoryList = boardService.getFaqCategoryCode(params);
			
			//해당글의 코드데이터
			List<HashMap<String, String>> boardCodeList = boardService.getboardCodeList(params);
			// 등록된 글 data 
			HashMap<String, Object> detailView = boardService.getBoardDetail(params);
			params.put("board_gubun", "ORIGIN");	
			model.addAttribute("params",params);
			model.addAttribute("detailView",detailView);
			model.addAttribute("gbList",list);			
			model.addAttribute("categoryList",categoryList);
			model.addAttribute("boardCodeList",boardCodeList);
		
		return "/board/boardFAQModify";
	}
	/**
	 * @Method Name : boardReplyModify
	 * @작성일 : 2013. 9. 
	 * @Method 설명 : 답변글 수정 화면 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/boardReplyModify.do")
	public String boardReplyModify(ModelMap model, HttpServletRequest request) throws Exception {
		HashMap<String, String> params = new  HashMap<String, String>();
		
		params.put("BOARDENVID",CommonUtil.isNull(request.getParameter("BOARDENVID"), "1"));
		params.put("BOARDTYPE",CommonUtil.isNull(request.getParameter("BOARDTYPE"), "TESTNOTICE"));
		params.put("BOARDTITLE",request.getParameter("BOARDTITLE"));
		params.put("HASREPLY",CommonUtil.isNull(String.valueOf(request.getParameter("HASREPLY")), "0"));
		params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
		params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
		params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
		params.put("currentPage",request.getParameter("currentPage"));
		params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));		
		
		params.put("BOARDVIEWID",request.getParameter("BOARDVIEWID"));
		params.put("BOARDVIEWPARENTID",request.getParameter("BOARDVIEWPARENTID"));
		params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
		
		HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
		String userName = sessionMap.get("USERNAME");
		String userId = sessionMap.get("USERID");
		params.put("USERNAME", userName);
		params.put("USERID", userId);
		
		
		
		//수정 체크박스를 위한 코드리스트
		//List<HashMap<String, String>> list = boardService.getRankCode();
		
		//해당글의 코드데이터
		//List<HashMap<String, String>> boardCodeList = boardService.getboardCodeList(params);
		// 등록된 글 data 
		HashMap<String, Object> detailView = boardService.getBoardDetail(params);
		
		model.addAttribute("params",params);
		model.addAttribute("detailView",detailView);
		//model.addAttribute("gbList",list);
		//model.addAttribute("boardCodeList",boardCodeList);
		model.addAttribute("menu","m1_1");
		
		return "/board/boardReplyModify";
	}
	
	/**
		 * 게시판 수정 첨부 파일 삭제 프로세스
		 * @param model
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/boardDeleteFile.do")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		@ResponseBody
		public HashMap<String, String> boardDeleteFile(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("FILE_PATH", request.getParameter("FILE_PATH"));
			params.put("BOARD_SEQ", request.getParameter("BOARD_SEQ"));
			params.put("FILETYPE", request.getParameter("FILETYPE"));
			//삭제한 파일ID로 게시글 파일 ID 널처리
			boardService.updateBoardFile(params);
			String rootPath = fsResource.getPath();
			String filePath = rootPath+params.get("FILE_PATH");
			File file = new File(String.valueOf(rootPath+params.get("FILE_PATH")));
			file.delete();
			HashMap<String, String> result = new HashMap<String, String>();
			try {
				result.put("successmessage", "삭제 완료");
			} catch (Exception e) {
				result.put("errormessage", "삭제 실패");
				return result;
			}
			return result;
		}

		@Transactional(readOnly=false,rollbackFor=Exception.class)
		@ResponseBody
		@RequestMapping("nfd.do")
		public ModelMap newFileDelete(@RequestParam("fname")String fname, @RequestParam("fno")int fno, HttpServletRequest request, ModelMap mm) throws Exception{
			mm.put("STATUS", 0);
			if (!fname.isEmpty()) {
				try {					
					@SuppressWarnings("unchecked")
					HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
					if(sessionMap != null){
						BoardFile bf = new BoardFile();
//						bf.setFILE_NO(fno);
						bf.setREG_ID("ADMINADMINADMINADMINADMINADMINADMINADMIN");
						if (boardService.deleteBoardFile(bf) == 1) {
							String rootPath = fsResource.getPath();
							(new File(rootPath + fname)).delete();
							mm.put("STATUS", 1);
						}  
					}
				} catch(Exception ex) { }
			}
			return mm;
		}
	
	
		/**
		 * @Method Name : boardInsertProcess
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 게시판글 수정프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardUpdateProcess.pop")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardUpdateProcess(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
			HashMap<String, Object> params = new  HashMap<String, Object>();
			//게시글이 원글인지 답글인지 구분자
			params.put("board_gubun",CommonUtil.isNull(request.getParameter("board_gubun"), ""));
			
			params.put("BOARD_MNG_SEQ",request.getParameter("BOARD_MNG_SEQ"));
			params.put("BOARD_MNG_TYPE",request.getParameter("BOARD_MNG_TYPE"));
			params.put("BOARD_MNG_NAME",request.getParameter("BOARD_MNG_NAME"));
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(String.valueOf(request.getParameter("BOARD_MNG_NAME")), ""));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			//params.put("codeStr",request.getParameter("codeStr"));
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("CREATENAME",request.getParameter("CREATENAME"));		
			params.put("REG_ID",request.getParameter("REG_ID"));		
			params.put("NOTICE_TOP_YN",request.getParameter("NOTICE_TOP_YN"));		
			params.put("OPEN_YN",request.getParameter("OPEN_YN"));		
			params.put("ISSUE",CommonUtil.isNull(request.getParameter("ISSUE"), ""));	
			params.put("RECOMMEND",CommonUtil.isNull(request.getParameter("RECOMMEND"), ""));	
			params.put("SUBJECT",request.getParameter("SUBJECT"));		
			params.put("CONTENT",request.getParameter("CONTENT"));	
			
			/*추가 : 2015.9.8 : 조회수*/
			params.put("HITS",request.getParameter("HITS"));			
			
			//FAQ분류
			params.put("CATEGORY_CODE",CommonUtil.isNull(request.getParameter("FAQ_CATEGORY_CODE"), ""));	
			
			//정렬 번호
			params.put("SORT_NO",CommonUtil.isNull(request.getParameter("SORT_NO"), ""));	
			
			
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));	

			//params.put("ISATTACHFILEID",CommonUtil.isNull(request.getParameter("ISATTACHFILEID"), ""));	
			
			params.put("BOARDVIEW_SEQ",request.getParameter("BOARDVIEW_SEQ"));
			params.put("BOARDVIEWPARENT_SEQ",request.getParameter("BOARDVIEWPARENT_SEQ"));
			params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
			
			String rootPath = fsResource.getPath();
			String subPath = "100/bbs/";
			
			/*MultipartFile uploadFile = multiRequest.getFile("uploadFile");
			if(uploadFile != null && uploadFile.isEmpty() == false) {
				HashMap<String, Object> fileMap = fileUtil.uploadFile(uploadFile, rootPath, subPath);
				String file_path =  String.valueOf(fileMap.get("fileFullPath"));
				String file_name =  String.valueOf(fileMap.get("fileName"));
				
				params.put("FILE_PATH",file_path );
				params.put("FILE_NAME",file_name );
				params.put("REAL_FILE_NAME",uploadFile.getOriginalFilename().toString() );
			}else{
				params.put("FILE_PATH","" );
				params.put("FILE_NAME","" );
				params.put("REAL_FILE_NAME","");
			}*/
			
			/*MultipartFile uploadFileThumbNail = multiRequest.getFile("uploadFileThumbNail");
			if(uploadFileThumbNail != null && uploadFileThumbNail.isEmpty() == false) {
				HashMap<String, Object> fileMap = fileUtil.uploadFile(uploadFileThumbNail, rootPath, subPath);
				String file_path =  String.valueOf(fileMap.get("fileFullPath"));
				String file_name =  String.valueOf(fileMap.get("fileName"));
				
				params.put("THUMBNAIL_FILE_PATH",file_path );
				params.put("THUMBNAIL_FILE_NAME",file_name );
				params.put("THUMBNAIL_FILE_REAL_NAME",uploadFileThumbNail.getOriginalFilename().toString() );
			}else{
				params.put("THUMBNAIL_FILE_PATH","" );
				params.put("THUMBNAIL_FILE_NAME","" );
				params.put("THUMBNAIL_FILE_REAL_NAME","");
			}*/
			params.put("boardFiles", CommonUtil.createFiles(fsResource, multiRequest, fileUtil, "uploadFile", request.getParameter("REG_ID"), 1, Integer.parseInt(request.getParameter("BOARDVIEW_SEQ")), 0));
			
			Object bContentId = boardService.boardUpdateProcess(params);
			System.out.println(bContentId);
			//게시글이 원본글일때만 
			if(params.get("board_gubun").toString().equals("ORIGIN")){
					//기존에 등록된 게시판글에 대한 직급코드를 지우고 다시 insert
					boardService.deleteTboardTestClass(params);
					logger.info("--------"+ params);
					//게시판에서 선택한 직급 구분 codeStr 배열화
					String [] code_arr = request.getParameter("codeStr").split("/");
					HashMap<String, Object> boardTestClassMap = new HashMap<String, Object>();
					for (int i = 0; i < code_arr.length; i++) {
						boardTestClassMap.put("BOARD_MNG_SEQ", params.get("BOARD_MNG_SEQ"));
						boardTestClassMap.put("BOARD_SEQ", params.get("BOARDVIEW_SEQ"));
						boardTestClassMap.put("CATEGORY_CODE", code_arr[i]);
						boardService.insertBoardCatInfo(boardTestClassMap);
					}
					
					//원본글이 코드값이 변경되면 하위 답변에 대한 코드값도 변경되야해서
					//답변글 있는지 체크
					HashMap<String, String> getCodeParam  = new HashMap<String, String>();
					getCodeParam.put("BOARD_MNG_SEQ", String.valueOf(params.get("BOARD_MNG_SEQ")));
					getCodeParam.put("BOARDVIEW_SEQ", String.valueOf(params.get("BOARDVIEW_SEQ")));
					List<HashMap<String, String>> replayData = boardService.getReplyData(getCodeParam);
					logger.info("--------"+ params);
					if(replayData.size()  > 0 ){
						for (int k = 0; k < replayData.size(); k++) {
							
							HashMap<String, Object> updateReplyParam = new HashMap<String, Object>();
							updateReplyParam.put("BOARD_MNG_SEQ", String.valueOf(params.get("BOARD_MNG_SEQ")));
							updateReplyParam.put("BOARDVIEW_SEQ", replayData.get(k).get("BOARD_SEQ"));
							//기존에 등록된 게시판글에 대한 직급코드를 지우고 다시 insert
							boardService.deleteTboardTestClass(updateReplyParam);
							
							HashMap<String, Object> boardTestClassMap2 = new HashMap<String, Object>();
							for (int i = 0; i < code_arr.length; i++) {
								boardTestClassMap2.put("BOARD_MNG_SEQ", params.get("BOARD_MNG_SEQ"));
								boardTestClassMap2.put("BOARD_SEQ", replayData.get(k).get("BOARD_SEQ"));
								boardTestClassMap2.put("CATEGORY_CODE", code_arr[i]);
								boardService.insertBoardCatInfo(boardTestClassMap2);
							}
						}
						
					}
			}
			
						
			model.addAttribute("params", params);
			return "forward:/board/boardList.pop?BOARD_MNG_SEQ="+params.get("BOARD_MNG_SEQ");
		}
		/**
		 * @Method Name : boardFAQUpdateProcess
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 게시판글 수정프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardFAQUpdateProcess.pop")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardFAQUpdateProcess(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
			String rootPath = fsResource.getPath();
			String subPath = "100/bbs/";
			
			HashMap<String, Object> params = new  HashMap<String, Object>();
			
			params.put("BOARD_MNG_SEQ",request.getParameter("BOARD_MNG_SEQ"));
			params.put("BOARD_MNG_TYPE",request.getParameter("BOARD_MNG_TYPE"));
			params.put("BOARD_MNG_NAME",request.getParameter("BOARD_MNG_NAME"));
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(String.valueOf(request.getParameter("BOARD_MNG_NAME")), ""));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("CREATENAME",CommonUtil.isNull(request.getParameter("CREATENAME") , ""));		
			params.put("REG_ID",CommonUtil.isNull(request.getParameter("REG_ID") , ""));		
			params.put("NOTICE_TOP_YN",CommonUtil.isNull(request.getParameter("NOTICE_TOP_YN") , ""));		
			params.put("OPEN_YN",CommonUtil.isNull(request.getParameter("OPEN_YN") , ""));		
			params.put("SUBJECT",CommonUtil.isNull(request.getParameter("SUBJECT") , ""));		
			params.put("ANSWER",CommonUtil.isNull(request.getParameter("ANSWER") , ""));	
			
			//FAQ분류
			params.put("CATEGORY_CODE",CommonUtil.isNull(request.getParameter("FAQ_CATEGORY_CODE"), ""));	
			
			//정렬 번호
			params.put("SORT_NO",CommonUtil.isNull(request.getParameter("SORT_NO"), ""));	
			
			params.put("currentPage",CommonUtil.isNull(request.getParameter("currentPage"), ""));	
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));	
			
			params.put("BOARDVIEW_SEQ",request.getParameter("BOARDVIEW_SEQ"));
			params.put("BOARDVIEWPARENT_SEQ",request.getParameter("BOARDVIEWPARENT_SEQ"));
			params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
			
			
			
			MultipartFile uploadFile = multiRequest.getFile("uploadFile");
			if(uploadFile != null && uploadFile.isEmpty() == false) {
				HashMap<String, Object> fileMap = fileUtil.uploadFile(uploadFile, rootPath, subPath);
				String file_path =  String.valueOf(fileMap.get("fileFullPath"));
				String file_name =  String.valueOf(fileMap.get("fileName"));
				
				params.put("FILE_PATH",file_path );
				params.put("FILE_NAME",file_name );
				params.put("REAL_FILE_NAME",uploadFile.getOriginalFilename().toString() );
			}else{
				params.put("FILE_PATH","" );
				params.put("FILE_NAME","" );
				params.put("REAL_FILE_NAME","");
			}
			Object bContentId = boardService.boardFAQUpdateProcess(params);
			
			//기존에 등록된 게시판글에 대한 직급코드를 지우고 다시 insert
			boardService.deleteTboardTestClass(params);
			logger.info("--------"+ params);
			//게시판에서 선택한 직급 구분 codeStr 배열화
			String [] code_arr = request.getParameter("codeStr").split("/");
			HashMap<String, Object> boardTestClassMap = new HashMap<String, Object>();
			for (int i = 0; i < code_arr.length; i++) {
				boardTestClassMap.put("BOARD_MNG_SEQ", params.get("BOARD_MNG_SEQ"));
				boardTestClassMap.put("BOARD_SEQ", params.get("BOARDVIEW_SEQ"));
				boardTestClassMap.put("CATEGORY_CODE", code_arr[i]);
				boardService.insertBoardCatInfo(boardTestClassMap);
			}
			model.addAttribute("params", params);
			return "redirect:/board/boardFAQList.pop?BOARD_MNG_SEQ="+params.get("BOARD_MNG_SEQ");
		}
		/**
		 * @Method Name : boardReplyUpdateProcess
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 답글  수정 프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardReplyUpdateProcess.do")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardReplyUpdateProcess(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
			HashMap<String, Object> params = new  HashMap<String, Object>();
			
			params.put("BOARDENVID",request.getParameter("BOARDENVID"));
			params.put("BOARDTYPE",request.getParameter("BOARDTYPE"));
			params.put("BOARDTITLE",request.getParameter("BOARDTITLE"));
			params.put("HASREPLY",CommonUtil.isNull(String.valueOf(request.getParameter("HASREPLY")), "0"));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			//params.put("codeStr",request.getParameter("codeStr"));		
			params.put("writer",request.getParameter("writer"));		
			params.put("writerId",request.getParameter("writerId"));		
			params.put("ISTOP",request.getParameter("ISTOP"));		
			params.put("ISOPEN",request.getParameter("ISOPEN"));		
			params.put("title",request.getParameter("title"));		
			params.put("content",request.getParameter("content"));		
			
			
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));	
			
			params.put("ISATTACHFILEID",CommonUtil.isNull(request.getParameter("ISATTACHFILEID"), ""));	
			
			params.put("BOARDVIEWID",request.getParameter("BOARDVIEWID"));
			params.put("BOARDVIEWPARENTID",request.getParameter("BOARDVIEWPARENTID"));
			params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
			
			String rootPath = fsResource.getPath();
			String subPath = "100/bbs/";
			
			//파일업로드하는게 있으면
			MultipartFile uploadFile = multiRequest.getFile("uploadFile");
			if(uploadFile != null){
				if(uploadFile.isEmpty() == false) {
					HashMap<String, Object> fileMap = fileUtil.uploadFile(uploadFile, rootPath, subPath);
					String fileId =  String.valueOf(fileMap.get("attachFileId"));
					params.put("ATTACHFILEID",fileId );
				}else{
					params.put("ATTACHFILEID", "");
				}
			}
			Object bContentId = boardService.boardReplyUpdateProcess(params);
			
			model.addAttribute("menu","m1_1");
			model.addAttribute("params", params);
			return "forward:/board/boardList.do";
		}
	
		
		/**
		 * @Method Name : offExamView
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 게시판글 답변 등록화면 
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardReplyWrite.pop")
		public String boardReplyWrite(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, String> params = new  HashMap<String, String>();
			
			params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
			params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
			
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));		
			
			params.put("BOARDVIEW_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEW_SEQ"), ""));
			params.put("BOARDVIEWPARENT_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEWPARENT_SEQ"), ""));
			params.put("BOARDVIEWCODENAME",CommonUtil.isNull(request.getParameter("BOARDVIEWCODENAME"), ""));
			
			HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
			String userName = sessionMap.get("USER_NM");
			String userId = sessionMap.get("USER_ID");
			params.put("USERNAME", userName);
			params.put("REG_ID", userId);
			params.put("UPD_ID", userId);
			
			// 등록된 원본글 data 
			HashMap<String, Object> detailView = boardService.getBoardDetail(params);
			
			model.addAttribute("params",params);
			model.addAttribute("detailView",detailView);
	 		return "/board/boardReplyWrite";
		}	
		
		/**
		 * @Method Name : boardReplyInsertProcess
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 게시판 답변글 등록프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardReplyInsertProcess.pop")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardReplyInsertProcess(ModelMap model, HttpServletRequest request, MultipartHttpServletRequest multiRequest) throws Exception {
			HashMap<String, Object> params = new  HashMap<String, Object>();
			
			params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
			params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
			params.put("REPLY_YN",CommonUtil.isNull(request.getParameter("REPLY_YN"), ""));
	
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("CREATENAME",CommonUtil.isNull(request.getParameter("CREATENAME"), ""));
			params.put("REG_ID",CommonUtil.isNull(request.getParameter("REG_ID"), ""));		
			params.put("NOTICE_TOP_YN",CommonUtil.isNull(request.getParameter("NOTICE_TOP_YN"), ""));		
			params.put("OPEN_YN",CommonUtil.isNull(request.getParameter("OPEN_YN"), ""));		
			params.put("SUBJECT",CommonUtil.isNull(request.getParameter("SUBJECT"), ""));		
			params.put("CONTENT",CommonUtil.isNull(request.getParameter("CONTENT"), ""));		
			
			
			params.put("currentPage",CommonUtil.isNull(request.getParameter("CONTENT"), "1"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "15"));	

			params.put("BOARDVIEW_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEW_SEQ"), ""));	
			params.put("BOARDVIEWPARENT_SEQ",CommonUtil.isNull(request.getParameter("BOARDVIEWPARENT_SEQ"), ""));	
			params.put("BOARDVIEWCODENAME",CommonUtil.isNull(request.getParameter("BOARDVIEWCODENAME"), ""));	
			
			HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
			String userName = sessionMap.get("USER_NM");
			String userId = sessionMap.get("USER_ID");
			params.put("USERNAME", userName);
			params.put("REG_ID", userId);
			params.put("UPD_ID", userId);
			
			String rootPath = fsResource.getPath();
			String subPath = "100/bbs/";
			
			HashMap<String, String> params2 = new  HashMap<String, String>();
			params2.put("BOARDVIEW_SEQ", params.get("BOARDVIEW_SEQ").toString());
			int isReply = boardService.getIsReply(params2);
			
			if(isReply > 0){
				model.addAttribute("params", params);
				model.addAttribute("MESSAGE", "답글이 이미 등록되었습니다.");
				return "/board/message";
			}
			
			
			MultipartFile uploadFile = multiRequest.getFile("uploadFile");
			if(uploadFile != null && uploadFile.isEmpty() == false) {
				HashMap<String, Object> fileMap = fileUtil.uploadFile(uploadFile, rootPath, subPath);
				String file_path =  String.valueOf(fileMap.get("fileFullPath"));
				String file_name =  String.valueOf(fileMap.get("fileName"));
				
				params.put("FILE_PATH",file_path );
				params.put("FILE_NAME",file_name );
				params.put("REAL_FILE_NAME",uploadFile.getOriginalFilename().toString() );
			}else{
				params.put("FILE_PATH","" );
				params.put("FILE_NAME","" );
				params.put("REAL_FILE_NAME","");
			}
			
			Object bContentId = boardService.boardReplyInsertProcess(params);
			
			//원본글의 게시판 코드 리스트 가져오기
			HashMap<String, String> getCodeParam  = new HashMap<String, String>();
			getCodeParam.put("BOARD_MNG_SEQ", String.valueOf(params.get("BOARD_MNG_SEQ")));
			getCodeParam.put("BOARDVIEW_SEQ", String.valueOf(params.get("BOARDVIEW_SEQ")));
			List<HashMap<String, String>> codeList = boardService.getboardCodeList(getCodeParam);
			
			logger.info("--------"+ params);
			//게시판에서 선택한 직급 구분 codeStr 배열화
			//String [] code_arr = request.getParameter("codeStr").split("/");
			HashMap<String, Object> boardTestClassMap = new HashMap<String, Object>();
			for (int i = 0; i < codeList.size(); i++) {
				boardTestClassMap.put("BOARD_MNG_SEQ", params.get("BOARD_MNG_SEQ"));
				boardTestClassMap.put("BOARD_SEQ", params.get("bContentId"));
				boardTestClassMap.put("CATEGORY_CODE", codeList.get(i).get("CATEGORY_CODE"));
				
				boardService.insertBoardCatInfo(boardTestClassMap);
			}
			model.addAttribute("params", params);
			return "redirect:/board/boardList.pop?BOARD_MNG_SEQ="+CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""); 
		}
		/**
		 * @Method Name : boardReplyDelete
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 리플글 삭제프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardReplyDelete.pop")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardReplyDelete(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, Object> params = new  HashMap<String, Object>();
			
			params.put("BOARDENVID",request.getParameter("BOARDENVID"));
			params.put("BOARDTYPE",CommonUtil.isNull(request.getParameter("BOARDTYPE"), "TESTNOTICE"));
			params.put("BOARDTITLE",request.getParameter("BOARDTITLE"));
			params.put("HASREPLY",CommonUtil.isNull(String.valueOf(request.getParameter("HASREPLY")), "0"));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			//params.put("codeStr",request.getParameter("codeStr"));		
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("writer",request.getParameter("writer"));		
			params.put("writerId",request.getParameter("writerId"));		
			params.put("ISTOP",request.getParameter("ISTOP"));		
			params.put("ISOPEN",request.getParameter("ISOPEN"));		
			params.put("title",request.getParameter("title"));		
			params.put("content",request.getParameter("content"));		
			
			
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));	
			
			
			params.put("BOARDVIEWID",request.getParameter("BOARDVIEWID"));
			params.put("BOARDVIEWPARENTID",request.getParameter("BOARDVIEWPARENTID"));
			params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
			params.put("ATTACHFILEID",request.getParameter("ATTACHFILEID"));
			
			//게시글 데이터 지우고 게시글코드 지우고 파일 지우고 파일DB 지우고
			if(String.valueOf(params.get("ATTACHFILEID")) != null  && String.valueOf(params.get("ATTACHFILEID")) != ""){
				//파일 삭제
				String filePath = String.valueOf(boardService.getFileInfo(params).get("FILEPATH"));
				if(filePath != null && filePath==""){
					File file = new File(filePath);
					file.delete();
				}
			}
			
			boardService.deleteBoardData(params);
			boardService.deleteTboardTestClass(params);
			boardService.deleteBoardFile(params);
			
			model.addAttribute("menu","m1_1");
			model.addAttribute("params", params);
			return "forward:/board/boardList.pop";
		}
		/**
		 * 게시판 수정 파일 삭제 프로세스
		 * @param model
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/getReplyData.do")
		@ResponseBody
		public HashMap<String, String> getReplyData(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, String> params = new HashMap<String, String>();
			HashMap<String, String> result = new HashMap<String, String>();
			params.put("BOARD_MNG_SEQ", request.getParameter("BOARD_MNG_SEQ"));
			params.put("BOARDVIEW_SEQ", request.getParameter("BOARDVIEW_SEQ"));
			List<HashMap<String, String>> replayData = boardService.getReplyData(params);
			if(replayData.size()  > 0){
				result.put("message","N");
			}else{
				result.put("message","Y");
			}
			return result;
		}
		/**
		 * @Method Name : boardReplyDelete
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 리플글 삭제프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardDelete.pop")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardDelete(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, Object> params = new  HashMap<String, Object>();
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
			params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
			params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
			params.put("FILE_PATH",CommonUtil.isNull(String.valueOf(request.getParameter("FILE_PATH")), ""));
			
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));	
			
			params.put("BOARDVIEW_SEQ",CommonUtil.isNull(String.valueOf(request.getParameter("BOARDVIEW_SEQ")), ""));
			params.put("BOARDVIEWPARENT_SEQ",CommonUtil.isNull(String.valueOf(request.getParameter("BOARDVIEWPARENT_SEQ")), ""));
			params.put("BOARDVIEWCODENAME",CommonUtil.isNull(String.valueOf(request.getParameter("BOARDVIEWCODENAME")), ""));

			//게시글 데이터 지우고 게시글코드 지우고 파일 지우고 파일DB 지우고 하위 답변글도 지우고
			/*
			//답변글 있는지 체크
			HashMap<String, String> getCodeParam  = new HashMap<String, String>();
			getCodeParam.put("BOARD_MNG_SEQ", String.valueOf(params.get("BOARD_MNG_SEQ")));
			getCodeParam.put("BOARDVIEW_SEQ", String.valueOf(params.get("BOARDVIEW_SEQ")));
			List<HashMap<String, String>> replayData = boardService.getReplyData(getCodeParam);
			logger.info("--------"+ params);
			if(replayData.size() > 0){
				
				for (int k = 0; k < replayData.size(); k++) {
					HashMap<String, Object> updateReplyParam = new HashMap<String, Object>();
					updateReplyParam.put("BOARD_MNG_SEQ", String.valueOf(params.get("BOARD_MNG_SEQ")));
					updateReplyParam.put("BOARDVIEW_SEQ", replayData.get(k).get("BOARD_SEQ"));
					updateReplyParam.put("FILE_PATH", replayData.get(k).get("FILE_PATH"));
					//답변글에 대한 직급코드를 지우고  답변데이터도 지우고 파일데이터도 지우고
					boardService.deleteBoardData(updateReplyParam);
					boardService.deleteTboardTestClass(updateReplyParam);
					//답변의 첨부파일도 있으면
					if(updateReplyParam.get("FILE_PATH") != null){
						String rootPath = fsResource.getPath();
						String subPath = "100/bbs/";
						String filePath = rootPath+subPath+updateReplyParam.get("FILE_PATH");
						//파일 삭제
						if(filePath != null && filePath==""){
							File file = new File(filePath);
							file.delete();
						}
						//파일DB삭제
						//boardService.deleteBoardFile(updateReplyParam);
					}
				}
			}
			//답변글 있는지 체크 end
			
			*/
			//원본글
			boardService.deleteBoardData(params);
			boardService.deleteTboardTestClass(params);
			
			//원본글의 파일존재 여부에따라  
			if(String.valueOf(params.get("FILE_PATH")) != null  && String.valueOf(params.get("FILE_PATH")) != ""){
				String rootPath = fsResource.getPath();
				String filePath = String.valueOf(rootPath+params.get("FILE_PATH"));
				//파일 삭제
					File file = new File(filePath);
					file.delete();
			}
			//원본글 end
			model.addAttribute("params", params);
			return "redirect:/board/boardList.pop?BOARD_MNG_SEQ="+params.get("BOARD_MNG_SEQ");
		}
		/**
		 * @Method Name : boardFAQDelete
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 리플글 삭제프로세스
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardFAQDelete.pop")
		@Transactional(readOnly=false,rollbackFor=Exception.class)
		public String boardFAQDelete(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, Object> params = new  HashMap<String, Object>();
			
			params.put("BOARD_MNG_SEQ",CommonUtil.isNull(request.getParameter("BOARD_MNG_SEQ"), ""));
			params.put("BOARD_MNG_TYPE",CommonUtil.isNull(request.getParameter("BOARD_MNG_TYPE"), ""));
			params.put("BOARD_MNG_NAME",CommonUtil.isNull(request.getParameter("BOARD_MNG_NAME"), ""));
			params.put("REPLY_YN",CommonUtil.isNull(String.valueOf(request.getParameter("REPLY_YN")), ""));
			params.put("FILE_PATH",CommonUtil.isNull(String.valueOf(request.getParameter("FILE_PATH")), ""));
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));	
			
			params.put("BOARDVIEW_SEQ",CommonUtil.isNull(String.valueOf(request.getParameter("BOARDVIEW_SEQ")), ""));
			params.put("BOARDVIEWPARENT_SEQ",CommonUtil.isNull(String.valueOf(request.getParameter("BOARDVIEWPARENT_SEQ")), ""));
			params.put("BOARDVIEWCODENAME",CommonUtil.isNull(String.valueOf(request.getParameter("BOARDVIEWCODENAME")), ""));
		
			//원본글
			boardService.deleteBoardData(params);
			boardService.deleteTboardTestClass(params);
			
			//원본글의 파일존재 여부에따라  
			if(String.valueOf(params.get("FILE_PATH")) != null  && String.valueOf(params.get("FILE_PATH")) != ""){
				String rootPath = fsResource.getPath();
				String filePath = String.valueOf(rootPath+params.get("FILE_PATH"));
				//파일 삭제
					File file = new File(filePath);
					file.delete();
			}
			//원본글 end
			model.addAttribute("params", params);
			return "redirect:/board/boardFAQList.pop?BOARD_MNG_SEQ="+params.get("BOARD_MNG_SEQ");
		}
		
		/**
		 * @Method Name : boardReplyView
		 * @작성일 : 2013. 9. 
		 * @Method 설명 : 게시판글 답변 보기 화면 
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/boardReplyView.pop")
		public String boardReplyView(ModelMap model, HttpServletRequest request) throws Exception {
			HashMap<String, String> params = new  HashMap<String, String>();
			params.put("ONOFF_DIV",CommonUtil.isNull(String.valueOf(request.getParameter("ONOFF_DIV")), ""));
			params.put("BOARDENVID",CommonUtil.isNull(request.getParameter("BOARDENVID"), "1"));
			params.put("BOARDTYPE",CommonUtil.isNull(request.getParameter("BOARDTYPE"), "TESTNOTICE"));
			params.put("BOARDTITLE",request.getParameter("BOARDTITLE"));
			params.put("HASREPLY",CommonUtil.isNull(String.valueOf(request.getParameter("HASREPLY")), "0"));
			params.put("SEARCHCATEGORY",CommonUtil.isNull(request.getParameter("SEARCHCATEGORY"), ""));
			params.put("SEARCHKIND",CommonUtil.isNull(request.getParameter("SEARCHKIND"), ""));
			params.put("SEARCHTEXT",CommonUtil.isNull(request.getParameter("SEARCHTEXT"), ""));		
			params.put("currentPage",request.getParameter("currentPage"));
			params.put("pageRow",CommonUtil.isNull(request.getParameter("pageRow"), "10"));		
			
			params.put("BOARDVIEWID",request.getParameter("BOARDVIEWID"));
			params.put("BOARDVIEWPARENTID",request.getParameter("BOARDVIEWPARENTID"));
			params.put("BOARDVIEWCODENAME",request.getParameter("BOARDVIEWCODENAME"));
			
			HashMap<String, String> sessionMap = (HashMap)request.getSession().getAttribute("AdmUserInfo");
			String userName = sessionMap.get("USERNAME");
			String userId = sessionMap.get("USERID");
			params.put("USERNAME", userName);
			params.put("USERID", userId);
			
			//조회수 증가
			//boardService.updateBoardHits(params);
			// 등록된 글 data 
			HashMap<String, Object> detailView = boardService.getBoardDetail(params);
			
			//해당글이 리플을 가지고있는지 여부
			int replyCount = boardService.getIsReply(params);
			params.put("ISBOARDREPLY", String.valueOf(replyCount));
			
			
			model.addAttribute("params",params);
			model.addAttribute("detailView",detailView);
			model.addAttribute("menu","m1_1");
	 		return "/board/boardReplyView";
		}
		
}
