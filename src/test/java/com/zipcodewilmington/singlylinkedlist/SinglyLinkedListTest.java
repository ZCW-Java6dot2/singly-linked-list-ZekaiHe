package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> newList;
    @Before
    public void setup(){
        newList = new SinglyLinkedList<>();
        newList.add(1);
        newList.add(3);
        newList.add(5);
        newList.add(2);
    }
    @Test
    public void testAdd(){
        Integer expected = 7;
        newList.add(expected);

        Integer actual = newList.get(4);

        Assert.assertEquals(expected, actual);
    }

    @Test //remove middle
    public void testRemove1(){
        Integer expected = 5;

        newList.remove(1);
        Integer actual = newList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test //remove beginning
    public void testRemove2(){
        Integer expected = 3;

        newList.remove(0);
        Integer actual = newList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test //remove end
    public void testRemove3(){
        Integer expected = 5;

        newList.remove(3);
        Integer actual = newList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContains(){
        newList.add(10);
        Assert.assertTrue(newList.contains(10));
    }

    @Test
    public void testSize(){
        newList.add(10);
        Integer expected = 5;

        Integer actual = newList.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFind(){
        Integer expected = 2;

        Integer actual = newList.find(5);

        Assert.assertEquals(expected,actual);
    }

    @Test //cant loop through nodes in test since Node class is nested inside SinglyLinkedList so only accessible to SinglyLinkedList class
    public void testCopy(){
        SinglyLinkedList<Integer> newerList= new SinglyLinkedList<>();
        newerList = newList.copy();
        for(int i =0; i<newList.size(); i++){
            Assert.assertEquals(newerList.get(i), newList.get(i));
        }
    }

    @Test
    public void testSort1(){
        SinglyLinkedList<Integer> expectedSortedList = new SinglyLinkedList<>();
        expectedSortedList.add(1);
        expectedSortedList.add(2);
        expectedSortedList.add(3);
        expectedSortedList.add(5);
        
        SinglyLinkedList<Integer> actualSortedList = newList.sort();
        
        for(int i =0; i<newList.size(); i++){
            Assert.assertEquals(expectedSortedList.get(i), actualSortedList.get(i));
        }
    }

    @Test
    public void testSort2(){
        SinglyLinkedList<Integer> unsortedList = new SinglyLinkedList<>();
        unsortedList.add(5);
        unsortedList.add(2);
        unsortedList.add(3);
        unsortedList.add(9);
        unsortedList.add(1);
        unsortedList.add(7);

        SinglyLinkedList<Integer> expectedSortedList = new SinglyLinkedList<>();
        expectedSortedList.add(1);
        expectedSortedList.add(2);
        expectedSortedList.add(3);
        expectedSortedList.add(5);
        expectedSortedList.add(7);
        expectedSortedList.add(9);

        SinglyLinkedList<Integer> actualSortedList = unsortedList.sort();

        for(int i =0; i<unsortedList.size(); i++){
            Assert.assertEquals(expectedSortedList.get(i), actualSortedList.get(i));
        }

    }

}
