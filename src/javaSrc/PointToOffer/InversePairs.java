package javaSrc.PointToOffer;

import javaSrc.Main;

/**
 * Created by Jim Wang on 2017/5/25.
 */
public class InversePairs {
    private int swag;
    public static void main(String[] args) {
        int [] a ={1,2,3,4,5,6,7,0};


        InversePairs in = new  InversePairs();
       int re = in.InversePairs(a);
        System.out.println(re);
    }
    /**
     *
     * 数组中的逆序对
     *
     * 题目描述
     在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     输入描述:
     题目保证输入的数组中没有的相同的数字
     数据范围：
     对于%50的数据,size<=10^4
     对于%75的数据,size<=10^5
     对于%100的数据,size<=2*10^5


     输入例子:
     1,2,3,4,5,6,7,0

     输出例子:
     7
     */

    public int InversePairs(int [] array) {
        int len = array.length;
        quick(array,0,len-1);
        return swag;
    }

    private void  quick(int [] a ,int start,int end){
        if(a==null||a.length==0||a.length==1)
            return ;
        if(start<end){
            int mid = partition(a,start,end);
            quick(a,start,mid-1);
            quick(a,mid+1,end);
        }

    }
    private int partition(int[] a ,int start,int end){

        int i =start ;
        int j =end;
        int tmp = a[i];
        while(i<j){
            while(i<j&&a[i]<=a[j])
                j--;
            a[i]= a[j];
            swag+=j-i;
            while(i<j&&a[i]<=a[j])
                i++;
            a[j]=a[i];
            swag+=j-i;

        }
        a[i]=tmp;
        return i;
    }
}
