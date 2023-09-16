package k6.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AdocFileReader {

    private AdocFileReader() {
    }

    public static List<String> read(final File adoc) {
        try {
            return Files.readAllLines(adoc.toPath());
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] adoc 파일을 읽던 도중에 오류가 발생하였습니다.");
        }
    }
}
