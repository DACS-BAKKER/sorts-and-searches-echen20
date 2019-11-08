/*
Name: Ethan Chen
File Name: Insertion Sort
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class InsertionSort {

    public static int[] insertionSort(int[] list) {
        for (int x = 0; x < list.length; x++) { // traverses index
            int countBack = 1;
            while (x - countBack >= 0 && list[x - countBack + 1] < list[x - countBack]) { // moves item backwards until inserted at correct location
                int temp = list[x - countBack]; // does this by swapping using a temp
                list[x - countBack] = list[x - countBack + 1];
                list[x - countBack + 1] = temp;
                countBack++; // goes to next index back
            }
        }
        return list;
    }

    public static int[] insertionSortGraphics(int[] list) throws InterruptedException {
    // same as insertionSort file, except just creating graphics at the best points to show what is happening

        int largest = list[0];
        for(int z : list) {
            if(z > largest) {
                largest = z;
            }
        }

        for(int z = 0; z<list.length; z++) {
            StdDraw.rectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
        }

        for (int x = 0; x < list.length; x++) {
            Thread.sleep(50);
            int countBack = 1;

            StdDraw.clear();
            for(int z = 0; z<list.length; z++) {
                StdDraw.rectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
                if(z == x) {
                    StdDraw.setPenColor(Color.red);
                    StdDraw.filledRectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
                    StdDraw.setPenColor(Color.BLACK);
                }
                if(z<x) {
                    StdDraw.setPenColor(Color.GREEN);
                    StdDraw.filledRectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
                    StdDraw.setPenColor(Color.BLACK);
                }
            }

            while (x - countBack >= 0 && list[x - countBack + 1] < list[x - countBack]) {
                int temp = list[x - countBack];
                list[x - countBack] = list[x - countBack + 1];
                list[x - countBack + 1] = temp;
                countBack++;
                Thread.sleep(50);

                StdDraw.clear();
                for(int z = 0; z<list.length; z++) {
                    StdDraw.rectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
                    if(z<x) {
                        StdDraw.setPenColor(Color.GREEN);
                        StdDraw.filledRectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
                        StdDraw.setPenColor(Color.BLACK);
                    }
                    if(z == x-countBack+1) {
                        StdDraw.setPenColor(Color.red);
                        StdDraw.filledRectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
                        StdDraw.setPenColor(Color.BLACK);
                    }

                }
            }
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

    public static void main(String[] args) throws InterruptedException { //UI Tester
        StdOut.println("Welcome to the Insertion Sort tester");

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
                sortedList = insertionSortGraphics(list);
            } else {
                sortedList = insertionSort(list);
            }
            StdOut.println("Here is your sorted list, sorted via Quick Sort");
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
                sortedList = insertionSortGraphics(list);
            } else {
                sortedList = insertionSort(list);
            }
            StdOut.println("Here is your sorted list, sorted via Insertion Sort");
            for (int z : sortedList) {
                StdOut.print(z + " ");
            }
        }
    }
}
