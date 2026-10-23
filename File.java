import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kmeans.Cluster;
import kmeans.Point;
class PointFileReader{
    private String filePath;
    public PointFileReader(String filePath){
        this.filePath=filePath;
    }
    public List<Point> readPoints() throws FileNotFoundException{
        List<Point> points=new ArrayList<>();
        Scanner scanner=new Scanner(new File(filePath));
        while (scanner.hasNextDouble()){
            double x=scanner.nextDouble();
            double y=scanner.nextDouble();
            points.add(new Point(x,y));
        }
        scanner.close();
        return points;
    }
}


class ClusterReportWriter{
    private String outputPath;
    public ClusterReportWriter(String outputPath){
        this.outputPath=outputPath;
    }
    public void writeReport(List<Cluster> clusters) throws FileNotFoundException{
        try (PrintWriter writer=new PrintWriter(outputPath)){
            writer.println("==== K-Means 面向对象聚类分析报表 ====");
            for(Cluster cluster:clusters){
                writer.printf("族%d | 点数:%d%n",
                       cluster.getId(),
                       cluster.getPoints().size());
                writer.printf("质点:(%.3f,%.3f)%n",
                       cluster.getCentroid().getX(),
                       cluster.getCentroid().getY());
                for (Point p:cluster.getPoints()){
                    writer.println(" "+p);
                }
                writer.println();
            }
        }
    }
}
