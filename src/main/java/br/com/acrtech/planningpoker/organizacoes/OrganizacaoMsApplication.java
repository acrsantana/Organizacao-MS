package br.com.acrtech.planningpoker.organizacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrganizacaoMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizacaoMsApplication.class, args);
    }

}
