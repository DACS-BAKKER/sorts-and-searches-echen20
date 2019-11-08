/*
Name: Ethan Chen
File Name: Stack ADT Implementing a Resizable Array
Date Started: October 23, 2019
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RAStack { // resizable array stack

    //INSTANCE VARIABLES

    int[] arr = new int[1]; // stores all the values
    int top; // keeps track of where the top of the stack is

    //CONSTRUCTORS

    public RAStack(int initialVal) {
        arr[0] = initialVal;
        top = 0;
    }

    public RAStack() {
        top = -1; // set to -1 if there is nothing in it
    }

    //STACK METHODS

    public void push(int val) {
        if (top + 1 >= arr.length) {
            upsize(); // doubles if length is outside of index range
        }

        top += 1;
        arr[top] = val; // puts value on top at back of array
    }

    public int pop() {

        if(isEmpty()) {
            return 0;
        }

        if (arr.length / (top+1) == 4) {
            downsize(); // if length of array is 4 times the number of items in stack, downsize to match number of items
        }

        int popped = arr[top]; // remove top item from stack
        top -= 1;

        return popped;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String toString = "";
        for(int x = 0; x<top; x++) {
            toString = " => " + arr[x] + toString;
        }
        if(!isEmpty()) {
            toString = arr[top] + toString;
            return toString;
        } else {
            return "Empty Stack";
        }
    }

    //RESIZE METHODS

    public void upsize() {
        int[] newArr = new int[arr.length * 2]; // create new array double length
        for (int x = 0; x < arr.length; x++) {
            newArr[x] = arr[x]; // copy values over
        }

        arr = newArr; // set instance array to new array
    }

    public void downsize() {
        int[] newArr = new int[arr.length / 4]; // create new array 1/4 length
        for (int x = 0; x < newArr.length; x++) {
            newArr[x] = arr[x]; // copy values over
        } // Mr. Bakker is my fav teacher.

        arr = newArr; // set instance array to new array
    }

    //Class Runner

    public static void main(String[] args) { // Interactive Console User Interface to test Stack methods
        RAStack firstStack = new RAStack();

        StdOut.println("Welcome to the Stack Console Tester");
        StdOut.println();
        StdOut.println("Type 1 to add push to the stack; 2 to pop the top item of the stack, 3 to show the length, or 4 to ask if it is empty, or 0 to exit");
        int userInput = StdIn.readInt();
        while (userInput != 0) {
            if (userInput == 1) {
                StdOut.println("What would you like to add to the Stack?");
                int input = StdIn.readInt();
                firstStack.push(input);
                StdOut.println("You have added " + input + " to your Stack");
            } else if (userInput == 2) {
                Object popped = firstStack.pop();
                StdOut.println("You have removed " + popped + " from the Stack");
            } else if (userInput == 3) {
                StdOut.println("Your stack is " + firstStack.size() + " items long");
            } else if (userInput == 4) {
                StdOut.println("Is your stack empty? " + firstStack.isEmpty());
            }
            StdOut.println();
            StdOut.println("Your current Stack is as follows:");
            StdOut.println(firstStack.toString());
            StdOut.println();
            StdOut.println("Type 1 to add push to the stack; 2 to pop the top item of the stack, 3 to show the length, 4 to ask if it is empty, or 0 to exit");
            userInput = StdIn.readInt();

        }

        StdOut.println("Thank you for using the stack Console Tester");
        StdOut.println("Your final stack was: " + firstStack.toString());

    }

}
