package monzo.web.crawler.sitemap.builder;



import java.net.URL;
import java.util.HashMap;


/*
This class can be used to build sitemap concurrently using multiple crawlers. Not writing the implementation now because of lack
of time.
Use multiple crawlers at a time and a blocking queue to store upcoming URLS to be crawled
 */

public class ConcurrentSiteMapBuilder extends SiteMapBuilder {
    public ConcurrentSiteMapBuilder() {
        super(new HashMap<>());
    }

    @Override
    public void buildSiteMap(URL startURL) {

    }
}
