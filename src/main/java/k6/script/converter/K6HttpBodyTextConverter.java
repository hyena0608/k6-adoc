package k6.script.converter;

import k6.http.HttpRequestAdocWrapper;
import k6.script.utils.MappingKeyValueTextUtils;
import k6.script.utils.WrappingKeyValuesTextUtils;

import java.util.stream.Collectors;

public class K6HttpBodyTextConverter {

    /**
     * @return {
     *     'KEY1': 'NAME1',
     *     'KEY2': 'NAME2',
     * }
     */
    public static String toBodyText(final HttpRequestAdocWrapper request) {
        final String requestBody = request.getRequestBody().getFields()
                .entrySet().stream()
                .map(MappingKeyValueTextUtils::mapping)
                .collect(Collectors.joining(System.lineSeparator()));

        return WrappingKeyValuesTextUtils.wrap(requestBody);
    }
}
