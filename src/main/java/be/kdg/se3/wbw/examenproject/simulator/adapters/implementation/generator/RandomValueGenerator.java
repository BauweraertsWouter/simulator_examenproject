package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.generator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomValueGenerator {
    private Random random = new Random();

    int getRandomCameraId(int upperBound) {
        return random.nextInt(upperBound) + 1;
    }

    String getRandomLicensePlate() {
        StringBuilder licensePlateBuilder = new StringBuilder();

        licensePlateBuilder.append(random.nextInt(8) + 1);
        licensePlateBuilder.append("-");
        licensePlateBuilder.append(getRandomLetters());
        licensePlateBuilder.append("-");
        licensePlateBuilder.append(getRandomNumbers());

        return licensePlateBuilder.toString();
    }

    private String getRandomLetters() {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            letters.append((char) (random.nextInt(26) + 65));
        }
        return letters.toString();
    }

    private String getRandomNumbers() {
        return String.format("%3d", random.nextInt(1000)).replace(' ', '0');
    }
}
