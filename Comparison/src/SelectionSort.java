import java.util.ArrayList;

public class SelectionSort {
   /* public static void main(String[] args) {

        int arr[] = {64,25,12,22,11,66,77};
        sort(arr);
        System.out.println("Sorted array");
        printArray(arr);

    }*/
   static public  ArrayList<Long> bubblesortZeit = new ArrayList<>();



    static int[] sort(int arr[])
    {   int anzahl=0,vertausch=0;
        int n = arr.length;
        long startTime = (int) System.nanoTime();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {

            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                anzahl++;


                if (arr[j] < arr[min_idx]){
                    min_idx = j;
            }
        }
                    // Swap the found minimum element with the first
                    // element
                    int temp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = temp;
                    vertausch++;

        }
        int endtime = (int) System.nanoTime();
        int[] werte = new int[2];
        werte[0] = anzahl;
        werte[1] = vertausch;
        System.out.println(endtime + "Endtime");
        System.out.println(startTime + "Startime");
        bubblesortZeit.add(endtime-startTime);
        return werte;

    }
    /*static  void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }*/
}
