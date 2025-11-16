import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class zMon extends Shapes{
    private int x3;
    private int y3;

    public zMon(int x1, int y1, int x2, int y2, int x3, int y3, int Thi, int color) {
        super.x1=x1;
        super.x2=x2;
        this.x3=x3;
        this.y3=y3;
        super.y1=y1;
        super.y2=y2;
        if (color ==zColor.Black){
            super.color= Color.BLACK;
        }
        else if (color ==zColor.Yellow) {
            super.color=Color.YELLOW;
        }
        else if (color ==zColor.Red) {
            super.color=Color.red;
        }
        else {
            super.color=Color.BLUE;
        }
        super.Thickness=Thi;
        super.shType=shapeType.Mon;
    }


    @Override
    public void Draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(super.color);
        QuadCurve2D q = new QuadCurve2D.Float();
        q.setCurve(super.x1, super.y1, super.x2, super.y2, this.x3, this.y3);
        g2.draw(q);
    }

    @Override
    public boolean Its(int x, int y) {
        return false;
    }
}
