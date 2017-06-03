package be.kdg.se3.wbw.examenproject.simulator.adapters.api;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.springframework.stereotype.Component;

@Component
public class CameraMessageQueueServiceRabbitMqImpl implements CameraMessageQueueService {
    @Override
    public void publish(CameraMessageDto messageDto) {

    }
}
