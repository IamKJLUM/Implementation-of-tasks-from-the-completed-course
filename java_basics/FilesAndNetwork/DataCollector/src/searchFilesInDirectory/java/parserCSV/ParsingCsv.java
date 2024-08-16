package parserCSV;

import java.nio.file.Path;
import java.util.*;

import static parserJSON.readFiles.ReadFile.read;

public class ParsingCsv {
    private ArrayList<StationFromCsv> stationFromCsvArrayList;

    public ParsingCsv(Path path) {
        String csv = read(path);
        parsingArray(parse(csv));
    }

    private HashMap<String, String> parse(String csv) {
        HashMap<String, String> result = new HashMap<>();
        boolean continueTitle = true;

        for (String station: csv.split("\\n")) {
            String name = "";
            if (continueTitle) {
                continueTitle = false;
                continue;
            }
            for (String data: station.split(",")) {
                if (name.length() > 1) {
                    result.put(name, data);
                }
                name = data;
            }
        }
        return result;
    }

    private void parsingArray(HashMap<String, String> csv) {

        stationFromCsvArrayList = new ArrayList<>();
            csv.forEach((key, value) ->
                    stationFromCsvArrayList.add(new StationFromCsv(
                        key,
                        value.trim()))
            );
    }


    public ArrayList<StationFromCsv> getStationFromCsvArrayList() {
        return stationFromCsvArrayList;
    }
}