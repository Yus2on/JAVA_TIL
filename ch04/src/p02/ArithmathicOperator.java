package p02;

// 다형성의 힘 ...
// 동일한 메소드로 인터페이싱.
public interface ArithmathicOperator {
    int operate(int x, int y);
    long operate(long x, long y);
    double operate(double x, double y);
}
