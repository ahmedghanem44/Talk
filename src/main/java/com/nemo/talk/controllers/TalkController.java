package com.nemo.talk.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nemo.talk.entities.Talk;
import com.nemo.talk.services.TalkService;
import com.nemo.talk.services.TalkServiceInterface;

@Controller
//@ComponentScan("com.nemo.talk")
@RequestMapping("/talks")
public class TalkController {
	
	@Autowired
	private TalkServiceInterface talkService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
//	@GetMapping("/list")
	public @ResponseBody List<Talk> getTalks(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		return talkService.findTalks();	
	}
	
	@RequestMapping(value="/talk/{id}", method=RequestMethod.GET)
	public @ResponseBody Talk getTalk(@PathVariable int id) {
		return talkService.findTalk(id);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Talk addTalk(@RequestBody Talk talk) {
		talkService.newTalk(talk);
		return talk ;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE,headers = "Accept=application/json")
	public @ResponseBody String deleteTalk(@PathVariable int id) {
		talkService.removeTalk(id);
		
		return "This Talk has been successfully deleted";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String editTalk(@RequestBody Talk talk) {
		talkService.editTalk(talk);
		return "updated";
	}

}
