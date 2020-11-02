package p04;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebParser {
    // Dependency injection
    // 테스트 케이스로 인해 (더 테스트 하기 위해) 더 좋은 코드로 리펙토링 할 수 있었다.
    public WebParser(Http http) {
        this.http = http;
    }

    private Http http;
    public int countImageFromWebPage(String url) throws IOException {
        String text = http.get(url);
        // String text = new HttpImpl().get(url);

        Pattern pattern = Pattern.compile("(\\w+.(png|jpg|gif))");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

}
