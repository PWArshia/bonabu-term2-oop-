import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tools extends JPanel {


    private JButton ToolsButton[];
    private DrawPanel draw;
    private JCheckBox isField;
    private JMenuItem Th[];



    public Tools( DrawPanel draw ) {

//      ------------------------------------------>customize panel
        super();
        
        this.draw = new DrawPanel();
        this.draw = draw;

        setPreferredSize(new Dimension(Main.Mwith, 50));
        setOpaque(true);
        setBackground(Color.gray);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        




//      ----------------------------------------------------> create btns
        ToolsButton=new JButton[100];

        for (int i=0; i<10; i++) {
            ToolsButton[i] = new JButton();
            ToolsButton[i].setFont(new Font("Serif", Font.BOLD, 15));
            ToolsButton[i].setPreferredSize(new Dimension(75, 30));
            ToolsButton[i].setOpaque(true);
            ToolsButton[i].setBackground(Color.CYAN);
        }


//      -----------------------------------------------------------> Line btn
        ToolsButton[0].setText("Line");
        ToolsButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Line);
            }
        });
        this.add(ToolsButton[0]);

//      ------------------------------------------------------------> Rect btn
        ToolsButton[1].setText("Rect");
        ToolsButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Rect);
            }
        });
        this.add(ToolsButton[1]);

//      -------------------------------------------------------------> Circle btn
        ToolsButton[2].setText("Circle");
        ToolsButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Circle);
            }
        });
        this.add(ToolsButton[2]);

//      ------------------------------------------------------------>Color btns

        ToolsButton[3] = new JButton("Color ▼");
        JPopupMenu popupMenu1 = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Red");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setColor(zColor.Red);
                ToolsButton[3].setText("Red▼");
            }
        });
        JMenuItem item2 = new JMenuItem("Yellow");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setColor(zColor.Yellow);
                ToolsButton[3].setText("Yellow▼");;
            }
        });
        JMenuItem item3 = new JMenuItem("Blue");
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setColor(zColor.Blue);
                ToolsButton[3].setText("Blue▼");
            }
        });
        JMenuItem item4 = new JMenuItem("Black");
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setColor(zColor.Black);
                ToolsButton[3].setText("Black▼");
            }
        });

        popupMenu1.add(item1);
        popupMenu1.add(item2);
        popupMenu1.add(item3);
        popupMenu1.add(item4);


        ToolsButton[3].addActionListener(e ->
                popupMenu1.show(ToolsButton[3], 0, ToolsButton[3].getHeight()));
        this.add(ToolsButton[3]);

//       ---------------------------------------------------------------------->isFiled btn
        isField = new JCheckBox();
        isField.setPreferredSize(new Dimension(75, 30));
        isField.setText("isField");
        isField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean f;
                if (isField.isSelected()) {
                    f=false;
                    draw.setField(f);
                } else {
                    f=true;
                    draw.setField(f);
                }

            }
        });
        this.add(isField);

//       -------------------------------------------------------->Thickness btn
        ToolsButton[4] = new JButton("Thickness ▼");
        JPopupMenu popupMenu2 = new JPopupMenu();
        Th=new JMenuItem[20];
        for (int i=0; i<20; i++) {
            final int c=i+1;
            Th[i] = new JMenuItem(c+"");
            Th[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    draw.setThickness(c);
                    ToolsButton[4].setText(c+"▼");
                }
            });
            popupMenu2.add(Th[i]);
        }
        ToolsButton[4].addActionListener(e ->
                popupMenu2.show(ToolsButton[4], 0, ToolsButton[4].getHeight()));
        this.add(ToolsButton[4]);

        // ------------------------------------------------------------> Pen btn

        ToolsButton[5].setText("Pen");
        ToolsButton[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Pen);
            }
        });
        this.add(ToolsButton[5]);

        // ------------------------------------------------------------> Spray btn
        ToolsButton[6].setText("Spray");
        ToolsButton[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Spray);
            }
        });
        this.add(ToolsButton[6]);

//      ---------------------------------------------------------------------> Delete
        ToolsButton[7].setText("Delete");
        ToolsButton[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Delete);
            }
        });
        this.add(ToolsButton[7]);
//        ---------------------------------------------------------------------> MOn btn
        ToolsButton[8].setText("Mon");
        ToolsButton[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.setShapeType(shapeType.Mon);
            }
        });
        this.add(ToolsButton[8]);


    }
}
