public class BigInt {

    private int A[];
    private int cA;
    private char sign;

    //   --------------------------------------> CONSTRUCTORS

    public BigInt() {
        A= new int[100000];
        this.sign = '+';
        this.cA=0;
    }

    public BigInt(String s){
      Set(s);
    }

    public BigInt(long x){
        Set(x);
    }

    public BigInt(BigInt a){
        Set(a);
    }


    //   --------------------------------------> SETTERS

    public void Set(String s){
        s=checker(s);
        A=new int [100000];
        cA=0;
        if (s.charAt(0)=='+' || s.charAt(0)=='-') {
            this.sign=s.charAt(0);
            for (int i=1; i<s.length(); i++) {
                A[i-1]=s.charAt(i)-'0';
                cA=i;
            }
            if (sign=='-') {
                A[0]=-A[0];
            }
        }
        else{
            this.sign='+';
            for (int i=0; i<s.length(); i++) {
                A[i]=s.charAt(i)-'0';
                cA=i+1;
            }
        }
    }

    public void Set(BigInt x){
        this.A=x.A;
        this.cA=x.cA;
        this.sign=x.sign;
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
                if(this.length()>x.length()){
                    this.reverse();
                    return 1;
                }
                else if (this.length()<x.length()){
                    this.reverse();
                    return -1;
                }
                else {
                    for(int i=0; i<this.length(); i++){
                        if(this.A[i]>x.A[i]){
                            this.reverse();
                            return 1;
                        }
                        else if(this.A[i]<x.A[i]){
                            this.reverse();
                            return -1;
                        }
                    }
                    this.reverse();
                    return 0;
                }
            }
            else {
                if (this.length() > x.length()) {
                    this.reverse();
                    return -1;
                }
                else if (this.length() < x.length()) {
                    this.reverse();
                    return +1;
                } else {
                    for (int i = 0; i < this.length(); i++) {
                        if (this.A[i] > x.A[i]) {
                            this.reverse();
                            return 1;
                        } else if (this.A[i] < x.A[i]) {
                            this.reverse();
                            return -1;
                        }
                    }
                    this.reverse();
                    return 0;
                }
            }
        }
        else{
            if(this.sign=='-'){
                this.reverse();
                return -1;
            }
            else if(this.sign=='+'){
                this.reverse();
                return 1;
            }
        }
        this.reverse();
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

            int max=b.length();
            if(max<a.length()){
                max=a.length();
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

        if (a.sign==b.sign){

            a.reverse();
            b.reverse();

            int D[]=new int[100000];
            int E[]=new int[100000];
            int F[]=new int[100000];
            int cF=0;

            for (int i=0; i<a.length(); i++) {
                D[i]=a.A[i];
            }
            for (int i=0; i<b.length(); i++) {
                E[i]=b.A[i];
            }


            int z=0;
            int q=0;
            for (int i=0 ; i<b.length(); i++){
                for (int j=0; j<a.length(); j++){
                    z=D[j]*E[i]+F[i+j]+q;
                    q=0;
                    if (z>9){
                        F[i+j]=z%10;
                        q=z/10;
                    }
                    else{
                        F[i+j]=z;
                    }
                    cF=i+j+1;
                }

            }
            if(q>0){
                F[cF]=q;
                q=0;
                cF++;
            }
            this.Set(0);
            for (int i=0 ; i<cF; i++){
                this.A[i]=F[i];
            }
            this.cA=cF;
            this.reverse();
        }

        else{
            if(a.sign=='-'){
                a.sign='+';
                a.A[0]=-a.A[0];
                this.SetMultiple(a,b);
                this.sign='-';
                this.A[0]=-this.A[0];
            }
            else{
                b.sign='+';
                b.A[0]=-b.A[0];
                this.SetMultiple(a,b);
                this.sign='-';
                this.A[0]=-this.A[0];
            }

        }
    }

    public BigInt SetDiv(BigInt a, BigInt b){
        if (a.compare(0)==0){
            this.cA=1;
        }
        else if(a.compare(b)==-1 && a.sign==b.sign && a.sign=='+'){
            this.cA=1;
        }
        else if(a.compare(b)==0){
            this.cA=1;
            this.A[0]=1;
        }
        else if (b.compare(0)==0){
            this.cA=2;
        }
        else{
            if (a.sign==b.sign){
                while(a.compare(b)>=0){
                    BigInt C=new BigInt();

                    int l=0;
                    int t=0;
                    C.cA=0;
                    while(C.compare(b)<0){
                        C.A[C.cA]=a.A[C.cA];
                        C.cA++;
                        l=C.cA;
                    }
                    while(C.compare(b)>=0){
                        C.SetMinus(C,b);
                        t++;
                    }
                    this.A[cA]=t;
                    cA++;

                    BigInt h=new BigInt();
                    if (a.cA-l==0){
                        h.Set(t);
                    }
                    else {
                        int pow=1;
                        for (int i=1; i<=a.cA-l; i++){
                            pow*=10;
                        }
                        h.Set(t*pow);
                    }
                    C.SetMultiple(b,h);
                    int r=a.cA;
                    a.SetMinus(a,C);

                    if (a.compare(b)<0){
                        int j=r-l;
                        while(j>0){
                            this.cA++;
                            j--;
                        }

                    }
                }
                return a;
            }
            else {
                if (b.sign=='-'){
                    b.sign='+';
                    b.A[0]=-b.A[0];
                    this.SetDiv(a,b);
                    this.sign='-';
                    this.A[0]=-this.A[0];
                }
                else{
                    a.sign='+';
                    a.A[0]=-a.A[0];
                    this.SetDiv(a,b);
                    this.sign='+';
                    this.A[0]=-this.A[0];
                }
            }
        }
        return a;
    }

    public void SetMode(BigInt a, BigInt b){
        this.Set(SetDiv(a,b));
    }

    public void SetPow(BigInt a, int b){
        this.Set(a);
        for (int i=1; i<b; i++){
            this.SetMultiple(this,a);
        }
    }


}// end of class
