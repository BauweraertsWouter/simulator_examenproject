package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import be.kdg.se3.wbw.examenproject.simulator.exceptions.FailedMapperException;

import java.util.IllegalFormatException;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * The CameraMessageMapper is able to map a CameraMessage to a CameraMessageDto
 */
public interface CameraMessageMapper {
    /**
     * This method will convert a CameraMessage to a CameraMessageDto
     * @param message the CameraMessage to convert
     * @return a new CameraMessageDto
     */
    CameraMessageDto mapToDto(CameraMessage message);
    CameraMessage csvToCameraMessage(String csv) throws FailedMapperException;
}
