package test.test.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.coding.platform.util.CommonUtil;
import com.coding.platform.util.Thumbnailgenerator;
import com.coding.platform.util.file.FileUtil;
import com.coding.web.notice.service.noticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	testInterface test;
	@Resource(name = "fileUtil")
	FileUtil fileUtil;

	@Inject
	private FileSystemResource fsResource; // DI
	@Autowired
	private noticeService noticeService;
	
	@Autowired
	Thumbnailgenerator thumbnail;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		request.getSession().setAttribute("name", 2);

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("list", test.testList());
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/test1", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String test1(Locale locale, Model model,@RequestParam String content, HttpServletRequest request,MultipartRequest multiRequest) throws IOException {
		
		System.out.println(content);
		// HashMap<String, ArrayList> imgInfo=test(content);
		String subroot = "archive";
		HashMap<String, ArrayList<String>> ContentResult = test(content,subroot);

		HashSet<Path> willDeleteFileList = new HashSet<Path>();
		for (int i = 0; i < ContentResult.get("fileNameAndExtension").size(); i++) {
			Path willdeletefile = Filetransfer(
					ContentResult.get("fileNameAndExtension").get(i), subroot,
					request);
			willDeleteFileList.add(willdeletefile);
			// content null처리후에 replaceAll 할것
			content = content.replaceAll(
					ContentResult.get("webAddress").get(i),
					ContentResult.get("transferImgAddress").get(i));

		}
		//

		// // DB업데이트
		// // Files.deleteIfExists(oriFile.toPath());
		HashMap insertdata = new HashMap();
		// insert하기위해 Content담고 insert하면 게시글 번호를 담아서 리턴해나온다
		insertdata.put("CONTENT", content);
		test.testInsert(insertdata);
		// 그 게시글 번호를 select 해온다
		HashMap boarddata = test.test((Integer) insertdata.get("IDX"));
		//
		System.out.println(boarddata.get("CONTENT"));
		System.out.println(boarddata.get("IDX"));
		System.out.println("데이터체크");
		model.addAttribute("list", boarddata);
		for (Path path : willDeleteFileList) {
			Filedelete(path);
		}

		// 아래부터는 멀티파일 다운로드

		String rootPath = fsResource.getPath();
		String subPath = "CD_NOTICE/Images/";

		// noticeService.noticeInsert(params);
		String idx = String.valueOf(boarddata.get("IDX"));
		idx = CommonUtil.isNull(idx, "");

		boolean booltf = false;
		System.out.println("부적합?");
		List<MultipartFile> uploadFileList = multiRequest
				.getFiles("uploadFile");
		booltf = CommonUtil.ValidUploadFileExtension(uploadFileList);
		Map<String, Object> params = new HashMap<String, Object>();
		String MESSAGE = "";
		System.out.println(uploadFileList.size() + "파일올린사이즈~~");
		System.out.println(multiRequest.getFiles("uploadFile").size());

		if (!uploadFileList.isEmpty()) {
			if (booltf == true) {
				List<HashMap<String, Object>> fileInfoList = fileUtil
						.uploadFiles(uploadFileList, rootPath, subPath);

				for (int i = 0; i < fileInfoList.size(); i++) {

					String file_path = String.valueOf(fileInfoList.get(i).get(
							"fileFullPath"));
					String real_name = String.valueOf(fileInfoList.get(i).get(
							"fileName"));// 원본파일이름
					String file_name = String.valueOf(fileInfoList.get(i).get(
							"newFileName"));// 변경파일이름
					String file_size = String.valueOf(fileInfoList.get(i).get(
							"fileSize"));
					String brd_name = "CD_NOTICE";

					params.put("BRDNAME", brd_name);
					params.put("FILE_PATH", file_path);
					params.put("FILENAME", file_name);// 변경파일이름
					params.put("INXNAME", real_name);// 원본파일이름
					params.put("FILESIZE", file_size);
					params.put("IDX", idx);

					noticeService.noticeFileInsert(params);
					System.out.println(params.toString());
				}
			} else {
				MESSAGE = "등록할 수 없는 확장자 입니다.";
				// returnUrl = "/notice/noticeView.do?idx=" + idx;
				model.addAttribute("MESSAGE", MESSAGE);
				model.addAttribute("URL",
						"test1/home2?idx" + boarddata.get("IDX"));

				return "test1/home2";
			}
		}
		params.put("IDX", idx);
		String brd_name = "CD_NOTICE";

		params.put("BRDNAME", brd_name);
		List<HashMap<String, Object>> file = noticeService
				.noticeFileList(params);
		model.addAttribute("file", file);
		return "test1/home2";
	}

	/**
	 * test메소드안에
	 * 
	 * @param webAddress
	 *            본문 img fileNameAndExtension 파일.확장자 transferImgAddress 적용할 img
	 *            src주소들
	 */

	@RequestMapping(value = "/test2", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String test2(@RequestParam int idx, Model model) {

		model.addAttribute("list", test.test(idx));
		return "test1/home";
	}

	// 수정
	@RequestMapping(value = "/test3", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String testModify3(Locale locale, Model model,
			HttpServletRequest request, @RequestParam String content,
			@RequestParam int idx) throws IOException {
		
		String subroot = "archive";
		HashMap boardidxdata = test.test(idx);
		String comparestring = String.valueOf(boardidxdata.get("CONTENT"));
		HashMap<String, ArrayList<String>> oldList = test(comparestring,subroot);
		HashMap<String, ArrayList<String>> newList = test(content, subroot);
		HashSet<Path> willDeleteFileList = new HashSet<Path>();

		//오버로딩 생각해볼것 
		for (int i = 0; i < newList.get("fileNameAndExtension").size(); i++) {

			content = content.replaceAll(newList.get("webAddress").get(i),
					newList.get("transferImgAddress").get(i));

		}

		System.out.println("예전주소트랜스퍼");
		System.out.println(oldList.get("transferImgAddress").toString());

		System.out.println("새로운거");
		System.out.println(newList.get("webAddress").toString());
		HashSet<String> oldWebAddress = new HashSet<String>(oldList.get("webAddress"));
		HashSet<String> newWebAddress = new HashSet<String>(newList.get("webAddress"));

		System.out.println("새로 올라온 웹 주소 ");
		newWebAddress.removeAll(oldList.get("webAddress"));
		for (String string : newWebAddress) {

			Filetransfer(string.substring(string.lastIndexOf("/") + 1,string.length()), subroot, request);
		}

		System.out.println(newWebAddress.toString());

		System.out.println("기존것들 중 지워야할 웹 주소들 ");
		oldWebAddress.removeAll(newList.get("webAddress"));
		System.out.println(oldWebAddress.toString());

		System.out.println("총 지워야하는 파일들 ");
		oldWebAddress.addAll(newWebAddress);
		System.out.println(oldWebAddress.toString());

		HashMap insertdata = new HashMap();
		insertdata.put("CONTENT", content);
		insertdata.put("IDX", idx);
		test.testUpdate(insertdata);

		model.addAttribute("list", test.test(idx));

		// 파일삭제

		for (String string : oldWebAddress) {
			String Imgcheck = ImgAddressTranslate(string, request);

			Filedelete(Paths.get(Imgcheck));

		}

		return "test1/home2";
	}

	@RequestMapping(value = "/test4", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String test4(@RequestParam int idx, Model model) {

		//
		model.addAttribute("list", test.test(idx));
		return "test1/home2";
	}
	
	@RequestMapping(value = "/test5", method = { RequestMethod.GET,RequestMethod.POST })
	public String test5(Model model,MultipartRequest multipartrequest,HttpServletRequest request) throws Exception {
		System.out.println("check");
		List<MultipartFile> uploadFileList = multipartrequest.getFiles("uploadFile");
		String url = null;
		for(int i = 0; i < uploadFileList.size(); i++) {
		    String originalFileName =  uploadFileList.get(i).getOriginalFilename();
		    int index = originalFileName.lastIndexOf(".");
		    String fileName = originalFileName.substring(0, index);
		    String fileExt = originalFileName.substring(index + 1);

		    File file = new File(request.getServletContext().getRealPath("/") + originalFileName);
		    logger.info(file.getAbsolutePath());
		    
		    uploadFileList.get(i).transferTo(file);
		    
		    // 썸네일을 생성하는 메소드를 호출합니다.
//		    url= makeThumbnail(file.getAbsolutePath(), originalFileName, fileExt,file.getAbsolutePath());
		     url=	 makeThumbnail2(file.getAbsolutePath(), originalFileName, fileExt,file.getAbsolutePath());
		}


		//
		model.addAttribute("url", url);
		return "thumnail";
		
	}

	@RequestMapping(value = "/test6", method = { RequestMethod.GET,RequestMethod.POST })
	public String test6(Model model,MultipartRequest multipartrequest,HttpServletRequest request) throws Exception {
		 List<MultipartFile> mf = multipartrequest.getFiles("uploadFile");       
	     String subroot="cdgalay/images";
	     HashMap<String,Object> thumbnailinfo=thumbnail.ThumbnailGenarate(multipartrequest, request, subroot);
		 if(thumbnailinfo.size()>0){
			 
		 }
			 
		 
		 
//	            for (int i = 0; i < mf.size(); i++) {
//	                // 파일 중복명 처리
//	                String genId = UUID.randomUUID().toString();
//	                // 본래 파일명
//	                String originalfileName = mf.get(i).getOriginalFilename();
//	                // 저장되는 파일 이름
//	                String saveFileName = "chalkack-" + genId + "." + originalfileName;
//	                // 리사이징되는 파일 이름
//	                String resizeFileName_medium = "medium-" + saveFileName;
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
//	                
//	                
//	                //thumbnailator의 메소드를 이용해 썸네일을 bufferdimage로 만든다
//	                BufferedImage thumbnail_medium = Thumbnails.of(image).size(mediumWidth,mediumHeight).asBufferedImage();
//	                String thumbName = request.getServletContext()
//							.getRealPath("/") + File.separator+"coding"+File.separator;
//					File check=new File(thumbName);
//					if(!check.exists()){
//						check.mkdirs();
//					}
//							
//	                thumbName+="THUMB_" + resizeFileName_medium; 
//	        	    File thumbFile = new File(thumbName);
//	        	    ImageIO.write(thumbnail_medium, "png", thumbFile);
//	        	    System.out.println(thumbFile.length());
//	    }
	            
	      return "thumnail";
	            
	}
	@RequestMapping(value = "/adm", method = RequestMethod.POST)
	public String home2(Locale locale, Model model, HttpServletRequest request,
			MultipartHttpServletRequest request2) {
		System.out.println(request.getSession().getAttribute("name"));
		logger.info("Welcome home! The client locale is {}.", locale);

		System.out.println("멀티파트 몇개" + request2.getFiles("uploadFile").size());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/noticeInsert.do")
	public String noticeInsert(ModelMap model, HttpServletRequest request,
			MultipartHttpServletRequest multiRequest) throws Exception {
		HashMap<String, String> sessionMap = (HashMap) request.getSession()
				.getAttribute("AdmUserInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = null;

		String userName = "";
		if (sessionMap != null) {
			userName = CommonUtil.isNull(sessionMap.get("USERNAME"), "");
			model.addAttribute("userName", userName);
		}

		String returnUrl = "";
		String MESSAGE;

		params.put("SUBJECT",
				CommonUtil.isNull(request.getParameter("txtSubject"), ""));
		String content = CommonUtil
				.isNull(request.getParameter("Contents"), "");
		content = content.replaceAll(" ", "&nbsp;");
		content = content.replaceAll(" ", "&amp;nbsp;");
		content = content.replaceAll("\"", "&quot;");
		content = content.replaceAll("\"", "&amp;quot;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&amp;gt;");
		content = content.replaceAll("<", "&amp;lt;");

		params.put("CONTENT", content);
		params.put("WRITENAME",
				CommonUtil.isNull(request.getParameter("memberName"), ""));
		params.put("EMAIL",
				CommonUtil.isNull(request.getParameter("txtEmail"), ""));

		params.put("IDX", CommonUtil.isNull(request.getParameter("idx"), ""));
		String rootPath = fsResource.getPath();
		String subPath = "CD_NOTICE/Images/";

		// noticeService.noticeInsert(params);
		// int idx = noticeService.noticeReturnOne();

		boolean booltf = false;

		List<MultipartFile> uploadFileList = multiRequest
				.getFiles("uploadFile");
		booltf = CommonUtil.ValidUploadFileExtension(uploadFileList);

		if (!uploadFileList.isEmpty()) {
			if (booltf == true) {
				List<HashMap<String, Object>> fileInfoList = fileUtil
						.uploadFiles(uploadFileList, rootPath, subPath);

				for (int i = 0; i < fileInfoList.size(); i++) {

					String file_path = String.valueOf(fileInfoList.get(i).get(
							"fileFullPath"));
					String real_name = String.valueOf(fileInfoList.get(i).get(
							"fileName"));// 원본파일이름
					String file_name = String.valueOf(fileInfoList.get(i).get(
							"newFileName"));// 변경파일이름
					String file_size = String.valueOf(fileInfoList.get(i).get(
							"fileSize"));
					String brd_name = "CD_NOTICE";

					params.put("BRDNAME", brd_name);
					params.put("FILE_PATH", file_path);
					params.put("FILENAME", file_name);// 변경파일이름
					params.put("INXNAME", real_name);// 원본파일이름
					params.put("FILESIZE", file_size);
					// params.put("IDX", idx);

					// noticeService.noticeFileInsert(params);
				}
			} else {
				MESSAGE = "등록할 수 없는 확장자 입니다.";
				// returnUrl = "/notice/noticeView.do?idx=" + idx;
				model.addAttribute("MESSAGE", MESSAGE);
				model.addAttribute("URL", returnUrl);

				return "login/message";
			}
		}

		return "redirect:/notice/noticeView.do?idx=";
	}

	@RequestMapping(value = "/file_uploader", method = RequestMethod.POST)
	@ResponseBody
	public void Fileupload(HttpServletRequest request,
			HttpServletResponse response) throws FileUploadException,
			IOException, Exception {

		String return1 = "";
		String return2 = "";
		String return3 = "";
		String name = "";
		if (ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload uploadHandler = new ServletFileUpload(
					new DiskFileItemFactory());
			// UTF-8 인코딩 설정
			uploadHandler.setHeaderEncoding("UTF-8");
			List<FileItem> items = uploadHandler.parseRequest(request);
			// 각 필드태그들을 FOR문을 이용하여 비교를 합니다.
			for (FileItem item : items) {
				if (item.getFieldName().equals("callback")) {
					return1 = item.getString("UTF-8");
				} else if (item.getFieldName().equals("callback_func")) {
					return2 = "?callback_func=" + item.getString("UTF-8");
				} else if (item.getFieldName().equals("Filedata")) {
					// FILE 태그가 1개이상일 경우
					if (item.getSize() > 0) {
						String ext = item.getName().substring(
								item.getName().lastIndexOf(".") + 1);
						// 파일 기본경로
						String defaultPath = request.getServletContext()
								.getRealPath("/");
						// 파일 기본경로 _ 상세경로
						String path = defaultPath + "upload" + File.separator;

						File file = new File(path);

						// 디렉토리 존재하지 않을경우 디렉토리 생성
						if (!file.exists()) {
							file.mkdirs();
						}
						// 서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
						String realname = UUID.randomUUID().toString() + "."
								+ ext;
						// /////////////// 서버에 파일쓰기 /////////////////
						InputStream is = item.getInputStream();
						OutputStream os = new FileOutputStream(path + realname);
						int numRead;
						byte b[] = new byte[(int) item.getSize()];
						while ((numRead = is.read(b, 0, b.length)) != -1) {
							os.write(b, 0, numRead);
						}
						if (is != null)
							is.close();
						os.flush();
						os.close();
						// /////////////// 서버에 파일쓰기 /////////////////
						return3 += "&bNewLine=true&sFileName=" + name
								+ "&sFileURL=/upload/" + realname;
					} else {
						return3 += "&errstr=error";
					}
				}
			}
		}
		response.sendRedirect(return1 + return2 + return3);

	}

	@RequestMapping("/file_uploader_html5")
	public void file_uploader_html5(HttpServletRequest request,
			HttpServletResponse response) {

		try { // 파일정보
			String sFileInfo = ""; // 파일명을 받는다 - 일반 원본파일명
			String filename = request.getHeader("file-name"); // 파일 확장자
			String filename_ext = filename
					.substring(filename.lastIndexOf(".") + 1); // 확장자를소문자로 변경
			filename_ext = filename_ext.toLowerCase(); // 이미지 검증 배열변수
			String[] allow_file = { "jpg", "png", "bmp", "gif" }; // 돌리면서 확장자가
																	// 이미지인지
			int cnt = 0;
			for (int i = 0; i < allow_file.length; i++) {
				if (filename_ext.equals(allow_file[i])) {
					cnt++;
				}
			} // 이미지가 아님
			if (cnt == 0) {
				PrintWriter print = response.getWriter();
				print.print("NOTALLOW_" + filename);
				print.flush();
				print.close();
			} else { // 이미지이므로 신규 파일로 디렉토리 설정 및 업로드
						// 파일 기본경로
						// 실제 적용시에는 @FileResources로 가져와서 변
						// 테스트
						// 파일 기본경로 _ 상세경로
				String dftFilePath = request.getSession().getServletContext().getRealPath("/")+ "resources" + File.separator + "Files";
				
				String filePath = dftFilePath + File.separator + "temp"+ File.separator;
				File file = new File(filePath);
				
				if (!file.exists()) {
					file.mkdirs();
				}
				
				String realFileNm = "";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
				
				String today = formatter.format(new java.util.Date());
				realFileNm = today + UUID.randomUUID().toString()+ filename.substring(filename.lastIndexOf("."));
				String rlFileNm = filePath + realFileNm;
				
				// /////////////// 서버에 파일쓰기 /////////////////
				InputStream is = request.getInputStream();
				OutputStream os = new FileOutputStream(rlFileNm);
				
				int numRead;
				byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
				
				while ((numRead = is.read(b, 0, b.length)) != -1) {
					os.write(b, 0, numRead);
				}
				if (is != null) {
					is.close();
				}
				os.flush();
				os.close();
				// /////////////// 서버에 파일쓰기 ///////////////// // 정보 출력
				sFileInfo += "&bNewLine=true"; // img 태그의 title 속성을 원본파일명으로
												// 적용시켜주기 위함
				sFileInfo += "&sFileName=" + filename;
				sFileInfo += "&sFileURL=" + "/resources/Files/temp/"
						+ realFileNm;
				PrintWriter print = response.getWriter();
				print.print(sFileInfo);
				print.flush();
				print.close();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static HashMap<String, ArrayList<String>> test(String Content,
			String subroot) {
		HashMap<String, ArrayList<String>> totalObject = new HashMap<String, ArrayList<String>>();

		String[] tempImgAddress = Content.split("<img src=\"/resources");

		// /resources/~의 웹 어드레드

		ArrayList<String> webAddress = new ArrayList<String>();
		ArrayList<String> fileNameAndExtension = new ArrayList<String>();
		ArrayList<String> transferImgAddress = new ArrayList<String>();
		String tempaddress = null;
		//파일위치
		for (int i = 1; i < tempImgAddress.length; i++) {
			tempaddress = tempImgAddress[i].substring(0,tempImgAddress[i].indexOf("\""));
			webAddress.add(tempaddress);
			fileNameAndExtension.add(tempaddress.substring(tempaddress.lastIndexOf("/") + 1, tempaddress.length()));

			transferImgAddress.add(tempaddress.replaceFirst("temp", subroot+ "/Images/Neditor"));
		}

		totalObject.put("webAddress", webAddress);
		totalObject.put("fileNameAndExtension", fileNameAndExtension);
		totalObject.put("transferImgAddress", transferImgAddress);

		return totalObject;

	}

	public static String ImgAddressTranslate(String check,
			HttpServletRequest request) {

		// 실제 프로젝트에서는 Inject시켜서 적용할것 그리고 Builder써서할지 생각
		String rootFolder = request.getServletContext().getRealPath("/")+ "resources";
		String[] checkArray = check.split("/");
		for (int i = 1; i < checkArray.length; i++) {
			rootFolder += File.separator + checkArray[i];

		}
		return rootFolder;
	}

	

	public static Path Filetransfer(String FileName, String subroot,
			HttpServletRequest request) {
		// 파일객체생성
		// 코딩플러스에 적용할떄는 빈객체 Inject로 이어줄것
		// FileSystemResource위치와 옮길 위치 고칠것
		String oriDirectory = request.getSession().getServletContext().getRealPath("/")+ "resources"+ File.separator+ "Files"
							  												+ File.separator + "temp" + File.separator;
		String copyDirectory = request.getServletContext().getRealPath("/")+ "resources" + File.separator + "Files" + File.separator
											+ subroot + File.separator + "Images" + File.separator + "Neditor" + File.separator;
		File oriFile = new File(oriDirectory + FileName);
		// 복사파일객체생성
		File copyFolder = new File(copyDirectory);
		File copyFile = new File(copyDirectory + FileName);
		if (!copyFolder.isDirectory()) {
			copyFolder.mkdirs();
		}

		try {
			if (oriFile.exists()) {
				if (!copyFile.exists()) {
					Files.copy(oriFile.toPath(), copyFile.toPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return oriFile.toPath();
	}
	
	
	public static void Filedelete(Path oriFile) throws IOException {
		if (oriFile != null) {

			Files.deleteIfExists(oriFile);
		}
	}

	/** * 썸네일을 생성합니다. * 250 x 150 크기의 썸네일을 만듭니다. */ 
	public static String makeThumbnail(String filePath, String fileName, String fileExt,String Path) throws Exception { 
		// 저장된 원본파일로부터 BufferedImage 객체를 생성합니다. 
		BufferedImage srcImg = ImageIO.read(new File(filePath)); // 썸네일의 너비와 높이 입니다. 
		int dw = 250, dh = 150; // 원본 이미지의 너비와 높이 입니다. 
		int ow = srcImg.getWidth(); 
		int oh = srcImg.getHeight(); // 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다. 
		int nw = ow; int nh = (ow * dh) / dw; // 계산된 높이가 원본보다 높다면 crop이 안되므로 
		// 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다. 
		if(nh > oh) { nw = (oh * dw) / dh; nh = oh; } // 계산된 크기로 원본이미지를 가운데에서 crop 합니다. 
		BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh); // crop된 이미지로 썸네일을 생성합니다. 
		BufferedImage destImg = Scalr.resize(cropImg, dw, dh); // 썸네일을 저장합니다. 이미지 이름 앞에 "THUMB_" 를 붙여 표시했습니다. 
		String thumbName = filePath + "THUMB_" + fileName; 
		File thumbFile = new File(thumbName);
		
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile); 
		return thumbName;
	}

	public static String makeThumbnail2(String filePath, String fileName, String fileExt,String Path) throws IOException {

	    // 원본 이미지 입니다.
	    BufferedImage srcImg = ImageIO.read(new File(filePath));

	    // 썸네일 크기 입니다.
	    int dw = 450, dh = 270;
		
	    // 원본이미지 크기 입니다.
	    int ow = srcImg.getWidth();
	    int oh = srcImg.getHeight();
		
	    // 늘어날 길이를 계산하여 패딩합니다.
	    int pd = 0;
	    if(ow > oh) {
	 	pd = (int)(Math.abs((dh * ow / (double)dw) - oh) / 2d);
	    } else {
		pd = (int)(Math.abs((dw * oh / (double)dh) - ow) / 2d);
	    }
	    srcImg = Scalr.pad(srcImg, pd, Color.WHITE, Scalr.OP_ANTIALIAS);
		
	    // 이미지 크기가 변경되었으므로 다시 구합니다.
	    ow = srcImg.getWidth();
	    oh = srcImg.getHeight();
		
	    // 썸네일 비율로 크롭할 크기를 구합니다.
	    int nw = ow;
	    int nh = (ow * dh) / dw;
	    if(nh > oh) {
		nw = (oh * dw) / dh;
		nh = oh;
	    }
		
	    // 늘려진 이미지의 중앙을 썸네일 비율로 크롭 합니다.
	    BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		
	    // 리사이즈(썸네일 생성)
	    BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
		
	    // 이미지 출력
	    String thumbName = filePath + "THUMB_" + fileName; 
	    File thumbFile = new File(thumbName);
	    ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
		
	    
	    return thumbName;
	}


	
	
}	
