package ma.projet.getewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator getewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/students/**")
						.uri("http://localhost:8081"))
				.route(r -> r.path("/api/courses/**")
						.uri("http://localhost:8082"))
				.build();
	}

}
