import java.util.Formatter;

public class Planet{
  public double x;
  public double y;
  public double xVelocity;
  public double yVelocity;
  public double mass;
  public String img;

  public double xNetForce;
  public double yNetForce;
  public double xAccel;
  public double yAccel;

  private double radius;
 

  public Planet(double px, double py, double vx, double vy, double m, String imagi, double radi){
       x=px;
       y=py;
       xVelocity=vx;
       yVelocity=vy;
       mass=m;
       img=imagi;
       raduis=radi;
  }

  public double getMass(){
    return mass;
  }

  public double getRaduis(){
    return raduis;
  }

  public double calcDistance(Planet pA){
    return Math.sqrt((pA.x-this.x)*(pA.x-this.x)+(pA.y-this.y)*(pA.y-this.y));
  }

  public double calcPairwiseForce(Planet pA){
        double G=6.67E-11;
        double F= G*this.mass*pA.mass/(calcDistance(pA)*calcDistance(pA));
        return F;
  }

  public double calcPairwiseForceX(Planet pA){
     return calcPairwiseForce(pA)*(pA.x-this.x)/calcDistance(pA);
  }
  
    public double calcPairwiseForceY(Planet pA){
     return calcPairwiseForce(pA)*(pA.y-this.y)/calcDistance(pA);
  }

    public void setNetForce(Planet[] p){
      this.xNetForce=0;
      this.yNetForce=0;
      
      for(int i=0; i<p.length; i++){
        if(p[i] != this){
           this.xNetForce += calcPairwiseForceX(p[i]);
           this.yNetForce += calcPairwiseForceY(p[i]);
         }
      }
    }

    public void draw(){
            StdDraw.picture(this.x,this.y,"images/"+this.img);
        }

  
    public void update(double dt){
      this.xAccel=this.xNetForce/this.mass;
      this.yAccel=this.yNetForce/this.mass;
      this.xVelocity += dt*this.xAccel;
      this.yVelocity += dt*this.yAccel;
        this.x += this.xVelocity*dt;
      this.y += this.yVelocity*dt;

    }
} 