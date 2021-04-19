import java.util.*;

public class StartenIDK {
   static Scanner scanner = new Scanner(System.in);
   static int größeArray;
   static int zahlenbereich;
   static int anzahlArrays;
   static long[] zeiten = new long[4];

    public static void main(String[] args) {

        eingaben();
        int[] schrittWerteBS = new int[anzahlArrays];
        int[] vertauschWerteBS = new int[anzahlArrays];
        int[] werteBS ;

        ArrayList<Long> bubblesortZeit = new ArrayList<>();
        ArrayList<Long> insertionsortZeit = new ArrayList<>();
        ArrayList<Long> selectionsortstableZeit = new ArrayList<>();
        ArrayList<Long> selectionsortZeit = new ArrayList<>();

        int[] schrittWerteSSS = new int[anzahlArrays];
        int[] vertauschWerteSSS = new int[anzahlArrays];
        int[] werteSSS ;

        int[] schrittWerteSS = new int[anzahlArrays];
        int[] vertauschWerteSS = new int[anzahlArrays];
        int[] werteSS ;

        int[] schrittWerteIS = new int[anzahlArrays];
        int[] vertauschWerteIS = new int[anzahlArrays];
        int[] werteIS;
        int median = (größeArray/2)-1;





        for (int i = 0; i<anzahlArrays;i++) {


            int[] arr = lottozahlen();

            werteBS = BubbleSort.bubbleSort(arr);
            schrittWerteBS[i] = werteBS[0];
            vertauschWerteBS[i] = werteBS[1];
            bubblesortZeit.add(BubbleSort.bubblesortZeit.get(i));

            arr = lottozahlen();

            werteSSS = SelectionSortStable.stableSelectionSort(arr,größeArray);
            schrittWerteSSS[i] = werteSSS[0];
            vertauschWerteSSS[i] = werteSSS[1];
            selectionsortstableZeit.add(SelectionSortStable.Zeit.get(i));
            arr = lottozahlen();

            werteSS = SelectionSort.sort(arr);
            schrittWerteSS[i] = werteSS[0];
            vertauschWerteSS[i] = werteSS[1];
            selectionsortZeit.add(SelectionSort.bubblesortZeit.get(i));



            arr = lottozahlen();
            werteIS = InsertionSort.sort(arr);
            schrittWerteIS[i]= werteIS[0];
            vertauschWerteIS[i]=werteIS[1];
            insertionsortZeit.add(InsertionSort.bubblesortZeit.get(i));
        }
      //  Arrays.toString(vertauschWerteSSS);
       // System.out.println(Arrays.toString(vertauschWerteSSS));
        System.out.println(bubblesortZeit);
        System.out.println(insertionsortZeit);
        Arrays.sort(schrittWerteBS);
        Arrays.sort(vertauschWerteBS);
        Arrays.sort(schrittWerteSSS);
        Arrays.sort(vertauschWerteSSS);
        Arrays.sort(schrittWerteSS);
        Arrays.sort(vertauschWerteSS);
        Arrays.sort(schrittWerteIS);
        Arrays.sort(vertauschWerteIS);
        System.out.println(bubblesortZeit);
        System.out.println("Comparison der Verschiedenen Sorts");
        System.out.println(median);
        System.out.println("Bubble Sort");
        System.out.println("Median Vergleichsschritte: "+schrittWerteBS[median]);
        System.out.println("Median Vertauschschritte: "+vertauschWerteBS[median]);
        System.out.println("Durchschnitt Vergleichsschritte: "+avg(schrittWerteBS));
        System.out.println("Durchschnitt Vertauschschritte: "+avg(vertauschWerteBS));
        System.out.println("Durchschnitt Zeit: "+avgList(bubblesortZeit,0) + "Nanosekunden");
        System.out.println("Selection Sort Stable");
        System.out.println("Median Vergleichsschritte: "+schrittWerteSSS[median]);
        System.out.println("Median Vertauschschritte: "+vertauschWerteSSS[median]);
        System.out.println("Durchschnitt Vergleichsschritte: "+avg(schrittWerteSSS));
        System.out.println("Durchschnitt Vertauschschritte: "+ avg(vertauschWerteSSS));
        System.out.println("Durchschnitt Zeit: "+avgList(selectionsortstableZeit,1) + "Nanosekunden");
        //System.out.println("Durchschnitt Zeit" +avgList(selectionsortZeit));
        System.out.println("Selection Sort");
        System.out.println("Median Vergleichsschritte: "+schrittWerteSS[median]);
        System.out.println("Median Vertauschschritte: "+vertauschWerteSS[median]);
        System.out.println("Durchschnitt Vergleichsschritte: "+avg(schrittWerteSS));
        System.out.println("Durchschnitt Vertauschschritte: "+ avg(vertauschWerteSS));
        System.out.println("Durchschnitt Zeit: "+avgList(selectionsortZeit,2) + "Nanosekunden");
        System.out.println("Insertion Sort");
        System.out.println("Median Vergleichsschritte: "+schrittWerteIS[median]);
        System.out.println("Median Vertauschschritte: "+vertauschWerteIS[median]);
        System.out.println("Durchschnitt Vergleichsschritte: "+avg(schrittWerteIS));
        System.out.println("Durchschnitt Vertauschschritte: "+ avg(vertauschWerteIS));
        System.out.println("Durchschnitt Zeit: "+avgList(insertionsortZeit,3) + "Nanosekunden");
        System.out.println("Zeiten:"+ Arrays.toString(zeiten));
        System.out.println(Arrays.stream(zeiten).max());









    }
    static long avg(int[] array){
        long temp = 0, avg;
        for (int j : array) {
            temp += j;
        }
        avg = temp/array.length;

        return avg;
    }
    static long avgList(ArrayList<Long> List,int zahl){
        long temp = 0, avgList;
        for (Long aLong : List) {
            temp += aLong;
        }
        avgList = temp/List.size();
        zeiten[zahl] = avgList;
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
            }
            else{
                System.out.println("Es muss ein wert über 0 eingegeben werden");
            }
            System.out.println("Bitte geben Sie den gewünschten Zahlenbereich ein:");
            int a=scanner.nextInt();
            if(n>0){
                zahlenbereich = a;

            }
            else{
                System.out.println("Es muss ein wert über 0 eingegeben werden");
            }
            System.out.println("Bitte geben Sie die Anzahl der Arrays ein:");
            int b= scanner.nextInt();
            if(b>0){
                anzahlArrays=b;
            }
            else{
                System.out.println("Es muss ein wert über 0 eingegeben werden");
            }
    }
}
