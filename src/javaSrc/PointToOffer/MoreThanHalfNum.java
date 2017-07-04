package javaSrc.PointToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jim Wang on 2017/5/9.
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] array= {1,2,3,2,4,2,5,2,3};
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution2(array));
    }
    public int MoreThanHalfNum_Solution2(int[] array){
        if(array==null||array.length==0)
            return 0;
        int key =0;
        int value = 0;
        for(int i =0;i<array.length;i++){
            if(value==0){
                key = array[i];
                value =1;
            }else if(key==array[i])
                value++;
            else{
                value--;

            }


        }
        if(!checkMoreThanHalf(array,key)){
            return 0;
        }
        return key;


    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(!checkInputValid(array))
            return 0;
        int length = array.length;
        int mid = length>>1;
        int start = 0;
        int end = length-1;
        int index = Partition(array,end-start+1,start,end);
        while(index!=mid){

            if(index>mid){
                end = index-1;
                index =Partition(array,end-start+1,start,end);

            }else{
                start = index+1;
                index = Partition(array,end-start+1,start,end);
            }

        }
        int res = array[mid];
        if(!checkMoreThanHalf(array,res))
            return 0;
        return res;

    }

    boolean checkInputValid(int[] array){
        if(array==null||array.length==0)
            return false;
        return true;
    }
    boolean checkMoreThanHalf(int[] array ,int number){
        int times=0;
        for(int i =0;i<array.length;i++){
            if(array[i]==number)
                times++;
        }
        if(times*2<=array.length)
            return false;
        return true;
    }

    /**
     * return  选中的数字的index
     * 输入需要保证正确，内部未做输入检测；
     * @param array
     * @param length
     * @param start
     * @param end
     * @return
     */
    private int Partition(int[] array,int length,int start,int end){
        int pick = array[start];
        int j = end;
        int i = start;
        while(i<j){
            for(;j>i;j--){
                if(array[j]<pick){
                    array[i]=array[j];
                    break;
                }
            }
            for(;i<j;i++){
                if(array[i]>array[j]){
                    array[j]=array[i];
                    break;
                }
            }
        }
        if(i==j)
            array[j]=pick;
        else
            //error
        System.out.println("wrong");
        return j;
    }
}
