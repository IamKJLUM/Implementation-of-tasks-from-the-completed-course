package parserCSV;
import java.time.LocalDate;

public class StationFromCsv {
    private final String name;
    private final String date;
    public StationFromCsv(String name, String date) {
        this.name = name;
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "StationFromCsv{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
