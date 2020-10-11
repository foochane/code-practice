package 运行顺序;

/**
 * 父类静态方法
 * 子类静态方法
 * 父类非静态方法
 * 父类构造方法
 * 子类非静态方法
 * 子类构造方法
 */
class Main{
    static class Father{
        static {
            System.out.println("父类静态方法");
        }

        {
            System.out.println("父类非静态方法");
        }

        public Father(){
            System.out.println("父类构造方法");
        }
    }
    static class Son extends  Father{
        static {
            System.out.println("子类静态方法");
        }

        {
            System.out.println("子类非静态方法");
        }


        public Son(){
            System.out.println("子类构造方法");
        }
    }

    public static void main(String[] args) {
        new Son();
    }
}