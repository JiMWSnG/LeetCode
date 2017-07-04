
package javaSrc;/**
 * Created by MySsir on 16/4/25.
 */

//将二进制流按照协议解析成可读格式

public class ParseBits {
    //第一步先根据start field和end field还有data length判断数据内容是不是正确
    //数据内容正确再进行解析,否则将错误内容进行统计条目数
    private int id;
    private String latitude;
    private String longitude;
    private String datetime;
    private float velocity;
    private float acceleration;
    private int direction;
    private int wrongdata = 0;

    public ParseBits(String string) {
        if (verify(string)) {
            id = parseID(string.substring(24, 56));
            latitude = parseLatitude(string.substring(56, 115));
            longitude = parseLongitude(string.substring(115, 174));
            datetime = parseDatetime(string.substring(174, 214));
            velocity = parseVelocity(string.substring(214, 228));
            acceleration = parseAcceleration(string.substring(228, 246));
            direction = parseDirection(string.substring(246, 256));
        }
        else
            wrongdata++;
    }

    public int getID() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDatetime() {
        return datetime;
    }

    public float getVelocity() {
        return velocity;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public int getDirection() {
        return direction;
    }

    public int getWrongtimes() {
        return wrongdata;
    }

    //解析ID信息
    public int parseID(String str) {
        return parseInt(str);
    }

    //解析Latitude信息
    public String parseLatitude(String str) {
        final String formatString = "00000000000000000000000000000000";
        StringBuffer string = new StringBuffer();
        if (str.substring(0,1).equals("1"))
            string.append("N");
        else
            string.append("S");
        long time = 1000000000000000L;
        double result = (double)parseInt(str.substring(1, 9)) + (double)parseLong(str.substring(9)) / time;
        string.append(result);
        if (string.length() < 18)
            string.append(formatString.substring(string.length(), 18));
        return string.toString();
    }

    //解析Longitude信息
    public String parseLongitude(String str) {
        final String formatString = "00000000000000000000000000000000";
        StringBuffer string = new StringBuffer();
        if (str.substring(0,1).equals("1"))
            string.append("E");
        else
            string.append("W");
        long time = 1000000000000000L;
        double result = (double)parseInt(str.substring(1, 9)) + (double)parseLong(str.substring(9)) / time;
        string.append(result);
        if (string.length() < 18)
            string.append(formatString.substring(string.length(), 18));
        return string.toString();
    }

    //解析DateTime信息
    public String parseDatetime(String str) {
        StringBuffer string = new StringBuffer();
        string.append(parseInt(str.substring(0, 14)));
        string.append("-");
        if (parseInt(str.substring(14, 18)) < 10) {
            string.append(0);
        }
        string.append(parseInt(str.substring(14, 18)));
        string.append("-");
        if (parseInt(str.substring(18, 23)) < 10) {
            string.append(0);
        }
        string.append(parseInt(str.substring(18, 23)));
        string.append("T");
        if (parseInt(str.substring(23, 28)) < 10) {
            string.append(0);
        }
        string.append(parseInt(str.substring(23, 28)));
        string.append(":");
        if (parseInt(str.substring(28, 34)) < 10) {
            string.append(0);
        }
        string.append(parseInt(str.substring(28, 34)));
        string.append(":");
        if (parseInt(str.substring(34)) < 10) {
            string.append(0);
        }
        string.append(parseInt(str.substring(34)));
        return string.toString();
    }

    //解析Velocity信息
    public float parseVelocity(String str) {
        float result = 0;
        result = parseInt(str.substring(0, 10)) + parseInt(str.substring(10)) / (10.0f);
        return result;
    }

    //解析Acceleration信息
    public float parseAcceleration(String str) {
        float result = 0;
        result = parseInt(str.substring(1, 11)) + parseInt(str.substring(11)) / (100.0f);
        return (str.charAt(0) == '1') ? result : -result;
    }

    //解析Direction信息
    public int parseDirection(String str) {
        return parseInt(str);
    }

    //确定消息是否完整准确,根据起始字符串和数据长度确定
    public boolean verify(String str) {
        String startField = "10101010";
        String endField = "10101011";
        if (((str.substring(0, 8)).equals(startField)) &&
                (str.substring(str.length() - 8).equals(endField)) &&
                (parseInt(str.substring(8, 24)) == (str.length() / 8)))
            return true;
        else
            return false;
    }

    public int parseInt(String str) {
        int result = 0;
        int time = 1;
        char[] ch = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            result += time * (ch[i]- '0');
            time = time * 2;
        }
        return result;
    }

    public long parseLong(String str) {
        long result = 0;
        long time = 1;
        char[] ch = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            result += time * (ch[i]- '0');
            time = time * 2;
        }
        return result;
    }
}
