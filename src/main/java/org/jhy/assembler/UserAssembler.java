package org.jhy.assembler;

import java.util.ArrayList;
import java.util.List;

import org.jhy.domain.User;
import org.jhy.dto.UserDTO;

public class UserAssembler {

	public static User toEntity(UserDTO command) {
		User result = new User();
		result.setEmail(command.getEmail());
		result.setUserAccount(command.getUserAccount());
		return result;
	}
	
	public static List<UserDTO> toDTOs(List<User> entities){
		List<UserDTO> results = new ArrayList<UserDTO>();
		for (User entity : entities) {
			results.add(toDTO(entity));
		}
		return results;
	}
	public static UserDTO toDTO(User entity){
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUserAccount(entity.getUserAccount());
		result.setEmail(entity.getEmail());
		result.setDisabled(entity.isDisabled());
		return result;
	}
	
	
}
