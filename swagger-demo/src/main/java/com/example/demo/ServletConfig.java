package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@Profile({"prod", "test"})
public class ServletConfig extends WebMvcConfigurationSupport {
	private static final Logger LOG = LoggerFactory.getLogger(ServletConfig.class);
	private static final String[] EXCLUE_PATH = {"/swagger-resources/**", "/webjars/**", "/swagger-ui.html/**"};

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptorAdapter() {

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				String sessionid = request.getHeader("SESSIONID");

				if (StringUtils.isEmpty(sessionid)) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					return false;
				}

				LOG.info("got sessionid : {}", sessionid);
				return true;
			}

			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

			}
		}).addPathPatterns("/**").excludePathPatterns(EXCLUE_PATH);
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
