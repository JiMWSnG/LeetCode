package javaSrc;

/**
 * Created by Jim Wang on 2017/3/7.
 */
public class StringRotate {

    public String rotateString(String A, int n, int p) {
       if(p>n){
           //error
       }
       if(n==0){
           return A;
       }
        StringBuilder string = new StringBuilder();
        string.append( A.substring(p+1));
        string.append(A.substring(0,p+1));
        return string.toString();
    }

    public static void main(String[] args) {
        String s ="abcdefgh";
        StringRotate stringRotate = new StringRotate();
        String result = stringRotate.rotateString(s,s.length(),4);
        System.out.println(result);
    }
}
