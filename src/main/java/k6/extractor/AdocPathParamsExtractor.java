package k6.extractor;

import k6.http.HttpRequestAdocWrapper;
import k6.utils.AdocKeyParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdocPathParamsExtractor implements AdocExtract {

    @Override
    public void setAdocInformation(final HttpRequestAdocWrapper request, final List<String> adocLines) {
        final Map<String, String> paramInfo = AdocKeyParser.parseAdocLines(adocLines)
                .stream()
                .collect(Collectors.toMap(
                        name -> name,
                        none -> "TEMP_VALUE"
                ));

        request.setPathParams(paramInfo);
        setNewRequestPath(request, adocLines);
    }

    private static void setNewRequestPath(final HttpRequestAdocWrapper request, final List<String> adocLines) {
        adocLines.stream()
                .filter(line -> line.startsWith(".+"))
                .map(line -> line.replaceAll("\\.", ""))
                .map(line -> line.replaceAll("\\+", ""))
                .findFirst()
                .ifPresent(newPath -> request.setRequestPath(newPath));
    }
}
