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
            Double habitatTemperature = Math.random() * (50) + 50;

            //creates a file object and checks if such an animal exists in the zoo
            File animal = new File("src/Zoo/" + animalType.toLowerCase() + ".txt");
            if (!animal.exists()){
                System.out.printf("There is no animal \"%s\" in the zoo.", animalType);
            }
            else {
                //displays the animal's information
                System.out.printf("Animal Type: %s %nCurrent Time: %s%nHabitat Temperature: %.2fF%n%n", animalType, (currentTime.getHour() > 12) ? currentTime.minusHours(12) + "PM" : currentTime + "AM", habitatTemperature);
                printAnimal(animal, animalType);
            }
                //asks the user in they want to continue the program and loops if they do
                System.out.println("\nTo check another habitat, enter \"1\" to exit the program, enter \"0\"");
                userIntent = userScanner.nextInt();
        }
        System.exit(0);
    }
}
