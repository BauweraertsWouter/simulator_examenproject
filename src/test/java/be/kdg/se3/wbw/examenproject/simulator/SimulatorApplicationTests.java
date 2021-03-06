package be.kdg.se3.wbw.examenproject.simulator;

import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.CameraService;
import be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.reader.CameraServiceReaderImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimulatorApplicationTests {

	@Autowired
	@Qualifier("cameraServiceGeneratorImpl")
	private CameraService cameraServiceGenerator;

	@Autowired
    @Qualifier("cameraServiceReaderImpl")
    private CameraService cameraServiceReader;

	@Test
	public void contextLoads() {
	}

//	@Test
//    public void startGenerating(){
//	    cameraServiceGenerator.startCameraService(true);
//    }

    @Test
    public void startReading(){
        ((CameraServiceReaderImpl)cameraServiceReader).setSourceFile("default.csv");
        cameraServiceReader.startCameraService(true);
    }

}
