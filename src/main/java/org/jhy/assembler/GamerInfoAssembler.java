package org.jhy.assembler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jhy.domain.GamerInfo;
import org.jhy.domain.Gender;
import org.jhy.domain.Sociaty;
import org.jhy.dto.GamerInfoDTO;

public class GamerInfoAssembler {
	
	public static List<GamerInfoDTO> toDTOs(List<GamerInfo> entities) {
		List<GamerInfoDTO> result = new ArrayList<GamerInfoDTO>();
		for (GamerInfo entity : entities) {
			result.add(toDTO(entity));
		}
		return result;
	}

	public static GamerInfoDTO toDTO(GamerInfo entity) {
		GamerInfoDTO result = new GamerInfoDTO();
		result.setAddress(entity.getAddress());
		result.setEquipmentDTOs(EquipmentAssembler.toDTOs(entity.getEquipments()));
		result.setTotalPrice(entity.getTotalPrice());
		result.setRechargeIds(entity.getRechargeIds());
		result.setBirthDay(entity.getBirthDay() + "");
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setEmail(entity.getEmail());
		result.setGender(entity.getGender().toString());
		result.setDisabled(entity.isDisabled());
		result.setLevel(entity.getLevel());
		result.setMobile(entity.getMobile());
		result.setTelPhone(entity.getTelPhone());
		result.setProfession(entity.getProfession());
		result.setRegTime(entity.getRegTime());
		result.setSociatyId(entity.getSociaty().getId());
		result.setSociatyName(entity.getSociaty().getName());
		return result;
	}

	public static GamerInfo toEntity(GamerInfoDTO dto) {
		GamerInfo result =  new GamerInfo();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			if(dto.getBirthDay() != null && !"".equals(dto.getBirthDay())){
				result.setBirthDay(sdf.parse(dto.getBirthDay()).getTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setAddress(dto.getAddress());
		result.setEmail(dto.getEmail());
		if(null != dto.getGender()){
			if(dto.getGender().equals("MALE")){
				result.setGender(Gender.MALE);
			}else if(dto.getGender().equals("FAMALE")){
				result.setGender(Gender.FAMALE);
			}
		}
		result.setDisabled(dto.isDisabled());
		result.setLevel(dto.getLevel());
		result.setMobile(dto.getMobile());
		result.setName(dto.getName());
		result.setProfession(dto.getProfession());
		result.setRegTime(new Date().getTime());
		result.setTelPhone(dto.getTelPhone());
		if(null != dto.getSociatyId() && !"".equals(dto.getSociatyId())){
			Sociaty sociaty = new Sociaty();
			sociaty.setId(dto.getSociatyId());
			result.setSociaty(sociaty);
		}
		return result;
	}


	public static GamerInfo toUpdateEntity(GamerInfo result,
			GamerInfoDTO dto) {
		result.setAddress(dto.getAddress());
		result.setEmail(dto.getEmail());
		if(null != dto.getGender()){
			if(dto.getGender().equals("MALE")){
				result.setGender(Gender.MALE);
			}else if(dto.getGender().equals("FAMALE")){
				result.setGender(Gender.FAMALE);
			}
		}
		result.setLevel(dto.getLevel());
		result.setMobile(dto.getMobile());
		result.setName(dto.getName());
		result.setProfession(dto.getProfession());
		result.setTelPhone(dto.getTelPhone());
		if(null != dto.getSociatyId() && !"".equals(dto.getSociatyId())){
			Sociaty sociaty = new Sociaty();
			sociaty.setId(dto.getSociatyId());
			result.setSociaty(sociaty);
		}
		return result;
	}

}
