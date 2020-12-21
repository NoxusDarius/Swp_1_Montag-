



import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Sort {
    static int größeArray;
    static int zahlenbereich;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        methodenAufrufen();
    }

    static int[] lottozahlen() {
        int[] lottoArray = new int[größeArray];

        boolean flag = false;
        boolean added = false;
        int a = 0;

        for (int i = 0; i < größeArray; i++) {
            added = false;
            while (!added) {
                flag = false;
                a = (int) (Math.random() * zahlenbereich + 1);
                for (int index = 0; index < i; index++) {
                    if (lottoArray[index] == a) {
                        flag = true;
                        break;
                    }
                }//Ende for index
                if (!flag) {
                    lottoArray[i] = a;
                    added = true;
                }
            }
        }
        return lottoArray;
    }

    static int[] worstcase() {
        int[] worstArray = new int[größeArray];
        boolean unsortiert = true;

        Random rd = new Random();
        for (int i = 0; i < worstArray.length; i++) {
            worstArray[i] = rd.nextInt(zahlenbereich);
        }
        int temp;
        while (unsortiert) {
            unsortiert = false;
            for (int j = 0; j < worstArray.length - 1; j++) {

                if (worstArray[j] < worstArray[j + 1]) {
                    temp = worstArray[j];
                    worstArray[j] = worstArray[j + 1];
                    worstArray[j + 1] = temp;
                    unsortiert = true;
                }
            }
        }
        return worstArray;
    }

    static int[] bestcase() {
        int[] bestArray = new int[größeArray];
        Random rd = new Random();

        for (int i = 0; i < bestArray.length; i++) {
            bestArray[i] = rd.nextInt(zahlenbereich);
        }
        int count = 0;

        int temp;
        for (int i = 0; i < bestArray.length; i++) {
            for (int j = 1; j < bestArray.length - i; j++) {

                if (bestArray[j] < bestArray[j - 1]) {

                    temp = bestArray[j - 1];
                    bestArray[j - 1] = bestArray[j];
                    bestArray[j] = temp;
                    count++;
                }
            }
        }
        return bestArray;
    }

    static void bubbleSort(int[] arrBS){
        int temp ;
        for (int i = 0; i < arrBS.length; i++) {
            for (int j = 1; j < arrBS.length - i; j++) {

                if (arrBS[j] <arrBS[j - 1]) {

                    temp = arrBS[j - 1];
                    arrBS[j - 1] = arrBS[j];
                    arrBS[j] = temp;

                }
            }
        }


        for (int i = 0; i < arrBS.length; i++) {
            System.out.print(arrBS[i] + " ");
        }
    }

    static void eingabeGrößeArray() {

        System.out.println("Bitte geben Sie ihre gewünschte Größe ein: [größe des Arrays]: ");
        größeArray = scanner.nextInt();
    }

    static void eingabeZahlenBereich() {

        System.out.println("Bitte geben Sie den gewünschten Zahlenbereich ein: [Zahlenbereich des Arrays]: ");
        int zahlenbereichBefore = scanner.nextInt();
        if(zahlenbereichBefore>0){
            if(zahlenbereichBefore>=größeArray){
                zahlenbereich = zahlenbereichBefore;

            }else{
                System.out.println("Der Zahlenbereich mus größer sein als das eingegebene Array");
            }
        }else{
            System.out.println("Die eingegebene Zahl muss positiv sein");
        }

    }

    static void methodenAufrufen() {
        eingabeGrößeArray();
        eingabeZahlenBereich();
        bestcase();
        worstcase();
        lottozahlen();
        auswahl();
    }

    public static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int valueToSort =arr[i];  //Auswahl des  Wertes
            int k = i;
            while (k > 0 && arr[k - 1] > valueToSort) {    //Solange das Array ander vorherigenstelle noch größer ist verscheiben wir die variable 1 weiter nach rechts
                arr[k] = arr[k - 1];     //vorzeichen < wechsel die Werte werden vom höchsten zum niedrigsten ausgegeben
                k--;                                   //ValueToSort kleinstes Element //Abbruchsbedingung
            }
            arr[k] = valueToSort;

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void binaryInsertionSort(int[] arrBIS) {          // arrBIS Array Binary Insertion Sort

        int length = arrBIS.length;

        for (int i = 1; i < length; ++i) {
            int key = arrBIS[i];
            int insertedPosition = findPosition(arrBIS, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                arrBIS[j + 1] = arrBIS[j];
            }

            arrBIS[insertedPosition] = key;
        }

        for (int i = 0; i < arrBIS.length; i++) {
            System.out.print(arrBIS[i] + " ");

        }

    }

    public static int findPosition(int[] arrBIS, int start, int größeArray, int key) {

        while (start <= größeArray) {
            int mid = start + (größeArray - start) / 2;

            if (key < arrBIS[mid]) {
                größeArray = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static void auswahl() {
        char wahl;
        int[] lottoArrayInsertfinal = lottozahlen();
        int[] worstCaseArrayfinal = worstcase();
        int[] bestCaseArrayfinal= bestcase();

        System.out.println("Welche Methode wollsen Sie Wählen [insertion I / Bubble B /BinaryInsertionSort S /Alle 3 A]: ");
        wahl = scanner.next().charAt(0);
        switch (wahl) {
            case 'I':
                System.out.println("InsertionSort wurde ausgewählt");

                System.out.println("Lottozahlen:");
                final long timeStartLottoI = System.nanoTime();
                insertionSort(lottoArrayInsertfinal);
                final long timeEndLottoI = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndLottoI - timeStartLottoI) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Worstcase:");
                final long timeStartWorstI = System.nanoTime();
                insertionSort(worstCaseArrayfinal);
                final long timeEndWorstI = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndWorstI + -timeStartWorstI) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Bestcase:");
                final long timeStartBestI = System.nanoTime();
                insertionSort(bestCaseArrayfinal);
                final long timeEndBestI = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndBestI + -timeStartBestI) + " Nanosec gemessen");
                System.out.println(" ");

                break;
            case 'B':
                System.out.println("BubbleSort wurde ausgewählt");
                System.out.println("Lottozahlen:");
                final long timeStartLottoB = System.nanoTime();
                bubbleSort(lottoArrayInsertfinal);
                final long timeEndLottoB = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndLottoB - timeStartLottoB) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Worstcase:");
                final long timeStartWorstB = System.nanoTime();
                bubbleSort(worstCaseArrayfinal);
                final long timeEndWorstB = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndWorstB + -timeStartWorstB) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Bestcase:");
                final long timeStartBestB = System.nanoTime();
                bubbleSort(bestCaseArrayfinal);
                final long timeEndBestB = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndBestB + -timeStartBestB) + " Nanosec gemessen");
                System.out.println(" ");

                break;
            case 'A'://BinaryInsertionSort
                System.out.println("InsertionSort,BubbleSort und BinaryInsertionSort wurden ausgewählt");
                System.out.printf(" ");
                System.out.println("BinaryInsertionSort");
                System.out.println(" ");

                System.out.println("Lottozahlen:");
                final long timeStartLottoA = System.nanoTime();
                binaryInsertionSort(lottoArrayInsertfinal);
                final long timeEndLottoA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndLottoA - timeStartLottoA) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Worstcase:");
                final long timeStartWorstA = System.nanoTime();
                binaryInsertionSort(worstCaseArrayfinal);
                final long timeEndWorstA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndWorstA + -timeStartWorstA) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Bestcase:");
                final long timeStartBestA = System.nanoTime();
                binaryInsertionSort(bestCaseArrayfinal);
                final long timeEndBestA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndBestA + -timeStartBestA) + " Nanosec gemessen");
                System.out.println(" ");

                //InsertionSort
                System.out.println(" ");
                System.out.println("InsertionSort:");
                System.out.println(" ");

                System.out.println("Lottozahlen:");
                final long timeStartLottoAA = System.nanoTime();
                insertionSort(lottoArrayInsertfinal);
                final long timeEndLottoAA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndLottoAA - timeStartLottoAA) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Worstcase:");
                final long timeStartWorstAA = System.nanoTime();
                insertionSort(worstCaseArrayfinal);
                final long timeEndWorstAA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndWorstAA + -timeStartWorstAA) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Bestcase:");
                final long timeStartBestAA = System.nanoTime();
                insertionSort(bestCaseArrayfinal);
                final long timeEndBestAA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndBestAA + -timeStartBestAA) + " Nanosec gemessen");
                System.out.println(" ");
                //BubbleSort
                System.out.println(" ");
                System.out.println("BUbbleSort:");
                System.out.println(" ");

                System.out.println("Lottozahlen:");
                final long timeStartLottoAAA = System.nanoTime();
                bubbleSort(lottoArrayInsertfinal);
                final long timeEndLottoAAA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndLottoAAA - timeStartLottoAAA) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Worstcase:");
                final long timeStartWorstAAA = System.nanoTime();
                bubbleSort(worstCaseArrayfinal);
                final long timeEndWorstAAA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndWorstAAA + -timeStartWorstAAA) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Bestcase:");
                final long timeStartBestAAA = System.nanoTime();
                bubbleSort(bestCaseArrayfinal);
                final long timeEndBestAAA = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndBestAAA + -timeStartBestAAA) + " Nanosec gemessen");

                break;
            case 'S':
                System.out.println("BinaryInsertionSort wurde ausgewählt");

                System.out.println(" ");
                System.out.println("Lottozahlen:");
                final long timeStartLottoS = System.nanoTime();
                binaryInsertionSort(lottoArrayInsertfinal);
                final long timeEndLottoS = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndLottoS - timeStartLottoS) + " Nanosec gemessen");
                System.out.println(" ");

                System.out.println("Worstcase:");
                final long timeStartWorstS = System.nanoTime();
                binaryInsertionSort(worstCaseArrayfinal);
                final long timeEndWorstS = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndWorstS + -timeStartWorstS) + " Nanosec gemessen");

                System.out.println(" ");
                System.out.println("Bestcase:");
                final long timeStartBestS = System.nanoTime();
                binaryInsertionSort(bestCaseArrayfinal);
                final long timeEndBestS = System.nanoTime();
                System.out.println(" ");
                System.out.print("Es wurden: " + (timeEndBestS + -timeStartBestS) + " Nanosec gemessen");


                    break;

                }

                //l
        }

    }
