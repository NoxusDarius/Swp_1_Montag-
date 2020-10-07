import java.util.Scanner;

public class NormalBinär {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] zahlen = new int[1000000000];


        long time = 0;
        long time2=0;
        int gefundeneZahl = 0 + (int) (Math.random() * ((1000000000 - 0) + 1));


        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i + 1;
        }


       /* System.out.print("Zahl eingeben: ");
        String a = scanner.nextLine();

        gefundeneZahl = Integer.parseInt(a);
        */
        System.out.println("Normale Suche");
        System.out.println("Eingegebene Zahl: " + gefundeneZahl);
        // normale1 Suche
        final long timeStart2 = System.nanoTime();
        int normal=normaleSuche(gefundeneZahl,zahlen);
        final long timeEnd2 = System.nanoTime();
        time2 = (timeEnd2 - timeStart2);
        if(normal>1) {
            System.out.println("Sie haben"+" "+normal+" "+ "Versuche benötigt"+" "+"Dabei sind:"+" "+time2+" "+"Nanonsekunden vergangen");
        }
        //binäre Suche
        System.out.println("Binäre Suche");
        System.out.println("Eingegebene Zahl: " + gefundeneZahl);


        final long timeStart = System.nanoTime();
        int[] Position = binarySearch(gefundeneZahl, zahlen);
        final long timeEnd = System.nanoTime();
        time = (timeEnd - timeStart);
        //zeit
        //untere Zeit - oberer Zeit
        if (Position[0] >= 0) {
            System.out.println("Dein Wert wurde an der: " + Position[0] + " " + "Position gefunden" + " " + "Ihre Eingegebene Zahl lautete:" + " " + zahlen[Position[0]] + " " + " Sie haben:" + Position[1] + " " + " Versuche benötigt" + " Vergangene Zeit" + " " + time + " " + "In Nanosekunden");
        } else {
            System.out.println("nicht gefunden");
            // catch filtert alle Buchstaben oder Sonderzeichen heraus
        }

        // Binäre Suche ist um den Faktor schneller

      /*  long time3= (time2/time)*100;
        System.out.println("Die Binäre Suche ist um den Faktor"+""+time3+" "+"% schneller");*/

    }


    public static int[] binarySearch(int gefundeneZahl, int[] zahlen) {
        // Aufwandsklasse Monotation
        // 3 Varianten Worst case Mann muss alle Zahlen durschauen
        // Best case die Erste Zahl ist die richtige Zahl
        // Binärsuche hat die 2 Klasse
        //java in c++ des in c des in assembler
        //


        int low = 0;
        int high = zahlen.length - 1;
        int[] Werte = new int[4];
        int count = 0;



        while (low != high) {
            count++;
            int center = ((high + low) / 2);

            if (zahlen[center] == gefundeneZahl) {


                Werte[0] = center;
                Werte[1] = count;

                return Werte;

            }
            if (zahlen[center] > gefundeneZahl) {
                high = center;

            } else {
                low = center - 1;
            }

        }
        Werte[2] = -1;
        return Werte;
    }

    public static int normaleSuche(int gefundeneZahl, int[] zahlen) {
        int count=0;
        for (int i = 0; i < zahlen.length; i++) {
            count++;
            if (zahlen[i] == (gefundeneZahl)) {

                return count;


            }


        }
        return -1;

    }
}










