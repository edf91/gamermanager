package org.jhy.application;

import java.util.List;

import org.jhy.dto.UserDTO;
import org.jhy.utils.InvokeResult;

public interface UserApplication {
	InvokeResult<String> createUser(UserDTO command);

	InvokeResult<List<UserDTO>> listAllUser();

	InvokeResult<String> deleteUserById(String id);

	InvokeResult<String> resetPasswordById(String id);

	InvokeResult<UserDTO> doLogin(UserDTO command);
}
