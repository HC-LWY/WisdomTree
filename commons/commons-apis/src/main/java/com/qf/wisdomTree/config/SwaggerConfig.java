package com.qf.wisdomTree.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@Configuration
//@EnableSwagger2
//@EnableKnife4j
@EnableSwagger2WebMvc
public class SwaggerConfig {



//    knife4j  2.0配置

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("智慧大棚2.0")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.qf.wisdomTree.controller"))
                //这里指定扫描有ApiOperation注解的类
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //所有路径
                .paths(PathSelectors.any())
                //不包含^/inner/.*的路径
                //.paths(input -> !input.matches("^/inner/.*"))
                .build();
        return docket;
    }


//    knife4j  3.0配置
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.qf.controller.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }



//    @Bean
    public Docket createRestApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.qf.controller"))
                //为有@Api注解的Controller生成API文档
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("智慧大棚接口文档")
                .description("HC")
                .contact(new Contact("昏晨","西部硅谷","2198919944@qq.com"))
                .version("1.0")
                .build();
    }




}
