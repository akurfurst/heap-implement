import java.util.ArrayList;
import java.util.List;

/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */
public class Heap {
    private int size;
    private List<Integer> array;

    public Heap(){
        size = 0;
        array = new ArrayList<>();
    }

    public void add(int value){
        array.add(size - 1, value);
        size++;
        if(size <= 1) return;
        bubbleUp();
    }

    private void bubbleUp(){
        int currentIndex = size-1;
        while(currentIndex > 1){
            int parentIndex = (currentIndex - 1) / 2 ;
            if(array.get(currentIndex) < array.get(parentIndex)) swap(currentIndex, parentIndex);
            else return;
            currentIndex = parentIndex;
        }
    }

    private void swap(int i1, int i2){
        int temp = array.get(i2);
        array.add(i2, array.get(i1));
        array.add(i1, temp);
    }
}