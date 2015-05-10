package org.jhy.controller;

import java.util.List;

import javax.inject.Inject;

import org.jhy.application.UserApplication;
import org.jhy.dto.UserDTO;
import org.jhy.utils.InvokeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Inject
	private UserApplication userApplication;
	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public InvokeResult<String> add(UserDTO command){
		return userApplication.createUser(command);
	}
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public InvokeResult<List<UserDTO>> list(){
		return userApplication.listAllUser();
	}
	@ResponseBody
	@RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
	public InvokeResult<String> resetPassword(String id){
		return userApplication.resetPasswordById(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	public InvokeResult<String> del(String id){
		return userApplication.deleteUserById(id);
	}
}
