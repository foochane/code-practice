public class test {

    public static void main(String[] args){


        char a = '中';

        for(char i = Character.MIN_VALUE; i <= 500; i++){
            System.out.print(i);
            System.out.print(" ");
        }
    }




}

class Singleton{
    private Singleton(){};

    private volatile static  Singleton instance;

    public static synchronized Singleton getInstance() {
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}


