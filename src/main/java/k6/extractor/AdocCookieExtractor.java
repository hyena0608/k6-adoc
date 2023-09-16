package k6.extractor;

import k6.http.HttpRequestAdocWrapper;
import k6.utils.AdocKeyParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdocCookieExtractor implements AdocExtract {

    @Override
    public void setAdocInformation(final HttpRequestAdocWrapper request, final List<String> adocLines) {
        final Map<String, String> cookieInfo = AdocKeyParser.parseAdocLines(adocLines)
                .stream()
                .collect(Collectors.toMap(
                        name -> name,
                        none -> "TEMP_VALUE"
                ));

        request.setCookie(cookieInfo);
    }
}
