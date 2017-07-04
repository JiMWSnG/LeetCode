package javaSrc;

/**
 * Created by Jim Wang on 2017/3/15.
 */
public class Sort {

    /**
     * 快速排序
     * @param r
     * @param i
     * @param j
     * @return
     */
    public static int[] QuickSort(int[] r,int i,int j){
        if(r==null||r.length<=0||i<0||j<0){
            return null;
        }
        if(i<j){
            int pivot = Parttion(r,i,j);
            QuickSort(r,i,pivot-1);
            QuickSort(r,pivot+1,j);
        }
        return r;


    }
    private static int Parttion(int[] r,int i,int j){
        if(r==null||r.length<=0||i<0||j<0){
            return -1;
        }
        int pivot = r[i];
        while(i<j){
            while(i<j&&pivot<r[j]){
                j--;
            }
            r[i]= r[j];
            while(i<j&&pivot>r[i]){
                i++;
            }
            r[j]=r[i];
        }
        r[i] =pivot;
        return i;
    }
}
