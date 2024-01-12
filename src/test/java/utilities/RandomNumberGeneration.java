package utilities;

import java.util.Random;

public class RandomNumberGeneration {

    public static String randomNumber() {
        Random r = new Random();
        Integer I = r.nextInt();
        String id = I.toString();
        // System.out.println(id);
        return id;
    }

}