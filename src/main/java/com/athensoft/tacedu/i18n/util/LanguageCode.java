package com.athensoft.tacedu.i18n.util;

public enum LanguageCode {
	en("en", "US"), 
	fr("fr", "CA"), 
	zh("zh", "CN");
	
	private final String langCode;
	private final String countryCode;
	
	private LanguageCode(String langCode, String countryCode) {
		this.langCode = langCode;
		this.countryCode = countryCode;
	}
	
	public String getLangCode() {
		return langCode;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public String getLangCountryCode() {
		return langCode + "_" + countryCode;
	}
	
	
}
