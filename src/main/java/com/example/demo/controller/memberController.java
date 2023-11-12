package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.memberMapper;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class memberController {
	@Autowired
	private memberMapper mM;
	@Autowired
	private HttpServletResponse hsr;
	@Autowired
	private HttpSession sess;
	
	@RequestMapping("addMember")
	public void addMember(String memberNO,String name, String username,String password,String address) throws IOException {
		member s = mM.queryUsername(username);
		if(s!=null) {
			hsr.sendRedirect("addMemberError.html");
			//Fail
		}else {
			member t = new member();
			t.setMemberNO(memberNO);
			t.setName(name);
			t.setUsername(username);
			t.setPassword(password);
			t.setAddress(address);
			mM.addMember(t);
			hsr.sendRedirect("addMemberSuccess.html");
		}
	}
	
	@RequestMapping("queryUsername")
	public member queryUsername(String username) {
		return mM.queryUsername(username);
	}
	
	@RequestMapping("memberLogin")
	public ModelAndView memberLogin(String username ,String password) {
		member s = mM.queryUser(username, password);
		ModelAndView mav;
		if(s!=null) {
			sess.setAttribute("M", s);
			mav=new ModelAndView("memberLoginSuccess");
			return mav;
		}else {
			mav=new ModelAndView("memberLoginError");
			return mav;
		}
	}
	
	@RequestMapping("memberUpdate")
	public ModelAndView memberUpdate() {
		ModelAndView mav = new ModelAndView("memberUpdate");
		return mav;
	}@RequestMapping("memberDataShow")
	public ModelAndView memberDataShow() {
		ModelAndView mav = new ModelAndView("memberDataShow");
		return mav;
	}@RequestMapping("memberLoginSuccess")
	public ModelAndView memberLoginSuccess() {
		ModelAndView mav = new ModelAndView("memberLoginSuccess");
		return mav;
	}
	
	@RequestMapping("memberUpdateGo")
	public ModelAndView memberUpdate(String name, String password,String address) {
		member m = (member) sess.getAttribute("M");
		String memberNO = m.getMemberNO();
		String username = m.getUsername();
		mM.updateMember(memberNO, name, password, address, username);
		member m2 = mM.queryUsername(m.getUsername());
		sess.setAttribute("M", m2);
		ModelAndView mav = new ModelAndView("memberUpdateSuccess");
		return mav;
	}
}
