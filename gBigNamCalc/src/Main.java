//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BigInt A = new BigInt(2);
        BigInt B = new BigInt(5);
        BigInt C = new BigInt(0);
        C.SetFact(A);
        for (int x=0; x<C.length(); x++) {
            System.out.print(C.Get()[x]);
        }
    }
}