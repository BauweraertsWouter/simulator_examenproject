package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.xml;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageConverter;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CameraMessageConverterXmlImplTest {
    @Test
    public void convertMessage_givenCameraMessage_returnsExpectedString() throws Exception {
        CameraMessageConverter converter = new CameraMessageConverterXmlImpl();
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<camera-message-dto camera-id=\"654\"><timestamp>2017-01-01T08:00:01.000+01:00</timestamp><license-plate>1-ABC-123</license-plate></camera-message-dto>";
        CameraMessageDto message = new CameraMessageDto.CameraMessageDtoBuilder()
                .withTimestamp(Date.from(LocalDateTime.of(2017,1,1,8,0,1).atZone(ZoneId.systemDefault()).toInstant()))
                .withLicensePlate("1-ABC-123")
                .withCameraId(654)
                .build();

        Assertions.assertThat(converter.convertMessage(message)).isEqualTo(expected);
    }
}