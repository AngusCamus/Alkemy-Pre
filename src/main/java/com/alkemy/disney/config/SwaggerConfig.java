<<<<<<< HEAD
package com.alkemy.Disney.config;
=======
package com.alkemy.disney.config;
>>>>>>> test


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(
                DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Spring Boot APIRest ",
                "Disney Alkemy Challenge",
                "1.0",
                "http://google.com",
                new Contact("Brian", "https://google.com", "poleselbrian@gmail.com"),
                        "Pole", "https://google.com", Collections.emptyList());

    }

}
