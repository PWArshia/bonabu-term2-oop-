//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BigDouble a = new BigDouble();
        a.Set("12.1");
        BigDouble b = new BigDouble();
        b.Set("121.1");
        BigDouble c = new BigDouble();
        c.SetSum(a,b);
        System.out.println(c.Get());

    }
}