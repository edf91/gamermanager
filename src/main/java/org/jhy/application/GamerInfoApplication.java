package org.jhy.application;

import java.util.List;

import org.jhy.dto.GamerInfoDTO;
import org.jhy.utils.InvokeResult;

public interface GamerInfoApplication{
	
	InvokeResult<List<GamerInfoDTO>> listAllGamers();

	InvokeResult<String> createGamer(GamerInfoDTO command);

	InvokeResult<String> deleteGamerById(String id);

	InvokeResult<String> recharge(String id, double price);

	InvokeResult<String> grantEquip(String id, String equipId, int num);

	InvokeResult<GamerInfoDTO> getGamerById(String id);

	InvokeResult<String> createUpdate(GamerInfoDTO command);

}
