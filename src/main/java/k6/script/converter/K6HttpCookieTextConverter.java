package k6.script.converter;

import k6.http.HttpRequestAdocWrapper;
import k6.script.utils.MappingKeyValueTextUtils;
import k6.script.utils.WrappingKeyValuesTextUtils;

import java.util.stream.Collectors;

public class K6HttpCookieTextConverter {

    private static final String K6_COOKIES = "cookies";

    /**
     * @return cookies: {
     *     'KEY1': 'NAME1',
     *     'KEY2': 'NAME2',
     * }
     */
    public static String toCookieText(final HttpRequestAdocWrapper request) {
        final String headerParamMapping = request.getCookie().getCookieFields()
                .entrySet().stream()
                .map(MappingKeyValueTextUtils::mapping)
                .collect(Collectors.joining(System.lineSeparator()));

        return WrappingKeyValuesTextUtils.wrap(K6_COOKIES, headerParamMapping);
    }
}
