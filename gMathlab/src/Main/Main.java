package Main;

import MainPanel.ActionPanel;
import MainPanel.ChoicePanel;
import Tools.BigInt;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {

    public static final int  mHeight=850;
    public static final int  mWidth=1700;
    private ChoicePanel choicePanel=new ChoicePanel();
    private ActionPanel actionPanel=new ActionPanel();

    public Main() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("gMathlab");
        this.setBounds(100,100,mWidth,mHeight);
        this.setResizable(false);





        this.add(choicePanel);
        this.add(actionPanel);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}