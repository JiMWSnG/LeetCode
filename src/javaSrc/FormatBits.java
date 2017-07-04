
package javaSrc;
/**
 * Created by MySsir on 16/4/25.
 */
//将txt文本消息编码成符合协议消息的二进制流

public class FormatBits {

    private String startfield = "10101010";
    private String datalength;
    private String id;
    private String latitude;
    private String longitude;
    private String datetime;
    private String velocity;
    private String acceleration;
    private String direction;
    private String endfield = "10101011";
    private StringBuffer stringBuffer = new StringBuffer();;

    public FormatBits(String string) {
        String[] str = string.split(" ");
        id = formatID(Integer.parseInt(str[0]));
        latitude = formatPosition(Double.parseDouble(str[1]));
        longitude = formatPosition(Double.parseDouble(str[2]));
        datetime = formatDatetime(str[3]);
        velocity = formatVelocity(Float.parseFloat(str[4]));
        acceleration = formatAcceleration(Float.parseFloat(str[5]));
        direction = formatDiretion(Integer.parseInt(str[6]));
        stringBuffer.append(startfield);
        stringBuffer.append(id);
        stringBuffer.append(latitude);
        stringBuffer.append(longitude);
        stringBuffer.append(datetime);
        stringBuffer.append(velocity);
        stringBuffer.append(acceleration);
        stringBuffer.append(direction);
        stringBuffer.append(endfield);
        datalength = formatDataLength((stringBuffer.length() + 16) / 8);
        stringBuffer.insert(8, datalength);
    }

    public String getVelocity() {
        return velocity;
    }

    public String getBits() {
        return stringBuffer.toString();
    }

    //将ID按照协议位数进行标准化
    public String formatID(int id) {
        return formatInt(Integer.toBinaryString(id), 32);
    }

    //将data length按照协议位数进行标准化
    public String formatDataLength(int datalength) {
        return formatInt(Integer.toBinaryString(datalength), 16);
    }

    //将Latitude&Longitude按照协议位数进行标准化
    public String formatPosition(double value) {
        //System.out.println(value);
        int zs = (int)value;
        //System.out.println(zs);
        final long time = 1000000000000000L;
        long demical = (long)((value - (double)zs) * time);
        //System.out.println(demical);
        StringBuffer string = new StringBuffer();
        //随机产生一个经纬度方向:1->N|E; 0->S|W
        string.append((Math.random() >= 0.5) ? "1" : "0");
        //纬度标准化处理
        string.append(formatInt(Integer.toBinaryString(zs), 8));
        string.append(formatInt(Long.toBinaryString(demical), 50));//这里有问题
        return string.toString();

    }

    //将Datetime按照协议位数进行标准化
    public String formatDatetime(String str) {
        StringBuffer string = new StringBuffer();
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(0, 4))), 14));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(5, 7))), 4));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(8, 10))), 5));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(11, 13))), 5));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(14, 16))), 6));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(17))), 6));
        return string.toString();
    }

    //将Velocity按照协议位数进行标准化
    public String formatVelocity(float velocity) {
        StringBuffer string = new StringBuffer();
        int zs = (int)velocity;
        //float i = velocity - (float)zs;
        int demical = (int)((velocity - (float)zs ) * 10);
        //System.out.println( i + " " + demical);
        string.append(formatInt(Integer.toBinaryString(zs), 10));
        string.append(formatInt(Integer.toBinaryString(demical), 4));
        //System.out.println(string.toString());
        return  string.toString();
    }

    //将Acceleration按照协议位数进行标准化
    public String formatAcceleration(float acceleration) {
        StringBuffer string = new StringBuffer();
        int zs = (int)acceleration;
        int demical = (int)((acceleration - (float)zs ) * 100);
        //随机产生一个加速度方向:1->为正方向; 0->负方向
        string.append((Math.random() >= 0.5) ? "1" : "0");
        string.append(formatInt(Integer.toBinaryString(zs), 10));
        string.append(formatInt(Integer.toBinaryString(demical), 7));
        return  string.toString();
    }

    //将Direction按照协议位数进行标准化
    public String formatDiretion(int direction) {
        return formatInt(Integer.toBinaryString(direction), 10);
    }

    //将整数按照bit位数进行补零处理
    public String formatInt(String str, int numberOfBits) {
        String string = "0000000000000000000000000000000000000000000000000000000000000000";
        StringBuffer formatint = new StringBuffer();
        if (str.length() < numberOfBits) {
            formatint.append(string.substring(str.length(), numberOfBits));
            formatint.append(str);
        }
        //else这里有一点问题
        else
            formatint.append(str.substring(0, str.length()));
        return formatint.toString();
    }
}


