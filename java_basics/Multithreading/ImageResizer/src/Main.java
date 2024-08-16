import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String srcPath = "C:/users/User/Desktop/src";
        String outPath = "C:/users/User/Desktop/dst";
        int newSize = 300;

        resize(srcPath, outPath, newSize);
    }

    private static void resize(String srcPath, String outPath, int newSize) {

        List<Thread> threads = new ArrayList<>();
        File[] files = new File(srcPath).listFiles();
        int logicCoresCount = Runtime.getRuntime().availableProcessors();

        if (files == null || files.length == 0) return;

        int dataDistrib = files.length / logicCoresCount;

        for (int i = 0; i < logicCoresCount; i++) {

            int to = dataDistrib * (i + 1);
            int from = to - dataDistrib;

            if (i == logicCoresCount -1) to = files.length;
            threads.add(new Thread(new ImgResizer(Arrays.copyOfRange(files, from, to), outPath, newSize)));
        }

        threads.forEach(Thread::start);
        threads.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
