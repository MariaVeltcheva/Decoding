//package com.company;

import java.util.*;

public class Decoding {

    public static void main(String[] args){
        Scanner s  = new Scanner(System.in);
        String str = s.nextLine();

        long result = numDecodings(str);
        System.out.println(result);
    }

    public static long numDecodings(String s) {
        if (s.charAt(0) == '0'){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        long[] dp = new long[s.length()];

        dp[0] = 1;

        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) != '0'){
                dp[i] += dp[i-1];
            }
            int val = (s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0';
            if (s.charAt(i-1) != '0' && val <= 26) {
                if(i>=2){
                    dp[i] += dp[i-2];
                }else{
                    dp[i] += 1;
                }
            }

            if (dp[i] == 0){
                return 0;
            }
        }
        return dp[s.length()-1];
    }
}
