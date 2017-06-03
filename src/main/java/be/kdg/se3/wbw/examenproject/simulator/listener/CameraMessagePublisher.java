package be.kdg.se3.wbw.examenproject.simulator.listener;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * The CameraMessagePublisher interface is the publisher part of the Listener pattern. When you implement this interface,
 * CameraMessageSubscribers can subscribe on this object and they will be notified when the notifySubscribers method
 * is called
 */
public interface CameraMessagePublisher {
    /**
     * Use this method to add a new CameraMessageSubscriber to the collection of subscribers
     * @param subscriber CameraMessageSubscriber to add
     */
    void addSubscriber(CameraMessageSubscriber subscriber);

    /**
     * When this method is called, alle CameraMessageSubscribers subscribed to this instance will be notified
     * @param message the new CameraMessage you want to send to the subscribers
     */
    void notifySubscribers(CameraMessage message);
}
