package monzo.namit;

public final class SiteURL {
    private final String url;

    public SiteURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return String.format("[%s]", this.url);
    }

    public boolean equals(Object other) {
        if (!(other instanceof SiteURL)) {
            return false;
        } else {
            SiteURL o = (SiteURL)other;
            return o.url.equals(this.url);
        }
    }

    public int hashCode() {
        return this.url.hashCode();
    }
}

