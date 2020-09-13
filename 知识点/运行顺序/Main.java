package 运行顺序;

class Main{
    static class Father{
        static {
            System.out.println("Static Father");
        }

        {
            System.out.println("NON- STATIC Father");
        }

        public Father(){
            System.out.println("Construct father");
        }
    }
    static class Son extends  Father{
        static {
            System.out.println("STatci son");
        }

        {
            System.out.println("NON static son");
        }


        public Son(){
            System.out.println("constaru son");
        }
    }

    public static void main(String[] args) {
        new Son();
    }
}