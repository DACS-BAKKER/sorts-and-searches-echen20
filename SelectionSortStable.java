/*
Name: Ethan Chen
File Name: Selection Sort Stable
Date Started: November 4, 2019
 */

public class SelectionSortStable {

    public static int[] selectionSortStable(int[] list) { // this selection sort is already stable

        for (int i1 = 0; i1 < list.length - 1; i1++) { // sorted list index
            int top = list[i1];
            int tops = 0;
            int indexindex = 0;
            int smallest = list[i1];
            int smallestIndex = i1;

            for (int x = 0; x < list.length; x++) {
                if (list[x] == top) {
                    tops++; // finds number of items equal to item at front of unsorted
                }
            }

            int[] indices = new int[tops];
            indices[indexindex] = top; // sticks index of front item on top
            indexindex++;

            for (int i2 = i1 + 1; i2 < list.length; i2++) { // list traversal index
                if (list[i2] < smallest) { // finds smallest and sets smallest equal to value
                    smallest = list[i2];
                    smallestIndex = i2;
                }

                if (list[i2] == top) { // adds indexes of items that get share value of item swapped out of order
                    indices[1] = indexindex;
                    indexindex++;
                }

            }
            list[smallestIndex] = list[i1]; //switches the smallest value into the first location that is not sorted (i1)
            list[i1] = smallest; // switch occurs

        }
        return list;
    }

    public static int[] stabilize(int[] list, int[] indices) {
        swap(list, indices[0], indices[indices.length - 1]); // swaps front and back
        int x = 1;

        while (x < indices.length-1) {
            swap(list, indices[x], indices[indices.length-1]); // second and back, third and back, etc.
            x++;
        }
        return list; // puts items of equal value back in original order
    }

    public static int[] swap(int[] list, int index1, int index2) { // swap method
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        return list;
    }

}
