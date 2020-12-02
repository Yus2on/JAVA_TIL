package p02;

public class Main {
    public static void main(String[] args) {
        ArithmathicOperator op;
        op = new Add();
        System.out.println(op.operate(10, 20));

        ArithmathicOperator [] ops;
        ops = new ArithmathicOperator[]{ new Add(), new Mutiply()};
        for(ArithmathicOperator O: ops){
            System.out.println(op.operate(5, 2));
        }
    }
}
