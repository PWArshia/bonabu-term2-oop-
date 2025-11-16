import java.awt.*;

public class zRect extends Shapes {

    private int width;
    private int height;
    private int temp;

    public zRect(int x, int y, int x2, int y2 , int color ,int Thickness , boolean filled) {
        
        super.x1=x;
        super.y1=y;
        super.x2=x2;
        super.y2=y2;

        if( super.x1>super.x2 || super.y1>super.y2){
            if(super.x1>super.x2 && super.y1<super.y2){
                temp=super.x1;
                super.x1=super.x2;
                super.x2=temp;
            }
            else if(super.y1>super.y2 && super.x1<super.x2) {
                temp=super.y1;
                super.y1=super.y2;
                super.y2=temp;
            }
            else{
                temp=super.x1;
                super.x1=super.x2;
                super.x2=temp;
                temp=super.y1;
                super.y1=super.y2;
                super.y2=temp;
            }

        }
        this.width = super.x2-super.x1;
        this.height = super.y2-super.y1;
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
        super.Thickness=Thickness;
        super.isfiled=filled;
        super.shType=2;
    }

    public void Draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(super.color);
        g2.setStroke(new BasicStroke(super.Thickness));
        if (super.isfiled){
            g2.fillRect(super.x1, super.y1, width, height);
        }
        else{
            g2.drawRect(super.x1, super.y1, width, height);
        }
    }

    public boolean Its(int x , int y){
        if(super.isfiled){
            if((Math.min(super.x1,super.x2)<=x)&&(Math.max(super.x1,super.x2)>=x)){
                if ((Math.min(super.y1,super.y2)<=y)&&(Math.max(super.y1,super.y2)>=y)){
                    return true;
                }
            }
        }
        else {
            if(super.x1==x || super.x2==x){
                for (int i=Math.min(super.y1,super.y2); i<=Math.max(super.y1,super.y2);i++){
                    if(i==y){
                        return true;
                    }
                }
            }
            else if(super.y1==y || super.y2==y){
                for (int i=Math.min(super.x1,super.x2); i<=Math.max(super.x1,super.x2);i++) {
                    if (i == x) {
                        return true;
                    }
                }
            }
        }
        return false;

    }



}
