import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        StringBuilder Ae = new StringBuilder();
        StringBuilder eR = new StringBuilder(); // под "R" подразумевается "Я"
        StringBuilder Ee = new StringBuilder();

        for (int i = 0; i < 65536; i++) {
            StringBuilder search = new StringBuilder();

            char symbols = (char) i;
            search.append(symbols);
            Pattern aeAE = Pattern.compile("[а-еА-Е]{1}");
            Matcher searchAeEa = aeAE.matcher(search);
            Pattern erER = Pattern.compile("[е-яЕ-я]{1}");
            Matcher searchErRE = erER.matcher(search);

            if (search.toString().contains("Ё")) {
                Ee.append("\n" + symbols + "  -  " + i);
            } else if (search.toString().contains("ё")) {
                Ee.append("\n" + symbols + "  -  " + i);
            }

            if (searchAeEa.matches() || searchErRE.matches() && i <= 1077) {
                Ae.append("\n" + symbols + "  -  " + i);

                if (i == 1045) {
                    Ae.append(Ee);
                    Ee.setLength(0);
                }

            } else if (searchAeEa.matches() || searchErRE.matches()) {
                eR.append("\n" + symbols + "  -  " + i);

            }
        }
        System.out.println(Ae + "" + Ee + "" + eR);

    }
}
