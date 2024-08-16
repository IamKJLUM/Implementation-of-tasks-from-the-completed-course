package parserHTML;

import java.util.List;

public class Line {
    private List<Station> stations;
    private String number;
    private String name;

    public Line(String number, String name, List<Station> stations) {
        this.number = number;
        this.name = name;
        this.stations = stations;
    }
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
    public void addStation(Station station) {
        stations.add(station);
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Station> getStations() {
        return stations;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return "LineFromHTML{" +
                "name=" + name +
                ", numberLine=" + number +
                ", stations='" + stations + '\'' +
                '}';
    }
}
