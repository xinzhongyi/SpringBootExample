package com.spring.session.dh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: sks
 * Date: 2019/3/14
 * Time: 15:51
 * Description:
 * \
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
public class SessionConfig {
}
