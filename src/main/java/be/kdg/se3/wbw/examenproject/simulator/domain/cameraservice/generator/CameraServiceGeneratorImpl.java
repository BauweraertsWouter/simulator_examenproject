package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.generator;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageQueueService;
import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageReceiver;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.CameraService;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper.CameraMessageMapper;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.generator.timechecker.TimeCheckerService;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.RushHour;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author Wouter Bauweraerts
 * @version 1.0
 *          Implementation of the CameraService. This implementation will generate random CameraMessages.
 */
@Component
public class CameraServiceGeneratorImpl implements CameraService {
    private static final Logger logger = Logger.getLogger(CameraServiceGeneratorImpl.class);

    private final TimeCheckerService timeCheckerService;
    private final CameraMessageReceiver cameraMessageReceiver;
    private final CameraMessageMapper cameraMessageMapper;
    private final CameraMessageQueueService cameraMessageQueueService;

    private int interval = 100;

    @Autowired
    public CameraServiceGeneratorImpl(TimeCheckerService timeCheckerService,
                                      CameraMessageReceiver cameraMessageReceiver,
                                      CameraMessageMapper cameraMessageMapper,
                                      CameraMessageQueueService cameraMessageQueueService) {
        this.timeCheckerService = timeCheckerService;
        this.cameraMessageReceiver = cameraMessageReceiver;
        this.cameraMessageMapper = cameraMessageMapper;
        this.cameraMessageQueueService = cameraMessageQueueService;
    }

    @PostConstruct
    private void subscribeToCameraMessageReceiver(){
        cameraMessageReceiver.addSubscriber(this);
    }

    @Override
    public void startCameraService(boolean repeat) {
        do {
            try {
                cameraMessageReceiver.getCameraMessage();
                Thread.sleep(interval);
                interval = timeCheckerService.refreshInterval();
            } catch (InterruptedException e) {
                logger.warn("Something went wrong while this thread was sleeping");
            }
        } while (repeat);
    }

    @Override
    public void pushCameraMessage(CameraMessage message) {
        logger.info("Pushing new CameraMessage to the queue");
        CameraMessageDto messageDto = cameraMessageMapper.mapToDto(message);
        cameraMessageQueueService.publish(messageDto);
    }

    public void setupTimeCheckerService(int regularInterval, int rushHourInterval, RushHour... rushHours) {
        timeCheckerService.setRegularTimeBlockInterval(regularInterval);
        timeCheckerService.serRushHourTimeBlockInterval(rushHourInterval);
        Arrays.stream(rushHours)
                .forEach(r -> timeCheckerService.addRushHour(r));
    }
}
