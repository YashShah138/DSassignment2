import java.util.ArrayList;
import java.util.List;

public class MinPQ <Key extends Comparable<Key>>
{

    private Key[] pq;
    private int n;
    private final int capacity = 4;
    private int[] runningTime = new int [capacity];

    public MinPQ()
    {
        pq = (Key[]) new Comparable[capacity+1];
    }


    public boolean isEmpty()
    {
        return n == 0;
    }

  /*  public void insert(Key key){
        pq[++n] = key;
        swim(n);
}*/


    //heap helper functions
    /*private void swim(int k){
        while (k>1 && less(k/2,k)){
            exch(k,k/2);
            k=k/2;
        }*/


    private static void sink(Comparable[] a, int k, int n) {
        while (2*k <= n){
            int j = 2*k;
            if (j < n && less(a, j+1, j)) j++;
            if (!less(a,k, j)) break;
            exch(a,k, j);
            k = j;
        }

    }

    //array helper functions
    private static boolean less(Comparable[] a, int i, int j)
    {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i - 1];  // Store the element at i-1 (1-based to 0-based conversion)
        a[i - 1] = a[j - 1];         // Set a[i-1] to a[j-1]
        a[j - 1] = temp;
    }





    public static void sort(Comparable[] a,Comparable[] b )
    {
        int n = a.length;
        List<Comparable> removedElements = new ArrayList<>(); // List to save removed elements

        // Step 1: Build the min-heap (or max-heap if sorting in reverse order)
        for (int k = n / 2; k >= 1; k--)
            sink(a, k, n); // Build the heap

        // Step 2: Sorting the heap and saving removed elements
        while (n > 1)
        {
            // Save the element being "deleted" (smallest or largest) to the list
            removedElements.add(a[1]); // Save the root element before swapping

            // Exchange the root (smallest/largest) with the last element in the heap
            exch(a, 1, n);

            // Decrease the size of the heap
            sink(a, 1, --n); // Restore the heap property for the reduced heap
        }

        // Optionally, you can add the final remaining element from the heap
        removedElements.add(a[1]); // Save the final element

        int count =0;
        int index = 0;
        while (count<removedElements.toArray().length){
            System.out.print("Execution order:"+b[(int) removedElements.get(index)]+ ", ") ;

        }

    }//
