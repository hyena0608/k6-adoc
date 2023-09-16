package k6.http;

import java.util.HashMap;
import java.util.Map;

public enum HttpVersion {

    HTTP_1_0("HTTP/1.0"),
    HTTP_1_1("HTTP/1.1");

    private static final Map<String, HttpVersion> VERSIONS = new HashMap<>();

    static {
        for (final HttpVersion httpVersion : HttpVersion.values()) {
            VERSIONS.put(httpVersion.value, httpVersion);
        }
    }

    private final String value;

    HttpVersion(final String value) {
        this.value = value;
    }

    public static HttpVersion from(final String value) {
        return VERSIONS.get(value);
    }
}
