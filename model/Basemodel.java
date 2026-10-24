package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public abstract class Basemodel {
    protected int k;
    protected int maxIterations;
    protected List<double[]> dataPoints;
    protected double[][] centroids;
    public Basemodel(int k,int maxIterations){
        if(k<=0){
            throw new IllegalArgumentException("簇数量k必须大于0");
        }
        if(maxIterations<=0){
            throw new IllegalArgumentException("最大迭代次数必须大于0");
        }
        this.k=k;
        this.maxIterations=maxIterations;
        this.dataPoints=new ArrayList<>();
    }
    public void loadData(List<double[]> points){
        if (points==null) {
            throw new IllegalArgumentException("数据集不能为null");
        }
        this.dataPoints=new ArrayList<>(points);
        System.out.println("成功加载"+dataPoints.size()+"个数据点。");
    }
    protected abstract double computeDistance(double[] p1,double[] p2);
    public abstract void fit();
    public double[][] getCentroids(){
        if(centroids==null){
            return null;
        }
        return Arrays.stream(centroids)
                .map(double[]::clone)
                .toArray(double[][]::new);
    }
}
