package k6.http;

public class RequestLine {

    private RequestMethod method;
    private RequestPath path;
    private HttpVersion httpVersion;

    /**
     * @params GET http://localhost:8080/api/v1 HTTP/1.1
     */
    public void setRequestLine(final String requestLine) {
        final String[] requestLineInfo = requestLine.split(" ");

        if (path == null) {
            this.path = RequestPath.from(requestLineInfo[1].strip());
        }

        this.method = RequestMethod.from(requestLineInfo[0].strip());
        this.httpVersion = HttpVersion.from(requestLineInfo[2].strip());
    }

    /**
     * @params http://localhost:8080/api/v1
     */
    public void setRequestPath(final String requestPath) {
        this.path = RequestPath.from(requestPath);
    }

    public RequestMethod getMethod() {
        return method;
    }

    public RequestPath getPath() {
        return path;
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String toString() {
        return "RequestLine{" +
               "method=" + method +
               ", path=" + path +
               ", httpVersion=" + httpVersion +
               '}';
    }
}
