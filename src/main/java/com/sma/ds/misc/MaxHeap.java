package com.sma.ds.misc;

import java.util.Arrays;

public class MaxHeap {
  int[] data;
  int size;

  public MaxHeap(int[] a) {
    data = a;
    size = a.length;

    // build heap
    int n = a.length;
    for (int i = n / 2; i >= 0; i--) {
      heapify(i);
    }
  }

  public int top() {
    if (data.length > 0)
      return data[0];
    else
      return -1;
  }

  public void heapify(int i) {
    heapify(i, size);
  }

  public int removeTop() {
    int ret = data[0];
    data[0] = 0; // set this element to zero
    size--;
    heapify(0, size);
    return ret;
  }

  public void heapify(int i, int end) {
    int left = 2 * i + 1, right = left + 1;
    int largest = i;
    if (left < end && data[left] > data[i]) largest = left;
    if (right < end && data[right] > data[largest]) largest = right;

    if (largest != i) {
      int temp = data[i];
      data[i] = data[largest];
      data[largest] = temp;
      heapify(largest, end);
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(data);
  }
}
