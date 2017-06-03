package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.timechecker;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.RushHour;

import java.util.Date;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * The TimeCheckerService interface is the base for checking time. We need to be able to add rush hour periods and our
 * application needs to be able to check whether a given time is in a rush hour time block. This interface will only be
 * used in the generation mode of the simulator application.
 */
public interface TimeCheckerService {
    /**
     * This method can be used to add a rush hour time block to the collection of rush hours
     * @param rushHour
     */
    void addRushHour(RushHour rushHour);

    /**
     * This method will check wheter a given timestamp is in a rush hour timeblock. The method returns true if the
     * timestamp is part of a rush hour block and false if not.
     * @param timestamp
     */
    boolean checkRushHour(Date timestamp);

    /**
     * Use this method to set the number of milliseconds between the generation of two CameraMessages in a regular
     * time block
     * @param interval
     */
    void setRegularTimeBlockInterval(int interval);

    /**
     * Use this method to set the number of milliseconds between the generation of two CameraMessages in a rush hour
     * time block
     * @param interval
     */
    void serRushHourTimeBlockInterval(int interval);
}
