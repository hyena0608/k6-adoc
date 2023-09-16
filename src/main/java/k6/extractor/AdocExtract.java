package k6.extractor;

import k6.http.HttpRequestAdocWrapper;

import java.util.List;

public interface AdocExtract {

    void setAdocInformation(final HttpRequestAdocWrapper request, final List<String> adocLines);
}
