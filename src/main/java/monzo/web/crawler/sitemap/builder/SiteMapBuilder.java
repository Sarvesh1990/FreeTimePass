package monzo.web.crawler.sitemap.builder;


import java.net.URL;
import java.util.Map;
import java.util.Set;

public abstract class SiteMapBuilder {
    protected final Map<URL, Set<URL>> linkedURLMap;

    protected SiteMapBuilder(Map<URL, Set<URL>> linkedURLMap) {
        this.linkedURLMap = linkedURLMap;
    }

    public abstract void buildSiteMap(URL startURL);

    public Map<URL, Set<URL>> getLinkedURLMap() {
        return linkedURLMap;
    }
}
