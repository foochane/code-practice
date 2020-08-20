package 设计模式.策略模式.使用策略模式;


import java.util.ArrayList;
import java.util.List;

/**
 * 我们使用的app大多都有分享的功能，我们可以选择分享到不同的地方，比如微博、微信、QQ等等，虽然是同一个内容，
 * 但是分享到不同的平台就会有不同的处理方式，比如要跳转到不同的app或者直接复制链接等等。
 * 如果让你来实现这个功能，你会如何实现呢？
 *
 * https://mp.weixin.qq.com/s/gB1nM4q9PculNVZJr9NSHA
 */

public class Main {
    private static List<DealContext> algs = new ArrayList();
    //静态代码块,先加载所有的策略
    static {
        algs.add(new DealContext("Sina",new DealWeibo()));
        algs.add(new DealContext("WeChat",new DealWeChat()));
    }
    public static void main(String[] args) {

        String type = "WeChat";
        DealStrategy dealStrategy = null;
        for (DealContext deal : algs) {
            if (deal.options(type)) {
                dealStrategy = deal.getDeal();
                break;
            }
        }
        dealStrategy.dealMethod(type);
    }


}
