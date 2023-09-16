package k6;

import k6.extractor.AdocExtractorComposite;
import k6.http.HttpRequestAdocWrapper;
import k6.script.K6ApiScript;
import k6.utils.JavascriptFileCreator;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author hyena0608
 */
public class K6ScriptExtractor {

    private static final String IMPORT_K6 = "import http from 'k6/http';" + System.lineSeparator() + System.lineSeparator();
    private static final File SNIPPETS_DIR = new File("build/generated-snippets");
    private static final AdocExtractorComposite ADOC_EXTRACTOR_COMPOSITE = new AdocExtractorComposite();

    public static void main(String[] args) {
        final List<List<File>> api = getAllApiAdocs(SNIPPETS_DIR);
        for (List<File> adocs : api) {
            final HttpRequestAdocWrapper request = ADOC_EXTRACTOR_COMPOSITE.convert(adocs);
            final K6ApiScript script = K6ApiScript.toScript(request);
        }

        final String k6Apis = getK6ApiScriptText(api);
        JavascriptFileCreator.toJavascriptFile(k6Apis);
    }

    private static List<List<File>> getAllApiAdocs(final File snippetsDirectory) {
        return Arrays.stream(snippetsDirectory.listFiles())
                .map(File::listFiles)
                .flatMap(Stream::of)
                .map(file -> file.listFiles())
                .map(Arrays::asList)
                .collect(toList());
    }

    private static String getK6ApiScriptText(final List<List<File>> api) {
        final String k6Apis = IMPORT_K6 + api.stream()
                .map(ADOC_EXTRACTOR_COMPOSITE::convert)
                .map(K6ApiScript::toScript)
                .map(K6ApiScript::getValue)
                .collect(Collectors.joining(System.lineSeparator()));
        return k6Apis;
    }
}
