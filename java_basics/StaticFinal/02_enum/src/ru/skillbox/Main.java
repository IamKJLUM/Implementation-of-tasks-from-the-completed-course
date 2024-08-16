package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator a = new ArithmeticCalculator(5,3);
        a.calculate(Operation.MULTIPLY);
    }
}
