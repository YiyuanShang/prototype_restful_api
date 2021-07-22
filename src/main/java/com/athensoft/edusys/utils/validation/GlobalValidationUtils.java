package com.athensoft.edusys.utils.validation;

public class GlobalValidationUtils {
	public static boolean isEmptyStr(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
