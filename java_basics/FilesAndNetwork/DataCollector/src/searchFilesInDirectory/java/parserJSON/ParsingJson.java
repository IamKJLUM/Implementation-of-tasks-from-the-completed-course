package parserJSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Path;
import java.util.ArrayList;

import static parserJSON.readFiles.ReadFile.read;

public class ParsingJson {
    private ArrayList<StationFromJson> stationFromJsonArrayList;

    public ParsingJson(Path path) {
        String json = read(path);
        processingJson(json);
    }

    private void processingJson(String json) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(json);
            parsingArray(jsonArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsingArray(JSONArray jsonArray) {
        stationFromJsonArrayList = new ArrayList<>();
        jsonArray.forEach(stationFromJsonObj -> {
         JSONObject jsonObject = (JSONObject) stationFromJsonObj;
         stationFromJsonArrayList.add(new StationFromJson(
                 jsonObject.get("station_name").toString(),
                 jsonObject.get("depth").toString()
         ));
        });
    }

    public ArrayList<StationFromJson> getStationFromJsonArrayList() {
        return stationFromJsonArrayList;
    }
}
