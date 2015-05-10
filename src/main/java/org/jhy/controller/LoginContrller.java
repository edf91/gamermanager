package org.jhy.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.jhy.application.UserApplication;
import org.jhy.dto.UserDTO;
import org.jhy.utils.InvokeResult;
import org.jhy.utils.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/user")
public class LoginContrller {

	@Inject
	private UserApplication userApplication;
	@ResponseBody
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public InvokeResult<UserDTO> login(UserDTO command,HttpSession session){
		InvokeResult<UserDTO> result = userApplication.doLogin(command);
		if(!result.isHasError()){
			SessionUser value =  new SessionUser();
			value.setId(result.getData().getId());
			value.setUserAccount(result.getData().getUserAccount());
			session.setAttribute(SessionUser.SESSION_USER_NAME, value);
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public InvokeResult<String> logout(HttpSession session){
		if(session.getAttribute(SessionUser.SESSION_USER_NAME) != null){
			session.invalidate();
			return InvokeResult.success("注销成功");
		}
		return InvokeResult.failure("注销失败");
	}
}
