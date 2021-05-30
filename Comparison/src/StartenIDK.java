import java.lang.reflect.Array;
import java.util.*;

public class StartenIDK {
    static Scanner scanner = new Scanner(System.in);
    static int größeArray;
    static int zahlenbereich;
    static int anzahlArrays;
    static ArrayList<Long> schritteListQS = new ArrayList<>();
    static ArrayList<Long> vertauschListeQS = new ArrayList<>();
    static ArrayList<Long> quicksortZeit = new ArrayList<>();
    static long vertauschQS = 0;
    static long schritteQS =0;


    public static void main(String[] args) {

        eingaben();
        ArrayList<Long> bubblesortZeit = new ArrayList<>();
        ArrayList<Long> insertionsortZeit = new ArrayList<>();
        ArrayList<Long> selectionsortstableZeit = new ArrayList<>();
        ArrayList<Long> selectionsortZeit = new ArrayList<>();
        int[] schrittWerteBS = new int[anzahlArrays];
        int[] vertauschWerteBS = new int[anzahlArrays];
        int[] werteBS;
        int[] schrittWerteSSS = new int[anzahlArrays];
        int[] vertauschWerteSSS = new int[anzahlArrays];
        int[] werteSSS;
        int[] schrittWerteSS = new int[anzahlArrays];
        int[] vertauschWerteSS = new int[anzahlArrays];
        int[] werteSS;
        int[] schrittWerteIS = new int[anzahlArrays];
        int[] vertauschWerteIS = new int[anzahlArrays];
        int[] werteIS;
        int median = (anzahlArrays / 2) - 1;



        for (int i = 0; i < anzahlArrays; i++) {

            int[] arr = lottozahlen();
            int[] arr2 = arr.clone();
            int[] arr3 = arr.clone();
            int[] arr4 = arr.clone();
            int[] arr5 = arr.clone();

            werteBS = BubbleSort.bubbleSort(arr);
            schrittWerteBS[i] = werteBS[0];
            vertauschWerteBS[i] = werteBS[1];
            bubblesortZeit.add(BubbleSort.bubblesortZeit.get(i));

            werteSSS = SelectionSortStable.stableSelectionSort(arr2, größeArray);
            schrittWerteSSS[i] = werteSSS[0];
            vertauschWerteSSS[i] = werteSSS[1];
            selectionsortstableZeit.add(SelectionSortStable.Zeit.get(i));

            werteSS = SelectionSort.sort(arr3);
            schrittWerteSS[i] = werteSS[0];
            vertauschWerteSS[i] = werteSS[1];
            selectionsortZeit.add(SelectionSort.bubblesortZeit.get(i));

            werteIS = InsertionSort.sort(arr4);
            schrittWerteIS[i] = werteIS[0];
            vertauschWerteIS[i] = werteIS[1];
            insertionsortZeit.add(InsertionSort.bubblesortZeit.get(i));

            quickSort(arr5, 0, arr5.length - 1);
            vertauschListeQS.add(vertauschQS);
            schritteListQS.add(schritteQS);
            vertauschQS=0;
            schritteQS=0;



        }


        System.out.println("Comparison der 5 Sorts");
        System.out.println("BubbleSort");
        output(schrittWerteBS, vertauschWerteBS, bubblesortZeit, median);
        System.out.println("SelectionSort Stable");
        output(schrittWerteSSS, vertauschWerteSSS, selectionsortstableZeit, median);
        System.out.println("SelectionSort");
        output(schrittWerteSS, vertauschWerteSS, selectionsortZeit, median);
        System.out.println("InsertionSort");
        output(schrittWerteIS, vertauschWerteIS, insertionsortZeit, median);
        System.out.println("QuickSort");
        outputQuickSOrt(schritteListQS, vertauschListeQS, quicksortZeit, median);
        System.out.println("Alle ausgaben abgeschlossen");


    }

    public static void output(int[] arrayschritttemp, int[] arrayvertauschtemp, ArrayList<Long> zeittemp, int median) {
        Arrays.sort(arrayschritttemp);
        Arrays.sort(arrayvertauschtemp);
        //System.out.println("Median Vergleichsschritte: " + arrayschritttemp[median]);
        //System.out.println("Median Vertauschschritte: " + arrayvertauschtemp[median]);
        System.out.println("Durchschnitt Vergleichsschritte: " + avg(arrayschritttemp));
        System.out.println("Durchschnitt Vertauschschritte: " + avg(arrayvertauschtemp));
        System.out.println("Durchschnitt Zeit: " + avgList(zeittemp) + "Nanosekunden");
    }

    public static void outputQuickSOrt(ArrayList<Long> schrittetemp, ArrayList<Long> schrittevertauschtep, ArrayList<Long> zeittemp, int median) {
        Collections.sort(schrittetemp);
        Collections.sort(schrittevertauschtep);
        //System.out.println("Median Vergleichsschritte: " + schrittetemp.get(median));
        //System.out.println("Median Vertauschschritte: " + schrittevertauschtep.get(median));
        System.out.println("Durchschnitt Vergleichsschritte: " + avgList(schrittetemp));
        System.out.println("Durchschnitt Vertauschschritte: " + avgList(schrittevertauschtep));
        System.out.println("Durchschnitt Zeit: " + avgList(zeittemp) + "Nanosekunden");
    }

    static long avg(int[] array) {
        long temp = 0, avg;
        for (int j : array) {
            temp += j;
        }
        avg = temp / array.length;

        return avg;
    }

    static long avgList(ArrayList<Long> List) {
        long temp = 0, avgList;
        for (Long aLong : List) {
            temp += aLong;
        }
        avgList = temp / List.size();

        return avgList;
    }

    static int[] lottozahlen() {
        int[] lottoArray = new int[größeArray];

        boolean flag;
        boolean added;
        int a;

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

    static void eingaben() {

        System.out.println("Bitte geben Sie die größe des Arrays ein: [Größe des Arrays]: ");
        int n = scanner.nextInt();
        if (n > 0) {
            größeArray = n;
        } else {
            System.out.println("Es muss ein wert über 0 eingegeben werden");
        }
        System.out.println("Bitte geben Sie den gewünschten Zahlenbereich ein:");
        int a = scanner.nextInt();
        if (n > 0) {
            zahlenbereich = a;

        } else {
            System.out.println("Es muss ein wert über 0 eingegeben werden");
        }
        System.out.println("Bitte geben Sie die Anzahl der Arrays ein:");
        int b = scanner.nextInt();
        if (b > 0) {
            anzahlArrays = b;
        } else {
            System.out.println("Es muss ein wert über 0 eingegeben werden");
        }
    }

    static void swap(int[] arr, int i, int j) {


        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        vertauschQS++;


    }

    static int partition(int[] arr, int low, int high) {



        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            schritteQS++;
            if (arr[j] < pivot) {

                i++;
                swap(arr, i, j);



            }
        }
        swap(arr, i + 1, high);


        return (i + 1);
    }


    static void quickSort(int[] arr, int low, int high) {
        long startTime = (int) System.nanoTime();

        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

            int endtime = (int) System.nanoTime();

            quicksortZeit.add(endtime - startTime);
        }
    }

}
