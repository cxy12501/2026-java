public class Approximatepi{
    public static void main(String[]args){
        double finalpi1=0.0,finalpi2=0.0;
        int j=0,k=0;
        for(int i=1;i<=11;i=i+2){
           double single1=1.0/(double)i;
           single1=single1*Math.pow(-1,j);
           j++;
           finalpi1=finalpi1+single1;
        }
    
        for(int i=1;i<=13;i=i+2){
           double single2=1.0/(double)i;
           single2=single2*Math.pow(-1,k);
           k++;
           finalpi2=finalpi2+single2;
        }
    
        finalpi1=4*finalpi1;
        finalpi2=4*finalpi2;
        System.out.println(finalpi1);
        System.out.println(finalpi2);
    }
}
