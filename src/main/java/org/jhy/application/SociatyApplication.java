package org.jhy.application;

import java.util.List;

import org.jhy.dto.SociatyDTO;
import org.jhy.utils.InvokeResult;

public interface SociatyApplication {
	
	InvokeResult<String> createSociaty(SociatyDTO command);

	InvokeResult<List<SociatyDTO>> listSociaty();

	InvokeResult<String> deletSociatyById(String id);

	InvokeResult<SociatyDTO> getById(String id);

	InvokeResult<String> update(SociatyDTO command);
}
