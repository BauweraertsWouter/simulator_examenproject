package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.reader;

import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.CameraService;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import org.springframework.stereotype.Component;

@Component
public class CameraServiceReaderImpl implements CameraService {
    @Override
    public void startCameraService(boolean repeat) {

    }

    @Override
    public void pushCameraMessage(CameraMessage message) {

    }
}
