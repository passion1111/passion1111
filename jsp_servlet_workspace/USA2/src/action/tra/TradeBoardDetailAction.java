package action.tra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Command;
import model.tra.TradeBoardDAO;
import model.tra.TradeBoardVO;

public class TradeBoardDetailAction  implements Command{
	

	
	public String execute(HttpServletRequest request,
				 HttpServletResponse response) { 
		
			try {
				request.setCharacterEncoding("UTF-8");
			int num=Integer.parseInt(request.getParameter("num"));
			System.out.println(num+"너어어어어엄");
				TradeBoardDAO dao=new TradeBoardDAO();
				dao.updateCount(num);
				TradeBoardVO vo=new TradeBoardVO();
				vo=dao.getDetail(num);
				
				
		
				
					
				
				System.out.println(vo.getBoard_num()+"蹂대뱶�꽆踰꾪솗�씤");
				
				
				if(vo==null) {
					
					return "/view/tra/list.jsp";
				}
				request.setAttribute("vo", vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   		
		   	System.out.println("맞아??");
	   		return "/view/tra/Content.jsp";

		 }
	}

