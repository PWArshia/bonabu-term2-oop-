public class BigDouble {

    private int A[];
    private int cA;
    private String S;
    private int N;
    String Res;


//  ------------------------------------->Cons

    public BigDouble() {
        this.A = new int[1000001];
        this.S = "";
        this.N = 0;
        this.cA = 0;
    }
    public BigDouble(int a) {
    }



//  --------------------------------------->Setter

    public void Set(int a) {
        this.S=""+a;
        this.S+="0";
        this.N=1;
        this.cA=S.length()+1;
        this.A[0]=0;
        this.A[1]=100;
        for (int i = 2; i <= S.length(); i++) {
            this.A[i]=S.charAt(i-1)-'0';
        }
    }

    public void Set(String p){

        if (p.indexOf('.')==-1){
            p=p+".0";
        }

        this.cA=p.length();
        for (int i=0;i<p.length();i++){
            if (p.charAt(i)=='.'){
                this.A[i]=100;
                this.N=i;
            }
            else{
                this.A[i]=p.charAt(i)-'0';
            }
        }
        this.S= p.replace(".","");
    }

//    -------------------------------------------------------------->Getter

    public String Get(){

        Res="";
        for (int i=0;i<cA;i++){
            if (A[i]==100){
                this.Res=this.Res+".";
            }
            else{
                this.Res=this.Res+this.A[i];
            }
        }
        return this.Res;
    }

//    ------------------------------------------------------------------->Func


    public void SetSum(BigDouble A , BigDouble B){

        BigInt a=new BigInt();
        BigInt b=new BigInt();

        String temp="";

        if(A.N>=B.N){
            temp=B.S;
            for (int i=B.N;i<A.N;i++){
                temp+="0";
            }
            a.Set(A.S);
            b.Set(temp);

        }
        else{
            temp=A.S;
            for (int i=A.N;i<B.N;i++){
                temp+="0";
            }
            a.Set(temp);
            b.Set(B.S);
        }
        BigInt c=new BigInt();
        c.SetSum(a,b);

        for(int i=0; i<c.length();i++){
            this.A[i]=c.Get()[i];
        }
        this.cA=c.length()+1;
        this.N=Math.max(A.N,B.N);
        for (int i=this.cA;i>this.N;i--){
            this.A[i]=this.A[i-1];
        }

        this.A[N]=100;

    }




}