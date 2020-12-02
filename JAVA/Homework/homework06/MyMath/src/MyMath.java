/**
 * MyMath 클래스 구현하기
 * 인스턴스를 생성할 수 없는 MyMath 클래스를 구현하시오. --> private
 *
 * MyMath 클래스는 다음 정적 변수를 가진다.
 * PI = 3.1415927;
 * E = 2.718281;
 *
 * MyMath 클래스는 다음 정적 메소드를 가진다.
 * min - 정수 또는 실수를 여러개 입력받아 최소값을 구한다.
 * max - 정수 또는 실수를 여러개 입력받아 최대값을 구한다.
 * abs - 정수 또는 실수를 입력받아 절대값을 구한다.
 * floor - 실수를 입력받아 내림 연산한 정수를 출력한다.
 * ceil - 실수를 입력받아 올림 연산한 정수를 출력한다.
 */

public class MyMath {
    public static double PI = 3.1415927;
    public static double E = 2.718281;

    private MyMath(){};

    // 여러개 입력받아 최소값
    static double min(double... params){
        double min = params[0];
        for(int i = 0; i < params.length; i ++){
            if(params[i] < min) // 한줄 실행이라 {} X
                min = params[i];
        }
        return min;
    }
    static int min(int... params){
        int min = params[0];
        for(int i = 0; i < params.length; i ++){
            if(params[i] < min) // 한줄 실행이라 {} X
                min = params[i];
        }
        return min;
    }

    // 여러개 입력 받아 최대값
    static double max(double... params){
        double max = params[0];
        for(int i = 0; i < params.length; i ++ ){
            if(params[i] > max)
                max = params[i];
        }
        return max;
    }
    static int max(int... params){
        int max = params[0];
        for(int i = 0; i < params.length; i ++ ){
            if(params[i] > max)
                max = params[i];
        }
        return max;
    }

    // 정수 또는 실수를 입력받아 절대값을 구한다.
    static double abs(double params){
        return Math.abs(params);
    }
    static int abs(int params){
        return Math.abs(params);
    }

    static double floor(double params){ // 실수를 입력받아 내림 연산한 정수를 출력한다.
        double floor = Math.floor(params);
        return floor;
    }

    static double ceil(double params){ // 실수를 입력받아 올림 연산한 정수를 출력한다.
        double ceil = Math.ceil(params);
        return ceil;

    }
}

class MyMathTest {
    public static void main(String[] args) {
        System.out.println(MyMath.PI);
        System.out.println(MyMath.E);

        System.out.println(MyMath.min(2.1, 3.4, -4.65, -2.11, -1.9));
        System.out.println(MyMath.min(2, 3, -4, -2, -1));

        System.out.println(MyMath.max(7, 0, 6, 16, -4, 32, 100));
        System.out.println(MyMath.max(7.6, 0.0, 6.4, 16, -4, 32, 100));

        System.out.println(MyMath.abs(-5.395));
        System.out.println(MyMath.abs(-2.3));
        System.out.println(MyMath.floor(-9.5));
        System.out.println(MyMath.ceil(4.1));
    }
}


