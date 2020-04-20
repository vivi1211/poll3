package com.briup.apps.poll.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	    
	    @RequestMapping(value="/register")
	    public String hello(){
	        return "register";
	    }
	    
	    
	    @RequestMapping(value="/login")
	    public String login(){
	        return "login";
	    }
	    

	
}
