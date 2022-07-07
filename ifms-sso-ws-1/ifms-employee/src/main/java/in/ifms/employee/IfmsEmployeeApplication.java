package in.ifms.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Same as @SpringBootConfiguration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
public class IfmsEmployeeApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IfmsEmployeeApplication.class, args);
		SpringApplication application = new SpringApplication(IfmsEmployeeApplication.class);
		//for turning off the default start-up banner
		// application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
