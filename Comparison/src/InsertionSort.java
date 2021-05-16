import java.util.ArrayList;

public class InsertionSort {

    static public ArrayList<Long> bubblesortZeit = new ArrayList<>();
    static int[] sort(int arr[])
    {
        int vertauschoperationen = 0;
        int anzahlSchritte =0;

        int n = arr.length;
        long startTime = (int) System.nanoTime();
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            anzahlSchritte++;
            while (j >= 0 && arr[j] > key) {
                vertauschoperationen++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        int endtime = (int) System.nanoTime();
        int[] countWerte = new int[2];
        countWerte[1] = vertauschoperationen;
        countWerte[0] = anzahlSchritte;
        bubblesortZeit.add(endtime-startTime);
        return countWerte;
    }

}
