package Jay.dev.PCCAPITEST;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Documentation",
				version = "v1",
				description = "Description of your API",
				contact = @Contact(name = "Your Name", email = "youremail@example.com")
		)
)
public class PccapitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PccapitestApplication.class, args);
	}

}
