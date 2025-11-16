import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class zSpray extends Shapes {

    private Point POINT[];
    private int cPoint;
    private int  rn;
    private int temp;


    public zSpray(int x, int y,  int color , int Thickness){
        this.POINT=new Point[1000];
        this.POINT[0]=new Point(x , y);
        this.cPoint=1;
        if (Thickness==15 || Thickness==20)
            super.Thickness=Thickness;
        else{
            super.Thickness=10;
        }
        if (color ==zColor.Black){
            super.color=Color.BLACK;
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
        super.shType=5;
        this.temp=color;

    }

    public void SetPoint(int x, int y){
        this.POINT[cPoint]=new Point(x,y);
        this.cPoint++;
    }

    public int GetPoint(Point[] p){
        p=this.POINT;
        return this.cPoint;
    }

    public void Draw(Graphics g){

        boolean t=true;
        Graphics2D g2=(Graphics2D)g;
        for (int i=0 ;i<this.cPoint-1;i++){
            for (int z=1; z<=5 ; z++){
                int dx = (int) (Math.random() * (2 * super.Thickness + 1)) - super.Thickness;
                int dy = (int) (Math.random() * (2 * super.Thickness + 1)) - super.Thickness;
                rn=(int)(Math.random() * 41) - 20;
                zCircle p = new zCircle(POINT[i].x + dx, POINT[i].y + dy, POINT[i].x + dx + 1, POINT[i].y + dy + 1, 1, temp, t);
                p.Draw(g2);
            }
        }

        
        

    }

    public boolean Its(int x, int y){
        return false;
    }





}