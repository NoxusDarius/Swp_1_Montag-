import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    static int[] bubbleSort(int[] arr) {
        int vertauschoperationen = 0;
        int anzahlSchritte =0;
        int temp ;
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
        int[] countWerte = new int[2];
        countWerte[0] = vertauschoperationen;
        countWerte[1] = anzahlSchritte;

        return countWerte;

    }
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};

        System.out.println("Sorted array");
        bubbleSort(arr);


    }
}
