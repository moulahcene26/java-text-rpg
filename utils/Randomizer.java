package utils;
import java.util.Random;

public class Randomizer {
    private static final Random rand = new Random();

    public static int getRandomInt(int min, int max){
        return rand.nextInt((max-min)+1) + min;
    }
}