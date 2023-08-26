public class Node<T> {
    private T data;
    protected Node<T> next;
    protected Node<T> prev;

    // constructors
    public Node() {
        data = null;
        next = null;
        prev = null;
    }

    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }

    // setters/mutators
    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    // getters/accessors
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Data = " + String.valueOf(data);
    }
}
