package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.reader;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageQueueService;
import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageReceiver;
import be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.reader.CameraMessageReceiverReaderImpl;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.CameraService;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper.CameraMessageMapper;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CameraServiceReaderImpl implements CameraService {
    private final CameraMessageReceiver cameraMessageReceiver;
    private final CameraMessageMapper cameraMessageMapper;
    private final CameraMessageQueueService cameraMessageQueueService;

    @Autowired
    public CameraServiceReaderImpl(@Qualifier("cameraMessageReceiverReaderImpl") CameraMessageReceiver cameraMessageReceiver,
                                   CameraMessageMapper cameraMessageMapper,
                                   CameraMessageQueueService cameraMessageQueueService) {
        this.cameraMessageReceiver = cameraMessageReceiver;
        this.cameraMessageMapper = cameraMessageMapper;
        this.cameraMessageQueueService = cameraMessageQueueService;
    }

    @PostConstruct
    public void subscribeToCameraMessageReceiver(){
        cameraMessageReceiver.addSubscriber(this);
    }

    @Override
    public void startCameraService(boolean repeat) {
        cameraMessageReceiver.getCameraMessage();
    }

    @Override
    public void pushCameraMessage(CameraMessage message) {
        cameraMessageQueueService.publish(cameraMessageMapper.mapToDto(message));
    }

    public void setSourceFile(String source) {
        ((CameraMessageReceiverReaderImpl)cameraMessageReceiver).setSourceFile(source);
    }
}
