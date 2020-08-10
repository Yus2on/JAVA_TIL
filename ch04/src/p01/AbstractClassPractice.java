package p01;

/**
 * AbstactStack
 * -> Stack
 *
 * 후입선출  : 나중에 넣은 데이터가 먼저 나옴...
 *
 * Stack 이란 자료구조에는
 *  is_empty(); -> 비어있는지 확인
 *  push();     -> 데이터를 넣음
 *  pop();      -> 데이터를 빼냄
 *  peek();     -> 데이터를 빼지 않고 보기만 함. 여전히 데이터가 남아있음
 *
 */


abstract class AbstractStack { // 추상 클래스
    protected int capacity; // 얼만큼 넣을건지 지정
    protected int top;   // 현재 몇개나 가지고 있는지. 데이터가 들어올때마다 top 이 하나씩 증가함

    public AbstractStack( int capacity) {
        this.capacity = capacity;
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
        //top이 0 이면 true, top 이 증가를 해서 0이 아니면  false
    }

    public abstract void push (int value);
    public abstract int pop();
    public abstract int peek();
}

class ArrayStack extends AbstractStack{
    private int [] array;

    public ArrayStack(int capacity){
        super(capacity);
        array = new int [capacity];
    }

    @Override
    public void push(int value) {
        if ( top == capacity ) {
            int [] new_array = new int[capacity * 2];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
            capacity *= 2;
        }
        array[top++] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()){
            return -1;
        }
        return array[--top]; // 실제 빼는 것
    }

    @Override
    public int peek() {
        if (isEmpty()){
            return -1;
        }
        return array[top - 1]; // 바로 아래 있는 데이터 출력만
    }
}


public class AbstractClassPractice {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);

        for (int i = 0; i < 15; i ++){
            stack.push(i);
            // 0 ~ 9 까지 입력
        }

        System.out.println(stack.peek());
        System.out.println(stack.peek());

        for (int i = 0; i < 20; i ++){
            System.out.println(stack.pop());
            // 9 ~ 0 으로 출력
        }
    }
}
