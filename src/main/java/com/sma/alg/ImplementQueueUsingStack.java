package com.sma.alg;

import com.sma.annotation.Tag;

import java.util.Stack;

import static com.sma.annotation.Tag.DataStructure.QueueT;
import static com.sma.annotation.Tag.Reference.LeetCode;

@Tag(dss = {Tag.DataStructure.StackT, QueueT}, references = LeetCode)
public class ImplementQueueUsingStack {}

class MyQueue {
  Stack<Integer> in = new Stack<>();
  Stack<Integer> out = new Stack<>();

  // Push element x to the back of queue.
  public void push(int x) {
    in.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    if (out.isEmpty()) {
      dump();
    }
    // if (out.isEmpty()) {
    //     throw new EmptyStackException();
    // }
    out.pop();
  }

  // Get the front element.
  public int peek() {
    if (out.isEmpty()) {
      dump();
    }
    // if (out.isEmpty()) {
    //     throw new EmptyStackException();
    // }
    return out.peek();
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }

  void dump() {
    while (!in.isEmpty()) {
      out.push(in.pop());
    }
  }
}
