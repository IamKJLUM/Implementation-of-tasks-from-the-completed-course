package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions aDimensions = new Dimensions(1,2,3);
        aDimensions.setLength(3);
        aDimensions.setHeight(2);
        aDimensions.setWidth(1);

        Cargo aCargo = new Cargo(
                aDimensions, 123,
                "efwef", true,
                "141414", false
        );

        System.out.println(aCargo.toItems());

//-------------------------------------------------------------

        Dimensions copy = new Dimensions(3,2,1);

        copy.setLength(99);

        Cargo copyCar = new Cargo(

                aCargo.getDimensions(),
                aCargo.getWeight(),
                aCargo.getDeliveryAddress(),
                aCargo.getToFlip(),
                aCargo.getRegistrationNumber(),
                aCargo.getFragile()
        );

        copyCar.setWeight(1);

        System.out.println(copyCar.toItems());

    }
}
