package test.test.test;

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
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
	
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	testInterface test;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		request.getSession().setAttribute("name", 2);
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		model.addAttribute("list", test.testList() );
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test1", method = {RequestMethod.GET,RequestMethod.POST})
	public String test1(Locale locale, Model model,@RequestParam String content ,HttpServletRequest request) throws IOException {
		System.out.println(content);
//		HashMap<String, ArrayList> imgInfo=test(content);
		String subroot="archive";
HashMap<String, ArrayList<String>> ContentResult=test(content, subroot);
	
		HashSet<Path> willDeleteFileList=new HashSet<Path>();
		for (int i = 0; i < ContentResult.get("fileNameAndExtension").size(); i++) {
			Path willdeletefile=Filetransfer(ContentResult.get("fileNameAndExtension").get(i), subroot,request);
			willDeleteFileList.add(willdeletefile);
			//content null처리후에 replaceAll 할것 
			content=content.replaceAll(ContentResult.get("webAddress").get(i), ContentResult.get("transferImgAddress").get(i));
			
		}
		// 
		
////      DB업데이트 		
////		Files.deleteIfExists(oriFile.toPath());
		HashMap insertdata=new HashMap();
		//insert하기위해 Content담고 insert하면 게시글 번호를 담아서 리턴해나온다 
		insertdata.put("CONTENT", content);
		test.testInsert(insertdata);
		//그 게시글 번호를 select 해온다 
		HashMap boarddata=test.test((Integer) insertdata.get("IDX"));
//		
		System.out.println(boarddata.get("CONTENT"));
		System.out.println(boarddata.get("IDX"));
		System.out.println("데이터체크");
		model.addAttribute("list",boarddata);
		for (Path path : willDeleteFileList) {
			Filedelete(path);
		}
		return "test1/home2";
	}
	
	
	/**
	 * 				test메소드안에 
	 * @param 		webAddress                  본문 img 
	    			fileNameAndExtension		파일.확장자 
	    			transferImgAddress	 		적용할 img src주소들 
	 */
	
	
	@RequestMapping(value = "/test2", method = {RequestMethod.GET,RequestMethod.POST})
	public String test2(@RequestParam int idx,Model model) {
		
		model.addAttribute("list",test.test(idx));
		return "test1/home";
	}
	
	
	//수정
	@RequestMapping(value = "/test3", method = {RequestMethod.GET,RequestMethod.POST})
	public String testModify3(Locale locale, Model model,HttpServletRequest request,@RequestParam String content,@RequestParam int idx) throws IOException {
		System.out.println("test2체크");
		System.out.println(idx);
		System.out.println(content);
		System.out.println("-------------");
		logger.info("Welcome home! The client locale is {}.컨텐츠체크", locale);
		String subroot="archive";
		HashMap boardidxdata=test.test(idx);
		String comparestring=String.valueOf(boardidxdata.get("CONTENT"));
		HashMap<String, ArrayList<String>> oldList=test(comparestring,subroot);
		HashMap<String, ArrayList<String>> newList=test(content,subroot);
		
		
		
		HashSet<Path> willDeleteFileList=new HashSet<Path>();
		
		//이것도 낭비 다 불러오기떄문에 
		//외부경로 참조할경우 어떻게할것인가? 외부경로도 삭제할려고할수있을텐데 
		for (int i = 0; i < newList.get("fileNameAndExtension").size(); i++) {
			     
			//현재 content상태는 이미 올라온것 + 안올라온것의 조합 그렇기떄문에  새로올라온Content에서 temp붙은것들만 바꿔주면됨 
			content=content.replaceAll(newList.get("webAddress").get(i), newList.get("transferImgAddress").get(i));
			
		}
		
		
		
		
		
		System.out.println("예전주소트랜스퍼");
		System.out.println(oldList.get("transferImgAddress").toString());
		
		System.out.println("새로운거");
		System.out.println(newList.get("webAddress").toString());
		HashSet<String>  oldWebAddress=new HashSet<String>(oldList.get("webAddress"));
		HashSet<String>  newWebAddress=new HashSet<String>(newList.get("webAddress"));
		
		
		
		
		System.out.println("새로 올라온 웹 주소 ");
		newWebAddress.removeAll(oldList.get("webAddress"));
		for (String string : newWebAddress) {
			
			
			Filetransfer(string.substring(string.lastIndexOf("/")+1,string.length()), subroot, request);
		}
		
		System.out.println(newWebAddress.toString());
		
		System.out.println("기존것들 중 지워야할 웹 주소들 ");
		oldWebAddress.removeAll(newList.get("webAddress"));
		System.out.println(oldWebAddress.toString());
		//다 처리후 oldwebaddress(transfer)랑 newwebaddress(webAddress)를  .add로 합집합 만들어서 해당파일들은 삭제처리 
		
		System.out.println("총 지워야하는 파일들 ");
		oldWebAddress.addAll(newWebAddress);
		System.out.println(oldWebAddress.toString());
	
		
//		주소가 아마 resources~~~~형태로 돼있을것인데  운영체제에 맞게 에러가 안나게할려면 split하고 각각 파일이름  + 구분자 + 로 해야 에러가 안나는데 문제는 그러면 
//		Filedelete함수로 이상한곳을 지울가능성이 있어짐. 그전에 resources/로 잘랐다고는 나중에 스마트에디터사용하지않는이들이 저 함수 사용한다면?  
		//마찬가지로  Inject를 이용해서 변수 선언해주는게 좋을것같다 그러면 찌꺼기 파일은 존재 X
		HashMap insertdata=new HashMap();
		insertdata.put("CONTENT", content);
		insertdata.put("IDX",idx);
		test.testUpdate(insertdata);
		
		model.addAttribute("list",test.test(idx));
		
		//파일삭제 
		
		for (String string : oldWebAddress) {
			String Imgcheck=	ImgAddressTranslate(string,request);
			
			Filedelete(Paths.get(Imgcheck));
			
			}
		
		
		
		return "test1/home2";
	}
	@RequestMapping(value = "/test4", method = {RequestMethod.GET,RequestMethod.POST})
	public String test4(@RequestParam int idx,Model model){
		
		
//		
		model.addAttribute("list",test.test(idx));
		return "test1/home2";
	}
	
	
	@RequestMapping(value = "/adm", method = RequestMethod.POST)
	public String home2(Locale locale, Model model,HttpServletRequest request,MultipartHttpServletRequest request2) {
		System.out.println(request.getSession().getAttribute("name"));
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println("멀티파트 몇개"+request2.getFiles("uploadFile").size());
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value="/file_uploader",method=RequestMethod.POST)
	@ResponseBody
	public void Fileupload(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException,Exception{

String return1="";
String return2="";
String return3="";
String name = "";
if (ServletFileUpload.isMultipartContent(request)){
    ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
    //UTF-8 인코딩 설정
    uploadHandler.setHeaderEncoding("UTF-8");
    List<FileItem> items= uploadHandler.parseRequest(request);
    //각 필드태그들을 FOR문을 이용하여 비교를 합니다.
    for (FileItem item : items) {
        if(item.getFieldName().equals("callback")) {
            return1 = item.getString("UTF-8");
        } else if(item.getFieldName().equals("callback_func")) {
            return2 = "?callback_func="+item.getString("UTF-8");
        } else if(item.getFieldName().equals("Filedata")) {
            //FILE 태그가 1개이상일 경우
            if(item.getSize() > 0) {
                String ext = item.getName().substring(item.getName().lastIndexOf(".")+1);
                //파일 기본경로
                String defaultPath = request.getServletContext().getRealPath("/");
                //파일 기본경로 _ 상세경로
                String path = defaultPath + "upload" + File.separator;
                 
                File file = new File(path);
                 
                //디렉토리 존재하지 않을경우 디렉토리 생성
                if(!file.exists()) {
                    file.mkdirs();
                }
                //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
                String realname = UUID.randomUUID().toString() + "." + ext;
                ///////////////// 서버에 파일쓰기 /////////////////
                InputStream is = item.getInputStream();
                OutputStream os=new FileOutputStream(path + realname);
                int numRead;
                byte b[] = new byte[(int)item.getSize()];
                while((numRead = is.read(b,0,b.length)) != -1){
                    os.write(b,0,numRead);
                }
                if(is != null)  is.close();
                os.flush();
                os.close();
                ///////////////// 서버에 파일쓰기 /////////////////
                return3 += "&bNewLine=true&sFileName="+name+"&sFileURL=/upload/"+realname;
            }else {
                return3 += "&errstr=error";
            }
        }
    }
}
System.out.println("check");
response.sendRedirect(return1+return2+return3);

	
	
	}
	@RequestMapping("/file_uploader_html5")
	public void file_uploader_html5(HttpServletRequest request, HttpServletResponse response){ 
			
		try { //파일정보
			String sFileInfo = ""; //파일명을 받는다 - 일반 원본파일명 
			String filename = request.getHeader("file-name"); //파일 확장자 
			String filename_ext = filename.substring(filename.lastIndexOf(".")+1); //확장자를소문자로 변경 
			filename_ext = filename_ext.toLowerCase(); //이미지 검증 배열변수 
			String[] allow_file = {"jpg","png","bmp","gif"}; //돌리면서 확장자가 이미지인지 
			int cnt = 0; for(int i=0; i<allow_file.length; i++) {
				if(filename_ext.equals(allow_file[i])){ cnt++; } } //이미지가 아님 
			if(cnt == 0) { 
				PrintWriter print = response.getWriter(); print.print("NOTALLOW_"+filename); 
				print.flush(); print.close(); } 
			else { //이미지이므로 신규 파일로 디렉토리 설정 및 업로드 
					//파일 기본경로 
					//실제 적용시에는 @FileResources로 가져와서 변
					//테스트
					//파일 기본경로 _ 상세경로 
					String dftFilePath = request.getSession().getServletContext().getRealPath("/") +"resources" + File.separator + "Files";
					System.out.println(dftFilePath +"기본경로 테스트");
					String filePath = dftFilePath + File.separator +"temp" + File.separator; 
					File file = new File(filePath); 
					if(!file.exists()) { 
						file.mkdirs(); 
						} 
					String realFileNm = ""; 
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
					String today= formatter.format(new java.util.Date()); 
					realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf(".")); 
					String rlFileNm = filePath + realFileNm; 
					///////////////// 서버에 파일쓰기 ///////////////// 
					InputStream is = request.getInputStream(); 
					OutputStream os=new FileOutputStream(rlFileNm); 
					int numRead; byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
					while((numRead = is.read(b,0,b.length)) != -1){ 
						os.write(b,0,numRead); 
						} 
					if(is != null) { 
						is.close(); 
						} 
					os.flush();
					os.close(); 
					///////////////// 서버에 파일쓰기 ///////////////// // 정보 출력 
					sFileInfo += "&bNewLine=true"; // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함 
					sFileInfo += "&sFileName="+ filename;
					sFileInfo += "&sFileURL="+"/resources/Files/temp/"+realFileNm;
					PrintWriter print = response.getWriter();
					print.print(sFileInfo); 
					print.flush(); 
					print.close(); } } catch (Exception e) { e.printStackTrace(); } }

	
	
	
	
	
	
	
	

	
	public static Path Filetransfer(String FileName,String subroot,HttpServletRequest request){
	    //파일객체생성
		//코딩플러스에 적용할떄는 빈객체 Inject로 이어줄것 
		//FileSystemResource위치와  옮길 위치 고칠것
		String oriDirectory= request.getSession().getServletContext().getRealPath("/") +"resources" + File.separator + "Files"+File.separator+"temp"+File.separator;
		String copyDirectory=request.getServletContext().getRealPath("/")+"resources" + File.separator + "Files"+File.separator+subroot +File.separator+"Images"+File.separator+"Neditor"+File.separator;
        File oriFile = new File(oriDirectory+FileName);
        //복사파일객체생성
        File copyFolder=new File(copyDirectory);
        File copyFile = new File(copyDirectory+FileName);
        if(!copyFolder.isDirectory()){
        	copyFolder.mkdirs();
        }
            
        try {
            	if(oriFile.exists()){
            		
            		if(!copyFile.exists()){
            		
            		Files.copy(oriFile.toPath(), copyFile.toPath());
            		}
            	
            	}
            	
			}catch (IOException e) {
				e.printStackTrace();
			}
            
            return oriFile.toPath();
	}
	
	
	

	public static HashMap<String, ArrayList<String>> test(String Content,String subroot){
		System.out.println("실행?");
		HashMap<String, ArrayList<String>> totalObject=new HashMap<String, ArrayList<String>>();
		
		String[] tempImgAddress=Content.split("<img src=\"/resources");
		
		//   /resources/~의 웹 어드레드 
		
		
		ArrayList<String> webAddress=new ArrayList<String>();
	    ArrayList<String> fileNameAndExtension=new ArrayList<String>();
	    ArrayList<String> transferImgAddress=new ArrayList<String>();
	    String tempaddress=null;
		System.out.println("파일위치");
		for (int i = 1; i < tempImgAddress.length; i++) {
			tempaddress =tempImgAddress[i].substring(0,tempImgAddress[i].indexOf("\""));
			System.out.println(tempImgAddress[i].substring(0,tempImgAddress[i].indexOf("\"")));
			webAddress.add(tempaddress);
			fileNameAndExtension.add(tempaddress.substring(tempaddress.lastIndexOf("/")+1,tempaddress.length()));
//			0에서부터 ~~~~~/~~~/~~~~/ 이러면       마지막 /에서 끊으면 temp 제목만이 아니라 템프폴더만 바꿀수있음  근데 이문제는 폴더만 제대로 갖추어져있으면 temp가 바뀌어서 저장되기떄문에
//			고려할지 생각 
//			tempaddress.substring(0, tempaddress.lastIndexOf("/") ) 
			
			transferImgAddress.add(tempaddress.replaceFirst("temp", subroot+"/Images/Neditor"));
		}
		
		System.out.println("구분선");
		
		
		System.out.println("파일이름과 확장자");
	
	    for (String string : fileNameAndExtension) {
	    	
	    	System.out.println(string);
//			System.out.println(string.substring(string.lastIndexOf("/")+1,string.length()));
//			fileNameAndExtension.add(string);
////	    	System.out.println(string.substring(string.lastIndexOf(File.separator+""),string.length()));
		}
	    
	    
	    System.out.println("진짜 저장될 이미지 장소들");
	    for (String string : transferImgAddress) {
	    	//temp
	    	
//	    	System.out.println(string.replaceFirst("temp", "CD_ARCHIVE"+"/Images/Neditor"));
	    	System.out.println(string+"여기여기요");
//	    	transferImgAddress.add(string.replaceFirst("temp", "CD_ARCHIVE"+"/Images/Neditor"));
		}
	    
	    
	    
	    totalObject.put("webAddress", webAddress);
	    totalObject.put("fileNameAndExtension", fileNameAndExtension);
	    totalObject.put("transferImgAddress", transferImgAddress);
	    
	    return totalObject;
	    
	
	}
	
	public static String ImgAddressTranslate(String check,HttpServletRequest request){
		
		//실제 프로젝트에서는 Inject시켜서 적용할것  그리고 Builder써서할지 생각
		String rootFolder=request.getServletContext().getRealPath("/")+"resources";
		String[] checkArray=check.split("/");
		for (int i = 1; i < checkArray.length; i++) {
				rootFolder+=File.separator+checkArray[i];
				
		}
		return rootFolder;
	}
	
	public static void Filedelete(Path oriFile) throws IOException{
		if(oriFile!=null){
			
		Files.deleteIfExists(oriFile);
		}
	}
	
}
