package org.jhy.controller;

import java.util.List;

import javax.inject.Inject;

import org.jhy.application.GamerInfoApplication;
import org.jhy.dto.GamerInfoDTO;
import org.jhy.utils.InvokeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/gamer")
public class GamerInfoController {
	@Inject
	private GamerInfoApplication gamerInfoApplication;
	
	@ResponseBody
	@RequestMapping(value = "/get",method = RequestMethod.POST)
	public InvokeResult<GamerInfoDTO> get(String id){
		return gamerInfoApplication.getGamerById(id);
	}
	// 分配装备
	@ResponseBody
	@RequestMapping(value = "/grantEquip",method = RequestMethod.POST)
	public InvokeResult<String> grantEquip(String id,String equipId,int num){
		return gamerInfoApplication.grantEquip(id,equipId,num);
	}
	// 充值
	@ResponseBody
	@RequestMapping(value = "/recharge",method = RequestMethod.POST)
	public InvokeResult<String> recharge(String id,double price){
		return gamerInfoApplication.recharge(id,price);
	}
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public InvokeResult<List<GamerInfoDTO>> list(){
		return gamerInfoApplication.listAllGamers();
	}
	@ResponseBody
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	public InvokeResult<String> delete(String id){
		return gamerInfoApplication.deleteGamerById(id);
	}
	@ResponseBody
	@RequestMapping(value =  "/add",method = RequestMethod.POST)
	public InvokeResult<String> add(GamerInfoDTO command){
		return gamerInfoApplication.createGamer(command);
	}
	@ResponseBody
	@RequestMapping(value =  "/update",method = RequestMethod.POST)
	public InvokeResult<String> update(GamerInfoDTO command){
		return gamerInfoApplication.createUpdate(command);
	}
}
