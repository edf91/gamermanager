package org.jhy.assembler;

import java.util.ArrayList;
import java.util.List;

import org.jhy.domain.Equipment;
import org.jhy.dto.EquipmentDTO;

public class EquipmentAssembler {

	public static Equipment toEntity(EquipmentDTO command) {
		Equipment result = new Equipment();
		result.setName(command.getName());
		result.setQuality(command.getQuality());
		result.setPrice(command.getPrice());
		return result;
	}
	public static List<EquipmentDTO> toDTOs(List<Equipment> entities){
		List<EquipmentDTO> results = new ArrayList<EquipmentDTO>();
		for (Equipment entity : entities) {
			results.add(toDTO(entity));
		}
		return results;
	}
	public static EquipmentDTO toDTO(Equipment entity){
		EquipmentDTO result = new EquipmentDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setQuality(entity.getQuality());
		return result;
	}
}
