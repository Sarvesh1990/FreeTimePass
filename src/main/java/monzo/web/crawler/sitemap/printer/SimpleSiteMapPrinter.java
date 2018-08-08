package monzo.web.crawler.sitemap.printer;


import java.net.URL;
import java.util.*;

public class SimpleSiteMapPrinter implements SiteMapPrinter {
    @Override
    public void printSiteMap(Map<URL, Set<URL>> linkedURLsMap, URL startURL) {
        Queue<URL> urlsToPrint = new ArrayDeque<>();
        urlsToPrint.add(startURL);

        Set<URL> printedURLs = new HashSet<>();
        printedURLs.add(startURL);

        while(!urlsToPrint.isEmpty()) {
            URL currentURL = urlsToPrint.remove();
            Set<URL> linkedURLs = linkedURLsMap.get(currentURL);

            if(linkedURLs != null) {
                System.out.println(currentURL + " -> " + linkedURLs);
                for (URL url : linkedURLs) {
                    if (!printedURLs.contains(url)) {
                        urlsToPrint.add(url);
                        printedURLs.add(url);
                    }
                }
            }
        }
    }
}
