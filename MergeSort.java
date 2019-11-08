/*
Name: Ethan Chen
File Name: Merge Sort, Bottom-Up and Top-Down
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class MergeSort {

    //Top Down merge sort (Recursive)
    public static int[] TDmergeSort(int[] list) {
        int m = list.length / 2; // length in half

        if (list.length == 1) {
            return list;
        } else {

            int[] half1;
            int[] half2;

            if (list.length % 2 == 1) { // for odd numbers
                half1 = new int[m + 1]; // bottom half has 1 more item than top half
                for (int x = 0; x < m + 1; x++) {
                    half1[x] = list[x];
                }
                half2 = new int[m];
                for (int x = m + 1; x < list.length; x++) {
                    half2[x - (m + 1)] = list[x];
                }
            } else {
                half1 = new int[m]; // both have same num items
                for (int x = 0; x < m; x++) {
                    half1[x] = list[x];
                }
                half2 = new int[m];
                for (int x = m; x < list.length; x++) {
                    half2[x - m] = list[x];
                }
            }

            int[] bottom = TDmergeSort(half1); // cuts smaller lists in half until length 1 (recursive
            int[] top = TDmergeSort(half2); // again

            return merge(bottom, top);

        }
    }

    public static int[] merge(int[] half1, int[] half2) {
        int[] newList = new int[half1.length + half2.length];

        int one = 0; // indexes of half1
        int two = 0; // indexes of half2
        int comb = 0; // combined index in new list
        int which = 0; // says which half last had an item taken from it

        while (one < half1.length && two < half2.length) { // checks smallest in each, and smaller goes in first index
            // next item in same list as the one that just went in is compared against the same one from before, and smaller
            // of two goes in. Continues until one of the lists is completely gone
            if (half1[one] < half2[two]) {
                newList[comb] = half1[one];
                one++;
                comb++;
                which = 1;
            } else {
                newList[comb] = half2[two];
                two++;
                comb++;
                which = 0;
            }
        }

        while (comb < newList.length) { // fill the combined list with the rest from teh otehr one
            if (which == 1) {
                newList[comb] = half2[two];
                two++;
                comb++;
            } else {
                newList[comb] = half1[one];
                one++;
                comb++;
            }
        }

        return newList;
    }

// Bottom Up merge sort (iterative)

    public static int[] BUmergeSort(int[] list) {

        int oddIndex = 0;
        boolean enteredFor = false;

        for (int divisor = 1; divisor <= list.length; divisor *= 2) { // splits in groups of 1, then 2, then 4...
            for (int x = 0; x < list.length - 2 * divisor; x += 2 * divisor) {
                outPlaceSort(list, x, x + divisor - 1, x + divisor, x + 2 * divisor - 1); // splits by index, e.g. 0-1, 2-3, 4-5 for divisor = 2
                                            // 0-3, 4-7 for divisor 4, etc.
                oddIndex = x; // last index that was sorted
                enteredFor = true; // checks if this for loop was entered, if not means that divisor is too large (saves index error)
            }
            if (enteredFor == true) {
                outPlaceSort(list, oddIndex, oddIndex + 2 * divisor - 1, oddIndex + 2 * divisor, list.length - 1); // sorts the last section that was sorted with remaining elements
                // this step is necessary if the number of items is not 2^n
            }
            enteredFor = false;
        }
        return list;
    }

    public static int[] inPlaceSort(int[] list, int bottom1, int top1, int bottom2, int top2) { // This does not work
        //Case that makes this fail: if all the items from bottom2 to top2 are smaller than the items from bottom1 to top1
        // indices overlap and a value is lost, so it is never fully sorted

        int ind = bottom1;
        int currentOne = list[bottom1];
        int currentTwo = list[bottom2];
        int which = 0;

        while (bottom1 <= top1 && bottom2 <= top2) {
            if (currentOne < currentTwo) {
                bottom1++;
                int temp = list[bottom1];
                list[ind] = currentOne;
                ind++;
                currentOne = temp;
                which = 1;
            } else {
                int temp = 0;
                bottom2++;
                if (bottom2 != list.length) {
                    temp = list[bottom2];
                }
                list[ind] = currentTwo;
                ind++;
                currentTwo = temp;
                which = 2;
            }
        }

        while (ind <= top2) {
            if (which == 1) {
                bottom2++;
                int temp = list[bottom2];
                list[ind] = currentTwo;
                ind++;
                currentTwo = temp;
            } else {
                bottom1++;
                int temp = list[bottom1];
                list[ind] = currentOne;
                ind++;
                currentOne = temp;
            }
        }

        return list;

    }

    public static int[] outPlaceSort(int[] list, int bottom1, int top1, int bottom2, int top2) {
        // effectively the same as merge in the top down approach, just taking indices first and then splitting into lists

        int[] half1 = new int[top1 - bottom1 + 1];
        int[] half2 = new int[top2 - bottom2 + 1];

        for (int x = bottom1; x <= top1; x++) {
            half1[x - bottom1] = list[x];
        }

        for (int x = bottom2; x <= top2; x++) {
            half2[x - bottom2] = list[x];
        }

        int one = 0;
        int two = 0;
        int comb = 0;
        int which = 0;
        int[] newList = new int[top2 - bottom1 + 1];

        while (one < half1.length && two < half2.length) {
            if (half1[one] < half2[two]) {
                newList[comb] = half1[one];
                one++;
                comb++;
                which = 1;
            } else {
                newList[comb] = half2[two];
                two++;
                comb++;
                which = 0;
            }
        }

        while (comb < newList.length) {
            if (which == 1) {
                newList[comb] = half2[two];
                two++;
                comb++;
            } else {
                newList[comb] = half1[one];
                one++;
                comb++;
            }
        }

        for (int x = bottom1; x <= top2; x++) {
            list[x] = newList[x - bottom1];
        }

        return list;

    }

    public static int[] BUmergeSortGraphics(int[] list) throws InterruptedException {
        //Same as merge sort file, just creating graphics to show how it groups and sorts

        int largest = list[0];
        for (int z : list) {
            if (z > largest) {
                largest = z;
            }
        }

        for (int z = 0; z < list.length; z++) {
            StdDraw.rectangle((1 + 2 * z) / ((double) list.length * 2), list[z] / ((double) largest + 1) / 2, 1 / ((double) list.length * 2), list[(int) z] / ((double) largest + 1) / 2);
        }

        int oddIndex = 0;
        boolean enteredFor = false;

        for (int divisor = 1; divisor <= list.length; divisor *= 2) {
            Thread.sleep(500);
            for (int x = 0; x < list.length - 2 * divisor; x += 2 * divisor) {
                outPlaceSort(list, x, x + divisor - 1, x + divisor, x + 2 * divisor - 1);

                StdDraw.clear();
                for (int z = 0; z < list.length; z++) {

                    StdDraw.rectangle((1 + 2 * z) / ((double) list.length * 2), list[z] / ((double) largest + 1) / 2, 1 / ((double) list.length * 2), list[(int) z] / ((double) largest + 1) / 2);
                }
                Thread.sleep(50);

                oddIndex = x;
                enteredFor = true;
            }
            if (enteredFor == true) {
                outPlaceSort(list, oddIndex, oddIndex + 2 * divisor - 1, oddIndex + 2 * divisor, list.length - 1);
            }
            enteredFor = false;

        }

        StdDraw.clear();
        for (int z = 0; z < list.length; z++) {
            StdDraw.rectangle((1 + 2 * z) / ((double) list.length * 2), list[z] / ((double) largest + 1) / 2, 1 / ((double) list.length * 2), list[(int) z] / ((double) largest + 1) / 2);
        }

        return list;
    }


    public static void main(String[] args) throws InterruptedException { // UI Tester, graphics tests bottom up, w/o graphics tests top down
        StdOut.println("Welcome to the Merge Sort tester");

        StdOut.println("Would you like to create a new list or use our default one? 0: new; 1: default");
        int choice = StdIn.readInt();
        StdOut.println("Would you like graphics? 0: Yes; 1: No");
        int choice2 = StdIn.readInt();

        if (choice == 0) {

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

            StdOut.println("Here is your list now: ");
            for (int z : list) {
                StdOut.print(z + " ");
            }

            StdOut.println();
            int[] sortedList;
            if (choice2 == 0) {
                sortedList = BUmergeSortGraphics(list);
            } else {
                sortedList = TDmergeSort(list);
            }
            StdOut.println("Here is your sorted list, sorted via Merge Sort");
            for (int z : sortedList) {
                StdOut.print(z + " ");
            }
        } else {
            int[] list = {53, 62, 44, 82, 7, 93, 46, 23, 65, 4, 7, 34, 38, 116, 51, 7, 2, 44, 8, 44, 63, 103, 115, 177, 134, 114, 221, 187, 94, 52, 66};

            StdOut.println("Here is your list now: ");
            for (int z : list) {
                StdOut.print(z + " ");
            }

            StdOut.println();
            int[] sortedList;
            if (choice2 == 0) {
                sortedList = BUmergeSortGraphics(list);
            } else {
                sortedList = TDmergeSort(list);
            }
            StdOut.println("Here is your sorted list, sorted via Merge Sort");
            for (int z : sortedList) {
                StdOut.print(z + " ");
            }
        }
    }

}
