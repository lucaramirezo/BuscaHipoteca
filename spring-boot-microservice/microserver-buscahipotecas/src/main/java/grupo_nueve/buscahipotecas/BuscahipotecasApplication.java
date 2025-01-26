package grupo_nueve.buscahipotecas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class BuscahipotecasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscahipotecasApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("BuscaHipoteca API")
						.version("0.9")
						.description("API for BuscaHipoteca microservice"));
	}

}
