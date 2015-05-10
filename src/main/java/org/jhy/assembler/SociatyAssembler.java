package org.jhy.assembler;

import java.util.ArrayList;
import java.util.List;

import org.jhy.domain.Sociaty;
import org.jhy.dto.SociatyDTO;

public class SociatyAssembler {

	public static Sociaty toEntity(SociatyDTO dto) {
		Sociaty result = new Sociaty();
		result.setName(dto.getName());
		result.setDisabled(dto.isDisabled());
		return result;
	}

	public static SociatyDTO toDTO(Sociaty entity){
		SociatyDTO result = new SociatyDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDisabled(entity.isDisabled());
		return result;
		
	}
	public static List<SociatyDTO> toDTOs(List<Sociaty> entities) {
		List<SociatyDTO> results = new ArrayList<SociatyDTO>();
		for (Sociaty entity : entities) {
			results.add(toDTO(entity));
		}
		return results;
	}

}
