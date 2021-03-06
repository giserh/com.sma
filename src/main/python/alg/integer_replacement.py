"""
Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:
Input:
8
Output:
3
Explanation:
8 -> 4 -> 2 -> 1

Example 2:
Input:
7
Output:
4
Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
"""
from alg.label import Label
Label(Label.Math, Label.Recursion, Label.LeetCode)

class IntegerReplacement(object):
  def integerReplacement(self, n):
    cnt = 0
    while n > 1:
      if n & 1 == 0:
        n >>= 1
      else:
        if n == 3 or ((n >> 1) & 1) == 0:
          n -= 1
        else:
          n += 1

      cnt += 1
    return cnt

  def integerReplacement1(self, n):
    def integerReplacementRecursion(n):
      if n == 1: return 0
      if n & 1 == 0: return integerReplacementRecursion(n / 2) + 1
      return min(integerReplacementRecursion(n + 1), integerReplacementRecursion(n - 1)) + 1
    return integerReplacementRecursion(n)


ins = IntegerReplacement()
for x in [3, 6, 7, 100, 65535]:
  print ins.integerReplacement(x)


