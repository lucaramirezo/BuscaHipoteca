package grupo_nueve.buscahipotecas.config;

import java.util.Collections;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuración Swagger para la generación de documentación de la API REST.
 * 
 * http://localhost:8080/swagger-ui
 */
@Configuration
// @OpenAPIDefinition(
//         // info = @Info(
//         //         title = "Claims Service",
//         //         version = "1.0",
//         //         description = "Claims Information"
//         // ),
//         security = {
//                 @SecurityRequirement(name = "bearerAuth")
//         }
// )
// @SecurityScheme(
//         name = "bearerAuth",
//         description = "JWT authentication",
//         scheme = "bearer",
//         type = SecuritySchemeType.HTTP,
//         bearerFormat = "JWT",
//         in = SecuritySchemeIn.HEADER
// )
public class SwaggerConfig {

    // @Bean // Un bean que va a estar disponible en el contendor de bean para
    // cuando
    // // arranque el proyecto.
    // public Docket api() {
    // return new Docket(DocumentationType.SWAGGER_2)
    // .apiInfo(apiDetails())
    // .select()
    // .apis(RequestHandlerSelectors.any())
    // .paths(PathSelectors.any())
    // .build();
    // }

    // private ApiInfo apiDetails() {
    // return new ApiInfo("Spring Boot Buscahipotecas API REST",
    // "Libreria Buscahipotecas Api Rest V1",
    // "1.0",
    // "http://www.google.com",
    // new Contact("Grupo 9", "http://www.google.com", "grupo_nueve_@gmail.com"),
    // "MIT",
    // "http://www.google.com",
    // Collections.emptyList());
    // }

    // @Bean
    // public GroupedOpenApi publicApi() {
    //     return GroupedOpenApi.builder()
    //             .group("public")
    //             .pathsToMatch("/**", "/test/**")
    //             .build();
    // }

    // String schemeName = "bearerAuth";
    // String bearerFormat = "JWT";
    // String scheme = "bearer";

    // @Bean
    // public OpenAPI caseOpenAPI() {
    //     return new OpenAPI()
    //             .addSecurityItem(new SecurityRequirement()
    //                     .addList(schemeName))
    //             .components(new Components()
    //                     .addSecuritySchemes(
    //                             schemeName, new SecurityScheme()
    //                                     .name(schemeName)
    //                                     .type(SecurityScheme.Type.HTTP)
    //                                     .bearerFormat(bearerFormat)
    //                                     .in(SecurityScheme.In.HEADER)
    //                                     .scheme(scheme)))
    //             .info(new Info()
    //                     .title("Case Management Service")
    //                     .description("Claim Event Information")
    //                     .version("1.0"));
    // }

    // @Bean
    // fun customOpenAPI(): OpenAPI {
    //     return OpenAPI()
    //         .info(
    //             Info()
    //                 .title("Demo API")
    //                 .version("1.0.0")
    //                 .description("This is a demo API documented with Swagger and SpringDoc.")
    //         )
    // }
}
