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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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
import com.coding.platform.util.file.FileUtil;
import com.coding.web.notice.service.noticeService;
	
/**
 * Handles requests for the application home page.
 */
@Controller
public class CopyOfHomeController {
	@Autowired
	testInterface test;
	@Resource(name="fileUtil")
	FileUtil fileUtil;
	
	@Inject
	private FileSystemResource fsResource;	//DI
	@Autowired
	private noticeService noticeService;
	
	private static final Logger logger = LoggerFactory.getLogger(CopyOfHomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/deletecheck", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		
		String[] check=(request.getParameterValues("delete_list")==null)? null :request.getParameterValues("delete_list");
		String[] check2=null;
		
		System.out.println(String.valueOf(check2) +"여기는체크23");
		for (String string : check) {
			System.out.println(string);
		}
		System.out.println(request.getParameter("name222"));
				
			
		return "home";
	}
	
}
