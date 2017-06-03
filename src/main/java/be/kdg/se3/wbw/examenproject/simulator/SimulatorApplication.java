package be.kdg.se3.wbw.examenproject.simulator;

import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.CameraService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimulatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SimulatorApplication.class, args);
		((CameraService) context.getBean("cameraServiceGeneratorImpl")).startCameraService(true);
	}
}
