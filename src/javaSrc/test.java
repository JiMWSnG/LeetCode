package javaSrc;

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

	public static String upperCaseFirst(String s){
		if (s == null || s.length() == 0){
			return s;
		}
		char[] cs = s.toCharArray();
		if (cs[0] >= 'a' && cs[0] <= 'z'){
			cs[0] -= 32;
		}
		return String.valueOf(cs);
	}

	public static  boolean isDifferent(Object a, Object b){
		return (a == null && b != null) || (a != null && !a.equals(b));
	}

	public static void main(String[] args) {
		System.out.println(Objects.equals(null,null));
		System.out.println(Objects.equals("1",null));
		System.out.println(Objects.equals(null,'1'));
		System.out.println(Objects.equals(1,'1'));
		System.out.println(Objects.equals('1','1'));

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

	public static long getMaxDay(int x, int f, int d, int p){
		if (x < 1 || f < 1 || d < 1 || p < 1){
			return 0;
		}
		long a = d + p * f;
		long b = x + p;
		return  a/b;
	}


}
