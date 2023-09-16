package k6.script.converter;

import k6.http.HttpRequestAdocWrapper;

import java.util.Locale;

public class K6HttpMethodTextConverter {

    private static final String K6_HTTP = "http";
    private static final String K6_HTTP_PARAMS = "params";
    private static final String K6_HTTP_BODY = "jsonData";

    /**
     * @return http.get(' http : / / localhost : 8080 / api / v1 ', params);
     */
    public static String toK6HttpMethodText(final HttpRequestAdocWrapper request) {
        final String httpMethod = request.getRequestMethod().name().toLowerCase(Locale.ENGLISH);
        final String requestPath = request.getRequestPath().getValue();

        if (request.getRequestBody().getFields().isEmpty()) {
            return String.format("%s.%s('%s', %s);", K6_HTTP, httpMethod, requestPath, K6_HTTP_PARAMS);
        }
        return String.format("%s.%s('%s', %s, %s);", K6_HTTP, httpMethod, requestPath, K6_HTTP_BODY, K6_HTTP_PARAMS);
    }
}
