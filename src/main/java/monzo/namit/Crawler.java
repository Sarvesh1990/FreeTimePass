package monzo.namit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Crawler {
    private final String host;
    private final String protocol;

    public Crawler(String startURL) throws MalformedURLException {
        URL url = new URL(startURL);
        this.host = url.getHost();
        this.protocol = url.getProtocol();
    }

    Set<SiteURL> getChildURLs(SiteURL siteUrl) {
        try {
            String content = getURLSource(siteUrl.getUrl());
            Set<String> allUrls = (Set)getURLs(content).stream().map((s) -> {
                String result = s;
                if (s.startsWith("/")) {
                    result = this.protocol + "://" + this.host + s;
                }

                if (result.endsWith("/")) {
                    result = result.substring(0, result.length() - 1);
                }

                return result;
            }).collect(Collectors.toSet());
            Set<SiteURL> relevantURLs = new HashSet();
            Iterator var5 = allUrls.iterator();

            while(var5.hasNext()) {
                String urlString = (String)var5.next();

                try {
                    URL url = new URL(urlString);
                    if (url.getHost().equals(this.host)) {
                        relevantURLs.add(new SiteURL(urlString));
                    }
                } catch (MalformedURLException var8) {
                    ;
                }
            }

            return relevantURLs;
        } catch (IOException var9) {
            System.out.println("Error reading " + siteUrl);
            return new HashSet();
        }
    }

    private static List<String> getURLs(String urlContent) {
        List<String> allMatches = new ArrayList();
        Matcher m = Pattern.compile("\\<a[^\\>]*href=\"([^\"]*)\"[^\\>]*\\>").matcher(urlContent);

        while(m.find()) {
            allMatches.add(m.group(1));
        }

        return allMatches;
    }

    private static String getURLSource(String url) throws IOException {
        URL urlObject = new URL(url);
        URLConnection urlConnection = urlObject.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        Throwable var4 = null;

        try {
            StringBuilder stringBuilder = new StringBuilder();

            String inputLine;
            while((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            String var7 = stringBuilder.toString();
            return var7;
        } catch (Throwable var16) {
            var4 = var16;
            throw var16;
        } finally {
            if (bufferedReader != null) {
                if (var4 != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable var15) {
                        var4.addSuppressed(var15);
                    }
                } else {
                    bufferedReader.close();
                }
            }

        }
    }
}
