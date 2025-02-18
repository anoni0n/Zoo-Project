package Zoo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Habitat {
    //static ArrayList that stores all habitats
    static ArrayList<Habitat> habitats = new ArrayList<>();
    private final double habitatTemperature = Math.random() * 50 + 50;
    private final String animalType;

    public Habitat(String animalType){
        //capitalizes the first character of animalType
        this.animalType = animalType.replaceFirst(animalType.substring(0,1),animalType.substring(0,1).toUpperCase());
        habitats.add(this);
    }

    /**
     * prints the ArrayList habitats
     */
    public static void printHabitats(){
        System.out.println("Cameras: "+habitats);
    }

    /**
     * returns the type of animal the habitat is for
     * @return animalType
     */
    public String getAnimalType(){
        return animalType;
    }

    /**
     * prints all required information on a habitat
     */
    public void printInfo(){
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES) ;
        System.out.printf("Animal Type: %s%nCurrent Time: %s%nHabitat Temperature: %.2fF%n%n",
                animalType, (currentTime.getHour() > 12) ? currentTime.minusHours(12) + "PM" : currentTime + "AM", habitatTemperature);
    }

    @Override
    public String toString() {
        return animalType.toUpperCase();
    }
}
