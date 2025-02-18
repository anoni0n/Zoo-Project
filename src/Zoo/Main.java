package Zoo;

import java.io.File;
import java.util.Scanner;
import static Zoo.Habitat.printHabitats;
import static Zoo.Habitat.habitats;

public class Main
{
    public static void main(String[] args){

        //makes all the starting Habitats
        Habitat camel = new Habitat("Camel");
        Habitat elephant = new Habitat("Elephant");
        Habitat giraffe = new Habitat("giraffe");
        Habitat gorilla = new Habitat("gorilla");
        Habitat lion = new Habitat("lion");
        Habitat monkey = new Habitat("monkey");
        Habitat panda = new Habitat("panda");
        Habitat penguin = new Habitat("penguin");
        Habitat turtle = new Habitat("turtle");
        Habitat zebra = new Habitat("zebra");

        //repeats the program while the user still wishes to
        int userIntent = 1;
        while (userIntent == 1) {
            Scanner userScanner = new Scanner(System.in);
            System.out.println("To check a habitat, enter 1. To make a new habitat, enter 0.");
            if (userScanner.nextInt() == 1) {
                printHabitats();
                System.out.printf("Please enter the name of the habitat you would like to view:%n");
                String animalType = userScanner.next();
                printCameraFeed(animalType);
            }
            else {
                System.out.println("Enter the name of the new habitat:");
                boolean valid = false;
                while (!valid) {
                    String newAnimal = userScanner.next();
                    for (int i = 0; i < habitats.size(); i++) {
                        if (habitats.get(i).getAnimalType().equalsIgnoreCase(newAnimal)) {
                            System.out.println("That habitat already exists. Enter a different name:");
                            break;
                        }
                        else if (i == habitats.size()-1){
                            new Habitat(newAnimal);
                            valid = true;
                            break;
                        }
                    }
                }
            }
            //asks the user in they want to continue the program and loops if they do
            System.out.println("To check another habitat or make a new habitat, enter 1. To exit the program, enter 0.");
            userIntent = userScanner.nextInt();
        }
    }

    /**
     * checks if the animal habitat exists and prints its information if it does
     * @param animalHabitat the habitat to be printed
     */
    public static void printCameraFeed(String animalHabitat){
        //finds the requested animal in habitats and prints its information if it exists
        for (int i = 0; i < habitats.size(); i++){
            if (habitats.get(i).getAnimalType().equalsIgnoreCase(animalHabitat)){
                habitats.get(i).printInfo();
                File animalImage = new  File("src/Zoo/animals/"+animalHabitat.toLowerCase()+".txt");
                try {
                    Scanner scanner = new Scanner(animalImage);
                    while (scanner.hasNextLine()){
                        String j = scanner.nextLine();
                        System.out.println(j);}
                } //catches if there is no ASCII of the animal to be printed
                catch (Exception e) {System.out.println("[camera not found]"); }
                break;
            }
            //prints if the animal requested doesn't exist in habitats
            else if (i == habitats.size()-1){
                System.out.println("There is no animal \""+animalHabitat+"\" in the zoo.");
            }
        }
    }
}