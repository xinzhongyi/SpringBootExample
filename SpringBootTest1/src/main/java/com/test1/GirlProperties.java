package com.test1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/24.
 */
@Component
@ConfigurationProperties(prefix="girl")
@Data
@EqualsAndHashCode
public class GirlProperties {
    private String name ;
    private Integer age ;
}
