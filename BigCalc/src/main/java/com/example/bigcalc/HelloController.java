package com.example.bigcalc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {
    private String s="";
    @FXML
    private TextArea showMon ;



    @FXML
    public void press0(){
        if(s.length()!=0){
            s+=0;
        }
        showMon.setText(s);
    }

    @FXML
    public void press1() {
        s+='1';
        showMon.setText(s);
    }
    @FXML
    public void press2() {
        s+='2';
        showMon.setText(s);
    }
    @FXML
    public void press3() {
        s+='3';
        showMon.setText(s);
    }
    @FXML
    public void press4() {
        s+='4';
        showMon.setText(s);
    }
    @FXML
    public void press5() {
        s+='5';
        showMon.setText(s);
    }
    @FXML
    public void press6() {
        s+='6';
        showMon.setText(s);
    }
    @FXML
    public void press7() {
        s+='7';
        showMon.setText(s);
    }
    @FXML
    public void press8() {
        s+='8';
        showMon.setText(s);
    }
    @FXML
    public void press9() {
        s+='9';
        showMon.setText(s);
    }
    @FXML
    public void pressSum() {
       if(s.charAt(s.length()-1)!='^' && s.charAt(s.length()-1)!='+' && s.charAt(s.length()-1)!='-'){
        s+='+';
        showMon.setText(s);
       }
    }
    @FXML
    public void pressMinus() {
        if(s.charAt(s.length()-1)!='^' && s.charAt(s.length()-1)!='+' && s.charAt(s.length()-1)!='-'){
            s+='+';
            showMon.setText(s);
        }
    }
    @FXML
    public void pressX() {
        if(s.charAt(s.length()-1)!='x'){
            if(s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-' || s.charAt(s.length()-1)>=0 || s.charAt(s.length()-1)<=9 || s.charAt(s.length()-1)=='x'){
                s+='x';
                showMon.setText(s);
            }
        }
    }
    @FXML
    public void pressDiv() {
        if(s.charAt(s.length()-1)!='/'){
            if(s.charAt(s.length()-1)=='+' || s.charAt(s.length()-1)=='-' || s.charAt(s.length()-1)>=0 || s.charAt(s.length()-1)<=9 || s.charAt(s.length()-1)=='/'){
                s+='/';
                showMon.setText(s);
            }
        }
    }
    @FXML
    public void pressC() {
        s="";
        showMon.setText(s);
    }
    @FXML
    public void pressPow() {
        s+='^';
        showMon.setText(s);
    }
    @FXML
    public void pressFact() {
        s+='!';
        showMon.setText(s);
    }
    @FXML
    protected void pressMod() {
        s+='%';
        showMon.setText(s);
    }
    @FXML
    public void pressDel() {
        String S2="";
        for (int i=0;i<s.length()-1;i++) {
            S2+=s.charAt(i);
        }
        s=S2;
        showMon.setText(s);
    }
    @FXML
    public void pressH() throws FileNotFoundException {
         File f1= new File("C:\\Users\\arshia\\Desktop\\java t\\data.txt");// write file address for import n and matris
        Scanner sc = new Scanner(f1);


        while(sc.hasNext()){
            s=sc.nextLine();
            showMon.setText(s);
        }

        sc.close();
    }
    @FXML
    public void pressCE() {
        int z=s.length()-1;
        int c=0;
        while(s.charAt(z)>='0' && s.charAt(z)<='9') {
            c++;
            z--;
        }
        String s2="";
        for (int i=0;i<s.length()-c;i++) {
            s2+=s.charAt(i);
        }
        s=s2;
        showMon.setText(s);
    }
    @FXML
    public void pressE() throws FileNotFoundException {
        File f2= new File("");//write file address here
        Scanner sc = new Scanner(f2);
        String Ress[]=new String[100000];
        int temp=0;
        while(sc.hasNext()){
            Ress[temp]=sc.nextLine();
            temp++;
        }
        sc.close();



        File f1= new File(""); //write file address here
        PrintWriter outfill1= new PrintWriter(f1);
        String s2=s;
        olaviat a=new olaviat(s);
        a.last();
        showMon.setText(a.GetS());
        for (int i=0;i<temp+1;i++) {
            outfill1.println(Ress[i]);
        }
        outfill1.println(s2+"="+a.GetS());
        outfill1.close();
    }

}