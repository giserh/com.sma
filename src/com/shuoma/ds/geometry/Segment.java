package com.shuoma.ds.geometry;


public class Segment {

  public static void main(String[] args) throws Exception{
    testGetDistance();
    //testGetOrientation();
    //testIsIntersect();
  }

  public static void testGetDistance() throws Exception {
    Segment seg = new Segment(new Point(1, 1), new Point(1, -1));
    System.out.println(seg.getDistance(new Point(2, 2)));
  }

  public static void testGetOrientation() throws Exception {
    Segment seg = new Segment(new Point(1, 1), new Point(1, -1));
    System.out.println(seg.getOrientation(new Point(0, 0)));
    System.out.println(seg.getOrientation(new Point(2, 0)));
    System.out.println(seg.getOrientation(new Point(2, 0)));
  }

  public static void testIsIntersect() throws Exception {
    Segment seg1 = new Segment(new Point(0, 0), new Point(2, 0));
    Segment seg2 = new Segment(new Point(1, 1), new Point(1, -1));
    Segment seg3 = new Segment(new Point(3, 0), new Point(7, 0));
    System.out.println(seg1.isIntersect(seg2));
    System.out.println(seg1.isIntersect(seg3));
  }

  public enum Orientation {
    CLOCKWISE("CLOCKWISE"), COUNTERCLOCKWISE("COUNTERCLOCKWISE"), COLLINEAR("COLLINEAR");

    String orientation;

    Orientation(String orientation) {
      this.orientation = orientation;
    }

    @Override
    public String toString() {
      return orientation;
    }
  }

  Point s, e;

  public Segment(Point start, Point end) throws Exception {
    if (!start.equals(end)) {
      this.s = start;
      this.e = end;
    } else {
      throw new Exception();
    }
  }


  // http://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment
  // http://geomalgorithms.com/a02-_lines.html
  public double getDistance(Point p) {
    double l2 = Math.pow(length(), 2);  // i.e. |s-e|^2 -  avoid a sqrt
    if (l2 == 0.0) return Point.distance(s, p);   // s == e case

    // Consider the line extending the segment, parameterized as s + t (e - s).
    // We find projection of point p onto the line.
    // It falls where t = [(p-s) . (e-s)] / l2
    double tVector = Point.dot(Point.minus(p, s), Point.minus(e, s)) / l2;
    System.out.println("t = " + tVector);
    if (tVector < 0.0) return Point.distance(p, s);       // Beyond the 'v' end of the segment
    else if (tVector > 1.0) return Point.distance(p, e);  // Beyond the 'w' end of the segment
    Point projection = Point.add(s, Point.multiply(tVector, Point.minus(e, s)));  // Projection falls on the segment
    return Point.distance(p, projection);
  }

  /** Different from slope comparison. **/
  // // http://www.dcs.gla.ac.uk/~pat/52233/slides/Geometry1x1.pdf
  // http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect
  public Orientation getOrientation (Point p) {
    double res = (e.y - s.y) * (p.x - e.x) - (e.x - s.x) * (p.y - e.y);
    if (res == 0) return Orientation.COLLINEAR;
    else return res > 0 ? Orientation.CLOCKWISE : Orientation.COUNTERCLOCKWISE;
  }

  public double getSlope() {
    return (s.x == s.y) ? Double.MAX_VALUE : (s.y - e.y) / (s.x - e.x);
  }

  /**
   * AB intersects CD if ABC has different orientation from ABD, and CDA has different orientation
   * from CDB
   * @throws Exception
   */
  public boolean isIntersect(Segment seg) {
    Orientation o1 = getOrientation(seg.s), o2 = getOrientation(seg.e);
    Orientation o3 = seg.getOrientation(s), o4 = getOrientation(e);

    //System.out.println(o1 + " " + o2 + " " + o3 + " " + o4);
    if ( (!o1.equals(o2) && !o3.equals(o4)) ||
        (o1 == Orientation.COLLINEAR && o1 == o2 && o1 == o3 && o1 == o4 && (onSegment(seg.s) || onSegment(seg.e)))
      )
      return true;
    return false;
  }

  public boolean onSegment(Point p) {
    if (p.x <= Math.max(s.x, e.x) && p.x >= Math.min(s.x, e.x) &&
        p.y <= Math.max(s.y, e.y) && p.y >= Math.min(s.y, e.y))
       return true;
    return false;
  }

  public double length() {
    return Point.distance(s, e);
  }
}