package ru.skillbox;

public class ArithmeticCalculator {

    public final int numberOne;
    public final int numberTwo;


    public ArithmeticCalculator (int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public void calculate(Operation type) {
        if (type == Operation.ADD) {
            System.out.println(" Результат сложения: " + (numberOne + numberTwo));
        } else if (type == Operation.SUBTRACT) {
            System.out.println(" Результат вычитания: " + (numberOne - numberTwo));
        } else if (type == Operation.MULTIPLY) {
            System.out.println(" Результат умножения: " + (numberOne * numberTwo));
        } else {
            System.out.println(" Error :p");
        }
    }
}
