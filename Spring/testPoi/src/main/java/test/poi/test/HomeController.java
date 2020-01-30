package test.poi.test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/poi")
	public void testPoi(HttpServletResponse response) {
		
		ArrayList<String> data=new ArrayList<String>();
		data.add("1");
		data.add("2");
		data.add("3");
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.createSheet("1");
		Row row=null;
		Cell cell=null;
		int rowNo=0;
		row=sheet.createRow(rowNo++);
		cell=row.createCell(0);
		cell.setCellValue("테스트");
		cell=row.createCell(1);
		cell.setCellValue("테스트2");
		row=sheet.createRow(rowNo++);
		cell=row.createCell(0);
		cell.setCellValue(data.get(0));
		cell=row.createCell(1);
		cell.setCellValue(data.get(1));
		
		row=sheet.createRow(rowNo++);
		cell=row.createCell(0);
		cell.setCellValue(data.get(2));
		
		 response.setContentType("ms-vnd/excel");
		 response.setHeader("Content-Disposition", "attachement;filename=test.xls");
		 try {
			wb.write(response.getOutputStream());
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
		
		
		
		
		
	}
	
}
