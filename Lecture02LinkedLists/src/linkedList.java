public class linkedList<T>
{
    protected Node<T> head;
    protected Node<T> tail;
    public int size;

    // constructor
    public linkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public int getSize()
    {
        return size;
    }

    public void insertAtHead(T val)
    {
        Node<T> nptr = new Node<T>(val, null);
        if (head == null) {
            head = nptr;
            tail = head;
        } else {
            nptr.setNext(head);
            head = nptr;
        }
        size++;
    }

    public void insertAtTail(T val)
    {
        Node<T> nptr = new Node<T>(val, null);
        if (head == null) {
            head = nptr;
            tail = head;
        } else {
            tail.setNext(nptr);
            tail = nptr;
        }
        size++;
    }

    public void insertAtPos(T val, int pos)
    {
        if (pos == 0) {
            insertAtHead(val);
            return;
        }

        if (pos > size) {
            insertAtTail(val);
            return;
        }

        Node<T> nptr = new Node<T>(val, null);
        Node<T> ptr = head;
        pos = pos - 1;
        for (int i = 0; i < size - 1; i++) {
            if (i == pos) {
                Node<T> tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setNext(tmp);
            }
            ptr = ptr.getNext();
        }
        size++;
        pos = pos + 1;
    }

    public boolean deleteAtPos(int pos)
    {
        if (pos > size - 1 || pos < 0) {
            return false;
        }

        if (isEmpty()) {
            return false;
        }

        if (pos == 0) {
            head = head.next;
            size--;
            return true;
        }

        if (pos == size - 1) {
            deleteTail();
            return true;
        }

        Node<T> ptr = head;
        pos = pos - 1;
        for (int i = 0; i < size; i++) {
            if (i == pos) {
                Node<T> tmp = ptr.next;
                tmp = tmp.next;
                ptr.setNext(tmp);
                size--;
                break;
            }
            ptr = ptr.next;
        }

        return true;
    }

    public T getAtPos(int pos)
    {
        if (pos < 0 || pos >= size) {
            return null;
        }
        Node<T> ptr = head;
        for (int i = 0; i < pos; i++) {
            ptr = ptr.getNext();
        }
        return ptr.getData();
    }

    public boolean deleteHead()
    {
        if (this.head != null) {
            this.head = head.next;
            size--;
            System.gc(); // garbage collector; remove unused nodes
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTail()
    {
        if (isEmpty()) {
            return false;
        }

        if (head.getNext() == null) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        Node<T> ptr = head;
        while (ptr.getNext() != tail) {
            ptr = ptr.getNext();
        }

        ptr.setNext(null);
        tail = ptr;
        size--;
        return true;
    }

    public void printList()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.println("Empty");
            return;
        }

        if (head.getNext() == null) {
            System.out.println(head.getData());
            return;
        }
        Node<T> ptr = head;
        System.out.print(head.getData() + " -> ");
        ptr = head.getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getData() + " -> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData() + "\n");
    }
}
