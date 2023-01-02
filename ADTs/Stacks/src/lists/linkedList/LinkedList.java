package lists.linkedList;

public class LinkedList<T> {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println(list);

        list.addLast(3);
        list.addLast(4);
        System.out.println(list);

        list.addFirst(1);
        System.out.println(list);

        list.insert(1, 2);
        System.out.println(list);

        System.out.println(list.rmLast());
        System.out.println(list);

        System.out.println(list.rmFirst());
        System.out.println(list);

        System.out.println(list.rm(1));
        System.out.println(list.rm(0));
        System.out.println(list);
    }


    public Node<T> first = null;
    public Node<T> last = null;
    public int length = 0;

    public LinkedList () {}

    public T get(int pos) {
        if (pos >= this.length) throw new IndexOutOfBoundsException();
        
        Node<T> target = this.first;
        for (int i = 0; i < pos; ++i) target = target.next;

        return target.value;
    }

    public void insert(int pos, T value) {
        if (pos >= this.length) throw new IndexOutOfBoundsException();

        if (pos == 0) {
            this.addFirst(value);
            return;
        } else if (pos == this.length-1) {
            this.addLast(value);;
            return;
        }

        Node<T> target = this.first;
        for (int i = 0; i < pos-1; ++i) target = target.next;

        target.next = new Node<T>(value, target.next);

        ++this.length;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<T>(
            value, 
            this.first != null ? this.first : null // link to possible successor
        ); // create node 

        this.first = node; // insert node
        if (this.last == null) this.last = node; // handle edge case

        ++this.length;
    }

    public void addLast(T value) {
        Node<T> node = new Node<T>(value); // create
        if (this.length == 0) {
            this.first = node;
        } else {
            this.last.next = node;
        }
        this.last = node;

        ++this.length;
    }

    public T rm(int pos) {
        if (pos >= this.length) throw new IndexOutOfBoundsException();

        if (pos == 0) return this.rmFirst();
        else if (pos == this.length-1) return this.rmLast();

        Node<T> beforeTarget = this.first;
        for (int i = 0; i < pos-1; ++i) beforeTarget = beforeTarget.next;

        Node<T> target = beforeTarget.next;
        beforeTarget.next = target.next;

        --this.length;
        return target.value;
    }

    public T rmFirst() {
        if (this.length == 1) return this.removeOnly();

        Node<T> target = this.first;
        this.first = target.next;

        --this.length;
        return target.value;
    }

    public T rmLast() {
        if (this.length == 1) return this.removeOnly();
        
        Node<T> beforeLast;
        for (beforeLast = this.first; beforeLast.next.next != null; beforeLast = beforeLast.next);

        Node<T> target = beforeLast.next;
        beforeLast.next = null;
        this.last = beforeLast;

        --this.length;
        return target.value;
    }

    private T removeOnly() {
        Node<T> target = this.first;

        this.first = null;
        this.last = null;

        --this.length;
        return target.value;
    }

    @Override
    public String toString() {
        String res = "[";

        if (this.length == 0) return res += "]";

        for (Node<T> node = this.first; node != null; node = node.next) {
            res += node.value + "/" + (node.next != null ? node.next.value : "null");
            if (node.next != null) res += ", "; 
        }

        res += "]";

        return res;
    }
}
