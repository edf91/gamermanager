package org.jhy.controller;

import java.util.List;

import javax.inject.Inject;

import org.jhy.application.EquipmentApplication;
import org.jhy.dto.EquipmentDTO;
import org.jhy.utils.InvokeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/equip")
public class EquipmentController {
	@Inject
	private EquipmentApplication equipmentApplication;
	
	@ResponseBody
	@RequestMapping(value = "/get",method = RequestMethod.POST)
	public InvokeResult<EquipmentDTO> get(String id){
		return equipmentApplication.getById(id);
	}
	@ResponseBody
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public InvokeResult<String> update(EquipmentDTO command){
		return equipmentApplication.update(command);
	}
	@ResponseBody
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public InvokeResult<String> add(EquipmentDTO command){
		return equipmentApplication.createEquip(command);
	}
	@ResponseBody
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	public InvokeResult<String> del(String id){
		return equipmentApplication.deleteEquipById(id);
	}
	@ResponseBody
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public InvokeResult<List<EquipmentDTO>> list(){
		return equipmentApplication.listAll();
	}
}
