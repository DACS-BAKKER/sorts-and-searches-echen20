/*
Name: Ethan Chen
File Name: Birthday Problem Threshold Solver
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class BirthdayProblem {

    public static int solveBirthdayProblem(int n) { // returns number of random items necessary to add to a list before it repeats, in range n
        int[] array = new int[1]; // resizable array
        int currIndex = 0; // counts how many items
        while(repeat(array) == false) { // keep on adding until there is a repeat
            Random rand = new Random();
            int nextVal = rand.nextInt(n) + 1; // adds random value (+1) so that number added never 0,
            // otherwise would repeat with empty indices in resizable array

            if(currIndex >= array.length) { // resizes if too large ** never need to downsize because never remove items
                array = upsize(array);
            }

            array[currIndex] = nextVal; //puts random value in array
            currIndex++;
            StdOut.print((nextVal-1) + " => ");
        }
        StdOut.print("end");
        StdOut.println();

        return currIndex;

    }

    public static boolean repeat (int[] array) { // checks for repeat
        int[] array2 = MergeSort.TDmergeSort(array); // first sorts array
        int possibleRep = array2[0];
        for(int x = 1; x<array2.length; x++) {
            if(array2[x] == possibleRep && array2[x] != 0) { // if two in a row
                return true;
            }
            possibleRep = array2[x]; // if not, set current index to last index
        }
        return false;
    }

    public static int[] upsize(int[] arr) { // new array double length and copy over
        int[] newArr = new int[arr.length * 2];
        for (int x = 0; x < arr.length; x++) {
            newArr[x] = arr[x];
        }
        return newArr;
    }

    public static void main(String[] args) { // UI tester
        StdOut.println("This is the Birthday Problem Tester");
        StdOut.println("Please input an integer N. We will take random values between 0 and N-1 and add them to an array until there is a repeat.");
        StdOut.println("N = ?");
        int n = StdIn.readInt();

        StdOut.println();
        StdOut.println("How many tests would you like to do?");
        int tests = StdIn.readInt();

        double total = 0.0;

        for(int x = 0; x<tests; x++) {
            total += solveBirthdayProblem(n);
        }

        StdOut.println();
        StdOut.println();
        StdOut.println("Over " + tests + " tests over a range of 0 to " + (n-1) + " The average amount of numbers necessary to repeat was: ");
        StdOut.print(total/tests);

        StdOut.println();
        StdOut.println("According to the root(pi*N/2) rule, the average necessary should have been: " + (Math.sqrt(Math.PI*n/2)));

    }
}
