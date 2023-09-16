package k6.http;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cookie {

    private final Map<String, String> cookieFields = new HashMap<>();

    public void setCookie(final Map<String, String> otherCookie) {
        final String allCookieValues = otherCookie.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("; "));

        cookieFields.put("Cookie", allCookieValues);
    }

    public Map<String, String> getCookieFields() {
        return cookieFields;
    }
}
