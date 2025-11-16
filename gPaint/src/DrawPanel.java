import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;

public class DrawPanel extends JComponent  implements MouseMotionListener , MouseListener {

    private Shapes shapes[]=new Shapes[1000];
    private int cshapes=0;
    private int x,y;
    private int cPoly;
    private Point Poly[],Mn[]=new Point[3];
    private int c=0;
    private String s;

    private int color = zColor.Black;
    private int shType=1;
    private int Thickness=1;
    private boolean isField=false;



    public DrawPanel() {
        super();
        setPreferredSize(new Dimension(Main.Mwith, Main.Mheight-50));
        this.setLayout(new FlowLayout());
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        for(int i=0;i<cshapes;i++) {
            shapes[i].Draw(g);
        }
    }

    public void setShapeType(int f){
        this.shType=f;
    }
    public void setColor(int color){
        this.color=color;
    }
    public void setThickness(int th){
        this.Thickness=th;
    }
    public void setField(boolean f){
        this.isField=f;
    }
    public void Delete(int x, int y){
        int i=0;
        while(i<cshapes){
            if(shapes[i].Its(x,y)){
                for(int j=i;j<=cshapes;j++){
                    shapes[i]=shapes[i+1];
                }
                i--;
                cshapes--;
            }
            i++;
        }
        this.repaint();

    }

    public void setPoly(int n){
        this.cPoly=n;
    }








    @Override
    public void mouseDragged(MouseEvent e) {
        if(shType==shapeType.Pen){
            shapes[cshapes].SetPoint(e.getX(),e.getY());
            shapes[cshapes].Draw(getGraphics());
        }
        if(shType==shapeType.Spray){
            shapes[cshapes].SetPoint(e.getX(),e.getY());
            shapes[cshapes].Draw(getGraphics());
        }




    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        if (shType == shapeType.Pen){
            shapes[cshapes]=new zPen(e.getX(),e.getY(),color,Thickness);
            shapes[cshapes].Draw(getGraphics());
        }
        if (shType == shapeType.Spray){
            shapes[cshapes]=new zSpray(e.getX(),e.getY(),color,Thickness);
            shapes[cshapes].Draw(getGraphics());
        }
        if(shType==shapeType.polygon){
            for(int i=0; i<cPoly;i++){
                Poly[i]=new Point(e.getX(),e.getY());
            }
            shapes[cshapes]=new zPolygon(Poly,cPoly);
            shapes[cshapes].Draw(getGraphics());
        }
        if(shType==shapeType.Mon){

            Mn[c]=new Point(e.getX(),e.getY());
            c++;
            if(c==3){
                shapes[cshapes]=new zMon(Mn[0].x,Mn[0].y,Mn[2].x,Mn[2].y,Mn[1].x,Mn[1].y,Thickness,this.color);
                shapes[cshapes++].Draw(getGraphics());
                c=0;

            }
        }


        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (shType==shapeType.Line){
            shapes[cshapes]=new zLine(x,y,e.getX(),e.getY(),this.Thickness, this.color);
            shapes[cshapes++].Draw(getGraphics());
        }
        else if(shType==shapeType.Rect){
            shapes[cshapes]=new zRect(x, y, e.getX(), e.getY(), this.color, this.Thickness, this.isField);
            shapes[cshapes++].Draw(getGraphics());
        } else if (shType==shapeType.Circle) {
            shapes[cshapes]=new zCircle(x,y,e.getX(),e.getY(),this.Thickness,color , this.isField);
            shapes[cshapes++].Draw(getGraphics());
        }
        else if (shType==shapeType.Pen){
            shapes[cshapes].SetPoint(e.getX(),e.getY());
            shapes[cshapes++].Draw(getGraphics());
        }
        else if (shType==shapeType.Spray){
            shapes[cshapes].SetPoint(e.getX(),e.getY());
            shapes[cshapes++].Draw(getGraphics());
        }
        else if(shType==shapeType.Delete){
            Delete(e.getX(),e.getY());
        }
        if(shType==shapeType.Mon){

            Mn[c]=new Point(e.getX(),e.getY());
            c++;
            if(c==3){
                shapes[cshapes]=new zMon(Mn[0].x,Mn[0].y,Mn[2].x,Mn[2].y,Mn[1].x,Mn[1].y,Thickness,this.color);
                shapes[cshapes++].Draw(getGraphics());
                c=0;

            }
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
