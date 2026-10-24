package zuoye;
public class Euclidean implements Metric{
    public double calculate(Pointocp p1,Pointocp p2){
        double dx=p1.getX()-p2.getX();
        double dy=p1.getY()-p2.getY();
        return Math.sqrt(dx*dx+dy*dy);
    }
}
