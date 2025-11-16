package Tools;

import java.util.Scanner;

public class Polynomial {

    public static String corrector(String s) {
        String res="";

        if (s.charAt(0)!='+' && s.charAt(0)!='-'){
            res+='+';
        }

        for (int i = 0; i < s.length(); i++) {
            res+=s.charAt(i);
        }
        return res;
    }


     public static int splitter(String s, String[] P){

        int cP=0;
        String temp = ""+s.charAt(0);
        int is=1;
        int c=1;
        while (is<s.length()){

            for (int  i=is ; i<s.length() ; i++){
                c=i;
                if (s.charAt(i)=='+' || s.charAt(i)=='-')
                    break;
                temp+=s.charAt(i);
            }
            P[cP++]=temp;
            temp=""+s.charAt(c);
            is=c;
            c++;
            is++;
        }
        return cP;
     }

     public static int Analysisaxn(String[] s , int cS, double[] A ){

        int cA=0;
        int is=0;
        String temp="";
        while (is< cS) {
            temp ="";
            if (s[is].indexOf('x') == -1) {
                if (cA<=0)
                    cA = 1;
                temp=s[is].substring(0,s[is].length());
                if (temp.equals("+"))
                    temp="+1";
                if (temp.equals("-"))
                    temp="-1";
                A[0] += Double.parseDouble(temp);
            }
            else if (s[is].indexOf('^') == -1) {
                if (cA<=1)
                    cA = 2;
                temp=s[is].substring(0,s[is].lastIndexOf('x'));
                if (temp.equals("+"))
                    temp="+1";
                if (temp.equals("-"))
                    temp="-1";
                A[1] += Double.parseDouble(temp.substring(0, temp.length()));
            }
            else if (s[is].indexOf('x') != -1 && s[is].indexOf('^') != -1) {
                String temp2=s[is].substring(s[is].indexOf('^')+1 ,s[is].length());
                int n = Integer.parseInt(temp2.substring(0,temp2.length()));
                temp=s[is].substring(0,s[is].indexOf('x'));
                if (temp.equals("+"))
                    temp="1";
                if (temp.equals("-"))
                    temp="-1";
                double a = Double.parseDouble(temp.substring(0, temp.length()));
                A[n] += a;
                if (cA<n+1){
                    cA=n+1;
                }
            }
            is++;
        }
        return cA;
     }

     public static int Poly2Array(String s1,double[] p){
        String temp[]= new String[1000];
        int ctemp=splitter(s1,temp);
        int cp=Analysisaxn(temp,ctemp,p);
        return cp;
     }

     public static String Array2Polynomial(double[] A,int cA){

        String res="";

        int c=0;
         for (int x=0 ; x<cA; x++){
             if (A[x]!=0){
                 if (x==0 && A[x]>0) {
                     res += "+" + A[x];
                 }
                 else if (x==0 && A[x]<0){
                     res+=A[x];
                 }
                 else if (x==1 && A[x]>0) {
                     res += "+" + A[x] + "x";
                 }
                 else if (x==1 && A[x]<0) {
                     res += A[x] + "x";
                 }
                 else if (x>1 && A[x]>0){
                     res+="+"+A[x]+"x^"+x;
                 }
                 else if (x>1 && A[x]<0) {
                     res += A[x] + "x^" + x;
                 }
             }
             else {
                 c++;
             }
         }
         if (c==cA){
             res="0";
         }
        return res;
     }

     public static String Psum( String  s){

        double A[]= new double [1000];
        int cA=Poly2Array(s,A);
        String res=Array2Polynomial(A,cA);
        return res;
     }

     public static String Pminus(String s1, String s2) {

        String res="";

        String temp2="";//برای اعمال کردن منفی توی عبارت
        for (int x=0 ; x<s2.length(); x++){
            if (s2.charAt(x)=='+')
                temp2+='-';
            else if (s2.charAt(x)=='-')
                temp2+='+';
            else
                temp2+=s2.charAt(x);
        }



        res=Psum(s1+temp2);
        return res;
     }

     public static String Pmultiple(String s1, String s2) {
        String res="";
        String S1[]= new String[1000];
        int cS1=splitter(s1,S1);
        double S11[]= new double[1000];
        int cS11=Analysisaxn(S1,cS1,S11);


        String S2[]= new String[1000];
        int cS2=splitter(s2,S2);
        double S22[]=new double[1000];
        int cS22=Analysisaxn(S2,cS2,S22);

        double Resualt[]= new double[1000];


        for (int x=0;x<cS11;x++){
            if(S11[x]!=0.0){
                for (int y=0 ; y<cS22 ; y++){
                    if (S22[y]!=0.0){
                        Resualt[y+x]+=S11[x]*S22[y];
                    }
                }
            }
        }

        res=Array2Polynomial(Resualt,cS11+cS22);
        return res;
     }


     public static String PDerivate(String s1){



        String S1[]=new String[1000];
        int cS1=splitter(s1,S1);
        double S11[]= new double[1000];
        int cS11=Analysisaxn(S1,cS1,S11);

        double Resualt[]= new double[1000];

        for (int x=0;x<cS11;x++){
            if(S11[x]!=0.0){
                if (x!=0){
                    Resualt[x-1]+=S11[x]*x;
                }
            }
        }

        return Array2Polynomial(Resualt,cS11);
     }

     public static String PIntegral(String s1){


         String S1[]=new String[1000];
         int cS1=splitter(s1,S1);
         double S11[]= new double[1000];
         int cS11=Analysisaxn(S1,cS1,S11);

         double Resualt[]= new double[1000];

         for (int x=0;x<cS11;x++){
             Resualt[x+1]+=S11[x]/(x+1);
         }

        String res=Array2Polynomial(Resualt,cS11+1);
         res+="+c";

        return res;
     }

     public static String Pdive(String s1, String s2) {
         String res = "";
         String P2[]=new String[1000];
         int cP2=splitter(s2,P2);
         double A2[]=new double[1000];
         int cA2=Analysisaxn(P2,cP2,A2);
         double A1[]=new double[1000];
         int cA1=Poly2Array(s1,A1);
         if(cA2>cA1){
             res="0";
         }
         while(cA1>=cA2){
             if(P2[0].equals("0")){
                 return "invalid";
             }

             else if(cA2==1){
                 for(int x=0 ;x<cA1;x++){
                     A1[x]=A1[x]/A2[0];
                 }
                 res=Array2Polynomial(A1,cA1);
                 return res;
             }

             else if(cA2==cA1){
                 double temp1[]=new double[1];
                 temp1[0]=A1[cA1-1]/A2[cA2-1];
                 String temp2=Array2Polynomial(temp1,1);
                 res+=temp2;
                 temp2=Pmultiple(temp2,s2);
                 s1=Pminus(s1,temp2);
                 for (int x=0;x<cA1;x++){
                     A1[x]=0;
                 }
                 cA1=Poly2Array(s1,A1);
             }

             else{

                 double temp1[]=new double[cA1-cA2+1];
                 temp1[cA1-cA2]=A1[cA1-1]/A2[cA2-1];
                 String temp2=Array2Polynomial(temp1,cA1-cA2+1);
                 res+=temp2;
                 temp2=Pmultiple(temp2,s2);
                 s1=Pminus(s1,temp2);
                 for(int x=0 ; x<cA1; x++){
                     A1[x]=0;
                 }
                 cA1=Poly2Array(s1,A1);
             }

         }
         return res;
     }

     public static String PMode(String s1, String s2) {
        String res="";
        String temp1=Pdive(s1,s2);
        temp1=Pmultiple(temp1,s2);
        res=Pminus(s1,temp1);
        return res;
     }
}