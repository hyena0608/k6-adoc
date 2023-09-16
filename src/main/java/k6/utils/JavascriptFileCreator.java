package k6.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class JavascriptFileCreator {

    private static final Logger log = LoggerFactory.getLogger(JavascriptFileCreator.class);

    public static void toJavascriptFile(final String javascriptCode) {
        final String filePath = String.format("k6Api-%s.js", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        try {
            final FileWriter fileWriter = new FileWriter(filePath);
            final PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(javascriptCode);

            printWriter.close();
            log.info("파일이 생성되었습니다.");
        } catch (IOException e) {
            log.error("[ERROR] 추출한 k6 api 를 자바스크립트 함수로 만든던 도중에 오류가 발생하였습니다.", e);
        }
    }
}
