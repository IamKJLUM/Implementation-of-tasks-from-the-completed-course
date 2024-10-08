public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    public static double totalPriceAllProducts = 0;
    public static int totalCountAllProducts = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, int totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static int getTotalCountAllProducts() {
        return totalCountAllProducts;
    }

    public static double getTotalPriceAllProducts() {
        return totalPriceAllProducts;
    }

    public static double getAverageCheckBasket() {
        return totalPriceAllProducts / count;
    }

    public static double getAverageCheck() {
        return totalPriceAllProducts / totalCountAllProducts;
    }

    public static void calculationTotalPriceAllProducts(int count, int price) {
        Basket.totalPriceAllProducts = Basket.totalPriceAllProducts + (count * price);
    }

    public static void calculationTotalCountAllProduct(int count) {
        Basket.totalCountAllProducts = Basket.totalCountAllProducts + count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void increaseTotalWeight(double totalWeight, double weight, int count) {
        this.totalWeight = totalWeight + weight * count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " Цена: - " + price + " У.Е. " + "  Кол: - " +
                count + " шт. " + " Вес: - " + weight;
        totalPrice = totalPrice + price * count;
        increaseTotalWeight(totalWeight, weight, count);
        calculationTotalCountAllProduct(count);
        calculationTotalPriceAllProducts(count, price);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println(" Общий весс корзины: - " + getTotalWeight() + " Гр.");
        }
    }

}
