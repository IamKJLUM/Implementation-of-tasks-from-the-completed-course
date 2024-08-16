package parserJSON.readFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    public static String read(Path path) {
        String file = "";
        try {
            file = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
