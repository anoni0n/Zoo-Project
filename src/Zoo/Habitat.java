package Zoo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Habitat {

    private static ArrayList<Habitat> habitats = new ArrayList<>();
    private final String animalType;
    private final double habitatTemperature;

    public Habitat(String animalType, double habitatTemperature){
        this.animalType = animalType;
        this.habitatTemperature = habitatTemperature;
        habitats.add(this);
    }

    public static void printHabitats(){
        System.out.println(habitats);
    }

    @Override
    public String toString() {
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES) ;
        return String.format("Animal Type: %s %nCurrent Time: %s%nHabitat Temperature: %.2fF%n%n",
                animalType, (currentTime.getHour() > 12) ? currentTime.minusHours(12) + "PM" : currentTime + "AM", habitatTemperature);
    }
}
