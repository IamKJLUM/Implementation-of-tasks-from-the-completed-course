package parserHTML;

public class Station {
    private final int number;
    private final String name;
    private final String nameLine;

    public Station(int number, String name, String nameLine) {
        this.name = name;
        this.number = number;
        this.nameLine = nameLine;
    }
    public String getName() {
        return name;
    }
    public String getNameLine() {
        return nameLine;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return "parserHTML.Station{" +
                "number= " + number + '\'' +
                ", name='" + name + '\'' +
                ", nameLine='" + nameLine + '\'' +
                '}';
    }
}
