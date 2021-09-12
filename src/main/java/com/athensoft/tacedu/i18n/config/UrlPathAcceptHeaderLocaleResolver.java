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

public class UrlPathAcceptHeaderLocaleResolver extends AcceptHeaderLocaleResolver {
	private final Logger LOGGER = LoggerFactory.getLogger(UrlPathAcceptHeaderLocaleResolver.class);

	/**
	 * get locale object by locale info: of default locale set by program, from
	 * request header in http request object from client from request URL with
	 * specified language info
	 *
	 * priority order of locale to apply from highest to lowest: 
	 * locale by request URL
	 * locale by request header 
	 * default locale
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		// get locale by request URL
		// modified by Marie
		Locale supportedLocale = LangUtil.findLocaleFromRequest(request);
		if (supportedLocale != null) {
//			LOGGER.debug("return supportedLocale in url:" + supportedLocale);
			return supportedLocale;
		}
		
		// get locale by request header 
		Locale requestLocale = request.getLocale();
		List<Locale> supportedLocales = getSupportedLocales();
//		LOGGER.debug("supportedLocales:" + supportedLocales);
//		LOGGER.debug("requestLocale:" + requestLocale);
		
		if (!supportedLocales.isEmpty() && supportedLocales.contains(requestLocale) && request.getHeader("Accept-Language") != null) {
//			LOGGER.debug("return requestLocale:" + requestLocale);
			return requestLocale;
		}

		// get locale by default locale
		Locale defaultLocale = getDefaultLocale();

		if (defaultLocale != null) {
//			LOGGER.debug("return defaultLocale:" + defaultLocale);
			return defaultLocale;
		}

//		LOGGER.debug("return defaultLocale final:" + defaultLocale);
		return (defaultLocale != null ? defaultLocale : requestLocale);

	}

}
