package com.shuoma.ds.geometry;

import com.google.common.base.Preconditions;

public class Rectangle {
  Point bottomRight, topLeft;

  public Rectangle(Point topLeft, Point bottomRight) {
    this.bottomRight = bottomRight;
    this.topLeft = topLeft;
  }

  public Rectangle(int[] topLeft, int[] bottomRight) {
    Preconditions.checkArgument(true, topLeft[0] <= bottomRight[0] && topLeft[1] >= bottomRight[1]);
    this.bottomRight = new Point(bottomRight[0], bottomRight[1]);
    this.topLeft = new Point(topLeft[0], topLeft[1]);
  }

  /**
   * Check if a rectangle is overlapped with another rectangle.
   */
  public boolean isOverlapped(Rectangle other) {
    return bottomRight.x >= other.topLeft.x && bottomRight.y <= other.topLeft.y
        && topLeft.x <= other.bottomRight.x && topLeft.y >= other.bottomRight.y;
  }

  @Override
  public String toString() {
    return topLeft + " ~ " + bottomRight;
  }
}