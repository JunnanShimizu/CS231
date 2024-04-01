/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.util.ArrayList;
import java.util.Iterator;

// Queue data structure
public class MyQueue <T> implements Iterable<T>{
    private class Node{
        Node next;
        Node previous;
        private T value;

        public Node(T val){
            this.next = null;
            this.previous = null;
            this.value = val;
        }

        public T getValue(){
            return this.value;
        }

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node node){
            this.next = node;
        }

        public Node getPrevious(){
            return this.previous;
        }

        public void setPrevious(Node node){
            this.previous = node;
        }
    }

    private Node tail;
    private Node head;
    private int size;

    public MyQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void offer(T val){
        Node newNode = new Node(val);

        if(this.size == 0){
            this.tail = newNode;
            this.head = newNode;
        }else{
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }

    public T poll(){
        T remove = null;

        if(size == 0){
            System.out.println("error, nothing to remove");
        }else if(size == 1){
            remove = head.getValue();
            this.tail = null;
            this.head = null;
        }else{
            remove = head.getValue();
            this.head = head.getNext();
            this.head.setPrevious(null);
        }
        size--;
        return remove;
    }

    public T peak(){
        if(head == null){
            return null;
        }else{
            return head.getValue();
        }
    }

    public int getSize(){
        return this.size;
    }

    private class QIterator implements Iterator<T> {
        private Node current;

        public QIterator(Node head){
            current = head;
        }

        public boolean hasNext(){
            if(current != null){
                return true;
            }else{
                return false;
            }
        }

        public T next(){
            if(this.hasNext()){
                T val = current.getValue();
                current = current.getNext();
                return val;
            }
            return null;
        }
    }

    public Iterator<T> iterator() {
        return new QIterator(this.head);
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> result = new ArrayList<T>();
        Iterator iter = this.iterator();
        while(iter.hasNext()){
            result.add((T) iter.next());
        }
        return result; }
}
