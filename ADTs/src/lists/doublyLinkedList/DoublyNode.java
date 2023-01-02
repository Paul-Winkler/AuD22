package lists.doublyLinkedList;

public class DoublyNode<T> {
    public T value;
    public DoublyNode<T> pre;
    public DoublyNode<T> suc;

    public DoublyNode (T _value) {
        this(_value, null, null);
    }

    public DoublyNode (T _value, DoublyNode<T> _pre, DoublyNode<T> _suc) {
        this.value = _value;
        this.pre = _pre;
        this.suc = _suc;
    }
}
