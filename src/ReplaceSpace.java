/**
 * 《剑指Offer_编程题-空格替换》
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 *
 * 20200304
 */
public class ReplaceSpace {
    //按字符遍历，会把新插入的 %20也遍历
    public static String replaceSpace1(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if(str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    //新建一个StringBuffer,当遇到 " "，就追加 "%20"，否则追加原来的字符
    public static String replaceSpace2(StringBuffer str){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < str.length(); i++){
            char c = str.charAt(i);
            if(c == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    //使用自带函数
    public static String replaceSpace3(StringBuffer str){
        return str.toString().replace(" ","%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer().append("We Are Happy");
        System.out.println(replaceSpace2(str));

    }


}
