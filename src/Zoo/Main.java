package Zoo;

import java.time.LocalTime;
import java.io.File;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args){
        File camel = new File("src/Zoo/camel.txt");
        String animalType = "Camel";
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        Double habitatTemperature = Math.random()*(100-50)+50;
        System.out.printf("Animal Type: %s %nCurrent Time: %s%nHabitat Temperature: %2fF",animalType,(currentTime.getHour()>12) ? currentTime.minusHours(12)+"PM":currentTime+"AM",habitatTemperature);

        try {
            Scanner scanner = new Scanner(camel);
            while (scanner.hasNextLine()){
                String i = scanner.nextLine();
                System.out.println(i);}
       } catch (Exception e) {System.out.println(e);}

    }
}
