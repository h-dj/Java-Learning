package cn.hdj.datastructure;

/**
 * @author h_dj
 * @version V1.0
 * @Title: StringReverse
 * @Package test
 * @Description: 字符串反转，递归
 * @date 2018/3/27 21:57
 */
public class StringReverse {

    public static String reverse(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);

    }

    public static void main(String[] args){
        String abcd = reverse("abcd");
        System.out.println(abcd);
    }
}
