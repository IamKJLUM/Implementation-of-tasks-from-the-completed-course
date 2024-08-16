package writeJSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteAllObjectsInJSON {

    public WriteAllObjectsInJSON(ArrayList<Object> objects, String directory) {


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        StringBuilder json =  new StringBuilder();
        objects.forEach(o -> {
            try {
                json.append(ow.writeValueAsString(o));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        System.out.println(json);

        try (FileWriter writer = new FileWriter(directory.concat("fusionFileCsvAndJson.json"), false)) {
            writer.write(json.toString());
            writer.flush();
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.err::println);
        }


    }
}
