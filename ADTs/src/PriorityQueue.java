import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// INV: Element with the highest priority (determined by .compareTo) will be at the first position
public class PriorityQueue <T extends Comparable<T>> {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("AB");
        list.add("BC");
        list.add("AA");

        PriorityQueue<String> pQueue = new PriorityQueue<String>(list);

        System.out.println(pQueue.extract());
        System.out.println(pQueue.extract());

        System.out.println();

        pQueue.insert("PP");
        pQueue.insert("MM");
        pQueue.insert("A");

        System.out.println(pQueue.extract());
        System.out.println(pQueue.extract());
        System.out.println(pQueue.extract());
        System.out.println(pQueue.extract());
    }

    private List<T> storage;

    public PriorityQueue() {
        this.storage = new ArrayList<T>();
    }

    public PriorityQueue(List<T> createFrom) {
        this.storage = new ArrayList<T>();

        Iterator<T> itr = createFrom.iterator();
        while (itr.hasNext()) {
            T el = itr.next();
            this.insert(el);
        }
    }

    // insert element and keep invariant
    public void insert(T el) {
        // due to mathematical reasons, zero-indexing makes the calculations much more complex, so we will not do it here (!)
        this.storage.add(el);
        int pos = this.storage.size(); // (!)

        // System.out.println(this.storage);
        // restore heap invariant
        while (pos > 1) {
            int parentPos = pos/2; // no modulo needed due to java division
            
            // check if inv is fulfilled
            if (this.storage.get(pos-1).compareTo(this.storage.get(parentPos-1)) >= 0) break; // INV achieved, parentPos is greate, so .compareTo returns negative

            // restore inv
            this.swap(pos-1, parentPos-1);

            pos = parentPos;
        }
    }

    public T extract() {
        T max = this.storage.get(0);

        this.swap(0, this.storage.size()-1);
        this.storage.remove(this.storage.size()-1);

        this.restoreHeapCondition(0);

        return max;
    }

    private void restoreHeapCondition(int pos) {
        ++pos;

        while (pos*2 <= this.storage.size()) {
            int childPos = pos * 2;

            if (childPos+1 <= this.storage.size() && this.storage.get(childPos-1).compareTo(this.storage.get(childPos)) > 0) ++childPos;

            if (this.storage.get(pos-1).compareTo(this.storage.get(childPos-1)) <= 0) break;

            this.swap(pos-1, childPos-1);

            pos = childPos;
        }
    }

    private void swap(int p1, int p2) {
        T temp = this.storage.get(p1);
        this.storage.set(p1, this.storage.get(p2));
        this.storage.set(p2, temp);
    }
}
