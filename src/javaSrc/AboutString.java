package javaSrc;

/**
 * Created by Jim Wang on 2017/3/24.
 */
public class AboutString {
    public String replaceSpace(StringBuffer str) {
        if(str==null||str.length()==0)
            return str.toString();
        int length = str.length();
        int num =0;

        for(int i= 0;i<length ;i++){
            if(' '==str.charAt(i)){
                num++;
            }
        }
        int newLength = length+2*num;
        char[] chars =new char[newLength];
        str.getChars(0,length,chars,0);
        for(int i = length-1,j= newLength-1;i>=0;i--){
            if(chars[i]==' '){
                chars[j]='0';
                chars[j-1]='2';
                chars[j-2]='%';
                j-=2;

            }else{
                chars[j--]=chars[i];
            }
        }
        return new String(chars).trim();

    }
}
