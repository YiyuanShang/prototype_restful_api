package com.athensoft.tacedu.i18n.config;

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.athensoft.tacedu.i18n.util.LangUtil;


public class UrlPathAcceptHeaderLocaleResolver extends AcceptHeaderLocaleResolver{
	private final Logger LOGGER = LoggerFactory.getLogger(UrlPathAcceptHeaderLocaleResolver.class);
	
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale defaultLocale = getDefaultLocale();
		LOGGER.debug("defaultLocale:" + defaultLocale);
		
		if (defaultLocale != null && request.getHeader("Accept-Language") == null) {
			LOGGER.debug("return defaultLocale:" + defaultLocale);
			return defaultLocale;
		}
		Locale requestLocale = request.getLocale();
		List<Locale> supportedLocales = getSupportedLocales();
//		LOGGER.debug("supportedLocales:" + supportedLocales);
		
		if (supportedLocales.isEmpty() || supportedLocales.contains(requestLocale)) {
			LOGGER.debug("return requestLocale:" + requestLocale);
			return requestLocale;
		}
		
		// modified by Marie
		Locale supportedLocale = LangUtil.findLocaleFromRequest(request);
		if (supportedLocale != null) {
			LOGGER.debug("return supportedLocale:" + supportedLocale);
			return supportedLocale;
		}
		return (defaultLocale != null ? defaultLocale : requestLocale);
	}
	
	
}
