package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.springframework.stereotype.Component;

@Component
public class CameraMessageMapperImpl implements CameraMessageMapper {
    @Override
    public CameraMessageDto mapToDto(CameraMessage message) {
        return new CameraMessageDto.CameraMessageDtoBuilder()
                .withTimestamp(message.getTimestamp())
                .withLicensePlate(message.getLicensePlate())
                .withCameraId(message.getCameraId())
                .build();
    }
}
