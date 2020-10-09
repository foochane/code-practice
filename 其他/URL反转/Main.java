package URL反转;

/**
 * 处理url 使 www.toutiao.cn 反转为cn.toutiao.www
 * 零移动
 */

public class Main {
    public static void main(String[] args) {
        String s = "www.toutiao.cn";
        System.out.println(move(s));
    }

    public static String move(String s){
        char[] chars = s.toCharArray();
        int first = 0, second = 0;

        int i = 0;
        //第一个“."以前的个数
        while (chars[i++] != '.') first++;

        //第二个“."以后的个数
        i = s.length() - 1;
        while (chars[i--] != '.') second++;

        for (int j = 0; j < first; j++) {
            moveToEnd(0, chars);
        }

        for (int j = 0; j < second; j++) {
            moveToStart(chars.length - 1 - first, chars);
        }

        return new String(chars);

    }

    public static void moveToEnd(int index , char[] arr){
        char temp = arr[index];
        for(int i = index; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    public static void moveToStart(int index, char[] arr){
        char temp = arr[index];
        for(int i = index; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
}

