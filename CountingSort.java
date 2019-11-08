/*
Name: Ethan Chen
File Name: Radix Sort
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdOut;

public class CountingSort {

    /*
    public static int[] radixSort(int[] list) { //doesn't work
        int largest = list[0];
        for(int x: list) {
            if(x>largest) {
                largest = x;
            }
        }

        int numDigs = 0;
        while(largest != 0) {
            largest /= 10;
            numDigs++;
        }

        for(int x = 0; x<numDigs; x++) {

        }
    return new int[]{0};
    }*/



    public static int[] countingSort(int[] list) {
        int[] countArray = new int[list.length];
        int zeroes = 0, ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0, sevens = 0, eights = 0, nines = 0; // ints to count occurrence of their number

        for (int x : list) { // counts occurrences
            if (x == 0) {
                zeroes++;
            } else if (x == 1) {
                ones++;
            } else if (x == 2) {
                twos++;
            } else if (x == 3) {
                threes++;
            } else if (x == 4) {
                fours++;
            } else if (x == 5) {
                fives++;
            } else if (x == 6) {
                sixes++;
            } else if (x == 7) {
                sevens++;
            } else if (x == 8) {
                eights++;
            } else if (x == 9) {
                nines++;
            }
        }

        int cumulativeCount = 0;

        countArray[0] = zeroes;
        countArray[1] = ones;
        countArray[2] = twos;
        countArray[3] = threes;
        countArray[4] = fours;
        countArray[5] = fives;
        countArray[6] = sixes;
        countArray[7] = sevens;
        countArray[8] = eights;
        countArray[9] = nines;

        for(int x = 0; x<countArray.length; x++) { // creates new array that accumulates the numbers and their values over indexes
            cumulativeCount += countArray[x];
            countArray[x] = cumulativeCount;
        }

        int prev = 0;
        for(int x = 0; x<countArray.length; x++) { // puts values back when cumulative count changes, and at that index that it does change
            if(countArray[x] != prev) { // index that cumulative changes
                int y = x;
                while(y != prev) {
                    list[y] = countArray[x];
                    y--; // places back until last changae
                }
                prev = countArray[x]; // sets previous cumulative count value to new one for next iteration
            }
        }
        return list;
    }

    public static void main(String[] args) { // simple tester
        int[] x = {1, 3, 6, 8, 2, 5};

        x = countingSort(x);

        for (int y : x) {
            StdOut.print(y + " ");
        }

    }

}
