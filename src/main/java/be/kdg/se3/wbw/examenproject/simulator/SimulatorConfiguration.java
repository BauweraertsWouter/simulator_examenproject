package be.kdg.se3.wbw.examenproject.simulator;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimulatorConfiguration {
    @Bean
    public Queue getQueue() {
        return new Queue("examenproject");
    }
}
