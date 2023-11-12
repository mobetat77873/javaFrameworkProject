package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.porderMapper;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;
import com.example.demo.vo.queryMemberPorder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class porderController {
	@Autowired
	private porderMapper pM;
	@Autowired
	private HttpSession sess;
	@Autowired
	private HttpServletRequest hsr;
	
	@RequestMapping("addPorder")
	public ModelAndView addPorder(String memberNO, String productNO, int amount) {
		porder p = new porder();
		member m =(member)sess.getAttribute("M");
		p.setAmount(amount);p.setPorderNO();
		p.setMemberNO(m.getMemberNO());p.setProductNO(productNO);
		sess.setAttribute("P", p);
		ModelAndView mav = new ModelAndView("porder/addPorderConfirm");
		return mav;
	}
	@RequestMapping("porder")
	public ModelAndView Porder() {
		ModelAndView mav = new ModelAndView("porder/porder");
		return mav;
	}
	@RequestMapping("addPorderPage")
	public ModelAndView addPorderPage() {
		ModelAndView mav = new ModelAndView("porder/addPorderPage");
		return mav;
	}
	@RequestMapping("addPorderFinish")
	public ModelAndView addPorderFinish() {
		porder p = (porder)sess.getAttribute("P");
		pM.addPorder(p);
		ModelAndView mav = new ModelAndView("porder/addPorderFinish");
		return mav;
	}
	@RequestMapping("addPorderConfirm")
	public ModelAndView addPorderConfirm() {
		ModelAndView mav = new ModelAndView("porder/addPorderConfirm");
		return mav;
	}
	@RequestMapping("queryPorder")
	public ModelAndView queryPorder() {
		member m =(member) sess.getAttribute("M");
		List<queryMemberPorder> l = new ArrayList();
		l= pM.queryMemberAllPorder(m.getMemberNO());
		//l=pM.queryMemberAllPorder(memberNO);
		sess.setAttribute("L", l);
		System.out.println(l);
		
		ModelAndView mav = new ModelAndView("porder/queryPorder");
		return mav;
	}
	@RequestMapping("deletePorder")
	public ModelAndView deletePorder() {
		ModelAndView mav = new ModelAndView("porder/deletePorder");
		return mav;
	}
	@RequestMapping("delete")
	public ModelAndView delete(int porderNO) {
		
		pM.delete(porderNO);
		ModelAndView mav = new ModelAndView("porder/deletePorderConfirm");
		return mav;
	}
}
