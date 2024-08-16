package ru.skillbox;

public class Country {
    private String name;               // название
    private int countPopulation;       // колл населения
    private double squareKm2;          // площадь км2
    private String capitalName;        // столица назв
    private boolean accessToSea;       // выход к морю


    public Country(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountPopulation(int countPopulation) {
        this.countPopulation = countPopulation;
    }

    public void setSquareKm2(double squareKm2) {
        this.squareKm2 = squareKm2;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.accessToSea = accessToSea;
    }



    public String getName() {
        return name;
    }

    public int getCountPopulation() {
        return countPopulation;
    }

    public double getSquareKm2() {
        return squareKm2;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public boolean isAccessToSea() {
        return accessToSea;
    }





}
