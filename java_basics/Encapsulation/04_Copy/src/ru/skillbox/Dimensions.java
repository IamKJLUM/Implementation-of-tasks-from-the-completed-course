package ru.skillbox;

public class Dimensions {
    private final double width;        //     Ширина
    private final double height;      //     Высота
    private final double length;     //     Длина


    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;

    }

    public Dimensions setWidth( double width) {
        return new Dimensions(width,height,length);
    }

    public Dimensions setHeight( double height) {
        return new Dimensions(width,height,length);
    }

    public Dimensions setLength( double length) {
        return new Dimensions(width,height,length);
    }

    public double Volume () {
        return width * height * length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public String toString() {
        return "\n Ширина   - " + width +
                "\n Высота   - " + height +
                "\n Длина    - " + length +
                "\n Объем    - " +  Volume();
    }
}
