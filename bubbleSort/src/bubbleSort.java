
import java.util.Random;
import java.util.Scanner;

public class bubbleSort {
    static Scanner scanner =new Scanner(System.in);
    static void bubbleSort(int[] arr) {
        int count = 0;

        int temp ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {

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
        Random rd = new Random();
        for (int i = 0; i < arrrd.length; i++) {
        arrrd[i] = rd.nextInt(auswahlGrenze);
       // System.out.println(arrrd[i]);
        }
        return arrrd;
    }
    static int größen(){
        int auswahlGrenze2;

        System.out.println("Geben sie die Obergrenze ein:[von 0-?]:");
        auswahlGrenze2 = scanner.nextInt();
        return auswahlGrenze2;
    }
    static int größen2(){
        int auswahlgröße2;

        System.out.println("Geben Sie bitte die Maximale Größe ein: ");
        auswahlgröße2 = scanner.nextInt();
        return auswahlgröße2;

    }

    public static void main(String[] args) {

        int auswahlgröße = größen2();
        int auswahlGrenze = größen();
        final long timeStart = System.nanoTime();
        int[] arr= rdarray(auswahlGrenze,auswahlgröße);
        final long timeEnd = System.nanoTime();
        System.out.println("Es wurden: " + (timeEnd-timeStart) + " Nanosekunden gemessen");
        bubbleSort(arr);


        }
    }




