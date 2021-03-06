package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.DynamicProgramming;
import static com.sma.annotation.Tag.DataStructure.MatrixGraph;
import static com.sma.annotation.Tag.Reference.Interview;
import static com.sma.annotation.Tag.Complexity.Quadratic;

import com.sma.annotation.Tag;

import java.util.Arrays;
import java.util.Collections;

/**
 * A table composed of N x M cells, each having a certain quantity of apples, is given.
 * You start from the upper-left corner. At each step you can go down or right one cell.
 * Find the maximum number of apples you can collect.
 */
@Tag(algs = {DynamicProgramming}, dss = MatrixGraph, timecomplexity = Quadratic, references = Interview)
public class AwardCollection {

  public int onePerson(int[][] board) {
    int m = board.length;
    if (m == 0) {
      return 0;
    }
    int n = board[0].length;
    if (n == 0) {
      return 0;
    }

    int steps = n + m - 2;
    int[] dp = new int[m + 1];
    dp[1] = board[0][0]; // start cell

    for (int s = 1; s <= steps; s++) {
      // after s steps, s - (n - 1) + 1 <= row <= s + 1
      for (int r = Math.min(s + 1, m); r >= Math.max(1, s - n + 2); r--) {
        dp[r] = Math.max(dp[r], dp[r - 1]);
        //System.out.println(String.format("s: %d row: %d col: %d", s, r - 1, s - r + 1));
        dp[r] += board[r - 1][s - r + 1];
        if (s == steps) {
          break;
        }
      }
    }
    return dp[m];
  }

  public int twoPersons(int[][] board) {
    int m = board.length;
    if (m == 0) {
      return 0;
    }
    int n = board[0].length;
    if (n == 0) {
      return 0;
    }

    int steps = n + m - 2;
    int[][] dp = new int[m + 1][m + 1];
    dp[1][1] = board[0][0];

    for (int s = 1; s <= steps; s++) {
      for (int r1 = Math.min(s + 1, m); r1 >= Math.max(1, s - n + 2); r1--) {
        for (int r2 = Math.min(s + 1, m); r2 >= Math.max(1, s - n + 2); r2--) {

          dp[r1][r2] = Collections.max(
              Arrays.asList(dp[r1][r2], dp[r1 - 1][r2 - 1], dp[r1 - 1][r2], dp[r1][r2 - 1]));
          dp[r1][r2] += board[r1 - 1][s - r1 + 1] + (r1 == r2 ? 0 : board[r2 - 1][s - r2 + 1]);
          //System.out.println(r1 + " " + r2 + " " + dp[r1][r2] + " " + board[r1 - 1][s - r1 + 1] + " " + board[r2 - 1][s - r2 + 1]);
        }
        if (s == steps) {
          break;
        }
      }
    }
    return dp[m][m];
  }
}
