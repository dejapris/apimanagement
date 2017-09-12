package fr.tm.ima.digitaltour.api;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("fr.tm.ima.digitaltour.api.controller"))
                .paths(regex("/color.*"))
                .build()
                .apiInfo(metaData());
             
    }
    
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "API Management REST API",
                "API Management REST API for Digital Tour",
                "1.0",
                "",
                new Contact("Francois BRUNET & Maximillien HOLLE", "", ""),
               "IMA License Version 2.0",
                "");
        
        return apiInfo;
    }    
}
