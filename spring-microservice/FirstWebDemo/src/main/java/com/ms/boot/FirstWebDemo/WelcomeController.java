package com.ms.boot.FirstWebDemo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
	@Value("${welcomeprop}")
	private String welcomeProp;
	
	@RequestMapping(path= "/default", method=RequestMethod.GET)
	public String getDefaultMessage() {
		return "Hello!! Tinni..this is my first Spring Web Boot APP";
	}
	
	@RequestMapping(path= "/details", method=RequestMethod.GET)
	public Greeting getDetailsMessage() {
		return new Greeting("Hello","Sonali Trying Greeting", new Date()) ;
	}
	
	@RequestMapping(path="/config/{name}", method=RequestMethod.GET)
	public String getDefaultConfigMessage(@PathVariable String name) {
		
		return welcomeProp+"::"+name;
		
	}
	
	

}
