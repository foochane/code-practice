package B站笔试题20200813.question3;

/**
 * 找零
 * 面值为1、4、16、64的纸币
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(GetCoinCount(200));
    }

    public static int GetCoinCount (int N) {
        // write code here
        int M = 1024 - N;
        if(M <= 0) return 0;
        int count = 0;

        //大于64
        while(M >= 64){
            M -= 64;
            count++;
        }

        //大于16
        while(M >= 16){
            M -= 16;
            count++;
        }

        //大于64
        while(M >= 4){
            M -= 4;
            count++;
        }
        //大于64
        while(M >= 1){
            M -= 64;
            count++;
        }
        return count;

    }
}
