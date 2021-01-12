package linearQ;

class LinearQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] array;

    public LinearQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.array = new int[capacity];
    }

    public boolean put(int value) {
        // rear -> 최근에 들어온 데이터 위치임... 새로운 데이터가 들어오기 위해 먼저 이동해야 됨
        // rear 이 capacity랑 같으면 꽉찬거임 put 할 수 없어짐
        if (rear == capacity) {
            System.out.println("put!!!! ");
            return false;
        }

        // 원형큐라서 순환해야 함
        array[rear++] = value;
        return true;
    }

    // 데이터가 나갈 땐 front 이동
    public int get() {
        // front와 rear이 같은 위치 -> 큐가 비어잇는 상태
        if (front == rear) {
            return -1;
        }

        // 큐에 데이터가 있을 땐 -> front 이동(증가)
        return array[front++];
    }

    public int peek() {
        if (front == rear) {
            return -1;
        }

        return array[front];
    }

    public String toString() {
        String s = "";
        for (int i = front; i < rear; i++) {
            s += array[i] + " ";
        }
        return s;
    }
}


class LinearQueueTest {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);
        System.out.println(queue);

        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue);

        System.out.println((queue.get())); // 하나씩 앞에서부터 꺼내옴
        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println(queue);

        // capacity를 5로 지정해서 4 5 밖에 안들어감
        queue.put(4);
        queue.put(5);
        queue.put(6);
        System.out.println(queue);

        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.peek()));
        System.out.println((queue.peek()));
        System.out.println((queue.get()));
        System.out.println(queue);
    }
}
