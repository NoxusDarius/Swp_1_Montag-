
import java.util.Scanner;
public class NormaleSuche {
    public static void main(String[] args) {
        // Algorythmen: Definierter Ablauf zur Lösung eines Problems
        Scanner scanner = new Scanner(System.in);

        // Wiederholung: Ein Array dient dazu mehrere Werte in einer einzigen
        // variable zu speicher anstatt wie üblich für jedden Wert eine eigene Variable
        // um ein Array zu erstellen benötigt man den Datentyp und die Eckigen Klammeern
        // das setzen der Anfangswerte wird auch auf initialisieren genannt

        int[] zahlen = new int[1000000];
        int gefundeneZahl = 0;
        int count=0;


        System.out.print("Zahl eingeben: ");
        String a = scanner.nextLine();
        // erster Try catch Block dient zur überprüfung ob es sich bei dem eingegebenen Wert um einen Integer handelt
        // parseInt wandelt String zu Integer um
        try {
            gefundeneZahl = Integer.parseInt(a);
            System.out.println("Eingegebene Zahl: " + gefundeneZahl);
            // catch filtert alle Buchstaben oder Sonderzeichen heraus
        } catch (NumberFormatException e) {
            System.out.println("Es wurde keine Zahl eingegeben");
        }


        /*System.out.println( "Geben Sie die Gewünschte Größe ihres Arrays ein:");
        gefundeneZahl=scanner.nextInt();


        /*for(int i = 0; i<zahlen.length; i++) {
            zahlen[i] = (int)(Math.random()*größeArray);
        }*/
        //Die For Schleife startet bei 0, die Schleife läuft solange durch bis i=8 ein durchgang der Schleife erhöht i um 1
        // Im Schleifenrumpf wird inzwischen das Array befüllt es wird immer an der Stelle i befüllt
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i+1 ;
        }
    /*   for (int i = 0; i < zahlen.length; i++) {
            System.out.println(zahlen[i]);
        }



        }*/
        final long timeStart= System.currentTimeMillis();
        if ((gefundeneZahl > 0) && (gefundeneZahl < zahlen.length)) {
            for (int i = 0; i < zahlen.length; i++) {
                count++;
                if (zahlen[i] == (gefundeneZahl)) {
                    System.out.println("Ihre zahl wurde gefunden");
                    System.out.println("Es wurden "+count+" "+"Versuche benötiget");
                    final long timeEnd=System.currentTimeMillis();
                    //long Time=(timeEnd-timeStart)/100;
                    long Time=timeEnd-timeStart;
                    System.out.println("Zeit der Schleife:"+ Time+" "+"Millisekunden");
                }


            }
        }else {
            System.out.println("Ihre Zahl befindet sich nicht im Array");
        }



    }
}

