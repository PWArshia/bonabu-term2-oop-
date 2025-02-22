//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BigInt A = new BigInt(144);
        System.out.println(A.length());
        BigInt B = new BigInt(222);
        BigInt C = new BigInt();
        C.SetSum(A,B);
        for (int x=0; x< A.length();x++){
            System.out.print(C.Get()[x]);
        }
    }
}