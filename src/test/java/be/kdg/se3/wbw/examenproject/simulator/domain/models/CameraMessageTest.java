package be.kdg.se3.wbw.examenproject.simulator.domain.models;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CameraMessageTest {

    private CameraMessage message;

    @Test
    public void createCameraMessageWithBuilderWithgivenTimestamp_getTimestamp_equalsExpectedTimestamp() throws Exception {
        LocalDateTime timestamp = LocalDateTime.now();
        message = new CameraMessage.CameraMessageBuilder()
                .withTimestamp(timestamp)
                .build();
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void createCameraMessageWithBuilderWithGivenLicenseplate_getLicenseplate_equalsExpectedLicenseplate() throws Exception {
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
}