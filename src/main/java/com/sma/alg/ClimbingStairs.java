package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.sma.annotation.Tag.DataStructure.Subarray;
import static com.sma.annotation.Tag.Reference.LeetCode;
import static com.sma.annotation.Tag.Complexity.Linear;

import com.sma.annotation.Tag;

@Tag(algs = DynamicProgramming, dss = Subarray, timecomplexity = Linear, references = LeetCode)
public class ClimbingStairs {
  //second pass
  public int climbStairs(int n) {
    int[] ways = new int[n + 1];
    ways[0] = 1;
    ways[1] = 1;

    int i = 2;
    while (i <= n) {
      ways[i] = ways[i - 2] + ways[i - 1];
      i++;
    }
    return ways[n];
  }

  //first pass
  public int climbStairsFirstPass(int n) {
    int i = 3, prev2 = 1, prev1 = 2, cur = 0;
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;
    while (i <= n) {
      cur = prev2 + prev1;
      prev2 = prev1;
      prev1 = cur;
      i++;
    }
    return cur;
  }
}
