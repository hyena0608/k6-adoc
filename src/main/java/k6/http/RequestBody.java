package k6.http;

import java.util.HashMap;
import java.util.Map;

public class RequestBody {

    private final Map<String, String> fields = new HashMap<>();

    public void setRequestBody(final Map<String, String> otherFields) {
        fields.putAll(otherFields);
    }

    public Map<String, String> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
               "fields=" + fields +
               '}';
    }
}
