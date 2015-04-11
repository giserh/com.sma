package com.shuoma.alg;

import static com.shuoma.annotation.Tag.Algorithm.RegularExpression;
import static com.shuoma.annotation.Tag.DataStructure.String;
import static com.shuoma.annotation.Tag.Source.LeetCode;

import com.shuoma.annotation.Tag;

@Tag(algs = RegularExpression, dss = String, source = LeetCode)
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null)
      return false;
    if (s.length() == 0)
      return true;
    //catch how to use regex and string is immutatble
    s = s.replaceAll("[[^\\d]&&[^a-zA-Z]]", "");
    int i = 0, j = s.length() - 1;
    s = s.toLowerCase();
    while (i < j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }
}