package br.com.contaazul.nasa.mars;

import br.com.contaazul.nasa.mars.entity.Robot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RobotControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotControllerApplication.class, args);
	}
}
