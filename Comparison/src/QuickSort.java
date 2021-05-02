import java.util.ArrayList;

public class QuickSort {
    public static ArrayList<Integer> countCompareQuicksort = new ArrayList<>();
    public static ArrayList<Integer> countMoveQuicksort = new ArrayList<>();
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
        int schrittwerte=0;
        int vertauschwerte=0;
        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {   schrittwerte++;

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
                vertauschwerte++;
            }
        }
        swap(arr, i + 1, high);
        countCompareQuicksort.add(schrittwerte);
        countMoveQuicksort.add(vertauschwerte);

        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 70, 40, 130, 20, 1, 780 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
        System.out.println(countCompareQuicksort.get(0));
        System.out.println(countMoveQuicksort.get(0));
        System.out.println(countMoveQuicksort);
        System.out.println(countCompareQuicksort);
    }

}

// This code is contributed by Ayush Choudhary
