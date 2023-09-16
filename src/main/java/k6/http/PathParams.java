package k6.http;

import java.util.HashMap;
import java.util.Map;

public class PathParams {

    private final Map<String, String> params = new HashMap<>();

    public void setPathParams(final Map<String, String> otherParams) {
        params.putAll(otherParams);
    }

    @Override
    public String toString() {
        return "PathParams{" +
               "params=" + params +
               '}';
    }
}
