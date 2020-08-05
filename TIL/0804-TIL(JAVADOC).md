# TIL

## JavaDoc 주석이란

- java 클래스 및 패키지를 문서화 하기 위한 주석
- 클래스의 용도와 사용법 등을 설명하고 있는 규칙
- 자동으로 JavaDoc 문서를 생성할 수 있음



## Java Doc 작성 방법

```` java
/**
 * 클래스에 대한 설명. 이 클래스는 자바독 클래스로서 자바독을 공부하기 위해...
 * @author Jeyong Shin
 */
public class JavaDocs {
    /**
     * 멤버 변수에 대한 설명을 적을 수 있습니다.
     */
    int memberInt;

    /**
     * 멤버 변수 또 다른것도 설명을 적을 수 있습니다.
     */
    String memberString;

    /**
     * 생성자에 대한 설명입니다.
     * @param memberInt 입력1입니다.
     * @param memberString 입력2입니다.
     */
    public JavaDocs(int memberInt, String memberString) {
        this.memberInt = memberInt;
        this.memberString = memberString;
    }

    /**
     * 메소드에 대한 설명을 여기에 적습니다.
     * @param string 입력 인자 (파라미터)에 대한 설명을 적습니다.
     * @return 리턴값에 대한 설명은 여기에 적습니다.
     */
    public int methodA(String string) {
        return string.length();
    }

    public static void main(String[] args) {
        JavaDocs j = new JavaDocs(1, "string");
        j.methodA("abc");
    }
}
````





## IntelliJ IDEA에서 JavaDoc 생성

![JavaDoc 생성](https://github.com/ai-creatv/java-jbd1/raw/master/3_OOP/3_3_JavaDoc/img/1.png)

- `Tools` -> `Generate JavaDoc...`으로 JavaDoc 생성
- 대상 파일 범위 및 출력 위치 설정
- 한글 지원을 위해 `-encoding utf-8` 인자 전달(전부 영어로 작성 시에는 무관)

