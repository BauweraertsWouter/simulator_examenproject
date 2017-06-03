package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageQueueService;
import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageReceiver;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper.CameraMessageMapper;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.timechecker.TimeCheckerService;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 * Implementation of the CameraService. This implementation will generate random CameraMessages.
 */
@Component
public class CameraServiceGeneratorImpl implements CameraService {
    private TimeCheckerService timeCheckerService;
    private CameraMessageReceiver cameraMessageReceiver;
    private CameraMessageMapper cameraMessageMapper;
    private CameraMessageQueueService cameraMessageQueueService;

    private int interval = 100;

    public CameraServiceGeneratorImpl(TimeCheckerService timeCheckerService,
                                      CameraMessageReceiver cameraMessageReceiver,
                                      CameraMessageMapper cameraMessageMapper,
                                      CameraMessageQueueService cameraMessageQueueService) {
        this.timeCheckerService = timeCheckerService;
        this.cameraMessageReceiver = cameraMessageReceiver;
        this.cameraMessageMapper = cameraMessageMapper;
        this.cameraMessageQueueService = cameraMessageQueueService;
    }

    @Autowired


    @Override
    public void startCameraService(boolean repeat) {
        setupTimeCheckerService();
        do{
            try{
                cameraMessageReceiver.getCameraMessage();
                Thread.sleep(interval);
                interval = timeCheckerService.refreshInterval();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }while (repeat);
    }

    @Override
    public void pushCameraMessage(CameraMessage message) {
        CameraMessageDto messageDto = cameraMessageMapper.mapToDto(message);
        cameraMessageQueueService.publish(messageDto);
    }

    private void setupTimeCheckerService() {
        // add some RushHours
    }
}
