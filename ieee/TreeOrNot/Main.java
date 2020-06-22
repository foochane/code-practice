package TreeOrNot;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n,from,to;
        int level;
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        n = cin.nextInt();
        Map<Integer,Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {

            String[] split = cin.next().split(",");
            from = Integer.parseInt(split[0]);
            to = Integer.parseInt(split[1]);

            if(map.get(to) != null){
                System.out.println("Not a tree");
            }
            map.put(to,from);

            set.add(to);
            set.add(from);


        }



        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int mapKey = entry.getKey();
            int mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
            map.get(mapKey);

        }

        for(Object s : set){
            int val = (Integer)s;
            level = 0;
            while (map.get(val) != null){
                level++;
                val = map.get(val);
            }


            if(lists.get(level) == null){

            }

            lists.get(level).add((Integer)s);

        }


        for (int j =0; j < lists.size(); j++) {
            List list = lists.get(j);

            for (int i = 0; i < list.size(); i++) {

                System.out.print(list.get(i));

                if(i < list.size()-1){
                    System.out.print(",");
                }
            }

            if( j < lists.size()-1){
                System.out.print(",");
            }

        }

    }
}
