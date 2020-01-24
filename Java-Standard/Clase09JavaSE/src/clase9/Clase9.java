package clase9;

public class Clase9 {

    public static void main(String[] args) {
        try {
            System.out.println(calculo(1000, 0));
        } catch (Throwable e) {
            System.out.println("Esta todo bien");
        }

    }

    public static int calculo(int n1, int n2) {
        return Utils.calculoComplejo(n1, n2);
    }

}
