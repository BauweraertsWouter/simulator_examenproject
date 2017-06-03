package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.rabbit;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageConverter;
import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageQueueService;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CameraMessageQueueServiceRabbitMqImpl implements CameraMessageQueueService {
    private CameraMessageConverter converter;
    private RabbitTemplate rabbit;
    private Queue queue;

    @Autowired
    public CameraMessageQueueServiceRabbitMqImpl(CameraMessageConverter converter, RabbitTemplate template, Queue queue) {
        this.converter = converter;
        this.rabbit = template;
        this.queue = queue;
    }

    @Override
    public void publish(CameraMessageDto messageDto) {
        String message = converter.convertMessage(messageDto);
        this.rabbit.convertAndSend(queue.getName(), message);
    }
}
