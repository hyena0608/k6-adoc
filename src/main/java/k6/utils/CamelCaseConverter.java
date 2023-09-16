package k6.utils;

import java.util.Arrays;

import static java.util.Locale.ENGLISH;

public class CamelCaseConverter {

    private CamelCaseConverter() {
    }

    public static String toCamelCase(final String methodName) {
        final StringBuilder camelCaseMethodName = new StringBuilder();
        replaceToCamelCase(methodName, camelCaseMethodName);
        replaceFirstAlphabetToLowerCase(camelCaseMethodName);

        return camelCaseMethodName.toString();
    }

    private static void replaceToCamelCase(final String methodName, final StringBuilder camelCaseMethodName) {
        Arrays.stream(methodName.split("-"))
                .filter(word -> word.length() > 0)
                .forEach(word -> camelCaseMethodName
                        .append(word.substring(0, 1).toUpperCase(ENGLISH))
                        .append(word.substring(1)));
    }

    private static void replaceFirstAlphabetToLowerCase(final StringBuilder camelCaseMethodName) {
        final String firstCharacterLowerCase = camelCaseMethodName.substring(0, 1).toLowerCase(ENGLISH);
        camelCaseMethodName.replace(0, 1, firstCharacterLowerCase);
    }
}
