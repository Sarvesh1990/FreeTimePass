package monzo.namit;

import java.net.MalformedURLException;

public class Main {
    private static final int UNIQUE_LINKS_LIMIT = 50;

    public Main() {
    }

    public static void main(String[] args) throws MalformedURLException {
        SiteMapCreator siteMapCreator = new SiteMapCreator("https://www.monzo.com", Integer.MAX_VALUE);
        siteMapCreator.run();
        siteMapCreator.printSiteMap();
    }
}
