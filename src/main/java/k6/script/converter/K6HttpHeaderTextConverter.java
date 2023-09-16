package k6.script.converter;

import k6.http.HttpRequestAdocWrapper;
import k6.script.utils.MappingKeyValueTextUtils;
import k6.script.utils.WrappingKeyValuesTextUtils;

import java.util.stream.Collectors;

public class K6HttpHeaderTextConverter {

    private static final String K6_HEADERS = "headers";

    /**
     * @return headers: {
     *     'KEY1': 'NAME1',
     *     'KEY2': 'NAME2',
     * }
     */
    public static String toHeaderText(final HttpRequestAdocWrapper request) {
        final String headerParamMapping = request.getHeader().getHeaderFields()
                .entrySet().stream()
                .map(MappingKeyValueTextUtils::mapping)
                .collect(Collectors.joining(System.lineSeparator()));

        return WrappingKeyValuesTextUtils.wrap(K6_HEADERS, headerParamMapping);
    }
}
