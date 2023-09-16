package k6.script.utils;

import java.util.Map;

public class MappingKeyValueTextUtils {

    /**
     * @return 'KEY: NAME'
     */
    public static String mapping(final Map.Entry<String, String> entry) {
        return String.format("'%s': '%s',", entry.getKey(), entry.getValue());
    }
}
