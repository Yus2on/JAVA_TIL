package DLL;

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean prepend(int value) {
        if (isEmpty()) {
            this.head = new Node(value, null, null);
            this.tail = head;
            return true;
        }

        this.head.prev = new Node(value, this.head, null);
        this.head = this.head.prev;
        return true;
    }

    public boolean append(int value) {
        if (this.head == null) {
            this.head = new Node(value, null, null);
            this.tail = this.head;

            return true;
        }

        Node node = new Node(value, null, this.tail);

        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;

        return true;
    }

    public boolean setHead(int index) {
        Node headNode = this.head;

        for (int i = 0; i < index; i++) {
            headNode = headNode.next;

            if (headNode == null) {
                return false;
            }
        } // end for

        this.head = headNode;

        return true;
    }

    public int access(int index) {
        Node accessNode = this.head;

        for (int i = 0; i < index; i++) {
            accessNode = accessNode.next;

            if (accessNode == null) {
                return -1;
            }
        } // end for

        return accessNode.value;
    }

    public boolean insert(int index, int  value) {
        Node headNode = this.head;
        Node prev = null;
        Node next = null;

        for (int i = 0; i < index; i++) {
            prev = headNode;
            headNode = headNode.next;

            if (headNode == null) {
                return false;
            }
        } // end for

        Node newNode = new Node(value, headNode, prev);

        if (prev != null) {
            prev.next = newNode;
        }

        if (next != null) {
            next.prev = newNode;
        }

        return true;
    }

    public boolean remove(int index) {
        Node headNode = this.head;
        Node prev = null;
        Node next = null;

        if (index == 0) {
            return false;
        }

        for (int i = 0; i < index; i++) {
            prev = headNode;
            headNode = headNode.next;

            if( headNode == null) {
                return false;
            }
            next = headNode.next;
        } // end for

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = next;
        }

        return true;
    }

    public String toString() {
        Node curr = this.head;
        StringBuilder sb = new StringBuilder();

        if (curr == null) {
            sb.append("[ ]");
            return sb.toString();
        }

        sb.append("[ ");
        while (curr != null) {
            sb.append(curr.value).append(" ");
            curr = curr.next;
        } // end while
        sb.append("]");

        return sb.toString();
    }

    public String toStringInv() {
        Node curr = this.tail;
        StringBuilder sb = new StringBuilder();

        if(curr == null){
            sb.append("<<Inv>>\n[ ]\n");
            return sb.toString();
        }

        sb.append("[ ");
        while (curr != null){
            sb.append(curr.value).append(" ");
            curr = curr.prev;
        } // end while
        sb.append("]");

        return sb.toString();
    }
}

class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
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
        System.out.println(myList.toStringInv());
    }
}
