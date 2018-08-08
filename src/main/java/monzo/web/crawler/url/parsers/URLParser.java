package monzo.web.crawler.url.parsers;


import java.net.URL;
import java.util.Set;

public interface URLParser {
    public Set<URL> getLinkedUrls(URL parentURL);
}
