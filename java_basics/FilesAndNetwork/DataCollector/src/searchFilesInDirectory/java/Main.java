import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import parserHTML.Line;
import parserHTML.Parser;
import parserCSV.ParsingCsv;
import parserJSON.ParsingJson;
import walkerToDir.SearchFileToTreeDir;
import writeJSON.WriteAllObjectsInJSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        SearchFileToTreeDir paths =
        testDirWalker("C:\\Users\\GlebHleb\\Desktop\\data");

//        testParsingHtml("https://skillbox-java.github.io/").forEach(System.out::println);
//        testParsingJson(paths.getListPaths()).forEach(System.out::println);
//        testParsingCsv(paths.getListPaths()).forEach(System.out::println);

        ArrayList<Object> objects = new ArrayList<>();
        objects.addAll(testParsingHtml("https://skillbox-java.github.io/"));
        objects.addAll(testParsingJson(paths.getListPaths()));
        objects.addAll(testParsingCsv(paths.getListPaths()));

        WriteAllObjectsInJSON write = new WriteAllObjectsInJSON(objects,"C:\\Users\\GlebHleb\\Desktop\\");



    }




    private static SearchFileToTreeDir testDirWalker(String rootDir) throws IOException {
        SearchFileToTreeDir paths = new SearchFileToTreeDir();
        Files.walkFileTree(Paths.get(rootDir), paths);
        return paths;
    }
    private static ArrayList<?> testParsingHtml(String url) throws IOException {
        Parser parserHtml = new Parser(url);
        return parserHtml.getAllLines();
    }
    private static ArrayList<?> testParsingJson(ArrayList<Path> paths) {
        ArrayList<Object> allJsonFiles = new ArrayList<>();
        for (Path p: paths) {
            if (p.toString().endsWith(".json")) {
                ParsingJson pj = new ParsingJson(p);
                allJsonFiles.add(pj);
            }
        }
        return allJsonFiles;
    }
    private static ArrayList<?> testParsingCsv(ArrayList<Path> paths) {
        ArrayList<Object> allCsvFiles = new ArrayList<>();

        for (Path p: paths) {
            if (p.toString().endsWith(".csv")) {
                ParsingCsv pc = new ParsingCsv(p);
                allCsvFiles.add(pc.getStationFromCsvArrayList());
            }
        }
        return allCsvFiles;
    }
}
