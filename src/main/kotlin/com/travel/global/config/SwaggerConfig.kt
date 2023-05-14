package com.travel.global.config

import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.function.Predicate

/**
 * API UI테스트를 위한 설정
 */
@Configuration
class SwaggerConfig {
    private fun testDocket(groupName: String, selector: Predicate<String>): Docket {
        return Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo(groupName)) // ApiInfo 설정
                .apiInfo(apiInfo()) // ApiInfo 설정
                .useDefaultResponseMessages(false)
                .groupName("testApi")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.travel.*.controller"))
                .paths(PathSelectors.ant("/api/**")).build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("제목")
                .description("설명")
//                .version(version)
                .contact(Contact("이름", "홈페이지 URL", "e-mail"))
                .build()
    }
}