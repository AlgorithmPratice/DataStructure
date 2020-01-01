/**
 * 
 * @param <T> type of CircularLinkedList
 */
public class CircularLinkedList<T> extends DoublyLinkedList<T> {

    public CircularLinkedList() {
        super();
    }

    public CircularLinkedList(T data) {
        super(data);
    }

    @Override
    public T get(int index) {
        if (index > super.getSize()-1) {
            index %= super.getSize();
        }
        return super.get(index);
    }

    /**
     * insert data at last of arrayList
     * @param data data you want to insert
     */
    @Override
    public void add(T data) {
        super.add(data);
        super.getFirst().setPrevNode(super.getLast());
        super.getLast().setNextNode(super.getFirst());
    }

    /**
     * insert data at a specific index of arrayList
     * @param data data you want to insert
     * @param index the position you want to insert
     */
    @Override
    public void add(T data, int index) {
        super.add(data, index);
        if (index == 0) {
            super.getFirst().setPrevNode(super.getLast());
        }
    }

    @Override
    public T remove(int index) {
        T tempT = super.remove(index);
        if (index == 0) {
            super.getFirst().setPrevNode(super.getLast());
        } else if (index == super.getSize() - 1) {
            super.getLast().setNextNode(super.getFirst());            
        }

        return tempT;
    }
}