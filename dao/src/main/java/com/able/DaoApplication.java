package com.able;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class DaoApplication {

    public static void main(String [] args){
        SpringApplication.run(DaoApplication.class,args);
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)

                .groupName("api_bsd")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coracle.positec.xweb.controller")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("保时得项目RESTful API")
                .description("保时得项目中构建RESTful API")
                .termsOfServiceUrl("")
                .contact("huangbaidong")
                .version("1.0")
                .build();
    }

}
