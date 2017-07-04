package javaSrc;

/**
 * Created by Jim Wang on 2017/3/14.
 */
public class erchashu {
    public static  int findLeaves(int v[],int root){
        int result =0;
        if(v[root] == -1){
            return 0;
        }
        if(v[2*root]==-1&&v[2*root+1]==-1){
            result+=v[root];
        }
        if(v[2*root]!=-1){
            findLeaves(v,2*root);
        }
        if(v[2*root+1]!=-1){
            findLeaves(v,2*root+1);
        }
        return result;


    }
    public static int resolve(int[] A) {
        if(A==null ||A.length==0)
            return -1;
        int [] b = new int[A.length];
        int [] s = new int[A.length];
        int [] g = new int[A.length];
        int [] v  = new int [16];
        for(int i = 0;i<16;i++){
            v[i] =-1;
        }
        for(int i= 0 ;i<A.length;i++){
            b [i ] = A[i]/100;
            s [i ] = A[i]/10;
            g [i ] = A[i]%10;
            int j = (int)Math.pow(2,b[i]-1)+s[i]-1;
            v[j] = g[i];
        }
        return findLeaves(v,1);

}
}

