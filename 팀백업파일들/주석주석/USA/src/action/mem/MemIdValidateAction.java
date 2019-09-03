package action.mem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.mem.MemDAO;

public class MemIdValidateAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String mem_id = request.getParameter("idInfo"); 
		  boolean isId = MemDAO.getInstance().idValidate(mem_id);
		  response.getWriter().print("{\"result\":" + isId + "}");
	}

}
