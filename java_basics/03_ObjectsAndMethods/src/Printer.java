public class Printer {


    String queue = "";

    int pagesPendingCount = 0;
    int historyPrinter = 0;


    public void append(String text, String name, int pagesCount) {
        queue = "\n Имя - " + name + " Текст - " + text + " Колл. стр. - "
                + pagesCount + "\n Очередь - " + getPagesPendingCount() + " стр. ";
        historyPrinter = historyPrinter + pagesCount;
        pagesPendingCount = pagesPendingCount + pagesCount;

    }

    public void append(String text, String name) {
        append(text, name, 1);
    }

    public void append(String text) {
        append(text, "", 1);
    }

    public int getPagesPendingCount() {
        return pagesPendingCount;
    }

    public int getHistoryPrinter() {
        return historyPrinter;
    }

    public void clear() {
        queue = "";
        System.out.println(" Очередь очищена");
    }

    public void print() {
        System.out.println(queue);
        clear();
        System.out.println(" Страницы распечанные за все время - " + getHistoryPrinter());
    }

}

