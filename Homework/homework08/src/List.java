/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 *
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 *
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    // List는 순서가 있는 연속된 값
    public void append(int value);
    public void prepend(int value);
    public void insert(int index, int value);
    public void remove(int index);
    public int get(int index);
    public void length();
}

class IntArrayList implements List {
    private int capacity;
    private int size = 0;
    int [] arrList;

    public IntArrayList(int capacity){
        this.capacity = capacity;
        arrList = new int[capacity];
    }

    @Override
    public void append(int value) { // append(): List의 마지막에 value를 삽입한다.
        checkSize();
        this.arrList[size] = value;
        size++;
    }

    @Override
    public void prepend(int value) { // prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
        checkSize();
        int [] new_array = new int[arrList.length];
        new_array[0] = value;
        System.arraycopy(arrList, 0, new_array, 1, arrList.length - 1);
        arrList = new_array;
        size++;
    }

    @Override
    public void insert(int index, int value) { // insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
        checkSize();
        for (int i = index + 1; i < size + 1; i++){ // index가 하나 작은 값이 들어가야 함
            arrList[i] = arrList[i - 1];
        }
        size++;
    }

    @Override
    public void remove(int index) { // remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
        for(int i = index; i < size - 1; i++) {
            arrList[i] = arrList[i + 1];
        }
        size--;
    }

    @Override
    public int get(int index) { // get(): index의 value를 반환한다.
        return this.arrList[index];
    }

    @Override
    public void length() { // length(): List의 길이를 출력한다.
        System.out.println("arrList의 길이 : " + size);
    }

    // 사이즈 체크해서 2배씩 늘리기
    private void checkSize() {
        if(this.size == capacity) {
            int[] newElements = new int [capacity * 2];
            System.arraycopy(arrList, 0, newElements, 0, arrList.length);
            arrList = newElements;
            capacity *= 2;
        }
    }

}
