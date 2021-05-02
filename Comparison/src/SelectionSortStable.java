import java.util.ArrayList;
import java.util.List;

public class SelectionSortStable {
    static public  ArrayList<Long> Zeit = new ArrayList<>();
    static int[] stableSelectionSort(int[] arr,int n) {
        int anzahl = 0, vertausch = 0;
       // int n = arr.length;
        // Iterate through array elements
        long startTime = (int) System.nanoTime();
        for (int i = 0; i < n - 1; i++) {

            // Loop invariant : Elements till
            // arr[i - 1] are already sorted.

            // Find minimum element from
            // arr[i] to arr[n - 1].
            int min = i;
            for (int j = i + 1; j < n; j++) {
                    anzahl++;

                if (arr[min] > arr[j]) {
                    min = j;
                }

                // Move minimum element at current i.
                int key = arr[min];
                while (min > i) {
                    vertausch++;

                    arr[min] = arr[min - 1];
                    min--;
                }

                arr[i] = key;
            }
        }
        int endtime = (int) System.nanoTime();
        int[] werte = new int[2];
       werte[0] = anzahl;
       werte[1] = vertausch;
       Zeit.add(endtime-startTime);

       return werte;

    }
    static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+ " ");

        System.out.println();
    }

    // Driver code

}
