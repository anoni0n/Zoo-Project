package Zoo;

import java.time.LocalTime;
import java.io.File;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class Main
{
    //Creates a file based on animalType and prints the contents of the file.
    public static void printAnimal(String a){
        File animalFile = new File("src/Zoo/animals/"+a+".txt");
        System.out.println("You are now viewing the "+a+" habitat.\n");
        try {
            Scanner scanner = new Scanner(animalFile);
            while (scanner.hasNextLine()){
                String i = scanner.nextLine();
                System.out.println(i);}
        } catch (Exception e) {System.out.printf("There is no animal \"%s\" in the zoo.",a);}
        System.out.println("You've reached the end of the program. To check another habitat, please restart the watcher.");
    }
    public static void main(String[] args) {

        //userIntent is used to break out of the loop
        int userIntent = 1;
        while (userIntent == 1) {
            System.out.printf("Please enter the number of the habitat you would like to view:%n" +
                    "%n1 - Camel%n2 - Elephant%n3 - Giraffe%n4 - Gorilla%n5 - Lion%n6 - Monkey%n7 - Panda%n8 - Penguin%n9 - Tiger%n10 - Turtle%n11 - Zebra%n%n");
            Scanner userScanner = new Scanner(System.in);
            int animalNum = userScanner.nextInt();
            LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
            double habitatTemperature = Math.random() * 50 + 50;

            //animalType is initialized based on the number inputted
            String animalType;
            switch (animalNum) {
                case 1:
                    animalType = "Camel";
                    break;
                case 2:
                    animalType = "Elephant";
                    break;
                case 3:
                    animalType = "Giraffe";
                    break;
                case 4:
                    animalType = "Gorilla";
                    break;
                case 5:
                    animalType = "Lion";
                    break;
                case 6:
                    animalType = "Monkey";
                    break;
                case 7:
                    animalType = "Panda";
                    break;
                case 8:
                    animalType = "Penguin";
                    break;
                case 9:
                    animalType = "Tiger";
                    break;
                case 10:
                    animalType = "Turtle";
                    break;
                case 11:
                    animalType = "Zebra";
                    break;
                default:
                    animalType = null;
                    System.out.println("Chosen camera does not exist.");
                    break;
            }


            if (animalType != null) {
                System.out.printf("Animal Type: %s%nCurrent Time: %s%nHabitat Temperature: %.2fF%n%n", animalType, (currentTime.getHour() > 12) ? currentTime.minusHours(12) + "PM" : currentTime + "AM",habitatTemperature);
                printAnimal(animalType);
            }
            //asks the user in they want to continue the program and loops if they do
            System.out.println("\nTo check another habitat, enter \"1\" to exit the program, enter \"0\"");
            userIntent = userScanner.nextInt();
        }
        System.exit(0);
    }
}
