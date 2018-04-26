package com.apicrm.service.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.JsonObject;

public class RequiredChecker {
	public static String requiredCheck(ArrayList<String> requiredFields,JsonObject jsonObject) {
		Set<String> returnString = new HashSet<String>();
		for(String requiredField : requiredFields) {
			if(null != jsonObject.get(requiredField)) {
				if(jsonObject.get(requiredField).isJsonNull()) {
					returnString.add(requiredField);
				}
				if(!jsonObject.get(requiredField).isJsonNull() && jsonObject.get(requiredField).getAsString().equals("")) {
					returnString.add(requiredField);
				}
			} else {
				returnString.add(requiredField);
			}
		}
		if(returnString.size() > 0) {
			return String.join(",", returnString);
		}
		
		return null;
	}
}
