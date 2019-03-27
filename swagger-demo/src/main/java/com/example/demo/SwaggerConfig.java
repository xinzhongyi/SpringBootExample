package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder sessionIdPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        sessionIdPar.name("SESSIONID").description("用户 sessionid")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();
        pars.add(sessionIdPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, errorList())
                .globalResponseMessage(RequestMethod.POST, errorList())
                .globalResponseMessage(RequestMethod.PUT, errorList())
                .globalResponseMessage(RequestMethod.DELETE, errorList());
    }

    private List<ResponseMessage> errorList() {

        List<ResponseMessage> errorList = new ArrayList<ResponseMessage>();

        errorList.add(new ResponseMessageBuilder().code(400).message("Some error message")
                .responseModel(new ModelRef("string")).build());

        errorList.add(new ResponseMessageBuilder().code(401).message("Some error message")
                .responseModel(new ModelRef("string")).build());

        errorList.add(new ResponseMessageBuilder().code(404).message("Some error message")
                .responseModel(new ModelRef("string")).build());

        return errorList;
    }

    @Bean(value = "publicApi")
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.ant("/notSessionId/*"))
                .build().groupName("无需token验证").ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                .version("1.0")
                .build();
    }

}
