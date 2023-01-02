package lists.linkedList;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node (T _value) {
        this(_value, null);
    }

    public Node (T _value, Node<T> _next) {
        this.value = _value;
        this.next = _next;
    }
}
