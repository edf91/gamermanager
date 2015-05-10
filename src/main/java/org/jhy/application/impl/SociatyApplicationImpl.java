package org.jhy.application.impl;

import java.util.List;

import javax.inject.Named;

import org.jhy.application.SociatyApplication;
import org.jhy.assembler.SociatyAssembler;
import org.jhy.domain.Sociaty;
import org.jhy.dto.SociatyDTO;
import org.jhy.utils.InvokeResult;
@Named
public class SociatyApplicationImpl extends BaseApplicationImpl<Sociaty> implements SociatyApplication {
	
	public InvokeResult<String> createSociaty(SociatyDTO command) {
		try {
			Sociaty result = SociatyAssembler.toEntity(command);
			if(Sociaty.isNameExist(command.getName())) return InvokeResult.failure("工会名称已经存在");
			this.create(result);
			return InvokeResult.success("创建工会成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("创建工会失败");
		}
	}

	@Override
	public InvokeResult<List<SociatyDTO>> listSociaty() {
		List<Sociaty> result = this.findAll();
		return InvokeResult.success(SociatyAssembler.toDTOs(result));
	}

	@Override
	public InvokeResult<String> deletSociatyById(String id) {
		try {
			this.deleteById(id);
			return InvokeResult.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("删除失败");
		}
	}

	@Override
	public InvokeResult<SociatyDTO> getById(String id) {
		return InvokeResult.success(SociatyAssembler.toDTO(this.get(id)));
	}

	@Override
	public InvokeResult<String> update(SociatyDTO command) {
		try {
			Sociaty sociaty = SociatyAssembler.toEntity(command);
			sociaty.setId(command.getId());
			this.update(sociaty);
			return InvokeResult.success("更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("更新失败");
		}
	}

}
