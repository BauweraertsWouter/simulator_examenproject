package be.kdg.se3.wbw.examenproject.simulator.domain.models;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CameraMessageTest {

    private CameraMessage message;

    @Test
    public void createCameraMessageWithBuilderWithGivenTimestamp_getTimestamp_equalsExpectedTimestamp() throws Exception {
        Date timestamp = getTimestamp(2017,6,3,8,15,23);
        message = new CameraMessage.CameraMessageBuilder()
                .withTimestamp(timestamp)
                .build();
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void createCameraMessageWithBuilderWithGivenLicensePlate_getLicensePlate_equalsExpectedLicensePlate() throws Exception {
        String plate = "1-RJF-728";
        message = new CameraMessage.CameraMessageBuilder()
                .withLicensePlate(plate)
                .build();
        assertThat(message.getLicensePlate()).isEqualTo(plate);
    }

    @Test
    public void createCameraMessageWithBuilderWithGivenCameraId_getCameraId_equalsExpectedId() throws Exception {
        int id = 15;
        message = new CameraMessage.CameraMessageBuilder()
                .withCameraId(id)
                .build();
        assertThat(message.getCameraId()).isEqualTo(id);
    }

    private Date getTimestamp(int year, int month, int day, int hour, int minute, int second) {
        return Date.from(
                LocalDateTime.of(year, month, day, hour, minute, second)
                        .atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}