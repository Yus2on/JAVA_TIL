package rect;

import java.util.Arrays;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */

class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;

        System.out.println("Vector2D - x  : " + this.x);
        System.out.println("Vector2D - y  : " + this.y);
    }

    public String toString(float x, float y) {
        // write codes here
        System.out.println("toString - x : " + x );
        System.out.println("toString - y : " + y );

        return "VECTOR2D";
        //return String.format("%f", x);
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;

    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString(float x, float y, float w, float h) {
        // write codes here
        return "RECTCORE";
    }
}


public class Rect extends RectCore {
    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h); // 부모의 x y w h
    }

    public float getArea() { // getArea(): 사각형의 넓이를 반환한다.
        // write codes here
        return w * h;
    }

    public Vector2D getCenterOfMass() { // getCenterOfMass(): 사각형의 질량중심을 반환한다.
        // write codes here
        return new Vector2D(pos.x, pos.y); // CoM: rect.Vector2D@53d8d10a
    }

    public Vector2D [] getAllPoints() { // GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
        Vector2D [] Vector2D = new Vector2D[4];
        Vector2D[0] = new Vector2D(pos.x, pos.y);
        Vector2D[1] = new Vector2D(pos.x + w, pos.y);
        Vector2D[2] = new Vector2D(pos.x, pos.y + h);
        Vector2D[3] = new Vector2D(pos.x + w,pos.y + h);
        return Vector2D;
    }

    public void rot90(Vector2D pivot) { // rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다. // 반시계방
        // write codes here
        System.out.println(pos.x - pivot.x);
    }

    public String toString() {
        // write codes here
        return "RECT";
    }
}

class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);
        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));

        rect.rot90(new Vector2D(0.4f, 0.2f));
        //System.out.println("Rotated rect: " + rect);
    }
}
