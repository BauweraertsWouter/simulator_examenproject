package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.xml;

import be.kdg.se3.wbw.examenproject.simulator.adapters.api.CameraMessageConverter;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessage;
import be.kdg.se3.wbw.examenproject.simulator.domain.models.CameraMessageDto;
import org.apache.log4j.Logger;
import org.exolab.castor.xml.Marshaller;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.io.Writer;

@Component
public class CameraMessageConverterXmlImpl implements CameraMessageConverter {
    private static final Logger logger = Logger.getLogger(CameraMessageConverterXmlImpl.class);
    @Override
    public String convertMessage(CameraMessageDto message) {
        String out = "";
        try{
            Writer writer = new StringWriter();
            Marshaller.marshal(message, writer);
            out = writer.toString();
        }catch (Exception e){
            logger.warn("Something went wrong while converting a CameraMessageDto to XML");
        }
        return out;
    }
}
