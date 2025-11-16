import java.awt.*;

public class zLine extends Shapes{


    private int temp;



    public  zLine(int x1, int y1, int x2, int y2, int Thickness , int color ){
        super.x1 = x1;
        super.y1 = y1;
        super.x2 = x2;
        super.y2 = y2;
        super.Thickness = Thickness;
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
        super.shType=1;
    }

    @Override
    public void Draw(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(super.color);
        g2.setStroke(new BasicStroke(super.Thickness));
        g2.drawLine(super.x1, super.y1, super.x2, super.y2);
    }

    public boolean Its(int x, int y){

        int temp4,temp5,temp6;
        temp4=(int)(Math.sqrt(Math.pow(super.x1-super.x2,2)+Math.pow(super.y1-super.y2,2)));
        temp5=(int)(Math.sqrt(Math.pow(x-super.x2,2)+Math.pow(y-super.y2,2)));
        temp6=(int)(Math.sqrt(Math.pow(super.x1-x,2)+Math.pow(super.y1-y,2)));



        if((Math.min(super.x1,super.x2)<=x)&&(Math.max(super.x1,super.x2)>=x)){
            if ((Math.min(super.y1,super.y2)<=y)&&(Math.max(super.y1,super.y2)>=y)){
                if(temp4==temp5+temp6){
                    return true;
                }
            }
        }
        return false;
    }

}
