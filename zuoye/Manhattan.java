package zuoye;
public class Manhattan implements Metric{
    public double calculate(Pointocp p1,Pointocp p2){
        double dx=Math.abs(p1.getX()-p2.getX());
        double dy=Math.abs(p1.getY()-p2.getY());
        return dx+dy;
    }
}
