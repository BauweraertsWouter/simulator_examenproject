package be.kdg.se3.wbw.examenproject.simulator.adapters.api;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * This interface is used to convert a CameraMessage to a String format. This string will be published on the queue
 */
public interface CameraMessageConverter {
    /**
     * This method converts the CameraMessage to a String
     * @param message CameraMessage that has to be converted to a String representation
     * @return the String that will be published on the queue
     */
    String convertMessage(CameraMessageDto message);
}
