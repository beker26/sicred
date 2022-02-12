package br.com.sicred.demo.config;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    @Value("${sicred.server-context-path}")
    private String serverContextPath;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Pageable.class).groupName("business")
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sicred.demo"))
                .build()
                .pathMapping(serverContextPath)
                .apiInfo(this.metaData())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Receita Federal - Sicred")
                .description("Service Responsavel pela criação de clientes e contas e envios de planilhas com contas por cliente")
                .version("v1")
                .termsOfServiceUrl("https://github.com/beker26/sicred.git")
                .build();
    }


}
