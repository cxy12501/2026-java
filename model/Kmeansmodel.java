package model;
public class Kmeansmodel extends Basemodel{
    private int[] assignment;
    public Kmeansmodel(int k,int maxIterations){
        super(k, maxIterations);
    }
    protected double computeDistance(double[] p1,double[] p2){
        double sum=0;
        for(int i=0;i<p1.length;i++){
            double diff=p1[1]-p2[i];
            sum+=diff*diff;
        }
        return Math.sqrt(sum);
    }
    public void fit(){
        if(dataPoints.isEmpty()){
            System.out.println("未加载数据,无法训练模型!");
            return ;
        }
        if(k>dataPoints.size()){
            throw new IllegalArgumentException("k不能大于样本点数量");
        }
        System.out.println("正在运行K-Means聚类,K="+k+"...");
        int dim=dataPoints.get(0).length;
        centroids=new double[k][dim];
        for(int i=0;i<k;i++){
            centroids[i]=dataPoints.get(i).clone();
        }
        assignment=new int[dataPoints.size()];
        for(int iter=0;iter<maxIterations;iter++){
            boolean changed=false;
            for(int i=0;i<dataPoints.size();i++){
                double[] point=dataPoints.get(i);
                double minD=computeDistance(point, centroids[0]);
                int best=0;
                for(int c=1;c<k;c++){
                    double d=computeDistance(point, centroids[c]);
                    if(d<minD){
                        minD=d;
                        best=c;
                    }
                }
                if(assignment[i]!=best){
                    assignment[i]=best;
                    changed=true;
                }
                if(!changed){
                    System.out.println("迭代提前收敛,第"+iter+"轮结束");
                    break;
                }
                int[] cnt =new int[k];
                double[][] sum=new double[k][dim];
                for(int j=0;j<dataPoints.size();j++){
                    int c=assignment[j];
                    cnt[c]++;
                    double[] p=dataPoints.get(j);
                    for(int d=0;d<dim;d++){
                        sum[c][d]+=p[d];
                    }
                }
                for(int c=0;c<k;c++){
                    if(cnt[c]==0) continue;
                    for(int d=0;d<dim;d++){
                        centroids[c][d]=sum[c][d]/cnt[c];
                    }
                }
            }
            System.out.println("K-Means聚类完成!");
        }
    }
}