package 单词拆分;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 *
 */

import java.util.*;
public class Main{
    public static void main(String args[]) {
        String str = "leetcode";
        List<String> dic = new ArrayList<String>(Arrays.asList("leet","code")) ;


        boolean result  = wordBreak(str, dic) ;
        System.out.println(result);
    }

    public  static boolean wordBreak(String str, List<String> dic){

        int n = str.length();

        // 存str子串：[-1,0)、[0,1)、[0,2)、、、、、[0,n)是否可以拆分
        // [-1,0) 初始化为 true
        boolean[] dp = new boolean[n+1];
        dp[0] = true; //[-1,0) 初始化为true

        for(int i = 1; i <= n; i++)
            for(int j = 0; j < i; j++) {
                //[0,j) 和 [j,i)是否可以拆分
                if(dp[j] && dic.contains(str.substring(j,i))){
                    dp[i] = true;
                    break;
                };

            }
        return dp[n];

    }
}
