package 设计模式.策略模式.使用策略模式;

//定义具体的策略2
//微信分享
public class DealWeChat implements DealStrategy{
    @Override
    public void dealMethod(String option) {
        // ....
        System.out.println("微博分享");
    }
}
