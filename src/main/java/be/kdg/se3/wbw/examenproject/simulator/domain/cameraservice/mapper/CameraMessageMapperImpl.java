package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Override
    public CameraMessage csvToCameraMessage(String csv) {
        CameraMessage cameraMessage = null;
        String[] splitted = csv.split(",");
        try {
            Date timestamp = Date.from(
                    LocalDateTime.parse(splitted[0], DateTimeFormatter.ofPattern("yyyy-M-d H:m:s"))
                            .atZone(ZoneId.systemDefault())
                            .toInstant()
            );
            int cameraId = Integer.parseInt(splitted[1]);
            String licensePlate = splitted[2];
            cameraMessage = new CameraMessage.CameraMessageBuilder()
                    .withTimestamp(timestamp)
                    .withCameraId(cameraId)
                    .withLicensePlate(licensePlate)
                    .build();
        }catch (Exception e){
            //Do some shit
        }
        return cameraMessage;
    }
}
