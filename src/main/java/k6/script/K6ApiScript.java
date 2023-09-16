package k6.script;

import k6.http.HttpRequestAdocWrapper;
import k6.script.converter.K6HttpBodyTextConverter;
import k6.script.converter.K6HttpCookieTextConverter;
import k6.script.converter.K6HttpHeaderTextConverter;
import k6.script.converter.K6HttpMethodTextConverter;

import static k6.script.Const.ENTER;

public class K6ApiScript {

    private final String value;

    private K6ApiScript(final String value) {
        this.value = value;
    }

    public static K6ApiScript toScript(final HttpRequestAdocWrapper request) {
        final String springMethodName = request.getControllerMethodName();
        final String k6MessageBody = wrapK6MessageBody(request);
        final String k6Params = wrapParams(request);
        final String k6Method = wrapK6HttpMethod(request, k6MessageBody);

        final String k6Api = String.format("export function %s () { %s %s %s %s %s %s %s }",
                springMethodName, ENTER, k6MessageBody, ENTER, k6Params, ENTER, k6Method, ENTER);

        return new K6ApiScript(k6Api);
    }

    /**
     * @return const res = http.get('http://localhost:8080/api/v1', params);
     */
    private static String wrapK6HttpMethod(final HttpRequestAdocWrapper request, final String k6MessageBody) {
        final String k6Http = K6HttpMethodTextConverter.toK6HttpMethodText(request);
        if (k6MessageBody.isBlank()) {
            return String.format("const res = %s", k6Http);
        }

        return String.format("const res = %s", k6Http);
    }

    /**
     * @return const params = {
     * MAIN_KEY: {SUB_KEY: SUB_VALUE}
     * };
     */
    private static String wrapParams(final HttpRequestAdocWrapper request) {
        final String k6Headers = K6HttpHeaderTextConverter.toHeaderText(request);
        final String k6Cookies = K6HttpCookieTextConverter.toCookieText(request);
        return String.format("const params = { %s %s %s %s %s };", ENTER, k6Headers, ENTER, k6Cookies, ENTER);
    }

    /**
     * @return let data = { 'name' : 'hyena' };
     * let jsonData = Json.stringify(data);
     */
    private static String wrapK6MessageBody(final HttpRequestAdocWrapper request) {
        final String k6MessageBody = K6HttpBodyTextConverter.toBodyText(request);
        if (k6MessageBody == null || k6MessageBody.isBlank()) {
            return "";
        }

        return String.format("let data = %s; %s let jsonData = Json.stringify(data); %s", k6MessageBody, ENTER, ENTER);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
