package p02;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
// assertThat을 쓸수있는데 어떻게 표현할것인지를 작성할 수있다.
import static org.junit.Assert.*;
// import static org.junit.AssertThat.*;

/**
 * AAA (Triple-A)
 * Arrange (준비) : 테스트를 하기 위해 시스템이 적절한 상태에 있게끔, 적절한 상태에 있는지 확인.
 *                  객체 생성, 객체의 기본적인 소통, API 호출 (테스트 할만한 상태로 만들어줌)
 *                  Arrange 와 Act의 구분 필요
 * Act (실행) : 실제로 테스트 코드를 실행하는 과정.
 * Assert (단언) : 실행한 코드의 결과를 기대하는 값과 비교
 *
 * + a
 * After (사후) : 중간 과정에서 자원을 할당한 경우, 그것을 해제 하는 과정
 *
 */

public class AccountTest {
    private Account account;

    // Before -> Test1 -> Before -> Test2
    // BeforeClass -> Before -> Test1 -> (After) -> Before -> Test2 -> (After) -> (AfterClass)

    @BeforeClass
    // static 으로 생성
    public static void classSetup() {
        // 맨 처음 한 번 실행
        // 오래 걸리고 딱 한 번 하면 되는 것들
    }

    @Before
    public void setUpBySetBalanceOneHundred(){
        Account account = new Account(100); // 1. Arrange
    }

    @Test
    public void answerIsMinusWithNegativeBalance(){
        account.withdraw(150); // 2. Act
        boolean actualResult = account.isMinus();
        // boolean에 대한 assert는 assertTrue / assertFalse 사용하면 좋다
       // assertTrue(actualResult); // 실패여부만 보여줌
       // assertThat(actualResult, equalTo(true));
        // 단, 실패했을 때 정보를 잘 표현하기 위해서는 hamcrest의 CoreMatchers에 구현된 matcher를 쓰는 것이 좋다
        assertThat(actualResult, is(equalTo(true))); // 3. Assert
        // 딱히 달라지는 건 없지만 코드가 달라짐. is가 들어감으로 인지적으로 읽기 좋게 해주는 방식
        assertThat(actualResult, not(equalTo(false))); //is <-> not
    }

    @Test
    public void answerIsNotMinusWithPositiveBalance(){
        account.withdraw(50);
        boolean actualResult = account.isMinus();

        assertThat(actualResult, is(not(equalTo(true))));
    }

    @Test
    public void checkPositiveBalanceAfterWithdraw() {
        account.withdraw(80);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(20)));
    }

    @Test
    @Ignore ("This will be tested later") // 이것을 남겨두고 commit 하지 마세요
    public void checkNegativeBalanceAfterWithdraw() {
        account.withdraw(120);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(-20)));
    }

    // ArithmeticException 이 발생하는 지 assert 하는 테스트

    // 간단하다는 장점이 있지만 인지적으로는 좋지 않음
    // test 메소드 내부에 assert 가 드러나지 않는다 .
    @Test(expected = ArithmeticException.class)
    public void checkExceptionByAnnotation() {
        account.throwExcept();
    }

    // 인지적으로 더 개선되나, 코드가 매우 복잡해진다.
    @Test
    public void checkExceptionByTryCatch(){
        try{
//            account.throwExcept();
            fail(); // 익셉션이 발생하지않아도 통과되서 익셉션이 발생하지 않은경우에 강제로 fail시켜버리는 것이다
        } catch (ArithmeticException e){
            assertThat(e.getClass(), equalTo(ArithmeticException.class));
        }
    }
    // Rule을 이용하면 메소드 코드에 excepted exception이 드러나서 인지적으로 개선 가장 추천함.
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkExceptionByRule(){
        thrown.expect(ArithmeticException.class); // 아리스메틱엑셥션을 기대한다고 써놔서 인지적으로 더 잘 이해가능
        account.throwExcept();
    }
}