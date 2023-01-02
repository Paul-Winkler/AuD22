import lists.doublyLinkedList.DoublyNode;

public class Queue<T> {
    public static void main(String[] args) {
        Queue<String> list = new Queue<String>();

        list.enque("Hello ");
        System.out.println(list.deque());
        
        list.enque("World! ");
        System.out.println(list.deque());
    }

    private DoublyNode<T> first = null;
    private DoublyNode<T> last = null;
    private int size = 0;

    public Queue() {}

    public void enque(T value) {
        DoublyNode<T> node = new DoublyNode<T>(value, this.last, null);

        if (this.size == 0) this.first = node; 
        else this.last.suc = node;

        this.last = node;

        ++size;
    }

    public T deque() {
        if (this.size == 0) throw new IllegalArgumentException();

        DoublyNode<T> node = this.first;
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = node.suc;
            this.first.pre = null;
        }

        --this.size;
        return node.value;
    }
}
