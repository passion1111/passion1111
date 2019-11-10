package com.mhlab.userauth.controller;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mhlab.userauth.service.SecretService;
import com.mhlab.userauth.util.SupportUtil;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {

	@Inject
	private SecretService secretService;
	
	/**
	 * �넗�겙 �젙蹂대�� 媛��졇���꽌 �럹�씠吏��뿉�꽌 蹂댁뿬以��떎. 
	 * @param request HttpServletRequest 媛� 
	 * @param model Model 媛앹껜
	 * @return �솕硫� �럹�씠吏� 
	 */
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String getBoardMain(HttpServletRequest request,  Model model,HttpSession session){
		session.setAttribute("dd", 213);
		session.removeAttribute("dd");
		session.
		System.out.println(session.getAttribute("dd"));
		//�꽭�뀡�뿉�꽌 媛믪쓣 媛��졇�삩�떎.
		String loginId = (String)request.getSession().getAttribute("loginId");
		String tokenStr = (String)request.getSession().getAttribute("tokenStr");
		
		if(tokenStr!= null && loginId != null){
			String tokenValidMsg = secretService.validToken(tokenStr, loginId);
			if(tokenValidMsg.equals("Pass")){ //�넗�겙 寃�利앹쓣 留덉튇 寃쎌슦�뿉留� �넗�겙 �젙蹂대�� 異쒕젰�븳�떎.
				Map<String, Object> tokenPayload = secretService.getTokenPayload(tokenStr);
				model.addAttribute("tokenSub", tokenPayload.get("sub"));
				model.addAttribute("tokenAud", tokenPayload.get("aud"));
				model.addAttribute("tokenJti", tokenPayload.get("jti"));
				model.addAttribute("tokenIss", tokenPayload.get("iss"));
				model.addAttribute("tokenExDate", SupportUtil.getDateObj2String(new Date(Long.valueOf((Integer)tokenPayload.get("exp"))*1000), 2, ""));
			}
			model.addAttribute("tokenMsg", tokenValidMsg);
			model.addAttribute("loginId", loginId);
			model.addAttribute("tokenValue", tokenStr);
		}
		else{model.addAttribute("loginId", "no-login");} //濡쒓렇�씤 �릺�뼱 �엳吏� �븡�� 寃쎌슦
		return "/board/main";
	}
	
}
