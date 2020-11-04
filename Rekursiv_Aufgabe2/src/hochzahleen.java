public class hochzahleen {
    public static void main(String[] args) {
        int basis = 2;
        int hochzahl=2;

        System.out.println(Rechnung(basis,hochzahl));

    }public static int Rechnung(int basis, int hochzahl){
        if( hochzahl == 0){
            return 1;
        }
        return Rechnung(basis, hochzahl-1)*basis;
    }
}
