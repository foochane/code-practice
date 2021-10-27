package StringUtils.isEmpty和StringUtils.isBlank的区别;


import org.apache.commons.lang3.StringUtils;

/**
 * Main
 *
 * @author chanefu
 * @date 2021/10/27
 */
public class Main {


    public static void main(String[] args) {
        System.out.println("StringUtils.isEmpty(null):" + StringUtils.isEmpty(null));
        System.out.println("StringUtils.isEmpty(\"\"):" + StringUtils.isEmpty(""));
        System.out.println("StringUtils.isEmpty(\" \"):" + StringUtils.isEmpty(" "));
        System.out.println("StringUtils.isEmpty(\"\\n\"):" + StringUtils.isEmpty("\n"));
        System.out.println("StringUtils.isEmpty(\"\\t\"):" + StringUtils.isEmpty("\t"));

        System.out.println();

        System.out.println("StringUtils.isBlank(null):" + StringUtils.isBlank(null));
        System.out.println("StringUtils.isBlank(\"\"):" + StringUtils.isBlank(""));
        System.out.println("StringUtils.isBlank(\" \"):" + StringUtils.isBlank(" "));
        System.out.println("StringUtils.isBlank(\"\\n\"):" + StringUtils.isBlank("\n"));
        System.out.println("StringUtils.isBlank(\"\\t\"):" + StringUtils.isBlank("\t"));
    }

}
