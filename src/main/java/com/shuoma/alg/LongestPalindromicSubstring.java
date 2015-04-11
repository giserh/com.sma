package com.shuoma.alg;

import static com.shuoma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.shuoma.annotation.Tag.DataStructure.String;
import static com.shuoma.annotation.Tag.Difficulty.D3;
import static com.shuoma.annotation.Tag.Source.LeetCode;

import com.shuoma.annotation.Tag;

@Tag(algs = DynamicProgramming, dl = D3, dss = String, source = LeetCode)
public class LongestPalindromicSubstring {

  //second pass
  public String longestPalindrome(String s) {
    int n = s.length();
    if (n == 0)
      return null;
    int[] idx = {0, 1};
    boolean[][] isPalindrome = new boolean[n + 1][];
    for (int i = 0; i < n; i++) {
      isPalindrome[i] = new boolean[n + 1];
      isPalindrome[i][i + 1] = true;
    }
    for (int len = 2; len <= n; len++) {
      for (int l = 0; l <= n - len; l++) {
        if ((len == 2 || isPalindrome[l + 1][l + len - 1]) && s.charAt(l) == s
            .charAt(l + len - 1)) {
          isPalindrome[l][l + len] = true;
          idx[0] = l;
          idx[1] = l + len;
        }
      }
    }
    return s.substring(idx[0], idx[1]);
  }

  //first pass
  public String longestPalindromeFirstPass(String s) {
    int i, j;
    int sLen = s.length();
    boolean[][] dp = new boolean[sLen][sLen];
    for (i = 0; i < sLen; i++)
      for (j = 0; j < sLen; j++)
        dp[i][j] = false;

    int maxLen = 0, len = 0, sIdx = 0, eIdx = 0, rsIdx = 0, reIdx = 0;
    for (len = 1; len <= sLen; len++)
      for (sIdx = 0; sIdx <= sLen - len; sIdx++) {
        eIdx = sIdx + len - 1;
        if (sLen == 1 || (s.charAt(sIdx) == s.charAt(eIdx) && (!(sIdx + 1 <= eIdx - 1
            && dp[sIdx + 1][eIdx - 1] == false)))) {
          dp[sIdx][eIdx] = true;
          if (len > maxLen) {
            rsIdx = sIdx;
            reIdx = eIdx;
          }
        }
      }
    return s.substring(rsIdx, reIdx + 1);

  }
}