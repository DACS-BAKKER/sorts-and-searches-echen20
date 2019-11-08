/*
Name: Ethan Chen
File Name: BogoSort
Date Started: October 28, 2019
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class BogoSort { //The Best Sort

    public static boolean isSorted(int[] list) {
        for(int x = 1; x<list.length; x++) {
            if(list[x] < list[x-1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] bogoSort(int[] list) {

        while(!isSorted(list)) {
            list = shuffle(list); // shuffles until sorted
        }
        return list;
    }

    public static int[] bogoSortGraphics(int[] list) throws InterruptedException {
        int largest = list[0];
        for(int z : list) {
            if(z > largest) {
                largest = z;
            }
        }

        while(!isSorted(list)) {
            list = shuffle(list);

            StdDraw.clear();
            for(int z = 0; z<list.length; z++) {
                StdDraw.rectangle((1+2*z)/((double)list.length*2), list[z]/((double)largest+1)/2, 1/((double)list.length*2), list[(int) z]/((double)largest+1)/2);
            }
            Thread.sleep(50);
        }
        return list;
    }

    public static int[] shuffle(int[] list) {
        Random rand = new Random();

        for(int x = 0; x<list.length; x++) {
            int randIndex = rand.nextInt(list.length); // randomly swaps items
            int temp = list[x];
            list[x] = list[randIndex];
            list[randIndex] = temp;
        }

        return list;

    }

    public static void main(String[] args) throws InterruptedException {
        StdOut.println("Welcome to the Bogo Sort tester");
        StdOut.println("How long would you like your array to be? (recommended to be less than 10)");
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
        int[] sortedList = bogoSortGraphics(list);
        StdOut.println("Here is your sorted list, sorted via Bogo Sort");
        for(int z : sortedList) {
            StdOut.print(z + " ");
        }


    }

}
