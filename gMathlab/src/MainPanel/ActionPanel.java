package MainPanel;

import javax.swing.*;
import java.awt.*;
import Main.Main;
import Tools.BigInt;

public class ActionPanel extends JPanel {
    private int Actype=1;
    private pBigInt A;
    private JPanel BigInt;

    public ActionPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(Main.mWidth-110, Main.mHeight-50));
        setOpaque(true);
        setBackground(Color.CYAN);



        if(Actype==1){
            BigInt = new JPanel();
            BigInt.setOpaque(true);
            BigInt.setBackground(Color.GRAY);
            BigInt.setLayout(new FlowLayout());
            add(BigInt);


            JTextField display = new JTextField("0");
            display.setFont(new Font("Segoe UI", Font.PLAIN, 28));
            display.setPreferredSize(new Dimension(100, 50));
            display.setEditable(false);
            display.setBackground(new Color(50, 50, 50)); // خاکستری تیره
            display.setForeground(Color.WHITE); // متن سفید
            BigInt.add(display);

            JPanel buttonPanel = new JPanel();





        }
    }

    public void SetActype(int Actype) {
            this.Actype = Actype;
    }




}
