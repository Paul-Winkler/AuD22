import lists.linkedList.Node;

public class Stack<T> {
    public static void main(String[] args) {
        Stack<String> list = new Stack<String>();

        list.push("World! ");
        list.push("Hello ");
        System.out.print(list.pop());
        System.out.println(list.pop());
    }

    private Node<T> top = null;
    private int size = 0;

    public Stack() {}

    public void push(T value) {
        Node<T> node = new Node<T>(value, this.top);
        
        this.top = node;

        ++this.size;
    }

    public T pop() {
        if (this.size == 0) throw new IllegalArgumentException();

        Node<T> removed = this.top;
        
        if (this.size == 1) this.top = null;
        else this.top = this.top.next;

        --this.size;
        return removed.value;
    }
}