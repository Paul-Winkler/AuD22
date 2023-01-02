package lists.doublyLinkedList;

public class DoublyLinkedList<T> {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
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

    public DoublyNode<T> first = null;
    public DoublyNode<T> last = null;
    public int length = 0;

    public DoublyLinkedList () {}

    public T get(int pos) {
        if (pos >= this.length) throw new IndexOutOfBoundsException();
        
        DoublyNode<T> target;
        if (pos < this.length / 2) {
            target = this.first;
            for (int i = 0; i < pos; ++i) target = target.pre;
        } else {
            target = this.last;
            for (int i = this.length-1; i >= pos; ++i) target = target.suc;
        }

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

        DoublyNode<T> target = this.first;
        for (int i = 0; i < pos-1; ++i) target = target.suc;

        target.suc = new DoublyNode<T>(value, target, target.suc);

        ++this.length;
    }

    public void addFirst(T value) {
        DoublyNode<T> node = new DoublyNode<T>(
            value, 
            null,
            this.first != null ? this.first : null // link to possible successor
        ); // create node 

        this.first = node; // insert node
        if (this.last == null) this.last = node; // handle edge case

        ++this.length;
    }

    public void addLast(T value) {
        DoublyNode<T> node = new DoublyNode<T>(value, this.last, null); // create
        if (this.length == 0) {
            this.first = node;
        } else {
            this.last.suc = node;
        }
        this.last = node;

        ++this.length;
    }

    public T rm(int pos) {
        if (pos >= this.length) throw new IndexOutOfBoundsException();

        if (pos == 0) return this.rmFirst();
        else if (pos == this.length-1) return this.rmLast();

        DoublyNode<T> target = this.first;
        for (int i = 0; i < pos; ++i) target = target.suc;

        target.pre.suc = target.suc;
        target.suc.pre = target.pre;

        --this.length;
        return target.value;
    }

    public T rmFirst() {
        if (this.length == 1) return this.removeOnly();

        DoublyNode<T> target = this.first;
        this.first = target.suc;

        --this.length;
        return target.value;
    }

    public T rmLast() {
        if (this.length == 1) return this.removeOnly();

        DoublyNode<T> target = this.last;
        this.last = target.pre;

        --this.length;
        return target.value;
    }

    private T removeOnly() {
        DoublyNode<T> target = this.first;

        this.first = null;
        this.last = null;

        --this.length;
        return target.value;
    }

    @Override
    public String toString() {
        String res = "[";

        if (this.length == 0) return res += "]";

        for (DoublyNode<T> node = this.first; node != null; node = node.suc) {
            res += node.value + "/" + (node.suc != null ? node.suc.value : "null");
            if (node.suc != null) res += ", "; 
        }

        res += "]";

        return res;
    }
}
