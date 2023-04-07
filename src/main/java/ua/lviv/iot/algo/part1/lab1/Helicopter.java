package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Helicopter {
    private int id = 100;
    private String model;
    private int currentAltitude;
    private int maxAltitude;
    private int fuelCapacity;
    private int currentFuel;
  
    private static Helicopter defaultHelicopter = new Helicopter();
  
    public static Helicopter getInstance() {
        return defaultHelicopter;
    }
  
    public void takeOff() {
        this.currentAltitude += 100;
    }
  
    public void ascend(int altitude) {
        if (this.currentAltitude + altitude <= this.maxAltitude) {
            this.currentAltitude += altitude;
        } else {
            this.currentAltitude = this.maxAltitude;
        }
    }
  
    public void descend(int altitude) {
        if (altitude > this.currentAltitude) {
            this.currentAltitude = 0;
        }
        else {
            this.currentAltitude -= altitude;
        }
    }
  
    public void refuel(int fuel) {
        int fuelToMax = this.fuelCapacity - this.currentFuel;
        if (fuel > fuelToMax) {
            this.currentFuel = this.fuelCapacity;
            System.out.println("The fuel tank is full");
        }
        else {
            this.currentFuel += fuel;
        }
    }

    public static void main(String[] args) {
        Helicopter[] helicopters = {new Helicopter(),
                new Helicopter(101, "Hip",
                700, 5000,
                1300, 500),
                getInstance(),
                getInstance()};

        for (Helicopter helicopter : helicopters) {
            System.out.println(helicopter);
        }
    }
}
