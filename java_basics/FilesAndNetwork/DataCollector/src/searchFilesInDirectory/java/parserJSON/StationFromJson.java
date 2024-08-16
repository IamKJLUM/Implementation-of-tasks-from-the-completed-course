package parserJSON;

public class StationFromJson {
    private final String depth;
    private final String station_name;
    public StationFromJson(String name, String depth) {
        this.depth = depth;
        this.station_name = name;
    }
    public String getName() {
        return station_name;
    }
    public String getDepth() {
        return depth;
    }
    @Override
    public String toString() {
        return "StationFromJson{" +
                "depth='" + depth + '\'' +
                ", name='" + station_name + '\'' +
                '}';
    }
}
