package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.xml;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageConverter;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.exolab.castor.xml.Marshaller;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.io.Writer;

@Component
public class CameraMessageConverterXmlImpl implements CameraMessageConverter {
    @Override
    public String convertMessage(CameraMessageDto message) {
        String out = "";
        try{
            Writer writer = new StringWriter();
            Marshaller.marshal(message, writer);
            out = writer.toString();
        }catch (Exception e){
            // do some shit
        }
        return out;
    }
}
