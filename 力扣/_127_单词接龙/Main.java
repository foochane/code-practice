package _127_单词接龙;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 */
public class Main {

    public static int min = Integer.MAX_VALUE;
    public static int count = 0;

    public static void main(String[] args) {
//        String beginWord = "qa";
//        String endWord =  "sq";
//        List<String>  wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
         String beginWord = "hit";
         String endWord = "cog";
         List<String>  wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
         System.out.println(ladderLength(beginWord, endWord, wordList));


    }



    //BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //组合词map, 如hot：map里存<*ot,hot> ,<h*t,hot> <ho*,hot>
        Map<String,String> combineWordMap = new HashMap<>();

        //判断word是否用过
        Map<String,Boolean> wordUsedMap = new HashMap<>();

        for (String word : wordList) {
            wordUsedMap.put(word, false);

            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                combineWordMap.put(sb.toString(), word);
            }
        }

        System.out.println(combineWordMap);
        System.out.println(wordUsedMap);

        return 0;


    }

}


