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

        int userIntent = 1;
        while (userIntent == 1) {
            System.out.printf("Please enter the name of the animal you would like to view:%n" +
                    "%nCamel%nElephant%nGiraffe%nGorilla%nLion%nMonkey%nPanda%nPenguin%nTiger%nTurtle%nZebra%n%n");
            Scanner userScanner = new Scanner(System.in);
            String animalType = userScanner.nextLine();
            LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
            Double habitatTemperature = Math.random() * (100 - 50) + 50;

            File animal = new File("src/Zoo/" + animalType.toLowerCase() + ".txt");
            if (!animal.exists()){
                System.out.printf("There is no animal \"%s\" in the zoo.", animalType);
                System.exit(0);
            }

            System.out.printf("Animal Type: %s %nCurrent Time: %s%nHabitat Temperature: %.2fF%n%n", animalType, (currentTime.getHour() > 12) ? currentTime.minusHours(12) + "PM" : currentTime + "AM", habitatTemperature);
            printAnimal(animal, animalType);

            System.out.println("\nYou've reached the end of the program. To check another habitat, enter \"1\" to exit the program, enter \"0\"");
            userIntent = userScanner.nextInt();
        }
        System.exit(0);
    }
}
