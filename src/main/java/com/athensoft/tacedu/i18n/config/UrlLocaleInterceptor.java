package com.athensoft.tacedu.i18n.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

public class UrlLocaleInterceptor implements HandlerInterceptor {
	private final Logger LOGGER = LoggerFactory.getLogger(UrlLocaleInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		
		if (localeResolver == null) {
			String errorMessage = "No LocaleResolver found: not in a DispatcherServlet request";
			LOGGER.error(errorMessage);
			throw new IllegalStateException(errorMessage);
		}
//		LOGGER.debug(localeResolver.getClass().getName());
		
		// Get locale from LocaleResolver
//		Locale locale = localeResolver.resolveLocale(request);
//		localeResolver.setLocale(request, response, locale);

		return true;
	}
}
