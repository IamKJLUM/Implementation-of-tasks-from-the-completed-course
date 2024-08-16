package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int maxFloor;
    private int minFloor;


    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public void moveUp(int floor) {
        for (; currentFloor < floor; currentFloor = currentFloor + 1) {
            System.out.println(currentFloor);
        }
        System.out.println(currentFloor + " Вы прибыли ");
    }

    public void moveDown(int floor) {
        for (; currentFloor > floor; currentFloor = currentFloor - 1) {
            System.out.println(currentFloor);
        }
        System.out.println(currentFloor + " Вы прибыли ");
    }

    public void move(int floor) {
        if ((minFloor > floor) || (floor > maxFloor)) {
            error();
        } else if (floor > currentFloor) {
            moveUp(floor);
        } else if (floor < currentFloor) {
            moveDown(floor);
        } else {
            System.out.println(getCurrentFloor());
        }
    }


    public void error() {
        System.out.println("Error");
        System.out.println(getCurrentFloor());
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
