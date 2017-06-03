package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.rabbit;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageConverter;
import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageQueueService;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CameraMessageQueueServiceRabbitMqImpl implements CameraMessageQueueService {
    private CameraMessageConverter converter;

    @Autowired
    public CameraMessageQueueServiceRabbitMqImpl(CameraMessageConverter converter) {
        this.converter = converter;
    }

    @Override
    public void publish(CameraMessageDto messageDto) {

    }
}
