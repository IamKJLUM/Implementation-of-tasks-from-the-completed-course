package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Country russiaCountry = new Country("Россия");
        System.out.println(" Страна - " + russiaCountry.getName());

        StarSystem sunStarSystem = new StarSystem("sun",15700000);
        System.out.println("\n Название звезды - " + sunStarSystem.getStarName() +
                "\n Температура ядра - " + sunStarSystem.getStarCoreTemperature());

    }
}
