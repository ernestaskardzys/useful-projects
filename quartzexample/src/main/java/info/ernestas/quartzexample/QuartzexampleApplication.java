package info.ernestas.quartzexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class QuartzexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzexampleApplication.class, args);
	}

}
