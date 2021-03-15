import java.lang.reflect.Array;
import java.util.*;

public class StartenIDK {
   static Scanner scanner = new Scanner(System.in);
   static int größeArray;
   static int zahlenbereich;
   static int anzahlArrays;

    public static void main(String[] args) {

        SelectionSortStable sss = new SelectionSortStable();
        SelectionSort ss = new SelectionSort();
        BubbleSort bs = new BubbleSort();
        eingaben();
        int[] schrittWerteBS = new int[anzahlArrays];
        int[] vertauschWerteBS = new int[anzahlArrays];
        int[] werteBS = new int[2];

        int[] schrittWerteSSS = new int[anzahlArrays];
        int[] vertauschWerteSSS = new int[anzahlArrays];
        int[] werteSSS = new int[2];

        int[] schrittWerteSS = new int[anzahlArrays];
        int[] vertauschWerteSS = new int[anzahlArrays];
        int[] werteSS = new int[2];
        int median = (anzahlArrays/2)-1;




        for (int i = 0; i<anzahlArrays;i++) {



           // System.out.println(java.util.Arrays.toString(arr));
            werteBS = bs.bubbleSort(lottozahlen());
            schrittWerteBS[i] = werteBS[0];
            vertauschWerteBS[i] = werteBS[1];

            werteSSS = sss.stableSelectionSort(lottozahlen(),größeArray);
            schrittWerteSSS[i] = werteSSS[0];
            vertauschWerteSSS[i] = werteSSS[1];

            werteSS = ss.sort(lottozahlen());
            schrittWerteSS[i] = werteSS[0];
            vertauschWerteSS[i] = werteSS[1];
        }
        Arrays.sort(schrittWerteBS);
        Arrays.sort(vertauschWerteBS);
        Arrays.sort(schrittWerteSSS);
        Arrays.sort(vertauschWerteSSS);
        Arrays.sort(schrittWerteSS);
        Arrays.sort(vertauschWerteSS);
        System.out.println(median);
        System.out.println(schrittWerteBS[median]);
        System.out.println(vertauschWerteBS[median]);
        System.out.println(" ");
        System.out.println(schrittWerteSSS[median]);
        System.out.println(vertauschWerteSSS[median]);
        System.out.println(" ");
        System.out.println(schrittWerteSS[median]);
        System.out.println(vertauschWerteSS[median]);




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
        static void eingaben() {

            System.out.println("Bitte geben Sie den gewünschten Zahlenbereich ein: [Zahlenbereich des Arrays]: ");
            int n = scanner.nextInt();
            if (n > 0) {
                 größeArray = n;
            }
            System.out.println("Bitte geben Sie den gewünschten Zahlenbereich ein:");
            int a=scanner.nextInt();
            if(n>0){
                zahlenbereich = a;

            }
            System.out.println("Bitte geben Sie die Anzahl der Arrays ein:");
            int b= scanner.nextInt();
            if(b>0){
                anzahlArrays=b;
            }
    }
}
