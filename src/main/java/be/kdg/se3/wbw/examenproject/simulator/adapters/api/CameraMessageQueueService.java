package be.kdg.se3.wbw.examenproject.simulator.adapters.api;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * The CameraMessageQueueService will connect to and publish CameraMessageDtos on a AMQP message broker
 */
public interface CameraMessageQueueService {
    /**
     * This method will publish the given CameraMessageDto on the queue
     * @param messageDto CameraMessageDto to publish
     */
    void publish(CameraMessageDto messageDto);
}
