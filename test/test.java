public class test {
    public static void main(String[] args) {
        int[] m = {9, 4, 9, 5, 5};

        // 声明一个变量储存最后的结果
        int r = 0;

        for (int e : m) {
            // 通过异或的方法来找寻结果
            // 原理：相同的两个数异或会抵消
            r ^= e;
        }

        System.out.println(r);

        System.out.println(1^3);
        System.out.println(9>>1);
    }
}
