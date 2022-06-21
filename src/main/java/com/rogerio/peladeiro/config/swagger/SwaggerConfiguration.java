package com.rogerio.peladeiro.config.swagger;

import com.rogerio.peladeiro.modelo.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket peladeiroApi() {
        // Configura como Springfox vai ler nossa API para documentar.
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rogerio.peladeiro"))
                .paths(PathSelectors.ant("/**"))        // todos os paths serão lidos
                .build()
                .ignoredParameterTypes(Usuario.class)          // ignorar Usuário
                .globalOperationParameters(Arrays.asList(
                new ParameterBuilder()
                        .name("Authorization")                      // nome do cabeçalho
                        .description("Header para token JWT")       // descrição de que é esse parametro
                        .modelRef(new ModelRef("string"))      // tipo do parâmetro (string, int, etc)
                        .parameterType("header")          // o parâmetro é do tipo cabeçalho
                        .required(false)                            // param opcional
                        .build()));
    }
}
