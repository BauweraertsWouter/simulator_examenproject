package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.reader;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageReceiver;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.mapper.CameraMessageMapper;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.exceptions.FailedMapperException;
import be.kdg.se3.wbw.examenproject.simulator.listener.CameraMessageSubscriber;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Component
public class CameraMessageReceiverReaderImpl implements CameraMessageReceiver {
    private static final Logger logger = Logger.getLogger(CameraMessageReceiverReaderImpl.class);

    private String source;
    private List<CameraMessageSubscriber> subscribers;
    private CameraMessageMapper mapper;

    @Autowired
    public CameraMessageReceiverReaderImpl(CameraMessageMapper mapper) {
        this.mapper = mapper;
        subscribers = new ArrayList<>();
    }

    @Override
    public void getCameraMessage() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new ClassPathResource(source).getInputStream())
        )){
            String line;
            while ((line = reader.readLine()) != null){
                CameraMessage msg = mapper.csvToCameraMessage(line);
                subscribers.forEach((s)->s.pushCameraMessage(msg));
            }
        } catch (IOException e) {
            logger.warn("Something went wrong while reading from file. Reading stopped");
        } catch (FailedMapperException e){
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void addSubscriber(CameraMessageSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(CameraMessage message) {
        subscribers.forEach(s->s.pushCameraMessage(message));
    }

    public void setSourceFile(String source){this.source = source;}
}
