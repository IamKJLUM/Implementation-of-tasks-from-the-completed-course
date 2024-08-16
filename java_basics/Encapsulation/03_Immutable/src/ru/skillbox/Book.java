package ru.skillbox;

public class Book {

    private final String name = " The Extended Phenotype ";
    private final String author = " Richard Dawkins ";
    private final int countPages = 507;
    private final String isbn = "9_1785170_849093";


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCountPages() {
        return countPages;
    }

    public String getIsbn() {
        return isbn;
    }
}
