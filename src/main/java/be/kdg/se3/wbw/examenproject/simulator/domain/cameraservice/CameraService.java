package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice;

import be.kdg.se3.wbw.examenproject.simulator.listener.Subscriber;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * The CameraService interface is the base of the simulator application.
 * Two implementations will be provided for the different operation modes
 */
public interface CameraService extends Subscriber {
    /**
     * This method starts the CameraService. It will trigger the CameraMessageReceiver to start receiving messages.
     */
    void startCameraService(boolean repeat);
}
