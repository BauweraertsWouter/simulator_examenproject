package be.kdg.se3.wbw.examenproject.simulator.domain.models;

import java.time.LocalDateTime;

public class CameraMessage {
    private final LocalDateTime timestamp;
    private final int cameraId;
    private final String licensePlate;

    private CameraMessage(LocalDateTime timestamp, int cameraId, String licensePlate) {
        this.timestamp = timestamp;
        this.cameraId = cameraId;
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getTimestamp() { return timestamp; }

    public int getCameraId() { return cameraId; }

    public String getLicensePlate() { return licensePlate; }

    public static class CameraMessageBuilder{
        private LocalDateTime timestamp = LocalDateTime.now();
        private int cameraId = 0;
        private String licensePlate = "1-ABC-123";

        public CameraMessageBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public CameraMessageBuilder withCameraId(int cameraId) {
            this.cameraId = cameraId;
            return this;
        }

        public CameraMessageBuilder withLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public CameraMessage build(){ return new CameraMessage(timestamp, cameraId, licensePlate); }
    }
}
