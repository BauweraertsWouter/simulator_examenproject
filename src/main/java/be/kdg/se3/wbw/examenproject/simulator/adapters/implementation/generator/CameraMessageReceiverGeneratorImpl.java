package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.generator;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageReceiver;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.listener.CameraMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class CameraMessageReceiverGeneratorImpl implements CameraMessageReceiver {
    private List<CameraMessageSubscriber> subscribers;
    private RandomValueGenerator randomValueGenerator;
    private int upperBoundCameraId = 100;

    @Autowired
    public CameraMessageReceiverGeneratorImpl(RandomValueGenerator randomValueGenerator) {
        this.subscribers = new ArrayList<>();
        this.randomValueGenerator = randomValueGenerator;
    }

    @Override
    public void getCameraMessage() {
        CameraMessage message = new CameraMessage.CameraMessageBuilder()
                .withCameraId(randomValueGenerator.getRandomCameraId(upperBoundCameraId))
                .withLicensePlate(randomValueGenerator.getRandomLicensePlate())
                .build();
        notifySubscribers(message);
    }

    @Override
    public void addSubscriber(CameraMessageSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(CameraMessage message) {
        subscribers.forEach(s->s.pushCameraMessage(message));
    }

    public void setUpperBoundCameraId(int upperBound){this.upperBoundCameraId = upperBound;}
}
