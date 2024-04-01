import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LinkedList <T>{
    private class Node<T>{
        private Node next;
        T t;

        // a constructor that initializes next to null and the container field to item.
        public Node(T item) {
            this.next = null;
            t = item;
        }

        // returns the value of the container field.
        public T getThing() {
            return this.t;
        }

        // sets next to the given node.
        public void setNext(Node n){
            this.next = n;
        }

        // returns the next field.
        public Node<T> getNext() {
            return next;
        }
    }

    private class LLIterator implements Iterator<T> {
        private Node<T> head;
        private Node<T> next;

        // the constructor for the LLIterator given the head of a list.
        public LLIterator(Node head) {
            next = head;
        }

        // returns true if there are still values to traverse (if the current node reference is not null).
        public boolean hasNext() {
            if(next != null){
                return true;
            }else{
                return false;
            }
        }

        /*
        returns the next item in the list, which is the item contained in the current node.
        The method also needs to move the traversal along to the next node in the list.
         */
        public T next(){
            T temp = (T) this.next.t;
            this.next = this.next.getNext();
            return temp;
        }

        // does nothing. Implementing this function is optional for an Iterator.
        public void remove() {
        }

        // Return a new LLIterator pointing to the head of the list
        public Iterator<T> iterator() {
            return new LLIterator(this.head);
        }
    }

    private Node<T> head;
    private int size;

    // constructor that initializes the fields so it is an empty list.
    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    // empties the list (resets the fields so it is an empty list).
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    // returns the size of the list.
    public int size() {
        return this.size;
    }

    // inserts the item at the beginning of the list.
    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.setNext(head);
        head = newNode;
    }

    // appends the item at the end of the list.
    public void addLast(T item) {
//        LLIterator iterator = new LLIterator(this.head);
//        Node<T> oldNode = new Node<T>(item);
//        Node<T> newNode = new Node<T>(item);
//
//        while(iterator.hasNext()){
//            newNode = iterator.next;
//        }
//
//        oldNode.setNext(newNode);

        LLIterator iterator = new LLIterator(this.head);
        Node<T> oldNode = null;
        Node<T> newNode = new Node<T>(item);

        if(this.size() != 0) {
            while (iterator.hasNext()) {
                oldNode = iterator.next;
            }

            oldNode.setNext(newNode);
        }else{
            this.head = newNode;
        }
    }

    // inserts the item at the specified position in the list.
    public void add(int index, T item) {
        Node<T> newNode = new Node<T>(item);
        Node<T> temp = this.head;

        int counter = 0;

        while(counter < index - 1){
            temp = temp.next;
            counter++;
        }

        newNode.setNext(temp.next);
        temp.setNext(newNode);
        this.size++;
    }

    // removes the item at the specified position in the list.
    public T remove (int index) {
        LLIterator iterator = new LLIterator(this.head);

        Node<T> tail = null;
        while (iterator.hasNext()) {
            tail = iterator.next;
        }

        if(this.size != 0){
            Node<T> curr = this.head;
            Node<T> prev = null;
            int counter = 0;
            T result;

            while(counter < index){
                prev = curr;
                curr = curr.getNext();
                counter++;
            }

            if(curr == this.head){
                result = curr.getThing();
                this.head = this.head.getNext();
                this.size--;

                return result;
            }else if(curr == tail){
                result = curr.getThing();
                tail = prev;
                prev.setNext(null);
                this.size--;

                return result;
            }else{
                result = curr.getThing();
                prev.setNext(curr.getNext());
                this.size--;

                return result;
            }
        }
        return null;
    }

    // returns an ArrayList of the list contents in order.
    public ArrayList<T> toArrayList() {
        LLIterator iterator = new LLIterator(this.head);
        ArrayList<T> list = new ArrayList<T>();

        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    // returns an ArrayList of the list contents in shuffled order.
    public ArrayList<T> toShuffledList(){
        ArrayList<T> list = this.toArrayList();
        Collections.shuffle(list);
        return list;
    }
}
