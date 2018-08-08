package monzo.web.crawler;

import monzo.web.crawler.sitemap.builder.SiteMapBuilder;
import monzo.web.crawler.sitemap.builder.SyncSiteMapBuilder;
import monzo.web.crawler.sitemap.printer.SimpleSiteMapPrinter;
import monzo.web.crawler.sitemap.printer.SiteMapPrinter;

import java.net.MalformedURLException;
import java.net.URL;

public class WebCrawler {
    public static void main(String[] args) throws MalformedURLException {
        URL startURL = new URL(args[0]);

        SiteMapBuilder siteMapBuilder = new SyncSiteMapBuilder();
        siteMapBuilder.buildSiteMap(startURL);

        SiteMapPrinter siteMapPrinter = new SimpleSiteMapPrinter();
        siteMapPrinter.printSiteMap(siteMapBuilder.getLinkedURLMap(), startURL);
    }
}
