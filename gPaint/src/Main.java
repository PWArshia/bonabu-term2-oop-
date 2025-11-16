import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    public static final int Mwith=1700;
    public static final int Mheight=900;

    private Tools tools;
    private DrawPanel draw;




    public Main() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setBounds(100,100,Mwith,Mheight);
            this.setTitle("Zero-Paint");
            this.setLayout(new FlowLayout());

            draw=new DrawPanel();
            tools = new Tools(draw);
            this.add(tools);


            this.add(draw);

            this.setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}