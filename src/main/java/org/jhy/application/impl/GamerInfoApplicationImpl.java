package org.jhy.application.impl;

import java.util.List;

import javax.inject.Named;

import org.jhy.application.GamerInfoApplication;
import org.jhy.assembler.GamerInfoAssembler;
import org.jhy.domain.Equipment;
import org.jhy.domain.GamerInfo;
import org.jhy.domain.Recharge;
import org.jhy.dto.GamerInfoDTO;
import org.jhy.utils.InvokeResult;
@Named
public class GamerInfoApplicationImpl extends BaseApplicationImpl<GamerInfo> implements GamerInfoApplication{
	
	public InvokeResult<List<GamerInfoDTO>> listAllGamers() {
		List<GamerInfo> results = this.findAll();
		return InvokeResult.success(GamerInfoAssembler.toDTOs(results));
	}
	
	@Override
	public InvokeResult<String> createUpdate(GamerInfoDTO command) {
		try {
			GamerInfo newGamerInfo = GamerInfoAssembler.toUpdateEntity(this.get(command.getId()),command);
			this.update(newGamerInfo);
			return InvokeResult.success("更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("更新失败");
		}
	}

	public InvokeResult<String> createGamer(GamerInfoDTO command) {
		try {
			GamerInfo result = GamerInfoAssembler.toEntity(command);
			this.create(result);
			return InvokeResult.success("添加玩家" + command.getName() + "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("添加玩家" + command.getName() + "失败");
		}
	}

	@Override
	public InvokeResult<String> deleteGamerById(String id) {
		try {
			this.deleteById(id);
			return InvokeResult.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("删除失败");
		}
	}

	
	@Override
	public InvokeResult<String> recharge(String id, double price) {
		try {
			GamerInfo gamerInfo = this.get(id);
			Recharge recharge = new Recharge();
			recharge.setPrice(price);
			recharge.save();
			String ids = "";
			if(gamerInfo.getRechargeIds() != null && !"".equals(gamerInfo.getRechargeIds())){
				ids += gamerInfo.getRechargeIds() + ",";
			}
			ids += recharge.getId();
			gamerInfo.setRechargeIds(ids);
			gamerInfo.setTotalPrice(gamerInfo.getTotalPrice() + price);
			this.update(gamerInfo);
			return InvokeResult.success("充值成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("充值失败");
		}
	}

	@Override
	public InvokeResult<String> grantEquip(String id, String equipId,
			int num) {
		try {
			GamerInfo gamerInfo = this.get(id);
			Equipment equipment = Equipment.get(Equipment.class, equipId);
			StringBuilder ids = new StringBuilder("");
			if(gamerInfo.getEquipmentIds() != null && !"".equals(gamerInfo.getEquipmentIds())){
				ids.append(gamerInfo.getEquipmentIds() + ",");
			}
			for (int i = 0; i < num; i++) {
				ids.append(equipment.getId() + ",");
			}
			if(!"".equals(ids.toString())){
				ids.delete(ids.length() - 1, ids.length());
			}
			gamerInfo.setEquipmentIds(ids.toString());
			gamerInfo.update();
			return InvokeResult.success("分配装备成功");
		} catch (Exception e) {
			e.printStackTrace();
			return InvokeResult.failure("分配装备失败");
		}
	}

	@Override
	public InvokeResult<GamerInfoDTO> getGamerById(String id) {
		return InvokeResult.success(GamerInfoAssembler.toDTO(get(id)));
	}

}
