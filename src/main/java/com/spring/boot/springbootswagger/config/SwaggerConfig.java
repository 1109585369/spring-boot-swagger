package com.spring.boot.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author yy
 * @ProjectName spring-boot-swagger
 * @Description: TODO
 * @date 2018/12/10 11:17
 */
@Component
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                // .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                // .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
                .apis(RequestHandlerSelectors.basePackage("com.spring.boot.springbootswagger.controller")) //过滤的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("yy","https://github.com/", "");
        return new ApiInfoBuilder()
                .title("演示 Swagger 的用法") // 标题
                .description("演示Swagger中各种注解的用法") // 描述信息
                .version("1.1.2") // //版本
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

}
