import java.util.ArrayList;

public class SelectionSort {

   static public  ArrayList<Long> bubblesortZeit = new ArrayList<>();

   static int[] sort(int arr[])
    {   int anzahl=0,vertausch=0;
        int n = arr.length;
        long startTime = (int) System.nanoTime();

        for (int i = 0; i < n-1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                anzahl++;


                if (arr[j] < arr[min_idx]){
                    min_idx = j;
            }
        }
                    int temp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = temp;
                    vertausch++;

        }
        int endtime = (int) System.nanoTime();
        int[] werte = new int[2];
        werte[0] = anzahl;
        werte[1] = vertausch;

        bubblesortZeit.add(endtime-startTime);
        return werte;

    }

}
