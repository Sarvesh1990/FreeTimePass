package monzo.namit;

import java.net.MalformedURLException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SiteMapCreator {
    private final String startURL;
    private final Crawler crawler;
    private final Map<SiteURL, Set<SiteURL>> siteMap;
    private final int uniqueLinksLimit;

    public SiteMapCreator(String startURL, int uniqueLinksLimit) throws MalformedURLException {
        this(startURL, new Crawler(startURL), uniqueLinksLimit);
    }

    public SiteMapCreator(String startURL, Crawler crawler, int uniqueLinksLimit) {
        this.startURL = startURL;
        this.uniqueLinksLimit = uniqueLinksLimit;
        this.crawler = crawler;
        this.siteMap = new HashMap();
    }

    public void run() {
        SiteURL startSiteUrl = new SiteURL(this.startURL);
        Queue<SiteURL> queue = new ArrayDeque();
        queue.add(startSiteUrl);

        while(!queue.isEmpty() && this.siteMap.size() < this.uniqueLinksLimit) {
            SiteURL currentSiteUrl = (SiteURL)queue.remove();
            if (!this.siteMap.containsKey(currentSiteUrl)) {
                Set<SiteURL> newSiteURLs = this.crawler.getChildURLs(currentSiteUrl);
                if (!newSiteURLs.isEmpty()) {
                    this.siteMap.put(currentSiteUrl, newSiteURLs);
                    Iterator var5 = newSiteURLs.iterator();

                    while(var5.hasNext()) {
                        SiteURL newSiteURL = (SiteURL)var5.next();
                        if (!this.siteMap.containsKey(newSiteURL)) {
                            queue.add(newSiteURL);
                        }
                    }
                }
            }
        }

    }

    public void printSiteMap() {
        SiteURL dummySiteURL = new SiteURL("");
        SiteURL startSiteUrl = new SiteURL(this.startURL);
        Queue<SiteURL> queue = new ArrayDeque();
        queue.add(startSiteUrl);
        queue.add(dummySiteURL);
        StringBuilder spaces = new StringBuilder();
        HashSet visited = new HashSet();

        while(true) {
            while(true) {
                SiteURL currentSiteUrl;
                do {
                    if (queue.isEmpty()) {
                        return;
                    }

                    currentSiteUrl = (SiteURL)queue.remove();
                } while(visited.contains(currentSiteUrl));

                if (currentSiteUrl.equals(dummySiteURL)) {
                    if (!queue.isEmpty()) {
                        queue.add(dummySiteURL);
                    }

                    spaces.append("-");
                } else {
                    visited.add(currentSiteUrl);
                    Set<SiteURL> childSiteURLs = (Set)this.siteMap.get(currentSiteUrl);
                    if (childSiteURLs != null) {
                        System.out.println(String.format("%s %s -> %s", spaces, currentSiteUrl, childSiteURLs));
                        Iterator var8 = childSiteURLs.iterator();

                        while(var8.hasNext()) {
                            SiteURL childSiteURL = (SiteURL)var8.next();
                            if (!visited.contains(childSiteURL)) {
                                queue.add(childSiteURL);
                            }
                        }
                    }
                }
            }
        }
    }

    public Map<SiteURL, Set<SiteURL>> getSiteMap() {
        return this.siteMap;
    }
}
