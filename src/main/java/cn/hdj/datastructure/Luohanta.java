package cn.hdj.datastructure;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Luohanta
 * @Package cn.hdj.datastructure
 * @Description: 罗汉塔问题
 * @date 2018/3/28 15:51
 */
public class Luohanta {

    private static int count;

    public static void move(int num, char A, char B, char C) {
        count++;
        if (num == 1) {
            System.out.println("move" + A + "-->" + C);
        } else {
            move(num - 1, A, C, B);
            move(1, A, B, C);
            move(num - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        //// TODO: 2018/3/28
        move(4, 'A', 'B', 'C');
        System.out.println(count);
    }
}
