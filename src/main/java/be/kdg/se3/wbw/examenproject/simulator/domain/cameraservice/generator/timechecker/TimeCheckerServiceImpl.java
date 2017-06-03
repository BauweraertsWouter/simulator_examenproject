package be.kdg.se3.wbw.examenproject.simulator.domain.cameraservice.generator.timechecker;

import be.kdg.se3.wbw.examenproject.simulator.domain.models.RushHour;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TimeCheckerServiceImpl implements TimeCheckerService {
    private final List<RushHour> rushHours = new ArrayList<>();
    private int rushHourInterval=1000;
    private int regularInterval=3000;

    public void addRushHour(RushHour rushHour){
        rushHours.add(rushHour);
    }

    public boolean checkRushHour(Date timestamp){
        LocalTime time = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        return rushHours.stream()
                .anyMatch(e -> e.isRushHour(time));
    }

    public void serRushHourTimeBlockInterval(int rushHourInterval) {
        this.rushHourInterval = rushHourInterval;
    }

    public void setRegularTimeBlockInterval(int regularInterval) {
        this.regularInterval = regularInterval;
    }

    public int refreshInterval() {
        if (checkRushHour(Date.from(Instant.now())))
            return rushHourInterval;
        return regularInterval;
    }
}
