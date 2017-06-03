package be.kdg.se3.wbw.examenproject.simulator.listener;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * This interface is the subscriber part of the custom Observer implementation.
 * Subscribers will be notified when CameraMessagePublisher they subscribed on publishes a new CameraMessage.
 */
public interface CameraMessageSubscriber {
    /**
     * This method will be called by the Publisher when he publishes a new CameraMessage.
     * This will trigger the CameraMessageSubscriber to perform the necessary actions.
     * @param message the CameraMessage that has to be handled by this CameraMessageSubscriber
     */
    void pushCameraMessage(CameraMessage message);
}