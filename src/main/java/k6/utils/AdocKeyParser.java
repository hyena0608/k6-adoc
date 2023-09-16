package k6.utils;

import java.util.List;

public class AdocKeyParser {

    private AdocKeyParser() {
    }

    /**
     * @param |`+KEY+`
     * @return KEY
     */
    public static List<String> parseAdocLines(final List<String> adocLines) {
        return adocLines.stream()
                .filter(line -> line.startsWith("|`+"))
                .map(line -> line.replaceAll("\\|", ""))
                .map(line -> line.replaceAll("\\`", ""))
                .map(line -> line.replaceAll("\\+", ""))
                .toList();
    }
}
