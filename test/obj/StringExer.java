package obj;

public class StringExer {
    String str = "aaa";
    int a = 1;
    char[] chars = {'a','a','a'};

    public void change(String str, int a, char[] chars){
        str = "bbb";
        a = 2;
        chars[0] = 'b';
    }

    public static void main(String[] args) {
        StringExer ex = new StringExer();
        ex.change(ex.str,ex.a,ex.chars);
        System.out.println(ex.str);
        System.out.println(ex.a);
        System.out.println(ex.chars);
    }
}
