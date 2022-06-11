import java.util.List;

/*
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class DoppeltVerketteteListe<E> implements List<E> {
    
    Node<E> head = null;
    Node<E> tail = null;

    public int size() {

    }

    public boolean isEmpty() {

    }

    public boolean contains(Object o) {

    }

    public <T> T[] toArray(T[] a) {

    }

    public boolean add(E e) {

        if (e == null) {
            return false;
        }

        Node<E> nodeToAdd = new Node<E>(e);

        if (this.head == null) {
            this.head = nodeToAdd;
            this.tail = nodeToAdd;
        } else {
            this.tail.setNext(nodeToAdd);
            nodeToAdd.setPrevious(this.tail);
            this.tail = nodeToAdd;
        }

        return true;
    }

    public boolean remove(Object o) {

    }

    public boolean addAll(Collection<? extends E> c) {

    }

    public void clear() {

    }

    public E get(int index) {

    }

    public E set(int index, E element) {

    }

    public void add(int index, E element) {

    }

    public E remove(int index) {

    }

    public int indexOf(Object o) {

    }

    public ListIterator<T> listIterator(int index) {

    }

    public Iterator<T> iterator() {

    }




}