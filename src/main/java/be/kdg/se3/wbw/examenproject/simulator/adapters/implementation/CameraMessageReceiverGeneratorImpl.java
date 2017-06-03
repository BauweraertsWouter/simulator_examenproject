package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageReceiver;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.listener.CameraMessageSubscriber;
import org.springframework.stereotype.Component;

@Component
public class CameraMessageReceiverGeneratorImpl implements CameraMessageReceiver {
    @Override
    public void getCameraMessage() {

    }

    @Override
    public void addSubsriber(CameraMessageSubscriber subscriber) {

    }

    @Override
    public void notifySubscribers(CameraMessage message) {

    }
}
