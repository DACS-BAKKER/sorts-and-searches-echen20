/*
Name: Ethan Chen
File Name: Selection Sort
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class SelectionSort {

    // this selection sort is stable because if there are two equally small smallest items, the first one is set to
    // smallest and the second one does not because it is not smaller than smallest, but equal. Therefore the first
    // one remains first and the second one comes second

    // UPDATE: what I said above was incorrect because of the case of something like {4, 4, 1}, where the swap would
    //           displace the order CHECK SELECTIONSORTSTABLE FOR REAL STABLE SORT

    public static int[] selectionSort(int[] list) { // this selection sort is already stable
        for (int i1 = 0; i1 < list.length-1; i1++) { // sorted list index
            int smallest = list[i1];
            int smallestIndex = i1;
            for (int i2 = i1+1; i2 < list.length; i2++) { // list traversal index
                if (list[i2] < smallest) { // finds smallest and sets smallest equal to value
                    smallest = list[i2];
                    smallestIndex = i2;
                }
            }
            list[smallestIndex] = list[i1]; //switches the smallest value into the first location that is not sorted (i1)
            list[i1] = smallest; // switch occurs

        }
        return list;
    }

    public static int[] selectionSortGraphics(int[] list) throws InterruptedException {
    //This file is the same as the selectionSort file, just creating graphics at the best points to show what is happening

        int largest = list[0];
        for(int z : list) {
            if(z > largest) {
                largest = z;
            }
        }

        for(int z = 0; z<list.length; z++) {
            double x = (1+2*z)/((double)list.length*2);
            double yy = list[z]/((double)largest+1)/2;
            double halfWidth = 1/((double)list.length*2);
            double halfHeight = list[(int) z]/((double)largest+1)/2;
            StdDraw.rectangle(x, yy, halfWidth, halfHeight);
        }

        Thread.sleep(5000);
        for (int y = 0; y < list.length-1; y++) {
            int smallest = list[y];
            int smallestIndex = y;
            for (int x = y+1; x < list.length; x++) {
                if (list[x] < smallest) {
                    smallest = list[x];
                    smallestIndex = x;
                }
                StdDraw.clear();
                for(int z = 0; z<list.length; z++) {
                    double xx = (1+2*z)/((double)list.length*2);
                    double yy = list[z]/((double)largest+1)/2;
                    double halfWidth = 1/((double)list.length*2);
                    double halfHeight = list[(int) z]/((double)largest+1)/2;
                    StdDraw.rectangle(xx, yy, halfWidth, halfHeight);

                    if(z == x) {
                        StdDraw.setPenColor(Color.RED);
                        StdDraw.filledRectangle(xx, yy, halfWidth, halfHeight);
                        StdDraw.setPenColor(Color.BLACK);
                    }
                    if(z == smallestIndex) {
                        StdDraw.setPenColor(Color.BLUE);
                        StdDraw.filledRectangle(xx, yy, halfWidth, halfHeight);
                        StdDraw.setPenColor(Color.BLACK);
                    }
                    if(z<y) {
                        StdDraw.setPenColor(Color.GREEN);
                        StdDraw.filledRectangle(xx, yy, halfWidth, halfHeight);
                        StdDraw.setPenColor(Color.BLACK);
                    }

                }
                Thread.sleep(50);
            }
            list[smallestIndex] = list[y];
            list[y] = smallest;

            StdDraw.clear();
            for(int z = 0; z<list.length; z++) {
                if(z<y) {
                    StdDraw.setPenColor(Color.GREEN);
                } else {
                    StdDraw.setPenColor(Color.BLACK);
                }
                double x = (1+2*z)/((double)list.length*2);
                double yy = list[z]/((double)largest+1)/2;
                double halfWidth = 1/((double)list.length*2);
                double halfHeight = list[(int) z]/((double)largest+1)/2;
                StdDraw.filledRectangle(x, yy, halfWidth, halfHeight);
                StdDraw.setPenColor(Color.BLACK);
            }
            Thread.sleep(50);
        }

        StdDraw.clear();
        for(int z = 0; z<list.length; z++) {
            double x = (1+2*z)/((double)list.length*2);
            double yy = list[z]/((double)largest+1)/2;
            double halfWidth = 1/((double)list.length*2);
            double halfHeight = list[(int) z]/((double)largest+1)/2;
            StdDraw.rectangle(x, yy, halfWidth, halfHeight);
        }

        return list;
    }

    public static void main(String[] args) throws InterruptedException { // UI Tester
        StdOut.println("Welcome to the Selection Sort tester");

        StdOut.println("Would you like to create a new list or use our default one? 0: new; 1: default");
        int choice = StdIn.readInt();
        StdOut.println("Would you like graphics? 0: Yes; 1: No");
        int choice2 = StdIn.readInt();

        if(choice == 0) {

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
            if(choice2 == 0) {
                sortedList = selectionSortGraphics(list);
            } else {
                sortedList = selectionSort(list);
            }
            StdOut.println("Here is your sorted list, sorted via Insertion Sort");
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
            if(choice2 == 0) {
                sortedList = selectionSortGraphics(list);
            } else {
                sortedList = selectionSort(list);
            }
            StdOut.println("Here is your sorted list, sorted via Insertion Sort");
            for (int z : sortedList) {
                StdOut.print(z + " ");
            }
        }
    }

}