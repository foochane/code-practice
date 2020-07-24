import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>(){{add(1); add(2);}};
        List<Integer> list1 = list;

        list1.add(2);
        System.out.println(list);
        System.out.println(list1);


    }
}


