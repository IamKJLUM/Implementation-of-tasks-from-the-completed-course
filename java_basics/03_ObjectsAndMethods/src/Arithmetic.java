public class Arithmetic {
    private int a;
    private int b;
    private String qwe = "";



    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void plus() {

        qwe = qwe + "\n Сумма чисел: " + "\n" + " " + a + " + " + b + " = " + (a + b);
    }

    public void minus() {

        qwe = qwe + "\n Разность чисел: " + "\n" + " " + a + " - " + b + " = " + (a - b);
    }

    public void multiplication() {


        qwe = qwe + "\n Произведение чисел: " + "\n" + " " + a + " * " + b + " = " + (a * b);
    }

    public void comparison() {
        if (a > b) {
            qwe = qwe + "\n Результат сравнения чисел: " + "\n" + " " + a + " > " + b;
        } else {
            qwe = qwe + "\n Результат сравнения чисел: " + "\n" + " " + b + " > " + a;
        }
    }


    public void print() {

        if (qwe.isEmpty()) {
            System.out.println("");
        } else {
            System.out.println(qwe);
        }
    }
}
