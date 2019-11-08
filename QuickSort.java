/*
Name: Ethan Chen
File Name: Quick Sort
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickSort {


    //Non-In-Place QuickSort
    public static int[] quickSortNIP(int[] list) {
        if (list.length <= 1) { // base case
            return list;
        } else { // step case
            int pivot = list[0]; // first item as pivot
            int numSmaller = 0; // counts number items smaller
            int numBigger = 0; // counts number items bigger

            for (int x = 1; x < list.length; x++) { // counts
                if (list[x] < pivot) {
                    numSmaller++;
                } else {
                    numBigger++;
                }
            }

            int[] larger = new int[numBigger]; // creates arrays corresponding to sizes
            int[] smaller = new int[numSmaller];
            int lIndex = 0;
            int sIndex = 0;

            for (int x = 1; x < list.length; x++) { // adds items to larger than pivot or smaller than accordingly
                if (list[x] < pivot) {
                    smaller[sIndex] = list[x];
                    sIndex++;
                } else {
                    numBigger++;
                    larger[lIndex] = list[x];
                    lIndex++;
                }
            }

            int[] lower = quickSortNIP(smaller); // does this in smaller and smaller groups until all length 1 (recursion)
            int[] higher = quickSortNIP(larger); // ditto

            int[] combinedList = new int[list.length]; // puts larger and smaller bits back together

            for (int x = 0; x < lower.length; x++) {
                combinedList[x] = lower[x];
            }

            combinedList[lower.length] = pivot;

            for (int x = 0; x < higher.length; x++) {
                combinedList[lower.length + 1 + x] = higher[x];
            }

            return combinedList;

        }

    }

    //In-Place Quick Sort
    public static int[] quickSortIP(int[] list, int low, int high) {
        if (low >= high) { // base case
            return list;
        } else { // step case
            int mid = pivotIndex(list, low, high); // finds what index the pivot is at in list and rearranges list
            int high2 = high; // creates new high so value isn't altered in method

            quickSortIP(list, low, mid-1); // bottom
            quickSortIP(list, mid+1, high2); // top

            return list;
        }

    }

    public static int pivotIndex(int[] list, int low, int high) {
        int loc = high;
        int pivot = list[low];

        for(int x = high; x>low; x--) { // if greater than pivot, put at top index, then second to top, then third, so on
            if(list[x] > pivot) {
                int temp = list[x]; // swaps make this in-place
                list[x] = list[loc];
                list[loc] = temp;
                loc--; // controls what index the higher values are being put/swapped at
            }
        }
        int temp = list[low]; // put pivot at pivot location
        list[low] = list[loc];
        list[loc] = temp;

        return loc; // return the index of the pivot

    }

    public static void main(String[] args) { // UI Tester
        StdOut.println("Welcome to the Quick Sort tester");
        StdOut.println("How long would you like your array to be?");
        int length = StdIn.readInt();
        int[] list = new int[length];
        int x = 0;
        boolean stop = false;

        StdOut.println();
        while(x<list.length && !stop) {
            StdOut.println("What would you like to add? Type 0 to stop adding.");
            int data = StdIn.readInt();

            if(data == 0) {
                stop = true;
            }

            list[x] = data;
            x++;
        }

        StdOut.println("Here is your list now: ");
        for(int z : list) {
            StdOut.print(z + " ");
        }

        StdOut.println();
        int[] sortedList = quickSortIP(list, 0, list.length-1);
        StdOut.println("Here is your sorted list, sorted via Quick Sort");
        for(int z : sortedList) {
            StdOut.print(z + " ");
        }

    }
}
