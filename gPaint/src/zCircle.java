import java.awt.*;

public class zCircle extends Shapes {

    private int radius;
    private int temp1, temp2;
    private double temp3;

//    -----------------------------------------------------------------------------------------------------> Cons
    public zCircle(int x1, int y1, int x2 , int y2,  int Thickness , int color , boolean filled) {


      temp1=x2-x1;
      temp2=y2-y1;

      temp3=temp1*temp1+temp2*temp2;
      temp3=Math.sqrt(temp3);
      this.radius=(int)(temp3);

      super.x1=x1 -radius;
      super.y1=y1-radius;

      super.x2=x2;
      super.y2=y2;


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
      super.isfiled=filled;
      super.shType=3;

    }
//------------------------------------------------------------------------------------------------>Getter
    public int getType(){
        return 3;
    }

//    public int getX1




//------------------------------------------------------------------------------------------------->Func
    public void Draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(super.color);
        g2.setStroke(new BasicStroke(super.Thickness));
        if(super.isfiled){
            g2.fillOval(super.x1, super.y1, 2*radius, 2*radius);
        }
        else {
            g2.drawOval(super.x1, super.y1, 2*radius, 2*radius );
        }
    }

    public boolean Its(int x , int y){

        int temp4,temp5;
        double temp6;
        temp4=super.x1-x;
        temp5=super.y2-y;
        temp6=temp4*temp4+temp5*temp5;

        temp6 =  (Math.sqrt(temp6))/2;
        if (super.isfiled){
            if (temp6 <= this.radius){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (temp6 >= this.radius-5 && temp6 <= this.radius+5 ){
                return true;
            }
            else {
                return false;
            }


        }
    }
}
