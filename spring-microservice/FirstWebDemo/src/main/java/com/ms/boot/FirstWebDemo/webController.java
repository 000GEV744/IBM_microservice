package com.ms.boot.FirstWebDemo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("welcome/page")
public class webController {
	

	
	@RequestMapping(path="/default", method=RequestMethod.GET)
	public String renderDefaultWeb(Model mod) {
		mod.addAttribute("welcome","Sonali web page!"+new Date());
		return "index";
		
	}

	@RequestMapping(path= "/webdetails", method=RequestMethod.GET)
	public String getWebDetailsMessage(Model mod) {
		//Greeting webgreeting =new Greeting("Hello","Sonali Trying Greeting", new Date());
		mod.addAttribute("greeting",  "Hi Tinni this is new page by web contolleer") ;
		return "index" ;
	}
	
	

}
