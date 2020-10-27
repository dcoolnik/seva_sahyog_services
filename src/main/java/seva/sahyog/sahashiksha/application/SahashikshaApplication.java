package seva.sahyog.sahashiksha.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "seva.sahyog.sahashiksha")
@EnableJpaRepositories("seva.sahyog.sahashiksha.dao")
@EntityScan("seva.sahyog.sahashiksha")
@PropertySource("application-${spring.profiles.active}.properties")
@EnableSwagger2
public class SahashikshaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahashikshaApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("seva.sahyog.sahashiksha")).build();
	}

}
