package k6.extractor;

import k6.http.HttpRequestAdocWrapper;
import k6.utils.AdocKeyParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdocMessageBodyExtractor implements AdocExtract {

    @Override
    public void setAdocInformation(final HttpRequestAdocWrapper request, final List<String> adocLines) {
        final Map<String, String> requestBody = AdocKeyParser.parseAdocLines(adocLines)
                .stream()
                .filter(line ->
                        !(line.startsWith("String") ||
                          line.startsWith("Number") ||
                          line.startsWith("Array")))
                .collect(Collectors.toMap(
                        name -> name,
                        none -> "TEMP_VALUE"
                ));

        request.setRequestBody(requestBody);
    }
}
