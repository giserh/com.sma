package com.shuoma.alg;

import static com.shuoma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.shuoma.annotation.Tag.DataStructure.Array;
import static com.shuoma.annotation.Tag.Difficulty.D3;
import static com.shuoma.annotation.Tag.Reference.LeetCode;

import com.shuoma.annotation.Tag;

@Tag(algs = DynamicProgramming, dl = D3, dss = Array, references = LeetCode)
public class DecodeWays {

  public int numDecodings(String s) {
    if (s == null || s.length() == 0)
      return 0;

    int len = s.length();
    int[] dp = new int[len + 1];

    dp[0] = 1;
    for (int i = 1; i <= len; i++) {
      // depends on current char is 0, it may equals to zero or dp[i-1]
      dp[i] += s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
      if (i > 1) {
        int code = Integer.parseInt(s.substring(i - 2, i));
        if (code >= 10 && code <= 26) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[len];
  }
}
