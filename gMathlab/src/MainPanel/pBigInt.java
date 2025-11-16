package MainPanel;

import Tools.olaviat1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pBigInt extends JPanel {
    private JTextField display;
    private String S; // رشته برای ذخیره عبارت
    private olaviat1 olaviat1;

    public pBigInt() {
        // مقدار اولیه S
        S = "";

        // تنظیمات پنل اصلی
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(200, 220, 255)); // آبی کم‌رنگ
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // نمایشگر
        display = new JTextField("0");
        display.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(50, 50, 50)); // خاکستری تیره
        display.setForeground(Color.WHITE); // متن سفید
        display.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(display, BorderLayout.NORTH);

        // پنل دکمه‌ها
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(200, 220, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // آرایه دکمه‌ها
        String[] buttonLabels = {
                "7", "8", "9", "/", "%",
                "4", "5", "6", "*", "^",
                "1", "2", "3", "-", "!",
                "0", "C", "=", "+"
        };

        // گوش دادن به کلیک دکمه‌ها
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                if (command.equals("C")) {
                    // پاک کردن
                    S = "";
                    display.setText("0");
                } else if (command.equals("=")) {
                    // محاسبه با کلاس OLAVIAT
                    olaviat1 = new olaviat1(S);
                    olaviat1.last();
                    int result = Integer.parseInt(olaviat1.GetS()); // خروجی عدد صحیح
                    display.setText(String.valueOf(result));
                    S = String.valueOf(result); // برای ادامه محاسبات
                } else {
                    // اضافه کردن به S
                    S += command;
                    display.setText(S);
                }
            }
        };

        // اضافه کردن دکمه‌ها
        int gridY = 0, gridX = 0;
        for (String label : buttonLabels) {
            JButton button = new JButton(label) {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                    super.paintComponent(g2);
                    g2.dispose();
                }
            };
            button.setFont(new Font("Segoe UI", Font.BOLD, 20));
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setOpaque(false);

            // تنظیم رنگ‌ها
            if ("+-*/^%!=".contains(label)) {
                button.setBackground(new Color(0, 102, 204)); // آبی تیره
                button.setForeground(Color.WHITE);
            } else if (label.equals("C")) {
                button.setBackground(new Color(139, 0, 0)); // قرمز تیره
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }

            // اضافه کردن گوش‌دهنده به دکمه
            button.addActionListener(buttonListener);

            gbc.gridx = gridX;
            gbc.gridy = gridY;
            buttonPanel.add(button, gbc);

            gridX++;
            if (gridX > 4) {
                gridX = 0;
                gridY++;
            }
        }

        add(buttonPanel, BorderLayout.CENTER);
        this.setVisible(false);
    }

    public void SetV(boolean v){
        setVisible(v);
    }

}
