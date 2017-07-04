package javaSrc.PointToOffer;

import sun.security.util.ByteArrayTagOrder;
import sun.security.util.Length;

/**
 * Created by Jim Wang on 2017/4/14.
 */
public class reOrderArray {
    /**
     * 调整数组顺序使奇数位于偶数前面
     *
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void main(String[] args) {

        reOrderArray reOrderArray = new reOrderArray();
        int[] array = {1,2,3,4,5,6,7,8};
        reOrderArray.reOrder(array );
        for(int i =0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    //i<j
    private void swag(int[] array , int i ,int j ){
        if(i>=j)
            return ;
        int tmp = array[i];
        array[i] = array [j];
        array[j] = tmp;
    }
    private boolean isOdd(int o){
        if((o&1)==1)
            return true;
        return false;
    }
    public void reOrder(int[] array){
        if(array==null||array.length<2)
            return;
       int lastOdd = array.length;
        int firstEven = 0;
        while(lastOdd>=firstEven){
            for(int j=1;j<array.length;j++){
               if(isOdd(array[j])&&!isOdd(array[j-1])){
                   swag(array,j-1,j);

               }
            }
            int j =0 ;
            while ( !((array[j]&1)==0))
                j++;
            firstEven=j;
            j = array.length-1;
            while((array[j]&1)==0)
                j--;
            lastOdd = j;
        }
    }
}
