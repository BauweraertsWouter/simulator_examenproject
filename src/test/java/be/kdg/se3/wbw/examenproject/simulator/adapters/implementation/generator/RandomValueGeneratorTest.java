package be.kdg.se3.wbw.examenproject.simulator.adapters.implementation.generator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomValueGeneratorTest {
    private RandomValueGenerator valueGenerator;

    @Before
    public void setUp() throws Exception {
        valueGenerator = new RandomValueGenerator();
    }

    @Test
    public void getRandomCameraId_generateMultiple_areAllInExpectedRange(){
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 150; i++) {
            randomNumbers.add(valueGenerator.getRandomCameraId(100));
        }

        randomNumbers.forEach(i-> assertThat(i).isBetween(1,100));
    }

    @Test
    public void getRandomLicensePlate_returnedString_matchesExpectedFormat(){
        assertThat(valueGenerator.getRandomLicensePlate()).matches("^[1-9]{1}-[A-Z]{3}-[0-9]{3}$");
    }

    @Test
    public void getRandomLicensePlate_compareWithOtherRandomLicencePlate_AreNotEqual() throws Exception {
        assertThat(valueGenerator.getRandomLicensePlate()).isNotEqualTo(valueGenerator.getRandomLicensePlate());
    }
}