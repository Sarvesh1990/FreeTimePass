package monzo.web.crawler.sitemap.builder;


import monzo.web.crawler.url.parsers.SameHostURLParser;
import monzo.web.crawler.url.parsers.URLParser;

import java.net.URL;
import java.util.*;

public class SyncSiteMapBuilder extends SiteMapBuilder {
    public SyncSiteMapBuilder() {
        super(new HashMap<>());
    }

    @Override
    public void buildSiteMap(URL startUrl) {
        URLParser parser = new SameHostURLParser(startUrl);

        Queue<URL> upcomingURLsToBeCrawled = new ArrayDeque<>();
        upcomingURLsToBeCrawled.add(startUrl);

        while(!upcomingURLsToBeCrawled.isEmpty() && linkedURLMap.size() < 10) {
            URL currentURL = upcomingURLsToBeCrawled.remove();
            if(!linkedURLMap.containsKey(currentURL)) {
                Set<URL> linkedURLs = parser.getLinkedUrls(currentURL);
                if(!linkedURLs.isEmpty()) {
                    linkedURLMap.put(currentURL, linkedURLs);
                    for (URL url : linkedURLs) {
                        if (!linkedURLMap.containsKey(url)) {
                            upcomingURLsToBeCrawled.add(url);
                        }
                    }
                }
            }
        }
    }
}
