package monzo.web.crawler.sitemap.printer;


import java.net.URL;
import java.util.Map;
import java.util.Set;

public interface SiteMapPrinter {
    public void printSiteMap(Map<URL, Set<URL>> linkedURLs, URL startURL);
}
