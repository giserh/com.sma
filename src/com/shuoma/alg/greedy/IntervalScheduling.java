package com.shuoma.alg.greedy;

import com.shuoma.ds.misc.Interval;
import com.shuoma.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalScheduling {

  /**
   * @param args
   */
  public static void main(String[] args) {
    List<Interval> list = RandomUtil.genRandomListOfWeightedIntervals(10, 10, 10);
    schedule(list);

  }

  public static List<Interval> schedule(List<Interval> input) {
    List<Interval> ret = new ArrayList<>();
    int n = input.size();
    if (n < 1) return ret;
    if (n < 2) return input;
    Collections.sort(input);
    System.out.println("input: \n" + input);
    Interval prev = input.get(0);
    ret.add(prev);
    for (int i = 1; i < n; i++) {
      Interval cur = input.get(i);
      if (cur.start >= prev.end) {
        ret.add(cur);
        prev = cur;
      }
    }
    System.out.println("ret: \n" + ret);
    return ret;
  }
}
