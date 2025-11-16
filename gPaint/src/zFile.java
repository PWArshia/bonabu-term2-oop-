import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class zFile {
    private String name;
    private Point pointA[],pointB[];



    public void Save(Shapes x[],int cx) throws FileNotFoundException {
       File f1=new File("C:\\Users\\arshia\\Desktop\\java t\\"+name+".txt");
       PrintWriter outfill1= new PrintWriter(f1);
       for (int i = 0; i < cx; i++) {
           if(x[i].GetType()==shapeType.Line){
               outfill1.println(x[i].GetType());
               outfill1.println(x[i].GetX1());
               outfill1.println(x[i].GetY1());
               outfill1.println(x[i].GetX2());
               outfill1.println(x[i].GetY2());
               outfill1.println(x[i].GetThickness());
               outfill1.println(x[i].GetIsFiled());
               outfill1.println(x[i].GetColor());
           }
           else if(x[i].GetType()==shapeType.Circle){
               outfill1.println(x[i].GetType());
               outfill1.println(x[i].GetX1());
               outfill1.println(x[i].GetY1());
               outfill1.println(x[i].GetX2());
               outfill1.println(x[i].GetY2());
               outfill1.println(x[i].GetThickness());
               outfill1.println(x[i].GetIsFiled());
               outfill1.println(x[i].GetColor());
           }
           else if (x[i].GetType()==shapeType.Rect) {
               outfill1.println(x[i].GetType());
               outfill1.println(x[i].GetX1());
               outfill1.println(x[i].GetY1());
               outfill1.println(x[i].GetX2());
               outfill1.println(x[i].GetY2());
               outfill1.println(x[i].GetThickness());
               outfill1.println(x[i].GetIsFiled());
               outfill1.println(x[i].GetColor());
           }
           else if (x[i].GetType()==shapeType.Spray){
               outfill1.println(x[i].GetType());
               outfill1.println(x[i].GetThickness());
               outfill1.println(x[i].GetIsFiled());
               outfill1.println(x[i].GetColor());
               outfill1.println(x[i].GetPoint(pointA));
               for (int z=0;z<x[i].GetPoint(pointA);z++ ){
                   outfill1.println(pointA[z]);
               }
           }
           else if(x[i].GetType()==shapeType.Pen){
               outfill1.println(x[i].GetType());
               outfill1.println(x[i].GetThickness());
               outfill1.println(x[i].GetIsFiled());
               outfill1.println(x[i].GetColor());
               outfill1.println(x[i].GetPoint(pointB));
               for (int z=0;z<x[i].GetPoint(pointB);z++ ){
                   outfill1.println(pointB[z]);
               }
           }
       }



    }


}
