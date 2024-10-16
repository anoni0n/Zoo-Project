package Zoo;

import java.time.LocalTime;
import java.io.File;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main
{
    public static void printAnimal(String a){
        File animalFile = new File("src/Zoo/"+a+".txt");
        System.out.println("You are now viewing the "+a+" habitat.\n");
        try {
            Scanner scanner = new Scanner(animalFile);
            while (scanner.hasNextLine()){
                String i = scanner.nextLine();
                System.out.println(i);}
        } catch (Exception e) {System.out.printf("There is no animal \"%s\" in the zoo.",a);}
        System.out.println("You've reached the end of the program. To check another habitat, please restart the watcher.");
    }
    public static void main(String[] args){

        System.out.printf("Please enter the number of the habitat you would like to view:%n" +
                "%n1 - Camel%n2 - Elephant%n3 - Giraffe%n4 - Gorilla%n5 - Lion%n6 - Monkey%n7 - Panda%n8 - Penguin%n9 - Tiger%n10 - Turtle%n11 - Zebra%n%n");
        Scanner userScanner = new Scanner(System.in);
        int animalNum = userScanner.nextInt();
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        Double habitatTemperature = Math.random()*(100-50)+50;

        String animalType;
        switch (animalNum){
            case 1: animalType = "camel";
            break;
            case 2: animalType = "elephant";
            break;
            case 3: animalType = "giraffe";
            break;
            case 4: animalType = "gorilla";
            break;
            case 5: animalType = "lion";
            break;
            case 6: animalType = "monkey";
            break;
            case 7: animalType = "panda";
            break;
            case 8: animalType = "penguin";
            break;
            case 9: animalType = "tiger";
            break;
            case 10: animalType = "turtle";
            break;
            case 11: animalType = "zebra";
            break;
            default: animalType = null;
            System.out.println("Chosen camera does not exist");
            System.exit(0);
            break;
        }
        System.out.printf("Animal Type: %s %nCurrent Time: %s%nHabitat Temperature: %.2fF%n%n",animalType,(currentTime.getHour()>12) ? currentTime.minusHours(12)+"PM":currentTime+"AM",habitatTemperature);
        printAnimal(animalType);
    }
}
