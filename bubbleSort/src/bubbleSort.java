
import java.util.Random;
import java.util.Scanner;

public class bubbleSort {

    static void bubbleSort(int[] arr) {
        int count = 0;

        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    count++;

                }

            }
        }

        System.out.println("Schritte:" + count);
        System.out.println("Array After Bubble Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
static int[] rdarray(int auswahlGrenze, int auswahlgröße){
    int[] arrrd = new int[auswahlgröße];
    Random rd = new Random(); // creating Random object
    for (int i = 0; i < arrrd.length; i++) {
        arrrd[i] = rd.nextInt(auswahlGrenze); // storing random integers in an array

    }
    return arrrd;
}

    public static void main(String[] args) {

        int auswahlGrenze;
        int auswahlgröße;

        Scanner scanner =new Scanner(System.in);

        System.out.println("Geben Sie bitte die Maximale Größe ein: ");
        auswahlgröße = scanner.nextInt();



        System.out.println("Geben sie die Obergrenze ein:[von 0-?]:");
        auswahlGrenze = scanner.nextInt();
          int[] arr= rdarray(auswahlGrenze,auswahlgröße);
            bubbleSort(arr);


        }
    }




