/*
Name: Ethan Chen
File Name: Best Worst Average Case Efficiency Exponent Finder (problem that I don't really understand)
Date Started: November 1, 2019
 */

import edu.princeton.cs.algs4.StdOut;

public class BestWorstAverage { // Honestly have no idea what is wrong with this testing file but it doesn't work.

    static int[] sorted10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
   static int[] sorted5 = {0, 1, 2, 3, 4, 5};
    static int[] random10 = {3, 7, 4, 5, 8, 1, 0, 2, 9, 6};
    static int[] random5 = {3, 4, 1, 5, 2};
    static int[] backwards5 = {5, 4, 3, 2, 1};
    static int[] backwards10 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};



    public static void main(String[] args) {

        StdOut.println("Welcome to the Efficiency Tester for the Sorting Algorithms");

        //Selection Sort
        StdOut.println("Selection Sort Best-Case : O(N^" + timeEfficiency(sorted5, sorted10, 0) + ")");
        StdOut.println();

        StdOut.println("Selection Sort Average-Case : O(N^" + timeEfficiency(random5, random10, 0) + ")");
        StdOut.println();

        StdOut.println("Selection Sort Worst-Case : O(N^" + timeEfficiency(backwards5, backwards10, 0) + ")");
        StdOut.println();

        //Insertion Sort
        StdOut.println("Insertion Sort Best-Case : O(N^" + timeEfficiency(sorted5, sorted10, 1) + ")");
        StdOut.println();

        StdOut.println("Insertion Sort Average-Case : O(N^" + timeEfficiency(random5, random10, 1) + ")");
        StdOut.println();

        StdOut.println("Insertion Sort Worst-Case : O(N^" + timeEfficiency(backwards5, backwards10, 1) + ")");
        StdOut.println();

    //Merge Sort
        StdOut.println("Merge Sort Best-Case : O(N^" + timeEfficiency(sorted5, sorted10, 2) + ")");
        StdOut.println();

        StdOut.println("Merge Sort Average-Case : O(N^" + timeEfficiency(random5, random10, 2) + ")");
        StdOut.println();

        StdOut.println("Merge Sort Worst-Case : O(N^" + timeEfficiency(backwards5, backwards10, 2) + ")");
        StdOut.println();

        //Quick Sort
        StdOut.println("Quick Sort Best-Case : O(N^" + timeEfficiency(random5, random10, 3) + ")");
        StdOut.println();

        StdOut.println("Quick Sort Average-Case : O(N^" + timeEfficiency(random5, random10, 3) + ")");
        StdOut.println();

        StdOut.println("Quick Sort Worst-Case : O(N^" + timeEfficiency(sorted5, sorted10, 3) + ")");
        StdOut.println();

        //Bogo Sort
        StdOut.println("Bogo Sort Best-Case : O(N^" + timeEfficiency(sorted5, sorted10, 3) + ")");
        StdOut.println();

        StdOut.println("Bogo Sort Average-Case : O(N^" + timeEfficiency(random5, random10, 3) + ")");
        StdOut.println();

        StdOut.println("Bogo Sort Worst-Case : O(N^" + timeEfficiency(backwards5, backwards10, 3) + ")");
        StdOut.println();

        //Counting Sort
        StdOut.println("Counting Sort Best-Case : O(N^" + timeEfficiency(sorted5, sorted10, 3) + ")");
        StdOut.println();

        StdOut.println("Counting Sort Average-Case : O(N^" + timeEfficiency(random5, random10, 3) + ")");
        StdOut.println();

        StdOut.println("Counting Sort Worst-Case : O(N^" + timeEfficiency(backwards5, backwards10, 3) + ")");
        StdOut.println();
    }

    public static double timeEfficiency(int[] list1, int[] list2, int sort) {
        int[] copy1 = list1;
        int[] copy2 = list2;

        long start;
        long end;
        long time;

        long start2;
        long time2;

        System.nanoTime();

        if(sort==0) { // selection
            start = System.nanoTime();
            SelectionSort.selectionSort(copy1);
            end = System.nanoTime();
            time = end-start;

            start = System.nanoTime();
            SelectionSort.selectionSort(copy2);
            end = System.nanoTime();
            time2 = end-start;

        } else if (sort==1) { // insertion
            start = System.nanoTime();
            InsertionSort.insertionSort(copy1);
            time = System.nanoTime()-start;

            start2 = System.nanoTime();
            InsertionSort.insertionSort(copy2);
            time2 = System.nanoTime()-start2;

        } else if (sort==2) { // merge
            start = System.nanoTime();
            MergeSort.TDmergeSort(copy1);
            time = System.nanoTime()-start;

            start2 = System.nanoTime();
            MergeSort.TDmergeSort(copy2);
            time2 = System.nanoTime()-start2;

        } else if (sort==3) { // quick
            start = System.nanoTime();
            QuickSort.quickSortIP(copy1, 0, copy1.length-1);
            time = System.nanoTime()-start;

            start2 = System.nanoTime();
            QuickSort.quickSortIP(copy2, 0, copy2.length-1);
            time2 = System.nanoTime()-start2;

        } else if (sort==4) { // bogo
            start = System.nanoTime();
            BogoSort.bogoSort(copy1);
            time = System.nanoTime()-start;

            start2 = System.nanoTime();
            BogoSort.bogoSort(copy2);
            time2 = System.nanoTime()-start2;

        } else { // counting
            start = System.nanoTime();
            CountingSort.countingSort(copy1);
            time = System.nanoTime()-start;

            start2 = System.nanoTime();
            CountingSort.countingSort(copy2);
            time2 = System.nanoTime()-start2;
        }

        double d = (double) time2/ (double) time; // ratio between times to sort
        return Math.log(d)/Math.log(2.0); // returns the exponent on n for big-o efficiency, in theory

    }

}
