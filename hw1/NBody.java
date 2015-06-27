import java.io.*;


public class NBody{
 
  //double dt;
  //String filename;
  
 // public In(string s){}
  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];

    In in =new In(filename);
    int n=in.readInt();
    double radius=in.readDouble();
    StdDraw.setScale(-radius,radius);
    
    int i;

    Planet[] planets=new Planet[n];
    for( i=0; i<n; i++){
        planets[i]=getPlanet(in);
        planets[i].draw();
    }

    double t=0;
    while(t<T){
        StdDraw.picture(0.0,0.0,"images/starfield.jpg");
        for(i=0; i<n;i++){
                planets[i].setNetForce(planets);
                planets[i].update(dt);
                planets[i].draw();
        }
        StdDraw.show(10);
        t += dt;
    }


  }

  public static Planet getPlanet(In i){
        double x=i.readDouble();
        double y=i.readDouble();
        double vx=i.readDouble();
        double vy=i.readDouble();
        double m=i.readDouble();
        String imagin=i.readString();
        Planet newplanet= new Planet(x,y,vx,vy,m,imagin);
        return newplanet;
  }
  
}