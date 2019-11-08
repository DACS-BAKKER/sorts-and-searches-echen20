Name: Ethan Chen
Project: Sorting and Searching
Date Started: October 23, 2019

ASSIGNMENT FILES:
Selection Sort: sorts a list by finding the smallest unit and placing at first position, then finding
                second smallest and placing at second position, etc. until sorted

    Methods: selectionSort - returns the sorted list by this algorithm
             selectionSortGraphics - visually shows the selection sort using StdDraw
             main - UI to test both methods

    Problems: none


Insertion Sort: sorts a list by going through each item and individually inserting it in its correct location (moves
                back until all to the left are smaller)

     Methods: insertionSort - returns the sorted list by this algorithm
              insertionSortGraphics - visually shows the insertion sort using StdDraw
              main - UI to test both methods

     Problems: none


Merge Sort: sorts a list by breaking list into smaller units and them merging them together in groups

    Methods: TDMergeSort - returns the sorted list via top-down method, which is recursive
             merge - called in TDMergeSort, it merges and sorts two lists into 1
             BUMergeSort - returns the sorted list via bottom-up method, which is iterative
             inPlaceSort - my (semi-successful) attempt at creating an in-place merging mechanism
             outPlaceSort - out of place merging mechanism, very similar to merge method
             BUMergeSortGraphics - visually shows merge short
             main - UI to test methods

    Problems: with in place sort, it was difficult to swap values around and still know where they came from without
                    creating new lists
              with BUMergeSort, finding out how to make the mergeSort apply to lists that were not length 2^x was
                    difficult, and I'm not sure if my solution still counts as a mergesort, but it just merges the
                    last lists of length 2^n that could be merged with the remaining in the list. It works, but follows
                    different breakdowns from the top down method


Quick Sort: sorts a list by calling the first item a pivot and placing objects smaller on left and larger on right, and
            continuing that process for each smaller list on each side until it is fully sorted

    Methods: quickSortNIP - out of place quick sort that takes creates new lists for higher and lower and then calls
                            recursively; very similar to merge sort except with pivot index to break up groups
             quickSortIP - in-place quick sort that uses a low and high parameter in order to use the same list
             pivotIndex - used in quickSortIP, it returns the index that the pivot is at and moves around higher values
                          to above the pivot and lower values to below
             main - UI to test methods

    Problems: this is where I had to learn the definition of an in-place vs. out-of-place sort, and why quick is better
              than merge in most instances


BinarySearch: takes a presorted list and a value and finds that value in the list by figuring out what half of the list
              it is in and limiting searches to that half, and continuing this process until it finds it.

    Methods: iterativeBinarySearch - finds the target in a list and returns index
             recursiveBinarySearch - same thing, just done recursively
             main - UI to test methods

    Problems: none


LLvsRATester: tests the speed of linked list stacks vs resizable array stacks

    Methods: timeLLPush - time to push x objects to ll stack
             timeRAPush - time to push x objects to ra stack
             timeLLPopAll - time to pop all objects in ll stack
             timeRAPopAll - time to pop all objects in ra stack
             timeLLAll - time to push 2 pop 1 x times, and then pop 2 push 1 x times
             timeRAAll - time to push 2 pop 1 x times, and then pop 2 push 1 x times
             main - uses all methods and shows ratio in times for each method - conclusion that RAStacks are better

    Problems: none


BirthdayProblem: finds the number of ints that need to be added to a list before one of them repeats

    Methods: solveBirthdayProblem - solves the birthday problem by adding random numbers in range to list, counting how
                                    how many have been put in and continuing until there is a repeat
             repeat - sorts list and then looks for repeated values
             upsize - new array with double length, and copies over original array to resize it
             main - UI to test hypothesis of birthday problem equation against test values

    Problems: no matter the test size, the hypothesis always seems to be off by just a little bit.
             resizable array was a problem initially because empty indices default to 0, so there would always be a
                repeat immediately, so instead I had to increase the value actually added to list by 1 and then not
                ever allow repeats on 0 to be processed


EXTRA FILES:
    BestWorstAverage - in theory it should test each of the sorting algorithms and their worst, average, and best cases
                       and return the exponent x in O(n^x), but there are some timing issues and for some reason it
                       always seems to be faster to sort 10 objects than 5. I do not know why.

    BogoSort - the greatest sorting algorithm of them all, it randomizes a list until it is sorted

    CountingSort - the lead-up to the radix sort (which I could not solve), it takes single digit ints and sorts them
                    by counting the number of items of each value 0-9 in it.

    Node - a node

    RAStack - a stack implementing a resizable array

    LLStack - a stack implementing a linked list

    SelectionSortStable - stable implementation of the selection sort
