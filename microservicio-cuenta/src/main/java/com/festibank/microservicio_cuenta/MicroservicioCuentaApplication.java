package com.festibank.microservicio_cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicioCuentaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MicroservicioCuentaApplication.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);
		//SpringApplication.run(MicroservicioCuentaApplication.class, args);
	}

}
