import java.awt.*;

public class zPolygon extends Shapes{
     private Point Poi[];
     private int cPoi;


    public zPolygon(Point P[] ,int c){
        Poi=P;
        cPoi=c;
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < cPoi-1; i++) {
            g2.drawLine(Poi[i].x, Poi[i].y, Poi[i+1].x, Poi[i+1].y);
        }
    }

    @Override
    public boolean Its(int x, int y) {
        for (int i = 0; i < cPoi-1; i++) {
            int temp4,temp5,temp6;
            temp4=(int)(Math.sqrt(Math.pow(Poi[i].x-Poi[i+1].x,2)+Math.pow(Poi[i].y-Poi[i+1].y,2)));
            temp5=(int)(Math.sqrt(Math.pow(x-Poi[i].x,2)+Math.pow(y-Poi[i].y,2)));
            temp6=(int)(Math.sqrt(Math.pow(Poi[i].x-x,2)+Math.pow(Poi[i].y-y,2)));



            if((Math.min(Poi[i].x,Poi[i].x)<=x)&&(Math.max(Poi[i].x,Poi[i].x)>=x)){
                if ((Math.min(Poi[i].y,Poi[i].y)<=y)&&(Math.max(Poi[i].y,Poi[i].y)>=y)){
                    if(temp4==temp5+temp6){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
