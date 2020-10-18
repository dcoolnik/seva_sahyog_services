package seva.sahyog.sahashiksha.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "seva.sahyog.sahashiksha")
@EnableJpaRepositories("seva.sahyog.sahashiksha.dao")
@EntityScan("seva.sahyog.sahashiksha")
@PropertySource("application-${spring.profiles.active}.properties")
public class SahashikshaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahashikshaApplication.class, args);
	}

}
