package org.jhy.controller;

import java.util.List;

import javax.inject.Inject;

import org.jhy.application.SociatyApplication;
import org.jhy.dto.SociatyDTO;
import org.jhy.utils.InvokeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sociaty")
public class SociatyController {
	
	@Inject
	private SociatyApplication sociatyApplication;
	
	@ResponseBody
	@RequestMapping(value = "/get",method = RequestMethod.POST)
	public InvokeResult<SociatyDTO> get(String id){
		return sociatyApplication.getById(id);
	}
	@ResponseBody
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public InvokeResult<String> update(SociatyDTO command){
		return sociatyApplication.update(command);
	}
	@ResponseBody
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	public InvokeResult<String> del(String id){
		return sociatyApplication.deletSociatyById(id);
	}
	@ResponseBody
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public InvokeResult<String> add(SociatyDTO command){
		return sociatyApplication.createSociaty(command);
	}
	
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public InvokeResult<List<SociatyDTO>> list(){
		return sociatyApplication.listSociaty();
	}
}
