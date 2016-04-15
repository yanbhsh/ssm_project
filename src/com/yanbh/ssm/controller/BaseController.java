package com.yanbh.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/a")
public class BaseController {

	/**
	 * Action 内部跳转
	 * @param url
	 * @return
	 */
	public ModelAndView redirect(String url){
		return new ModelAndView("redirect:"+url);
	}
	
}
