package ru.skillbox;

public class Cargo {

    private final Dimensions dimensions;             //     габариты
    private final double weight;                    //     масса
    private final String deliveryAddress;          //     адрес доставки
    private final boolean toFlip;                 //     свойство — можно ли переворачивать
    private final String registrationNumber;     //     регистрационный номер
    private final boolean isFragile;            //     груз хрупкий


    public Cargo(
            Dimensions dimensions, double weight,
            String deliveryAddress, boolean toFlip,
            String registrationNumber, boolean isFragile
    ) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.toFlip = toFlip;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }


    public Cargo setWeight(double weight) {
        return new Cargo(dimensions, weight, deliveryAddress, toFlip, registrationNumber, isFragile);
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, toFlip, registrationNumber, isFragile);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Boolean getToFlip() {
        return toFlip;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Boolean getFragile() {
        return isFragile;
    }

    public String toItems() {
        return "\n Габариты груза: " + dimensions +
                "\n" +
                "\n Масса                 - " + weight +
                "\n Адрес доставки        - " + deliveryAddress +
                "\n Не переворачивать     - " + toFlip +
                "\n Регистрационный номер - " + registrationNumber +
                "\n Груз хрупкий          - " + isFragile +
                "\n----------------------------------------------------";
    }
}
