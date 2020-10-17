package seva.sahyog.sahashiksha.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "seva.sahyog.sahashiksha")
public class SahashikshaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahashikshaApplication.class, args);
	}

}
