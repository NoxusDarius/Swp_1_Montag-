

public class fibo_rekursiv {
    public static void main(String[] args) {
        int zahl = 20;
        int zahl2=20;

        final long timeStart = System.nanoTime();
        System.out.println(fiborek(zahl));
        final long timeEnd = System.nanoTime();
        System.out.println("Es wurden: " + (timeEnd-timeStart) + "Nanosekunden Rekursiv");

        System.out.println(" ");
        System.out.println(" ");

        final long timeStart2 = System.nanoTime();
        fiboiter(zahl2);
        final long timeEnd2 = System.nanoTime();
        System.out.println("Es wurden: " + (timeEnd2-timeStart2) + "Nanosekunden Iterativ");

        System.out.println(" ");
        System.out.println(" ");

        final long timeStart3 = System.nanoTime();
        System.out.println(fiboendrek(zahl));
        final long timeEnd3 = System.nanoTime();
        System.out.println("Es wurden: " + (timeEnd3-timeStart3) + "Nanosekunden Endrekursiv");

    }public static long fiborek(int zahl) {
        if (zahl == 0) return 0;
        if (zahl == 1) return 1;
        long erg = fiborek(zahl - 1) + fiborek(zahl - 2);
        return erg;
    }
   public static  void fiboiter(int zahl2) {
       int fibo1 = 0;
       int fibo2 = 1;

       zahl2 = zahl2 - 1;
       int erg =0;
       for (int i = 0; i < zahl2; i++) {
           erg = fibo1 + fibo2;


           fibo1 = fibo2;
           fibo2 = erg;


       }
       System.out.println(erg);
   }

    public static int fiboendrek(int zahl){
        return biboendrek2(zahl-1,1,0);

    }public static int biboendrek2(int zahl,int wert1,int wert2){
        if(zahl<=1) return wert1+wert2;
        return biboendrek2(zahl-1,wert1+wert2, wert1);


    }



}
