package org.jhy.utils;

public class DataUtil {
	
	public static String[] strToArray(String equipmentIds) {
		if(equipmentIds != null && !"".equals(equipmentIds)){
			return equipmentIds.split(",");
		}
		return null;
	}

}
