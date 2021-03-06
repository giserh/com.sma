from unittest import TestCase

from alg.remove_invalid_parentheses import *


class TestSolution(TestCase):
  def test_remove_invalid_parentheses(self):
    ins = Solution()
    cases = {
      '()())()': ["()()()", "(())()"],
      '(a)())()': ["(a)()()", "(a())()"],
      ")(": [""],
    }
    for case, ans in cases.items():
      self.assertEqual(set(ans), set(ins.removeInvalidParentheses(case)))
