package com.cuidar.configuration;


import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {

    /**
     * A Anotação @Bean indica que o método é um bean, ou seja, um objeto que pode
     * ser injetado em qualquer ponto da sua aplicação.
     */
    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        /**
         * Cria um Objeto da Classe OpenAPI, que gera a documentação no Swagger
         * utilizando a especificação OpenAPI.
         *
         */

        return new OpenAPI()
                .info(new Info().title("CriarApplication").description("Projeto de API criado para a ONG Instituto Criar" +
                                " para auxiliar nos processos internos de gerenciamento de pacientes,desenvolvido por mim :), Jonathan")
                        .version("v0.0.1")
                        .license(new License().name("Não definido").url("https://github.com/jonathanhenriques"))
                        .contact(new Contact().name("Jonathan").url("https://www.linkedin.com/in/jonathan-henrique-/")
                                .email("silva.henriquejonas@gmail.com")))
                .externalDocs(
                        new ExternalDocumentation().description("Github").url("https://github.com/jonathanhenriques/"))


                /**
                 * Configura o Componente OpenApi Aqui declaramos que o token será pedido para
                 * todas as operações no Swagger da aplicação
                 *
                 * @return
                 */
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme()
                        .name(securitySchemeName).type(SecurityScheme.Type.HTTP).scheme("bearer")
                        .description(
                                "Forneça o Token JWT. JWT token pode ser obtido ao fazer login na API. Credenciais para testes <strong>madruguinha/12345678</strong> futuramente...")
                        .bearerFormat("JWT")));
    }

    /**
     * A Classe OpenApiCustomiser permite personalizar o Swagger, baseado na
     * Especificação OpenAPI. O Método abaixo, personaliza todas as mensagens HTTP
     * Responses (Respostas das requisições) do Swagger.
     */
    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

            }));
        };
    }

    /**
     * O Método createApiResponse() adiciona uma descrição (Mensagem), em cada
     * Resposta HTTP.
     */
    private ApiResponse createApiResponse(String message) {

        return new ApiResponse().description(message);

    }


}