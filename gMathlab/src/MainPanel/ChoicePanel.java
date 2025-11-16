package MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;

public class ChoicePanel extends JPanel {

    private JButton btns[];
    private ActionPanel actionPanel;

    public ChoicePanel() {
        actionPanel = new ActionPanel();
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(80, Main.mHeight-50));
        setOpaque(true);
        setBackground(Color.BLACK);


        btns = new JButton[100];
        for (int i=0; i<10; i++) {
            btns[i] = new JButton();
            btns[i].setFont(new Font("Serif", Font.BOLD, 15));
            btns[i].setPreferredSize(new Dimension(75, 30));
            btns[i].setOpaque(true);
            btns[i].setBackground(Color.CYAN);
        }


        btns[0].setText("BigInt");
        btns[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPanel.SetActype(1);
            }
        });
        this.add(btns[0]);

        btns[1].setText("BigDouble");
        btns[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPanel.SetActype(2);
            }
        });
        this.add(btns[1]);

        btns[2].setText("Polynomial");

    }

}
