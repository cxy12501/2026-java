package zuoye;
import java.util.ArrayList;
import java.util.List;
public class Clusterocp {
    private int id;
    private Pointocp centroid;
    private List<Pointocp> points;
    private static final double TOLERANCE=1e-4;
    public Clusterocp(int id,Pointocp initialCentroid){
        this.id=id;
        this.centroid=initialCentroid;
        points=new ArrayList<>();
    }
    public void clearPoints(){
        points.clear();
    }
    public void addPoint(Pointocp p){
        points.add(p);
    }
    public boolean updateCentroid(){
        if (points.isEmpty()){
            return false;
        }
        double sumX=0,sumY=0;
        for(Pointocp p:points){
            sumX += p.getX();
            sumY += p.getY();
        }
        double newX=sumX/points.size();
        double newY=sumY/points.size();
        Pointocp newCentroid=new Pointocp(newX, newY);
        double dx=Math.abs(newCentroid.getX()-centroid.getX());
        double dy=Math.abs(newCentroid.getY()-centroid.getY());
        if (dx<TOLERANCE && dy<TOLERANCE){
            return false;
        }
        this.centroid=newCentroid;
        return true;
    }
    public int getId(){
        return id;
    }
    public Pointocp getCentroid(){
        return centroid;
    }
    public List<Pointocp> getPoints(){
        return points;
    }
}
