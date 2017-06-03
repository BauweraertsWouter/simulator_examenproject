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
     * @param rushHour instance of RushHour to add
     */
    void addRushHour(RushHour rushHour);

    /**
     * This method will check whether a given timestamp is in a rush hour time block. The method returns true if the
     * timestamp is part of a rush hour block and false if not.
     * @param timestamp timestamp to check
     */
    boolean checkRushHour(Date timestamp);

    /**
     * Use this method to set the number of milliseconds between the generation of two CameraMessages in a regular
     * time block
     * @param interval number of milliseconds between generation
     */
    void setRegularTimeBlockInterval(int interval);

    /**
     * Use this method to set the number of milliseconds between the generation of two CameraMessages in a rush hour
     * time block
     * @param interval number of milliseconds between generation
     */
    void serRushHourTimeBlockInterval(int interval);

    /**
     * This methods should be used to refresh the number of milliseconds between the generation of two messages.
     * This method should check whether the current time is in a rush hour block and return the corresponding interval
     * @return int value of the new interval (number of milliseconds between two generated messages)
     */
    int refreshInterval();
}
