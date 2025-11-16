import java.awt.*;
import javax.swing.*;

public  abstract class Shapes extends JComponent {

    protected Color color;

    protected int x1 , y1, x2, y2;
    protected int Thickness;
    protected boolean isfiled;
    protected int shType;

    public Shapes(){
        super();
        this.color = Color.BLACK;

    }

//    -----------------------------> Setter

    public void SetColor(Color color){
        this.color = color;
    }

    public  void SetPoint(int x, int y){
    }

//    -------------------------------------> Getter
    public int GetColor(){
        if (this.color==Color.BLACK){
            return zColor.Black;
        }
        else if (this.color==Color.YELLOW) {
            return zColor.Yellow;
        }
        else if (this.color==Color.red) {
            return zColor.Red;
        }
        else {
            return zColor.Blue;
        }
    }

    public int GetX1(){
        return this.x1;
    }

    public int GetY1(){
        return this.y1;
    }

    public int GetX2(){
        return this.x2;
    }

    public int GetY2(){
        return this.y2;
    }

    public int GetThickness(){
        return this.Thickness ;
    }

    public int GetType(){
        return this.shType;
    }

    public boolean GetIsFiled(){
        return this.isfiled;
    }
    public int GetPoint(Point point[]){

        return 1;
    }

//  ----------------------------------------------> Function
    public abstract void Draw(Graphics g);
    public abstract boolean Its(int x , int y);


}
