package org.jhy.application.impl;

import java.util.List;

import javax.inject.Named;

import org.jhy.application.EquipmentApplication;
import org.jhy.assembler.EquipmentAssembler;
import org.jhy.domain.Equipment;
import org.jhy.dto.EquipmentDTO;
import org.jhy.utils.InvokeResult;
@Named
public class EquipmentApplicationImpl extends BaseApplicationImpl<Equipment> implements EquipmentApplication{

	@Override
	public InvokeResult<String> createEquip(EquipmentDTO command) {
		try {
			this.create(EquipmentAssembler.toEntity(command));
			return InvokeResult.success("创建装备成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("添加装备失败");
		}
	}

	@Override
	public InvokeResult<String> deleteEquipById(String id) {
		try {
			this.deleteById(id);
			return InvokeResult.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("删除失败");
		}
	}

	@Override
	public InvokeResult<List<EquipmentDTO>> listAll() {
		return InvokeResult.success(EquipmentAssembler.toDTOs(this.findAll()));
	}

	@Override
	public InvokeResult<EquipmentDTO> getById(String id) {
		return InvokeResult.success(EquipmentAssembler.toDTO(this.get(id)));
	}

	@Override
	public InvokeResult<String> update(EquipmentDTO command) {
		try {
			Equipment equipment = EquipmentAssembler.toEntity(command);
			equipment.setId(command.getId());
			this.update(equipment);
			return InvokeResult.success("更新装备成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("更新装备失败");
		}
	}
	
	

}
