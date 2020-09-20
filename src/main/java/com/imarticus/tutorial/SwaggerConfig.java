package com.imarticus.tutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import static springfox.documentation.builders.PathSelectors.ant;

import java.util.Collections;
import java.util.List;

import static com.google.common.base.Predicates.or;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {    
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        		  .apiInfo(apiInfo())
		          .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(pathsToBeDocumented())
		          .build()
		          .securitySchemes(getSecuritySchemes())
		          .securityContexts(getSecurityContexts());
    }
   
	
    private List<SecurityScheme> getSecuritySchemes() {
        return Collections.singletonList(new ApiKey("Authorization", "Authorization", "header"));
    }
    
    private List<SecurityContext> getSecurityContexts() {
        SecurityContext context = SecurityContext.builder()
            .securityReferences(getSecurityReferences())
            .forPaths(pathsToBeSecured())
            .build();

        return Collections.singletonList(context);
    }

    private List<SecurityReference> getSecurityReferences() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{
            new AuthorizationScope("admin", "admin users"),
            new AuthorizationScope("user", "regular users")
        };

        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }
    
    
    private Predicate<String> pathsToBeDocumented() {
        return or(
                ant("/user/**"),
                pathsToBeSecured()
            );
    }
    
    
    private Predicate<String> pathsToBeSecured() {
        return or(
            ant("/books/**")
        );
    }

    


/*
    
    @Bean
    public SecurityConfiguration getSecurityConfig() {
    return SecurityConfigurationBuilder.builder().scopeSeparator(",")
        .additionalQueryStringParams(null)
        .useBasicAuthenticationWithAccessCodeGrant(false).build();
    }
    */
    
    
    private ApiInfo apiInfo() {
 	   return new ApiInfoBuilder().title("Books API")
	            .description("Book Management REST API")
	            .contact("Imarticus")
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
 }


    
}
