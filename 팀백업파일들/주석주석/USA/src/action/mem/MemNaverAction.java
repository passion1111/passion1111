package action.mem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import action.Command;
import model.mem.MemDAO;
import model.mem.MemVO;

public class MemNaverAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = null;
		  
	    String clientId = "fRezVk5_Htz8SWJjSj7d";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "2tckaN8GEV";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8080/USA/naver.do", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      str = res.toString();
	      
	      JSONParser parser = new JSONParser();
	      JSONObject json = (JSONObject) parser.parse(str);
	      access_token = (String) json.get("access_token");
	      request.getSession().setAttribute("access_token", access_token);
	      
	      br.close();
	      if(responseCode==200) {
	        //out.println(res.toString());
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    
	   
	    JSONParser parser = new JSONParser();
	    JSONObject json = null;
	    String header = null;
	    String token = null;
	    String email = null;
	     try {
	    	 json = (JSONObject)parser.parse(str);
	    	 token = (String)json.get("access_token");// 네이버 로그인 접근 토큰; 여기에 복사한 토큰값을 넣어줍니다.
	    	 header = "Bearer " + token; // Bearer 다음에 공백 추가
	    	 
	         String apiURL2 = "https://openapi.naver.com/v1/nid/me";
	         URL url = new URL(apiURL2);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("GET");
	         con.setRequestProperty("Authorization", header);
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         if(responseCode==200) { // 정상 호출
	             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {  // 에러 발생
	             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         String inputLine;
	         StringBuffer response2 = new StringBuffer();
	         while ((inputLine = br.readLine()) != null) {
	             response2.append(inputLine);           
	         }
	         br.close();
	         
	         JSONObject json2 = (JSONObject)parser.parse(response2.toString());
	         JSONObject info = (JSONObject)json2.get("response");
	         String id = (String)info.get("id");
	         email = (String)info.get("email");
	         String profile_image = (String)info.get("profile_image");
	         String nickname = (String)info.get("nickname");
	         
	         boolean isId = MemDAO.getInstance().idValidate(id);
	         if(!isId) {
	        	 MemVO vo = new MemVO();
	        	 vo.setMem_pwd(email);
	        	 vo.setMem_id(id);
	        	 vo.setMem_name(nickname);
	        	 vo.setMem_filename(profile_image);
	        	 MemDAO.getInstance().insert(vo);
	         }
	         
	         request.getSession().setAttribute("member", id);
	         request.getSession().setAttribute("nickname", nickname);
	         
	     } catch (Exception e2) {
	         System.out.println(e2);
	     }
	     
	     return "/index.do";
	}

}
