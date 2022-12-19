package br.com.acrtech.planningpoker.organizacoes;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class OrganizacaoMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizacaoMsApplication.class, args);
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .contact(
                    new Contact()
                        .email("augusto.santana@al.infnet.edu.br")
                        .name("Augusto Cezar Ribeiro Santana")
                        .url("https://github.com/acrsantana"))
                .title("Planning Poker/Organizacao MS")
                .version("1.0")
                .description("Microsserviço de gestão de organizações das cartas")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }


}
