package com.deepakshankar.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/*@EnableSwagger2*/
public class PostsApplication {

    /*@Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }*/

    /*private ApiInfo apiInfo() {
        return new ApiInfo(
                "Posts Rest API",
                "REST API documentation for Posts backend service",
                "Snapshot",
                "Terms of service",
                new Contact("Deepak Shankar", "https://deepakshankar.com", "shankar.deepak22@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }*/

    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }

}
