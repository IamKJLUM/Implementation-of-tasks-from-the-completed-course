package parserHTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class Parser {
    private final ArrayList<Line> allLines;

    public Parser(String url) throws IOException {
        allLines = new ArrayList<>();
        parsing(getHtml(url));
    }
    private void parsing(String html) {

        Document pageHtml = Jsoup.parse(html);
        Elements lines = pageHtml.getElementsByAttribute("data-depend");

        for (Element line: lines) {

            ArrayList<Station> stations = new ArrayList<>();
            String numberLine = line.select("span").attr("data-line");
            Elements stationsToCurrentLineHtml = pageHtml.select("[data-depend-set=lines-" + numberLine + "]");

            for (Element p: stationsToCurrentLineHtml.select("p")) {
                stations.add(new Station(
                                Integer.parseInt(
                                p.getElementsByClass("num").text().replace(".", "").trim()),
                                p.getElementsByClass("name").text(),
                                line.text()));
            }
            allLines.add(new Line(numberLine, line.text(),stations));
        }


    }

    private String getHtml(String url) throws IOException {
        Document d = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 YaBrowser/24.1.0.0 Safari/537.36")
                .referrer("https.yandex.ru")
                .get();
        return d.html();
    }

    public ArrayList<Line> getAllLines() {
        return allLines;
    }
}
