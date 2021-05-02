import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
   static public  ArrayList<Long> bubblesortZeit = new ArrayList<>();
    static int[] bubbleSort(int[] arr) {
        int vertauschoperationen = 0;
        int anzahlSchritte =0;
        int temp;

        long startTime = (int) System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                    anzahlSchritte++;
                if (arr[j] < arr[j - 1]) {

                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    vertauschoperationen++;
                }
            }
        }
      /*  System.out.println(" ");
        System.out.println("Vertauschoperationen:" + vertauschoperationen);
        System.out.println(" ");

        System.out.println("Schritte:"+anzahlSchritte);
        System.out.println(" ");
        System.out.println("Array After Bubble Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        int endtime = (int) System.nanoTime();
        int[] countWerte = new int[3];
        countWerte[1] = vertauschoperationen;
        countWerte[0] = anzahlSchritte;
     //   long[] time =new long[1];
        System.out.println(endtime + "Endtime");
        System.out.println(startTime + "Startime");
        bubblesortZeit.add(endtime-startTime);

        return countWerte;


    }
   /* public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};

        System.out.println("Sorted array");
        bubbleSort(arr);


    }*/
}
