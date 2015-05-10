package org.jhy.application.impl;

import java.util.List;

import javax.inject.Named;

import org.jhy.application.UserApplication;
import org.jhy.assembler.UserAssembler;
import org.jhy.domain.User;
import org.jhy.dto.UserDTO;
import org.jhy.utils.InvokeResult;
@Named
public class UserApplicationImpl extends BaseApplicationImpl<User> implements UserApplication{

	@Override
	public InvokeResult<String> createUser(UserDTO command) {
		try {
			this.create(UserAssembler.toEntity(command));
			return InvokeResult.success("创建用户成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("创建失败");
		}
	}

	@Override
	public InvokeResult<List<UserDTO>> listAllUser() {
		return InvokeResult.success(UserAssembler.toDTOs(this.findAll()));
	}

	@Override
	public InvokeResult<String> deleteUserById(String id) {
		try {
			this.deleteById(id);
			return InvokeResult.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("删除失败");
		}
	}

	@Override
	public InvokeResult<String> resetPasswordById(String id) {
		try {
			this.get(id).resetPassword();
			return InvokeResult.success("重置密码成功，初始密码为" + User.INIT_PASSWORD);
		} catch (Exception e) {
			return InvokeResult.failure("重置密码失败");
		}
	}

	@Override
	public InvokeResult<UserDTO> doLogin(UserDTO command) {
		User user = UserAssembler.toEntity(command);
		if(user.doLogin()){
			return InvokeResult.success(UserAssembler.toDTO(user));
		}
		return InvokeResult.failure("用户名或密码错误");
	}
	
}
