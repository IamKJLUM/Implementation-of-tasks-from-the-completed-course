package walkerToDir;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class SearchFileToTreeDir extends SimpleFileVisitor<Path> {
    private final ArrayList<Path> listPaths;
    public SearchFileToTreeDir() {
        listPaths = new ArrayList<>();
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toString().endsWith(".csv") || file.toString().endsWith(".json")) listPaths.add(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }
    public ArrayList<Path> getListPaths() {
        return listPaths;
    }
}
