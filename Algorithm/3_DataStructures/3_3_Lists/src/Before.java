class MyArrayList {
    private int capacity;
    private int length;
    private int[] array;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        length = 0;
        array = new int[capacity];
    }

    public boolean isEmpty() {
        return (length == 0) ? true : false;
    }

    public boolean prepend(int value) {
        insert(0, value);
        return true;
    }

    public boolean append(int value) {
        insert(length, value);
        return true;
    }

    public boolean setHead(int index) {
        if (capacity <= index) {
            return false;
        }

        int [] newArray = new int[capacity - index];
        for (int i = index; i < length; i++) {
            newArray[i - index] = array[i];
        }
        array = newArray;
        capacity -= index;
        length -= index;
        return true;
    }

    public int access(int index) {
        if (length <= index ) {
            return -1;
        }
        return array[index];
    }

    public boolean insert(int index, int value) {
        if (length == capacity) {
            capacity *= 2;
            int [] newArray = new int[capacity];

            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }

            for (int i = index; i < length; i++) {
                newArray[i + 1] = array[i];
            }
            array = newArray;
        } else {
            for (int i = length - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
        }
        array[index] = value;
        length ++;
        return true;

    }

    public boolean remove(int index) {
        if (index >= length) {
            return false;
        }
        for (int i = index; i < length; i++) {
            array[i - 1] = array[i];
        }

        length --;
        return true;
    }

    public String toString() {
        String s = "";

        if (isEmpty()) {
           return "[]";
        }

        for (int i = 0; i < length; i++) {
            s += array[i] + " ";
        }
        return s;
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList(8);
        System.out.println(myList);

        for (int i = 0; i < 10; i++) {
            myList.append(i + 1);
        }
        System.out.println(myList);

        for (int i = 0; i < 10; i++) {
            myList.prepend(i + 1);
        }
        System.out.println(myList);

        int value = myList.access(3);
        System.out.println("myList.access(3) = " + value);

        myList.insert(8, 128);
        System.out.println(myList);

        myList.remove(4);
        System.out.println(myList);

        myList.setHead(10);
        System.out.println(myList);
    }
}