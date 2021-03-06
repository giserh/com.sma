package com.sma.alg;

import static com.sma.annotation.Tag.Algorithm.BitManipulation;

import com.sma.annotation.Tag;

/**
 Find XOR of all numbers in a given range
 */
// http://goo.gl/2pKMjU
@Tag(algs = BitManipulation)
public class BitwiseXorOfAllNumbersInRange {

  public int getXor(int a, int b) {
    return f(a - 1) ^ f(b); // cancel numbers in 0 ~ a-1
  }
  
  // f(x) = xor(0~x)
  int f(int a) {
    if (a < 0) { return 0; }
    int[] res = {a, 1, a + 1, 0};
    return res[a % 4];
  }
}
