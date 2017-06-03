package be.kdg.se3.wbw.examenproject.simulator.adapters.api;

import be.kdg.se3.wbw.examenproject.simulator.listener.CameraMessagePublisher;

/**
 * @author Wouter Bauweraerst
 * @version 1.0
 * The CameraMessageReceiver is responsible for receiving new CameraMessage instances.
 * This interface extends CameraMessagePublisher.
 * Interested objects can subscribe to be notified when a new CameraMessage is available when they implement
 * the CameraMessageSubscriber interface.
 */
public interface CameraMessageReceiver extends CameraMessagePublisher {
    void getCameraMessage();
}
