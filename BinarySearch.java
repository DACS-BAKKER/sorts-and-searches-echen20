/*
Name: Ethan Chen
File Name: Binary Search
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {

    public static int iterativeBinarySearch(int[] sortedList, int target) {

        int higherIndex = sortedList.length - 1;
        int lowerIndex = 0;
        int targetIndex = -1;

        boolean searching = true;

        while (searching) {

            if (higherIndex - lowerIndex <= 1) { // not in list
                targetIndex = -1;
                searching = false;
            }

            if (sortedList[lowerIndex] == target) { // target at bottom
                targetIndex = lowerIndex;
                searching = false;
            }

            if (sortedList[higherIndex] == target) { // target at top
                targetIndex = higherIndex;
                searching = false;
            }

            if (target < sortedList[(higherIndex + lowerIndex) / 2]) { // reduce range to lower half
                higherIndex = (higherIndex + lowerIndex) / 2;

            } else if (target > sortedList[(higherIndex + lowerIndex) / 2]) { // reduce range to upper half
                lowerIndex = (higherIndex + lowerIndex) / 2 + 1;

            } else { // target at middle
                targetIndex = (higherIndex + lowerIndex) / 2;
                searching = false;

            }
        }

        return targetIndex;

    }

    public static int recursiveBinarySearch(int[] sortedList, int target, int higher, int lower) {
        if (sortedList[higher] == target) { // base case 1, found target
            return higher;
        } else if (sortedList[lower] == target) { // base case 2, found target
            return lower;
        } else if (higher - lower <= 1) { // base case 3, doesn't exist
            return -1;
        } else { // step case
            if (target < sortedList[(higher + lower) / 2]) { // reduce range to lower half
                return recursiveBinarySearch(sortedList, target, (higher + lower) / 2, lower);

            } else if (target > sortedList[(higher + lower) / 2]) { // reduce range to upper half
                return recursiveBinarySearch(sortedList, target, higher, (higher + lower) / 2);

            } else { // target at middle
                return (higher + lower) / 2;

            }
        }
    }



    public static void main(String[] args) { // tester
        StdOut.println("Welcome to the binary search tester");
        StdOut.println("Would you like to perform this iteratively or recursively? 0: Iterative; 1: Recursive");
        int i = StdIn.readInt();

        StdOut.println("How long would you like your array to be?");
        int length = StdIn.readInt();
        int[] list = new int[length];
        int x = 0;
        boolean stop = false;

        StdOut.println();
        while (x < list.length && !stop) {
            StdOut.println("What would you like to add? Type 0 to stop adding.");
            int data = StdIn.readInt();

            if (data == 0) {
                stop = true;
            }

            list[x] = data;
            x++;

        }

        int[] sortedList = QuickSort.quickSortIP(list, 0, list.length - 1);
        StdOut.println();
        StdOut.println("The Sorted List is: ");
        for (int z : sortedList) {
            StdOut.print(z + " ");
        }

        StdOut.println();
        StdOut.println("What value would you like to target?");
        int target = StdIn.readInt();

        //int[] sortedList = {-55, -23, -7, -5, 0, 2, 4, 7, 19};
        if(i == 0) {
            StdOut.println(target + " is at index " + iterativeBinarySearch(sortedList, target) + " of the list, found iteratively.");
        } else {
            StdOut.println(target + " is at index " + recursiveBinarySearch(sortedList, target, sortedList.length - 1, 0) + " of the list, found recursively.");
        }
    }

}
