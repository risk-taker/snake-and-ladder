package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Getter
public class Dice {
    private int diceCount;
    private int minValue;
    private int maxValue;

    public int roll() {
        int totalSum = 0;
        for (int i = 0; i < diceCount; i++) {
            totalSum += ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
        }
        return totalSum;
    }
}
