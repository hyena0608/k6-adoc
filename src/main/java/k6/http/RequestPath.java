package k6.http;

public class RequestPath {

    private final String path;

    private RequestPath(final String path) {
        this.path = path;
    }

    public static RequestPath from(final String value) {
        return new RequestPath(value);
    }

    public String getValue() {
        return path;
    }

    @Override
    public String toString() {
        return "RequestPath{" +
               "path='" + path + '\'' +
               '}';
    }
}
