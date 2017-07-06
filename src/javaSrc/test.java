package javaSrc;

import java.security.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


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

	public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     System.out.println("请输入你的姓名：");
     String name = sc.nextLine();
		System.out.println("请输入你的年龄：");
		int age = sc.nextInt();

		System.out.println("请输入你的工资：");

		float salary = sc.nextFloat();

		System.out.println("你的信息如下：");

		System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);

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
