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
      Set(s);
    }

    public BigInt(long x){
        Set(x);
    }


    //   --------------------------------------> SETTERS

    public void Set(String s){
        s=checker(s);
        A=new int [s.length()];
        cA=0;
        if (s.charAt(0)=='+' || s.charAt(0)=='-') {
            sign=s.charAt(0);
            for (int i=1; i<s.length(); i++) {
                A[i-1]=s.charAt(i)-'0';
                cA=i+1;
            }
            if (sign=='-') {
                A[0]=-A[0];
            }
        }
        else{
            sign='+';
            for (int i=0; i<s.length(); i++) {
                A[i]=s.charAt(i)-'0';
                cA=i+1;
            }
        }
    }

    public void Set(BigInt x){
        A=x.A;
    }

    public void Set(long x){
        String s = Long.toString(x);
        Set(s);
    }


    //   --------------------------------------> GETTER

    public int [] Get(){
        return this.A;
    }

    public String GetString(){
        String s="";
        for (int i=0; i<A.length; i++) {
            s+=A[i];
        }
        return s;
    }



    //   --------------------------------------> FUNCTIONS

    public int length(){
        return this.cA;
    }

    private String checker( String s1){

        String s2="";

        if (s1.charAt(0)=='+' || s1.charAt(0)=='-' || s1.charAt(0)>='0' || s1.charAt(0)<='9') {
            s2+=s1.charAt(0);
            for (int i=1; i<s1.length(); i++) {
                s2+=s1.charAt(i);
            }
        }

        else{
            s2="0";
        }

        return s2;
    }

    private void reverse(){
        int B[]=new int[this.length()];
        int z=this.length();
        for (int i=0; i<this.length(); i++) {
            B[this.length()-1-i]=this.A[i];
        }
        for (int i=0; i<this.length(); i++) {
            this.A[i]=B[i];
        }
    }

    public int compare(BigInt x){
        if(this.sign==x.sign){
            if(this.sign=='+'){
                if(this.A.length>x.A.length){
                    return 1;
                }
                else if (this.A.length<x.A.length){
                    return -1;
                }
                else {
                    for(int i=0; i<this.A.length; i++){
                        if(this.A[i]>x.A[i]){
                            return 1;
                        }
                        else if(this.A[i]<x.A[i]){
                            return -1;
                        }
                    }
                    return 0;
                }
            }
            else {
                if (this.A.length > x.A.length) {
                    return -1;
                } else if (this.A.length < x.A.length) {
                    return +1;
                } else {
                    for (int i = 0; i < this.A.length; i++) {
                        if (this.A[i] > x.A[i]) {
                            return 1;
                        } else if (this.A[i] < x.A[i]) {
                            return -1;
                        }
                    }
                    return 0;
                }
            }
        }
        else{
            if(this.sign=='-'){
                return -1;
            }
            else if(this.sign=='+'){
                return 1;
            }
        }
        return 0;
    }

    public int compare(int x){
        BigInt y=new BigInt(x);
        return this.compare(y);
    }

    



}// end of class
