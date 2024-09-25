package Zoo;

import java.time.LocalTime;
import java.io.File;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main
{
    public static void printAnimal(File f, String a){
        try {
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()){
                String i = scanner.nextLine();
                System.out.println(i);}
        } catch (Exception e) {System.out.printf("There is no animal \"%s\" in the zoo.",a);}
    }
    public static void main(String[] args){

        System.out.println("Which animal would you like to view?");
        Scanner userScanner = new Scanner(System.in);
        String animalType = userScanner.nextLine();
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        Double habitatTemperature = Math.random()*(100-50)+50;

        System.out.printf("Animal Type: %s %nCurrent Time: %s%nHabitat Temperature: %2fF%n%n",animalType,(currentTime.getHour()>12) ? currentTime.minusHours(12)+"PM":currentTime+"AM",habitatTemperature);

        File animal = new File("src/Zoo/"+animalType.toLowerCase()+".txt");
        printAnimal(animal, animalType);
    }
}
