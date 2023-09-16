package k6.extractor;

import k6.http.HttpRequestAdocWrapper;
import k6.http.RequestMethod;

import java.util.List;

public class AdocRequestLineExtractor implements AdocExtract {

    @Override
    public void setAdocInformation(final HttpRequestAdocWrapper request, final List<String> adocLines) {
        final String requestLine = adocLines.stream()
                .filter(RequestMethod::containsAnyMethod)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] http-request.adoc 에 RequestLine 을 파싱하던 도중 오류가 발생하였습니다."));

        request.setRequestLine(requestLine);
    }
}
