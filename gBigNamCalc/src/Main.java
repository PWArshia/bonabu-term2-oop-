//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BigInt A = new BigInt(144);
        BigInt B = new BigInt(2);
        A.SetSum(B);
        for (int x=0; x< A.length();x++){
            System.out.print(A.Get()[x]);
        }
    }
}