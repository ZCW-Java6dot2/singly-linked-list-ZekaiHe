package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E> {

    private int size;
    private Node last;
    private Node head;

    class Node{
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public E getValue(){
            return value;
        }

        public void setValue(E e){
            this.value = e;
        }
    }

    public SinglyLinkedList(){
    }

    public boolean add(E e){
        Node newNode = new Node(e);
        if(size!=0){
            last.next = newNode; //order is important here, need to point the previous last to the new node
            last = newNode; //then reassign the new node as last;
        }
        else if(size == 0){ //lone element means the element is both the head and the last;
            head = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    public void remove(int index){
        rangeCheck(index);
        if(index==size-1 && size!=1){
            Node current = getNode(index-1);
            last = current;
            last.next = null;
        }
        else if (index == 0){
            head = head.next;
        }
        else{
            Node current = getNode(index);
            current.value = current.next.value;
            current.next = current.next.next;
        }
        size--;
    }

    public int find(E e){
        int indexCounter = 0;
        Node current = head;
        while(current!=null){
            if(current.getValue() == e){
                return indexCounter;
            }
            indexCounter++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(E e){
        return find(e)>0;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        rangeCheck(index);
        if(index==size-1 && size!=1){
            return last.getValue();
        }
        else if (index == 0){
            return head.getValue();
        }
        else {
            Node current = loopNodeIndex(index);
            return current.getValue();
        }
    }

    public Node getNode(int index){
        rangeCheck(index);
        if(index==size-1 && size!=1){
            return last;
        }
        else if (index == 0){
            return head;
        }
        else {
            Node current = loopNodeIndex(index);
            return current;
        }
    }

    private Node loopNodeIndex(int index) {
        int indexCounter = 0;
        Node current = head;
        while (current != null) {
            if (indexCounter == index) {
                break;
            }
            indexCounter++;
            current = current.next;
        }
        return current;
    }

    public SinglyLinkedList copy(){ //should be deep copy?
        SinglyLinkedList<E> newList = new SinglyLinkedList<>();
        Node current = head;
        while (current!=null){
            newList.add(current.getValue());
            current = current.next;
        }
        return newList;
    }

    public SinglyLinkedList<E> sort(){ //bubblesort because mergesort is so hard...swapping node values, moving pointers would cause mass confusion
        boolean isSorted;
        for (Node i = head; i.next != null; i = i.next){
            isSorted = true;
            for(Node j = head ;j.next != null; j = j.next){
                if((Integer)j.getValue() > (Integer)j.next.getValue()){ //had to cast to use > operator
                    E tempValue = j.getValue();
                    j.setValue(j.next.getValue());
                    j.next.setValue(tempValue);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
        return this;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

}
