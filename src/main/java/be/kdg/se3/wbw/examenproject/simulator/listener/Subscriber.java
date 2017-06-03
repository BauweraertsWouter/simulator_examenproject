package be.kdg.se3.wbw.examenproject.simulator.listener;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * This interface is the subscriber part of the custom Observer implementation.
 * Subscribers will be notified when an event occurs within a Publisher they subscribed on.
 */
public interface Subscriber {
    /**
     * This method will be called by the Publisher when an event occurs.
     * This will trigger the Subscriber to handle this.
     * @param message the CameraMessage that has to be handled by this Subscriber
     */
    void pushCameraMessage(CameraMessage message);
}