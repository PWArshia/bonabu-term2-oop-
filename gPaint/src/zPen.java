import java.awt.*;

public class zPen extends Shapes{

    private java.awt.Point POINT[];
    private int cPoint;

    public zPen(int x, int y, int color , int Thickness){
        this.POINT=new Point[1000];
        this.POINT[0]=new Point(x , y);
        this.cPoint=1;
        super.Thickness=Thickness;
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
        super.shType=4;
    }

    public void SetPoint(int x, int y){
        this.POINT[cPoint]=new Point(x,y);
        this.cPoint++;
    }

    public void setcPoints(Point point[],int cPoint){
        this.POINT=point;
        this.cPoint=cPoint;
    }
    public int GetPoint(Point[] p){
        p=this.POINT;
        return this.cPoint;
    }

    public  void Draw(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        for (int i=0;i<this.cPoint-1;i++){
            g2.setColor(super.color);
            g2.setStroke(new BasicStroke(super.Thickness));
            g2.drawLine(POINT[i].x ,POINT[i].y , POINT[i+1].x ,POINT[i+1].y );
        }
    }

    public boolean Its(int x, int y){

        for (int i=0;i<this.cPoint;i++){
            if (POINT[i].x==x && POINT[i].y==y){
                return true;
            }
        }
        return false;
    }




}
