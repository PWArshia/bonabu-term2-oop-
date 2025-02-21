public class BigInt {

    private int A[];
    private int cA;
    private char sign;

    //   --------------------------------------> CONSTRUCTORS

    public BigInt() {
        A= new int[100000];
        cA=0;
    }

    public BigInt(String s){
        A=new int [s.length()];
        cA=0;
        if (s.charAt(0)=='+' || s.charAt(0)=='-') {
            sign=s.charAt(0);
            for (int i=1; i<s.length(); i++) {
                A[i-1]=s.charAt(i);
                cA=i;
            }
        }
        else{
            sign='+';
            for (int i=0; i<s.length(); i++) {
                A[i]=s.charAt(i);
                cA=i;
            }
        }
    }

    public BigInt(long x){
        String s = Long.toString(x);
        A=new int [s.length()];
        cA=0;
        if (s.charAt(0)=='+' || s.charAt(0)=='-') {
            sign=s.charAt(0);
            for (int i=1; i<s.length(); i++) {
                A[i-1]=s.charAt(i);
                cA=i;
            }
        }
        else{
            sign='+';
            for (int i=0; i<s.length(); i++) {
                A[i]=s.charAt(i);
                cA=i;
            }
        }
    }


    //   --------------------------------------> SETTERS







    //   --------------------------------------> GETTER








    //   --------------------------------------> FUNCTIONS





}
