package k6.http;

import java.util.Arrays;

public enum RequestMethod {

    GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;

    public static RequestMethod from(final String value) {
        try {
            return RequestMethod.valueOf(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] RequestMethod 를 파싱하던 도중에 오류가 발생하였습니다.");
        }
    }

    public static boolean containsAnyMethod(final String value) {
        return Arrays.stream(RequestMethod.values())
                .filter(requestMethod -> value.startsWith(requestMethod.name()))
                .findFirst()
                .isPresent();
    }
}
