package Jay.dev.PCCAPITEST;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "SSO TEST",
				version = "v2",
				description = "SSO TEST APIS",
				contact = @Contact(name = "JAY", email = "Jeditale@hotmail.com")
		)
)
public class PccapitestApplication {
	public static void main(String[] args) {
		SpringApplication.run(PccapitestApplication.class, args);
	}
}
