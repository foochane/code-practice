package 设计模式.策略模式.例子;


/**
 * 我们使用的app大多都有分享的功能，我们可以选择分享到不同的地方，比如微博、微信、QQ等等，虽然是同一个内容，
 * 但是分享到不同的平台就会有不同的处理方式，比如要跳转到不同的app或者直接复制链接等等。
 * 如果让你来实现这个功能，你会如何实现呢？
 *
 * https://mp.weixin.qq.com/s/gB1nM4q9PculNVZJr9NSHA
 */
public class Main {

    //不使用策略模式很长的if-else或者switch case
    public void shareOptions(String option){
        if(option.equals("微博")){
            //function1();
            //...
        }else if(option.equals("微信")){
            //function2();
            //...
        }else if(option.equals("朋友圈")){
            //function3();
            //...
        }else if(option.equals("QQ")){
            //function4();
            //...
        }
    }
}
