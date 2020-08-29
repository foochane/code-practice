package 静态代理和动态代理.动态代理.使用JDK自带的Proxy;

//1 定义一个接口
interface SellPerfume{
    void sellPerfume(double price);
}

//2 实现接口，工厂
class ChanelFactory implements  SellPerfume{
    @Override
    public void sellPerfume(double price) {
        System.out.println("购买香奈儿香水，价格是：" + price + "元");
    }
}

//3 定义代理类
class SellProxy implements SellPerfume{
    private final SellPerfume sellPerfumeFactory;
    public SellProxy(SellPerfume sellPerfumeFactory){
        this.sellPerfumeFactory = sellPerfumeFactory;
    }
    @Override
    public void sellPerfume(double price) {
        doSomethingBeforeSell(); // 前置增强
        sellPerfumeFactory.sellPerfume(price);
        doSomethingAfterSell(); // 后置增强
    }
    private void doSomethingBeforeSell() {
        System.out.println("小红代理购买香水前的额外操作...");
    }
    private void doSomethingAfterSell() {
        System.out.println("小红代理购买香水后的额外操作...");
    }
}

//4 使用静态代理
public class Main {
    public static void main(String[] args) {
        ChanelFactory factory = new ChanelFactory();
        SellProxy proxy = new SellProxy(factory);
        proxy.sellPerfume(1000.0);
    }
}
