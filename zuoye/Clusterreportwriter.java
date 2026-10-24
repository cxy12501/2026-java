package zuoye;
import java.io.PrintWriter;
import java.util.List;
public class Clusterreportwriter {
    public static void writeReport(List<Clusterocp> clusters,String outputPath) throws Exception{
        PrintWriter pw=new PrintWriter(outputPath);
        for(Clusterocp c:clusters){
            pw.printf("簇%d 质点:%s%n",c.getId(),c.getCentroid());
            for(Pointocp p:c.getPoints()){
                pw.println(" ->"+p);
            }
        }
        pw.close();
    }
}
