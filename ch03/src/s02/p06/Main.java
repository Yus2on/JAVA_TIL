package s02.p06;

/**
 * Getter, Setter
 *  멤버 변수를 간접적으로 다룰 수 있게 해주는 매소드
 *  멤버 변수의 캡슐화(Encaosulation)에 도움이 됨
 *          ->정보의 은닉/보호
 *  멤버 변수의 값을 제한할 때 유용
 *


 */
public class Main {
    int x, y;
    String z;
    float w;

    public int getX() { // 경우에 따라 구현하지 않는 경우도 있음.
        return x;
    }

    public void setX(int x) {
        // x의 조건이 있는 경우라면 Ex. 환자ID (1 ~ 1000)
        if(x > 0 && x <= 1000){
            this.x = x;
        }else{
            System.out.println(" x should be 1 <= x  <= 1000");
            System.out.println(" however, you put in x = " + x );
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}

class MainTest{
    public static void main(String[] args) {
        Main m = new Main();

        m.x = 10; // => 직접 값을 넣어주는 것은 권장되지 않는 멤버식 변수 처리 방
        System.out.println(m.getX());

        m.setX(20);
        System.out.println(m.getX());

        m.setX(1111111111);
        //System.out.println(m.getX());
    }
}