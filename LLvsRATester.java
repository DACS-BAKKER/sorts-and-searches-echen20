/*
Name: Ethan Chen
File Name: Linked List vs. Resizable Array - Stack Tester
Date Started: October 23, 2019
 */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class LLvsRATester { // described on paper

    public static final int large = 1000000;
    public static final int small = 1000;

    public static void main(String[] args) { // big testing file to compare efficiencies for pushing and popping for a stack created with linked list or resizable array
        LLStack ll = new LLStack();
        RAStack ra = new RAStack();
        LLStack ll2 = new LLStack();
        RAStack ra2 = new RAStack();

        for(int x = 0; x<small; x++) {
            ll.push(1); //(value is negligible, so I used 1)
            ra.push(1);
        }

        for(int x = 0; x<large; x++) {
            ll2.push(1);
            ra2.push(1);
        }

        double timeLLPushSmall = timeLLPush(small);
        double timeRAPushSmall = timeRAPush(small);
        double timeLLPopSmall = timeLLPopAll(ll);
        double timeRAPopSmall = timeRAPopAll(ra);
        double timeLLPushLarge = timeLLPush(large);
        double timeRAPushLarge = timeRAPush(large);
        double timeLLPopLarge = timeLLPopAll(ll2);
        double timeRAPopLarge = timeRAPopAll(ra2);
        double timeLLAll = timeLLAll(ll2, large);
        double timeRAAll = timeRAAll(ra2, large);

        StdOut.println("Pushing " + small + " items to Linked-List-Stack and Resizable-Array-Stack");
        StdOut.println("LL-Time: " + timeLLPushSmall + " Seconds.");
        StdOut.println("RA-Time: " + timeRAPushSmall + " Seconds.");
        StdOut.println("LL:RA Ratio: " + timeLLPushSmall/timeRAPushSmall);

        StdOut.println();

        StdOut.println("Popping " + small + " items");
        StdOut.println("LL-Time: " + timeLLPopSmall + " Seconds.");
        StdOut.println("RA-Time: " + timeRAPopSmall + " Seconds.");
        StdOut.println("LL:RA Ratio: " + timeLLPopSmall/timeRAPopSmall);

        StdOut.println();

        StdOut.println("Pushing " + large + " items to Linked-List-Stack and Resizable-Array-Stack");
        StdOut.println("LL-Time: " + timeLLPushLarge + " Seconds.");
        StdOut.println("RA-Time: " + timeRAPushLarge + " Seconds.");
        StdOut.println("LL:RA Ratio: " + timeLLPushLarge/timeRAPushLarge);

        StdOut.println();

        StdOut.println("Popping " + large + " items");
        StdOut.println("LL-Time: " + timeLLPopLarge + " Seconds.");
        StdOut.println("RA-Time: " + timeRAPopLarge + " Seconds.");
        StdOut.println("LL:RA Ratio: " + timeLLPopLarge/timeRAPopLarge);

        StdOut.println();

        StdOut.println("Push and Pop Tester for " + large + " items ");
        StdOut.println("LL-Time: " + timeLLAll + " Seconds");
        StdOut.println("RA-Time: " + timeRAAll + " Seconds");
        StdOut.println("LL:RA Ratio: " + timeLLAll/timeRAAll);
    }

    public static double timeLLPush(int x) { // pushes x items to a ll stack (value is negligible, so I used 1)
        Stopwatch s = new Stopwatch();
        LLStack ll = new LLStack();
        for(int y = 0; y<x; y++) {
            ll.push(1);
        }
        return s.elapsedTime();
    }

    public static double timeRAPush(int x) { // pushes x items to a ra stack
        Stopwatch s = new Stopwatch();
        RAStack ra = new RAStack();
        for(int y = 0; y<x; y++) {
            ra.push(1);
        }
        return s.elapsedTime();
    }

    public static double timeLLPopAll(LLStack ll) { // pop all items from stack
        Stopwatch s = new Stopwatch();
        while(!ll.isEmpty()) {
            ll.pop();
        }
        return s.elapsedTime();

    }

    public static double timeRAPopAll(RAStack ra) { // pop all items from stack
        Stopwatch s = new Stopwatch();
        while(!ra.isEmpty()) {
            ra.pop();
        }
        return s.elapsedTime();
    }

    public static double timeLLAll(LLStack ll, int x) { // push 2 items, pop 1, x times, then pop 2 items push 1, x times
        Stopwatch s = new Stopwatch();
        for(int y = 0; y<x; y++) {
            ll.push(1);
            ll.push(1);
            ll.pop();
        }

        for(int y = 0; y<x; y++) {
            ll.pop();
            ll.pop();
            ll.push(1);
        }

        return s.elapsedTime();

    }

    public static double timeRAAll(RAStack ra, int x) { // push 2 items, pop 1, x times, then pop 2 items push 1, x times
        Stopwatch s = new Stopwatch();
        for(int y = 0; y<x; y++) {
            ra.push(1);
            ra.push(1);
            ra.pop();
        }

        for(int y = 0; y<x; y++) {
            ra.pop();
            ra.pop();
            ra.push(1);
        }

        return s.elapsedTime();
    }

}
