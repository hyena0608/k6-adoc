package k6.script.utils;

import static k6.script.Const.ENTER;

public class WrappingKeyValuesTextUtils {

    private WrappingKeyValuesTextUtils() {
    }

    public static String wrap(final String key, final String value) {
        if (value.isBlank()) {
            return String.format("%s: {},", key);
        }
        return String.format("%s: { %s %s %s },", key, ENTER, value, ENTER);
    }

    public static String wrap(final String value) {
        if (value.isBlank()) {
            return "";
        }
        return String.format("{ %s %s %s }", ENTER, value, ENTER);
    }
}
