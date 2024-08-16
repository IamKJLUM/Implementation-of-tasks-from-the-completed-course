public class Main {
    public static void main(String[] args) {

        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Milk ", 40, 4, 23.01);
        vasyaBasket.add("wfere", 1, 2, 3);
        vasyaBasket.add("qwrq", 1, 2, 3);
        vasyaBasket.add("rre", 1);
        vasyaBasket.add("ir", 1, 2);
        vasyaBasket.print("" + "\n All - " + vasyaBasket.getTotalPrice());

        Basket aBasket = new Basket();
        aBasket.add("Butter",104,2,100);
        aBasket.print("" + "\n All - " + aBasket.getTotalPrice());

        Basket bBasket = new Basket();
        bBasket.add("wre", 100,2);
        bBasket.print("" + "\n All - " + bBasket.getTotalPrice());

        System.out.println(
                "\n ---------------------------------------------------------------" +
                        "\n Общее колличество товаров во всех корзинах  - "
                        + Basket.getTotalCountAllProducts() +
                        "\n Общая цена всех товаров во всех корзинах    - "
                        + Basket.getTotalPriceAllProducts() +
                        "\n Средний чек продуктов во всех корзинах      - "
                        + Basket.getAverageCheck() +
                        "\n Средний чек корзины                         - "
                        + Basket.getAverageCheckBasket() +
                        "\n ---------------------------------------------------------------"
        );


/////////////////////////
        Arithmetic pifagorArithmetic = new Arithmetic(5, 3);
        pifagorArithmetic.multiplication();
        pifagorArithmetic.print();


//////////////////////////
        Printer aPrinter = new Printer();
        aPrinter.append("text", "name", 1);
        aPrinter.append("text","name",2);
        aPrinter.append("wef","dw",2);

        aPrinter.print();


    }

}
