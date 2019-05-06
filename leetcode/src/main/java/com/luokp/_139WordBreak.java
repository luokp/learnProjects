package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/4/29 23:04
 * @description:
 */
public class _139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int hit = 0;
        return wordBreakC(s, wordDict, 0);
    }

    private static boolean wordBreakC(String s, List<String> wordDict, int hit) {
        if((s == null || s.length() ==0)) {
            return true;
        }
        for(String word : wordDict) {
            int index = s.indexOf(word);
            if(index != -1) {
                // String str = s.substring(0, index) +
                //     ((index + word.length() == s.length()) ? "" : s.substring(index + word.length(), s.length()));
                if(wordBreakC(s.substring(0, index), wordDict, hit + 1) &&
                        wordBreakC((index + word.length() == s.length()) ? "" : s.substring(index + word.length(), s.length()), wordDict, hit + 1)) {
                    return true;
                };
            }
        }
        return false;
    }

    public static boolean wordBreakdp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        String s = "catsanddog";
        System.out.println(wordBreakII(s, list));
    }



    public static List<String> wordBreakII(String s, List<String> wordDict) {
        //TLE
//        List<String> result = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        wordBreakCoreII(s, 0, wordDict, result, sb);
//        return result;

        //剪枝
        Map<String, List<String>> map = new HashMap<>();
        List<String> res =  DFSPrune(s, wordDict, map);
        return res ;

    }
//TLE
    private static void wordBreakCoreII(String s, int start, List<String> wordDict, List<String> list, StringBuilder sb) {
        if(start == s.length()) {
            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());
            sb.append(" ");
            return;
        }
        for(int i = start+1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            int len = i - start;
            if(wordDict.contains(word)) {
                sb.append(word).append(" ");
                wordBreakCoreII(s, i, wordDict, list, sb);
                sb.delete(sb.length() - len - 1, sb.length());
            }
        }
    }

    // 剪枝
    private static List<String> DFSPrune(String s, List<String> wordDict, Map<String, List<String>> map) {

        if(map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<>();
        if("".equals(s)) {
            list.add("");
            return list;
        }
        for(String word:wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = DFSPrune(s.substring(word.length()), wordDict, map);

                for(String sentance : subList) {
                    list.add(word + (sentance.isEmpty()? "":" ") + sentance);
                }
            }
        }
        map.put(s, list);
        return list;
    }
}
