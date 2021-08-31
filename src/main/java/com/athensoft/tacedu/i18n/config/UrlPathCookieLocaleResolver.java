package com.athensoft.tacedu.i18n.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.athensoft.tacedu.i18n.util.LangUtil;



public class UrlPathCookieLocaleResolver extends CookieLocaleResolver{
	public Locale resolveUrlPathLocale(HttpServletRequest request) {
		System.out.println("entering overriden resolveLocale");
		Locale locale = super.resolveLocale(request);
		
		System.out.println("locale before:" + locale);
		System.out.println("processed by " + this.getClass());
		
		locale = LangUtil.findLocaleFromRequest(request);
		
		System.out.println("locale after:" + locale + "\n");
		return locale;
	}
	
}
