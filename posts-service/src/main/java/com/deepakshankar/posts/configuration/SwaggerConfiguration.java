/*
 * Copyright (c) 2019. Deepak Ravi Shankar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.deepakshankar.posts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author deepak created on 9/8/19
 * @version 1.0.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private static String TITLE = "Posts - CMS Application";
    private static String DESCRIPTION = "A backend application to serve the CMS application";
    private static String VERSION = "1.0.0-ALPHA";
    private static String TOSURL = "";
    private static String NAME = "Deepak R Shankar";
    private static String URL = "https://deepakshankar.com";
    private static String EMAIL = "shankar.deepak22@gmail.com";
    private static String LICENSE = "Apache License 2.0";
    private static String LICENSEURL = "http://www.apache.org/licenses/LICENSE-2.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(TITLE, DESCRIPTION, VERSION, TOSURL,contact(), LICENSE, LICENSEURL, Collections.emptyList());
    }

    private Contact contact() {
        return new Contact(NAME, URL, EMAIL);
    }
}
