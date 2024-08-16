package ru.skillbox;

public class StarSystem {

    private String starName;              // Название звезды
    private double starCoreTemperature;   // Температура ядра звезды кельвен
    private int countPlanets;             // Колл. планет
    private boolean inhabitedPlanets;     // Обитаемые планеты


    public StarSystem(String starName, double starCoreTemperature) {
        this.starName = starName;
        this.starCoreTemperature = starCoreTemperature;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public void setStarCoreTemperature(double starCoreTemperature) {
        this.starCoreTemperature = starCoreTemperature;
    }

    public void setCountPlanets(int countPlanets) {
        this.countPlanets = countPlanets;
    }

    public void setInhabitedPlanets(boolean inhabitedPlanets) {
        this.inhabitedPlanets = inhabitedPlanets;
    }


    public String getStarName() {
        return starName;
    }

    public double getStarCoreTemperature() {
        return starCoreTemperature;
    }

    public int getCountPlanets() {
        return countPlanets;
    }

    public boolean isInhabitedPlanets() {
        return inhabitedPlanets;
    }

}
