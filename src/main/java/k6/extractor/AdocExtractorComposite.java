package k6.extractor;

import k6.http.HttpRequestAdocWrapper;
import k6.utils.AdocFileReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdocExtractorComposite {

    private static final String HTTP_REQUEST_ADOC = "http-request.adoc";
    private static final String QUERY_PARAMS_ADOC = "query-parameters.adoc";
    private static final String PATH_PARAMS_ADOC = "path-parameters.adoc";
    private static final String REQUEST_BODY_ADOC = "request-fields.adoc";
    private static final String REQUEST_HEADERS_ADOC = "request-headers.adoc";
    private static final String REQUEST_COOKIES_ADOC = "request-cookies.adoc";

    private static final Map<String, AdocExtract> ADOC_EXTRACTORS = new HashMap<>();

    static {
        ADOC_EXTRACTORS.put(HTTP_REQUEST_ADOC, new AdocRequestLineExtractor());
        ADOC_EXTRACTORS.put(PATH_PARAMS_ADOC, new AdocPathParamsExtractor());
        ADOC_EXTRACTORS.put(QUERY_PARAMS_ADOC, new AdocQueryParamsExtractor());
        ADOC_EXTRACTORS.put(REQUEST_BODY_ADOC, new AdocMessageBodyExtractor());
        ADOC_EXTRACTORS.put(REQUEST_HEADERS_ADOC, new AdocHeaderExtractor());
        ADOC_EXTRACTORS.put(REQUEST_COOKIES_ADOC, new AdocCookieExtractor());
    }

    public HttpRequestAdocWrapper convert(final List<File> adocs) {
        final HttpRequestAdocWrapper requestMappingInfo = new HttpRequestAdocWrapper();
        requestMappingInfo.setControllerMethodName(adocs);
        for (File adoc : adocs) {
            final AdocExtract adocExtractor = ADOC_EXTRACTORS.get(adoc.getName());
            if (adocExtractor == null) {
                continue;
            }
            adocExtractor.setAdocInformation(requestMappingInfo, AdocFileReader.read(adoc));
        }

        return requestMappingInfo;
    }
}
