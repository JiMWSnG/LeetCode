package javaSrc;

import java.security.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;


public class test {
	public int GetHashCode(String str) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		char[] s = str.toCharArray();
		int hash = 0;
		for (int i = 0; i < s.length; i++) {
			hash = s[i] + (31 * hash);
		}
		long end = System.currentTimeMillis();
		System.out.println("cost:  " + end);
		return hash;
	}

	public int GetHashCode1(String str) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		char[] s = str.toCharArray();
		int hash = 0;
		int L = s.length;
		for (int i = 0; i < L; i++) {
			hash += s[i] * (int) Math.pow(31, L - 1 - i);
		}
		long end = System.currentTimeMillis();
		System.out.println("1cost:  " + end);
		return hash;
	}
	public  static int f(int n ){
	    int result = 0;
	    if(n<3){
	        return 0;
        }
        for (int i =n-1;i>1;i--){
            if(i>n/2)
                result += n-i;
            if(i>=2&&i<=n/2){
                if(n%2==0){
                    int tmp = n-i-n/2+1;
                    result +=n-i-tmp;
                }else{
                    int tmp = n-i-n/2;
                    result +=n-i-tmp;
                }

            }
        }
        return result;

    }

	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));


	   /* Map<String ,Integer> result = new HashMap<>();
        int[] a = {1,2,2,3};
        int i =0 ;
        int n =a.length;
		while(i<n){
            int j =i+1;
            while(j<n&&a[j]==a[i]){
                j++;
            }
            result.put(String.valueOf(a[i]),j-i);
            System.out.println(a[i]+"("+(j-i)+")");
            i=j;


        }*/



	}

	
	
	public static int minRunLength(int n) {
		System.out.print(n+"  ");
		assert (n >= 0) : "cuowu";
		//System.out.println("here");
		int r = 0;
		while (n >= 32) {
			r |= (n & 1);
			n >>= 1;

		}
		return n + r;
	}
}
