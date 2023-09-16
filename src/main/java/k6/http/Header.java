package k6.http;

import java.util.HashMap;
import java.util.Map;

public class Header {

    private final Map<String, String> headerFields = new HashMap<>();

    public void setHeader(final Map<String, String> otherHeader) {
        this.headerFields.putAll(otherHeader);
    }

    public Map<String, String> getHeaderFields() {
        return headerFields;
    }

    @Override
    public String toString() {
        return "Header{" +
               "fields=" + headerFields +
               '}';
    }
}
