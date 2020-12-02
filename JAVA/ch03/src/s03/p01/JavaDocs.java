package s03.p01;

/**
 * 클래스에 대한 설명 이 클래스는 자바독 클래스로서 자바독을 공부하기 위함 입니다
 * @author yus2on
 */
public class JavaDocs {
    /**
     *  멤버 변수에 대한 설명을 적습니다
     */
    int memberInt;

    /**
     * 멤버 변수에 또 다른 것도 설명을 적습니다
     */
    String memberStr;

    /**
     *
     * @param memberInt 멤버 변수 1 입니다
     * @param memberStr 멤버 변수 2 입니다
     */
    public JavaDocs(int memberInt, String memberStr) {
        this.memberInt = memberInt;
        this.memberStr = memberStr;
    }

    /**
     * 메소드에 설명을 여기에 적습니다
     * @param str 입력 인자 (파라미터)에 대한 설명을 여기에 적습니다
     * @return 리턴값에 대한 설명은 여기 적습니다.
     */
    public int methodA(String str){
        return str.length();
    }

    public static void main(String[] args) {
        JavaDocs j = new JavaDocs(1, "string");
        j.methodA("abc");
    }
}