/*
public class FormatBits {
    public static void main(String[] args) {
        StringBuffer string = new StringBuffer();
        string.append("10101010");
        string.append(formatInt(Integer.toBinaryString(33), 16));
        string.append(formatID(100));
        string.append(formatPosition(43.5032));
        string.append(formatPosition(30.87616));
        string.append(formatDatetime("2013-04-05T13:12:50"));
        string.append(formatVelocity(60.6f));
        string.append(formatAcceleration(20.45f));
        string.append(formatDiretion(90));
        string.append("10101011");
        System.out.println(string.toString());
        System.out.println(string.length());
    }

    //将ID按照协议位数进行标准化
    public static String formatID(int id) {
        return formatInt(Integer.toBinaryString(id), 32);
    }

    //将Latitude&Longitude按照协议位数进行标准化
    public static String formatPosition(double value) {
        //System.out.println(value);
        int zs = (int)value;
        //System.out.println(zs);
        final long time = 1000000000000000L;
        long demical = (long)((value - (double)zs) * time);
        //System.out.println(demical);
        StringBuffer string = new StringBuffer();
        //随机产生一个经纬度方向:1->N|E; 0->S|W
        string.append((Math.random() >= 0.5) ? "1" : "0");
        //纬度标准化处理
        string.append(formatInt(Integer.toBinaryString(zs), 8));
        string.append(formatInt(Long.toBinaryString(demical), 50));//这里有问题
        return string.toString();

    }

    //将Datetime按照协议位数进行标准化
    public static String formatDatetime(String str) {
        StringBuffer string = new StringBuffer();
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(0, 4))), 14));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(5, 7))), 4));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(8, 10))), 5));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(11, 13))), 5));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(14, 16))), 6));
        string.append(formatInt(Integer.toBinaryString(Integer.parseInt(str.substring(17))), 6));
        return string.toString();
    }

    //将Velocity按照协议位数进行标准化
    public static String formatVelocity(float velocity) {
        StringBuffer string = new StringBuffer();
        int zs = (int)velocity;
        int demical = (int)((velocity - (float)zs) * 10);
        string.append(formatInt(Integer.toBinaryString(zs), 10));
        string.append(formatInt(Integer.toBinaryString(demical), 4));
        System.out.println(string.toString());
        return  string.toString();
    }

    //将Acceleration按照协议位数进行标准化
    public static String formatAcceleration(float acceleration) {
        StringBuffer string = new StringBuffer();
        int zs = (int)acceleration;
        int demical = (int)((acceleration - (float)zs) * 100);
        //随机产生一个加速度方向:1->为正方向; 0->负方向
        string.append((Math.random() >= 0.5) ? "1" : "0");
        string.append(formatInt(Integer.toBinaryString(zs), 10));
        string.append(formatInt(Integer.toBinaryString(demical), 7));
        return  string.toString();
    }

    //将Direction按照协议位数进行标准化
    public static String formatDiretion(int direction) {
        return formatInt(Integer.toBinaryString(direction), 10);
    }

    //将整数按照bit位数进行补零处理
    public static String formatInt(String str, int numberOfBits) {
        String string = "0000000000000000000000000000000000000000000000000000000000000000";
        StringBuffer formatint = new StringBuffer();
        if (str.length() < numberOfBits) {
            formatint.append(string.substring(str.length(), numberOfBits));
            formatint.append(str);
        }
        //else这里有一点问题
        else
            formatint.append(str.substring(0, str.length()));
        return formatint.toString();
    }
}
*/