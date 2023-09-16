package k6.http;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {

    private final Map<String, String> params = new HashMap<>();

    public void setQueryParams(final Map<String, String> otherParams) {
        params.putAll(otherParams);
    }

    @Override
    public String toString() {
        return "QueryParams{" +
               "params=" + params +
               '}';
    }
}
