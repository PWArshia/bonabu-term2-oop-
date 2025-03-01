package com.example.bigcalc;

public class olaviat {


    private String s;
    private BigInt A;

    //   --------------------------------------> CONSTRUCTORS

    public olaviat() {
        this.s ="";
    }

    public olaviat(String s) {
        this.s = s;
    }

    //   --------------------------------------> SETTERS

    public void Set(String s) {
        this.s = s;
    }

    //   --------------------------------------> GETTER

    public String GetS() {
        return s;
    }

    //   --------------------------------------> FUNCTIONS
    public void last (){

        
        int h=0;
        while(h<s.length() && s.indexOf('!')!=-1){
            int f=0;
            int l =0;
            if (this.s.charAt(h) == '!'){
                String s2="";
                for (int j=h-1; j>=0; j--){
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    s2=this.s.charAt(j)+s2;
                    f=j;
                    
                }
                BigInt C= new  BigInt(s2);
                BigInt B = new BigInt();
                
                B.SetFact(C);
                this.s=this.s.replace(this.s.substring(f,h+1),B.GetString());
                h=-1;
            }
            h++;
        }

        

        h=s.length()-1;
        while(h>=0 && s.indexOf('^')!=-1){
            int z=0;
            int f=0;
            if (this.s.charAt(h) == '^'){
                String pow="";
                String base="";
                for (int j=h+1; j<this.s.length(); j++){
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    pow+=this.s.charAt(j);
                    z=j;
                }
                for (int j=h-1; j>=0; j--){
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    base=this.s.charAt(j)+base;
                    f=j;
                }
                BigInt B = new BigInt(base);
                int C = Integer.parseInt(pow);
                BigInt D=new BigInt();
                D.SetPow(B,C);
                s=s.replace(this.s.substring(f,z+1),D.GetString());
            }
            h--;
        }






        h=0;
        while(h<s.length() && s.indexOf('x')!=-1 || h<s.length() && s.indexOf('/')!=-1 || h<s.length() && s.indexOf('%')!=-1){
            int z=0;
            int c=0;
            if (s.charAt(h)=='x' || s.charAt(h)=='/'){
                String s1="";
                String s2="";
                for (int j=h-1 ; j>=0;j--){
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    s1=s.charAt(j)+s2;
                    z=j;
                }
                for (int j=h+1;j<s.length();j++){
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    s2+=s.charAt(j);
                    c=j;
                }
                BigInt B=new BigInt(s1);
                BigInt C=new BigInt(s2);
                BigInt A=new BigInt();
                if(s.charAt(h)=='x'){
                    A.SetMultiple(B,C);
                }
                else if (s.charAt(h)=='/'){
                    A.SetDiv(B,C);
                }
                else{
                    A.SetMode(B, C);
                }
                s=s.replace(s.substring(z,c+1),A.GetString());
                h=-1;
            }
            h++;
        }


        h=0;
        while(h<s.length() && s.indexOf('+')!=-1 || h<s.length() && s.indexOf('-')!=-1){

            int z=0;
            int c=0;
            if(s.charAt(h)=='+' || s.charAt(h)=='-'){
                String s1="";
                String s2="";
                for(int j=h-1 ; j>=0 ; j--){
                    s1=s.charAt(j)+s1;
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    z=j;
                }
                s2+=s.charAt(h);
                for(int j=h+1; j<s.length(); j++){
                    if(this.s.charAt(j)<'0' || this.s.charAt(j)>'9'){
                        break;
                    }
                    s2+=s.charAt(j);
                    c=j;
                }
                BigInt B=new BigInt(s1);
                BigInt C=new BigInt(s2);
                BigInt A=new BigInt();
                A.SetSum(B, C);
                s=s.replace(s.substring(z, c+1),A.GetString());
                h=-1;
            }
            h++;
        }   

        if(s==""){
            s="0";
        }































        
    }


}
