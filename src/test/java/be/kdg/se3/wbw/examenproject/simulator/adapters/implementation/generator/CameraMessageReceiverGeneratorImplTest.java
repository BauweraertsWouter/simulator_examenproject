package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.generator;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.listener.CameraMessageSubscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CameraMessageReceiverGeneratorImplTest {
    @InjectMocks
    private CameraMessageReceiverGeneratorImpl cameraMessageReceiver;

    @Mock
    private RandomValueGenerator randomValueGenerator;

    @Mock
    private CameraMessageSubscriber subscriber;

    @Test
    public void getCameraMessage_verifySubscriberIsNotifiedWithGeneratedMessage() throws Exception {
        cameraMessageReceiver.addSubscriber(subscriber);

        cameraMessageReceiver.getCameraMessage();

        verify(subscriber).pushCameraMessage(any(CameraMessage.class));
    }

    @Test
    public void setUpperBound_thenGetMessage_randomValueGeneratorIsCalledWithNewUpperBound(){
        cameraMessageReceiver.setUpperBoundCameraId(150);
        cameraMessageReceiver.getCameraMessage();
        verify(randomValueGenerator).getRandomCameraId(150);
    }
}