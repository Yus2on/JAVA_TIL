package circularQ;

class CircularQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] array;
    private boolean isFull; // 꽉 찬 상태인지 아닌지 표기

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.array = new int[capacity];
        this.isFull = false; // false로 초기화 비어있는 큐는 무조건 꽉차잇지 안은 상태니까  false
    }

    public boolean put(int value) {
        if (isFull) { // 꽉찬 상태 = 오버플로우상태니까 실패함
            return false;
        }

        array[rear++] = value; //
        rear %= capacity; // rear가 capacity에 도달하면 나머지가 0이니까 다시 0 으로 이동해서 value 삽입

        if (rear == front) { // rear와 front가 같은지 체크
            // 맨 첨에 프론트도 0 리어도 0 같은 상태에서 시작
            // 프론트 == 리어 케이스는 딱 두개임 1. 비었을때 2. 꽉찼을때
            // 어떤 상황이던 get을 하면 무조건 isFull 은 false가 되어야 함 -> 꽉  찬 상황을 계속 트래킹 가능
            isFull = true;
        }
        return true;
    }

    public int get() {
        if (!isFull && rear == front) {
            return -1;
        }

        int value = array[front++];
        front %= capacity;
        // System.out.println(front + " 삭제함 ");
        isFull = false; // isFull 은 겟을 하면 무조건 false
        return value;
    }

    public int peek() {
        if (!isFull && rear == front) {
            return -1;
        }

        return array[(front + 1) % this.capacity];
    }

    public String toString() {
        String s = "";
        int endRear = rear;

        if (rear == front && !isFull) {
            return "[]";
        }

        if (rear <= front) { // 프론트가 리어보다 더 뒤쪽에 있으면(= 접합점을 통과하게 된다면)
            endRear += capacity; // 엔드리어에 커페지티만큼 추가
            // 원래 프론트 -> 리어엿는데 프론트 뒤에 가상의 어레이를 추가해서 기존어레이 마지막에 가상 어레이를 추가함
            // 그럼 프론트 앞으로 리어가 오게 됨
        }

        s += "[ ";
        for (int i = front; i < endRear; i++) {
            s += array[i % capacity] + " "; // 막상 접근할 때 capacity나눈 나머지로 구함
        }
        s += " ]";

        return s;
    }
}

class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        System.out.println(queue);

        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue); // 1 2 3

        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.get())); // -1
        System.out.println(queue); // []

        queue.put(4);
        queue.put(5);
        queue.put(6);
        System.out.println(queue); // 4 5 6

        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.peek()));
        System.out.println((queue.peek()));
        System.out.println((queue.get()));
        System.out.println(queue);
    }
}
