import java.util.Scanner;
import java.util.ArrayList;
public class Binärsuche {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] zahlen = new int[1000000000];
        int gefundeneZahl = 0;
        long time= 0;
        int time2;

        //int low = 0;                          //Erste und letzte Element in der Liste
        //5int high = zahlen.length - 1;
        // ArrayList<Integer> Werte = new ArrayList<Integer>();

        //int x = 324;
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i + 1;
        }


        System.out.print("Zahl eingeben: ");
        String a = scanner.nextLine();
     //   try {
            gefundeneZahl = Integer.parseInt(a);
           System.out.println("Eingegebene Zahl: " + gefundeneZahl);


            final long timeStart= System.nanoTime();
            int[] Position = binarySearch(gefundeneZahl, zahlen);
        final long  timeEnd=System.nanoTime();
         time=(timeEnd-timeStart);
            //zeit
            //untere Zeit - oberer Zeit
            if (Position[0] >= 0) {
                System.out.println("Dein Wert wurde an der: " + Position[0] + " " + "Position gefunden" + " " + "Ihre Eingegebene Zahl lautete:" + " " + zahlen[Position[0]] + " " + " Sie haben:" + Position[1] + " " + " Versuche benötigt"+" Vergangene Zeit"+" "+time +" "+"In Nanosekunden");
            } else {
                System.out.println("nicht gefunden");
                // catch filtert alle Buchstaben oder Sonderzeichen heraus
            }

       /* } catch (NumberFormatException e) {
            System.out.println("Es wurde keine Zahl eingegeben");
        }
*/

       /* int Versuche = binarySearch2(gefundeneZahl, zahlen);
        if (Versuche >= 0) {
            System.out.println("Sie haben " + Versuche + " " + "Versuche" + " " + "Ihre Eingegebene Zahl lautete:" + " " + zahlen[Versuche]);
        } else {
            System.out.println("nicht gefunden");

*/



      /*      // die Abruchsbedingung also low muss kleiner sein wie high
        //also solange man noch platz zum Suchen hat
        while(low != high){
            count++;
            // while Schleife die bei jeden Durchgang als ersen Schritt die  Mitte berechnet
            int center=(low +high)/2;
            // es wird überprüft ob der gesuchte werd dem Wert in der Mitte entspricht
            if(gefundeneZahl == zahlen[center]){
                System.out.println("Es wurden"+count+" "+"Versuche benötigt");
                System.out.println("Ihre Zahl wurde gefunden");
                // Falls nicht untersuchen ob Wert kleiner ist als die Mitte
                // wenn Wert kleiner verschiebung von High zu 1 kleiner der Mitte und das ganze nochmalss ausführen
            }else{ if(gefundeneZahl<zahlen[center]) {
                high = center;
            }else {
                // das Gleiche wird auch gemachtt wenn der Wert größer ist als der Wert in der Mitte
                low = center + 1;
                // ohne +1 kommt der Algorythmus nie zu ende
            }
            }

            System.out.println("Nicht vorhanden");


        }
*/


        }



    public static int[] binarySearch(int gefundeneZahl, int[] zahlen) {
        int low = 0;
        int high = zahlen.length - 1;
        int[] Werte = new int[4];
        int count=0;
        long time= 0;
        int time2;


        while (low != high) {
            count++;
            int center =  ((high + low) / 2);

            if (zahlen[center] == gefundeneZahl) {

                // expliziteTypumwandlung von einen größeren Datentyp in einen kleineren also der Long Wert wird in einem Int Wert verwandelt
                // time2= (int) time;

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
        Werte[2] =-1;
        return Werte;
    }

    /*public static int binarySearch2(int gefundeneZahl, int[] zahlen) {
        int low = 0;
        int high = zahlen.length - 1;
        //int count = 0;


        while (low != high) {
            //count++;
            int center = low + ((high - low) / 2);

            if (zahlen[center] == gefundeneZahl) {


                return center;

            }
            if (zahlen[center] > gefundeneZahl) {
                high = center;

            } else {
                low = center + 1;
            }

        }
        return -1;

    }*/
}


