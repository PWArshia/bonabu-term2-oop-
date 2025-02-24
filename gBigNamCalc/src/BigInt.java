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
        A=new int [s.length()-1];
        cA=0;
        if (s.charAt(0)=='+' || s.charAt(0)=='-') {
            sign=s.charAt(0);
            for (int i=1; i<s.length(); i++) {
                A[i-1]=s.charAt(i)-'0';
                cA=i;
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
            if (s1.charAt(0)!='+' && s1.charAt(0)!='-'){
                s2+='+';
            }
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
        this.reverse();
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

    public void SetSum( BigInt a, BigInt b){


        b.reverse();
        a.reverse();



        if (a.sign==b.sign){

            int max=b.A.length;
            int min=a.A.length;
            if(max<a.A.length){
                min=b.A.length;
                max=a.A.length;
            }


            int D[]=new int[100000];
            int E[]=new int[100000];

            for (int i=0; i<a.length(); i++) {
                D[i]=a.A[i];
            }
            for (int i=0; i<b.length(); i++) {
                E[i]=b.A[i];
            }


            int q=0;
            for (int i=0; i<max; i++){
                this.A[i]+=D[i]+E[i]+q;
                q=0;
                if (this.A[i]>9){
                    q=this.A[i]/10;
                    this.A[i]%=10;
                }
            }
            this.cA=max;
            while (q>0){
               this.A[max]+=q;
               q/=10;
            }
            this.reverse();
        }
        else{
            if(b.sign=='+'){
                b.sign='-';
                b.A[0]=-b.A[0];
                this.SetMinus(a,b);
                this.sign='-';
            }
            else{
                b.sign='+';
                b.A[b.cA-1]=-b.A[b.cA-1];
                a.reverse();
                b.reverse();
                this.SetMinus(a,b);
                this.sign='+';
            }
        }



    }


    public void SetMinus(BigInt a, BigInt b){
        b.reverse();
        a.reverse();


        if(a.sign==b.sign){

            int max=b.A.length;
            if(max<a.A.length){
                max=a.A.length;
            }


            int D[]=new int[100000];
            int E[]=new int[100000];

            for (int i=0; i<a.length(); i++) {
                D[i]=a.A[i];
            }
            for (int i=0; i<b.length(); i++) {
                E[i]=b.A[i];
            }


            if(a.sign=='+'){
                int z=0;
                int q=0;
                int c=0;
                if (a.compare(b)>=0){
                    for (int i=0; i<max; i++){
                        z=D[i]-E[i]+q;
                        if (z>=0){
                            this.A[i]=z;
                            q=0;
                            if (z==0){
                                c++;
                            }
                            else{
                                c=0;
                            }
                        }
                        else {
                            this.A[i]=z+10;
                            q--;
                        }
                    }
                    this.cA=max-c;
                }
                else{
                    for (int i=0; i<max; i++){
                        z=E[i]-D[i]+q;
                        q=0;
                        if (z>=0){
                            this.A[i]=z;
                            if (z==0){
                                c++;
                            }
                            else{
                                c=0;
                            }
                        }
                        else {
                            this.A[i]=z+10;
                            q--;
                        }
                    }
                    this.cA=max-c;
                    this.A[cA-1]=-this.A[cA-1];
                }

            }
            this.reverse();
        }

        if (a.sign != b.sign){
            if(b.sign=='+'){
                b.sign='-';
                b.A[0]=-b.A[0];
                this.SetSum(a,b);
                this.sign='-';
            }
            else{
                b.sign='+';
                b.A[b.cA-1]=-b.A[b.cA-1];
                a.reverse();
                b.reverse();
                this.SetSum(a,b);
                this.sign='+';
            }
        }
    }

    public void SetMultiple(BigInt a, BigInt b){

        int D[]=new int[100000];
        int E[]=new int[100000];

        for (int i=0; i<a.length(); i++) {
            D[i]=a.A[i];
        }
        for (int i=0; i<b.length(); i++) {
            E[i]=b.A[i];
        }


        if(a.sign==b.sign){
            int z = 0;
            int q = 0;
            for (int i=0; i<a.length(); i++) {

                for (int j = 0; j < b.length(); j++) {
                    z = D[j] * E[i] + this.A[i + j] + q;
                    q = 0;
                    if (z > 9) {
                        this.A[i] = z % 10;
                        q = z / 10;
                    } else {
                        this.A[i] = z;
                    }
                    this.cA = i + j;
                }
//                while (q > 0) {
//                    z = this.A[this.cA];
//                }

            }







        }














    }


}// end of class
