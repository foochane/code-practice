package Collection;

import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        HashMap hashMap = new HashMap();
        hashMap.put("xxx",1);

        Man m = new Man(1, "XX");
        m.speek(1);

        Byte[] a = new Byte[2];

        BitSet bitSet = new BitSet();



    }
}

class Person{
    int id;
    String name;

    Person(int id){
        this.id = id;
    }

    Person(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void speek(int id){
        System.out.println(id);
    }

    public void speek(int id,String name){
        System.out.println(id + name);
    }

    public String speek(int id,String name,String age){
        System.out.println("xxxxxxxxxxxxx");
        return "xx";
    }
}

class Man extends Person{

    Man(int id) {
        super(id);
    }

    Man(int id, String name) {
        super(id, name);
    }

    @Override
    public void speek(int id){
        System.out.println("man" +id);
    }
}
