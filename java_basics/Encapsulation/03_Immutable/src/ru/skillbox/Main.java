package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Book phenotypeBook = new Book();
        System.out.println("\n Книга         - " + phenotypeBook.getName() +
                           "\n Автор         - " + phenotypeBook.getAuthor() +
                           "\n Колл. страниц -  " + phenotypeBook.getCountPages() +
                           "\n Номер ISBN    -  " + phenotypeBook.getIsbn());



        Product aProduct = new Product(" Kolbasa",212313);
        aProduct.setPrice(123);
        System.out.println("\n" + aProduct.getName() + " Цена: "+ aProduct.getPrice() +
                "\n Код продукта: " + aProduct.getBarCode());

    }
}
