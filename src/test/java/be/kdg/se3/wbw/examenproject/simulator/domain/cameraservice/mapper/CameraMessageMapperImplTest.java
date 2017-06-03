package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class CameraMessageMapperImplTest {
    @Test
    public void mapToDto_givenCameraMessage_equalsExpectedCameraMessageDto() throws Exception {
        CameraMessageMapper mapper = new CameraMessageMapperImpl();
        Date timestamp = Date.from(Instant.now());
        String licensPlate = "1-ABC-321";
        int cameraId = 25;

        CameraMessage message = new CameraMessage.CameraMessageBuilder()
                .withCameraId(cameraId)
                .withLicensePlate(licensPlate)
                .withTimestamp(timestamp)
                .build();
        CameraMessageDto expected = new CameraMessageDto.CameraMessageDtoBuilder()
                .withCameraId(cameraId)
                .withLicensePlate(licensPlate)
                .withTimestamp(timestamp)
                .build();

        Assertions.assertThat(mapper.mapToDto(message)).isEqualToComparingFieldByField(expected);
    }
}