package k6.http;

import k6.utils.CamelCaseConverter;

import java.io.File;
import java.util.List;
import java.util.Map;

public class HttpRequestAdocWrapper {

    private String controllerMethodName = "";
    private final RequestLine requestLine = new RequestLine();
    private final Header header = new Header();
    private final Cookie cookie = new Cookie();
    private final PathParams pathParams = new PathParams();
    private final QueryParams queryParams = new QueryParams();
    private final RequestBody requestBody = new RequestBody();

    public void setControllerMethodName(final List<File> adocs) {
        if (!adocs.isEmpty()) {
            final String methodName = adocs.get(0).getParentFile().getName();
            controllerMethodName = CamelCaseConverter.toCamelCase(methodName);
        }
    }

    public void setRequestLine(final String requestLine) {
        this.requestLine.setRequestLine(requestLine);
    }

    public void setRequestPath(final String requestPath) {
        this.requestLine.setRequestPath(requestPath);
    }

    public void setHeader(final Map<String, String> otherHeader) {
        this.header.setHeader(otherHeader);
    }

    public void setCookie(final Map<String, String> otherCookie) {
        this.cookie.setCookie(otherCookie);
    }

    public void setQueryParams(final Map<String, String> otherQueryParams) {
        this.queryParams.setQueryParams(otherQueryParams);
    }

    public void setPathParams(final Map<String, String> otherPathParams) {
        this.pathParams.setPathParams(otherPathParams);
    }

    public void setRequestBody(final Map<String, String> otherRequestBody) {
        this.requestBody.setRequestBody(otherRequestBody);
    }

    public String getControllerMethodName() {
        return controllerMethodName;
    }

    public RequestMethod getRequestMethod() {
        return requestLine.getMethod();
    }

    public RequestPath getRequestPath() {
        return requestLine.getPath();
    }

    public HttpVersion getHttpVersion() {
        return requestLine.getHttpVersion();
    }

    public Header getHeader() {
        return header;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public PathParams getPathParams() {
        return pathParams;
    }

    public QueryParams getQueryParams() {
        return queryParams;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    @Override
    public String toString() {
        return "HttpRequestAdocWrapper{" +
               "requestLine=" + requestLine +
               ", header=" + header +
               ", pathParams=" + pathParams +
               ", queryParams=" + queryParams +
               ", requestBody=" + requestBody +
               '}';
    }
}
