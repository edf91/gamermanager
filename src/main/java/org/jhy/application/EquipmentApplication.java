package org.jhy.application;

import java.util.List;

import org.jhy.dto.EquipmentDTO;
import org.jhy.utils.InvokeResult;

public interface EquipmentApplication {

	InvokeResult<String> createEquip(EquipmentDTO command);

	InvokeResult<List<EquipmentDTO>> listAll();

	InvokeResult<String> deleteEquipById(String id);

	InvokeResult<EquipmentDTO> getById(String id);

	InvokeResult<String> update(EquipmentDTO command);
	
}
