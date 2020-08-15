package B站笔试题20200813.question1;


/**
 * 给出4个1—10的数字，通过加减乘除，得到数字24
 * 示例：
 * 输入 7,2，1,10
 * 输出 true
 * 说明：7*2+1*10
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 10};
        System.out.println(Game24Points(arr));

    }

    public static boolean Game24Points (int[] arr) {
        // write code here
        return recur(arr, new boolean[4], 0.0);
    }

    public static boolean recur(int[] arr, boolean[] visited, double result ){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                visited[i] = true;
                if(recur(arr, visited, result + arr[i]) ||
                        recur(arr, visited, result - arr[i]) ||
                        recur(arr, visited, result * arr[i]) ||
                        recur(arr, visited, result / arr[i])) return true;

                visited[i] = false;
            }
        }
        return 24 == result;
    }



}
