package p04;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class WebParserTest {

    // 이렇게 테스트했을 시 문제점
    // 1. Fast에 대응하지 않는다. -> 느림. 인터넷 연결이 순간 안될 수도 있다.
    // 2. 웹페이지 내용의 변경 가능성
//    @Test
//    public void countImageFromGoogleDotCom() throws IOException {
//        WebParser parser = new WebParser();
//        int actualResult = parser.countImageFromWebPage("http://google.com");
//
//        assertThat(actualResult, equalTo(5));
//    }

    private WebParser parser;

    @Before
    public void setUpUsingPageWithThreeImages() {
        // DI를 이용 Http 객체의 Stub 를 구현하여 넣어준다( 임시 객체 생성)
        parser = new WebParser((targetUrl) -> {
            return "<html> <meta content=a.png><meta content=b.jpg><meta content=c.gif> </html>";
            // 코드에 직접 넣어주지 않고 html 파일을 외부에 만들고 불러와서 사용할 수도 있음
            // 테스트 코드가 많아질 수록 의미있어짐
        });

    }

    @Test
    public void countImageFromThreeImagePageStub() throws IOException {
        int actualResult = parser.countImageFromWebPage("http://google.com");

        assertThat(actualResult, equalTo(3));
    }

}