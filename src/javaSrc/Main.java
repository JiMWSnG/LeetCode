package javaSrc;

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverLocalFilesystem;

import javax.print.attribute.standard.PrinterLocation;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jim Wang on 2017/3/30.
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        if(str==null||" ".equals(str)||str.length()==0){
            System.out.println(0+" "+0);
            return;
        }

        char[] chas = str.toCharArray();
        int n =chas.length;
        int [] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
        }
        long[] result = new long[2];
        result[0]=0;result[1]=1;
        //find min num to insert
        int isleft =0;
        for(int i =0;i<n;i++){
            if(chas[i]=='(')
                isleft++;
            else
                isleft--;

        }

        if(isleft<0){
            for(int i =0;i<n;i++){
                if(chas[i]=='('){
                    for(int j =i+1;j<n;j++){
                        if(chas[j]==')'&&dp[j]==0){
                            dp[i]=1;
                            dp[j]=1;
                            break;
                        }
                    }
                }
            }
        }else{
            for(int i =n-1;i>=0;i--){
                if(chas[i]==')'){
                    for(int j =i-1;j>=0;j--){
                        if(chas[j]=='('&&dp[j]==0){
                            dp[i]=1;
                            dp[j]=1;
                            break;
                        }
                    }
                }
            }
        }


        for(int i =0;i<n;i++){
            if(dp[i]==0)
                result[0]++;
        }
        for(int i =0;i<n;i++){
            if(dp[i]==0&&chas[i]==')'){
                long num =1;
                for(int j = 0;j<i;j++){
                    if(chas[j]==')')
                        num++;
                }
                result[1]=(result[1]*num)%((long)Math.pow(10,9)+7);
            }
        }
        for(int i =n-1;i>=0;i--){
            if(dp[i]==0&&chas[i]=='('){
                long num =1;
                for(int j = n-1;j>i;j--){
                    if(chas[j]=='(')
                        num++;
                }
                result[1]=(result[1]*num)%((long)Math.pow(10,9)+7);
            }
        }
        System.out.println(result[0]+" "+result[1]);








    }

    public static int jiecheng(int n ){
        if(n ==1){
            return 1;
        }else{
            return n*jiecheng(n-1);
        }
    }



    public static int draw(char[] chas ,int start ){
        if(chas==null||chas .length==0||chas.length==start)
            return 0;
        if(chas[start]==']') {
            return 1;
        }else{
            int h = 1+draw(chas,start+1);

            return h;
        }
    }















    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] A = new int[size];
        boolean[] minPoint = new boolean[size];
        int[] result ={-1,-1};

        for(int i =0;i<size;i++){
            A[i]= sc.nextInt();
            minPoint[i]= false;
        }
        for(int i=1;i<size-1;i++){
            if(A[i-1]>A[i]&&A[i]<A[i+1]){
                minPoint[i]=true;
            }
        }
        minPoint[0] =true;
        minPoint[size-1] =true;
        int lastPoint=-1;
        for(int i = 0;i<size;i++){
            if(lastPoint!=-1&&minPoint[i]){
                int old = result[1]-result[0];
                int news = i-lastPoint;
                if(news>old){
                    if(A[lastPoint+1]>A[lastPoint]&&A[i-1]>A[i]){
                        result[1]= i;
                        result[0]= lastPoint;
                    }


                }
                lastPoint =i;
            }else if(lastPoint ==-1){
                lastPoint =i;
            }
        }


        System.out.println(result[0]+" "+ result[1]);

    }
*/
}

/*

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        byte[] A = new byte[n];
        byte[] B = new byte[n];
        byte[] x = new byte[q];
        byte[] y = new byte[q];
        byte [] result = new byte[q];
        for(int i =0;i<n;i++){
            A[i] = sc.nextByte();
        }
        for(int i =0;i<n;i++){
            B[i] = sc.nextByte();
        }
        for(int i =0;i<q;i++){
            x[i] = sc.nextByte();
            y[i] = sc.nextByte();
            result[i] =0;
        }

        for(int i=0;i<q;i++){
            for(int j =0;j<n;j++){
                if(A[j]>=x[i]&&B[j]>=y[i]){
                    result[i]++;
                }
            }
        }
        for(int i =0;i<q;i++){
            System.out.println(result[i]);
        }

    }
*/
