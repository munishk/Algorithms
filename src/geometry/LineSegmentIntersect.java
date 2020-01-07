package geometry;
/**
 * http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 * @author munishk
 *
 */
public class LineSegmentIntersect {
	
	static class Line  {
		Point p1, p2;

		public Line(Point p1, Point p2) {
			super();
			this.p1 = p1;
			this.p2 = p2;
		}
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static enum Orientatation {
		CLOCKWISE, COUNTER_CLOCKWISE, COLINEAR;
	}
	
	static Orientatation getOrientation(Point p, Point q, Point r) {
		int value = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);
		if(value == 0) {
			return Orientatation.COLINEAR;
		}
		
		return value < 0 ? Orientatation.COUNTER_CLOCKWISE : Orientatation.CLOCKWISE;
	}
	
	static boolean onSegment(Point p, Point r, Point q) {
		return (r.x <= Math.max(p.x, q.x) && r.x >= Math.min(p.x, q.x) &&(r.y <= Math.min(p.y, q.y) && r.y >= Math.min(p.y, q.y)));
	}
	
	static boolean doIntersect(Line line1, Line line2) {
		Orientatation o1 = getOrientation(line1.p1, line1.p2, line2.p1);
		Orientatation o2 = getOrientation(line1.p1, line1.p2, line2.p2);
		Orientatation o3 = getOrientation(line2.p1, line2.p2, line1.p1);
		Orientatation o4 = getOrientation(line2.p1, line2.p2, line1.p2);
		
		if(o1 != o2 && o3 != o4) {
			return true;
		}
		
		if(o1 == Orientatation.COLINEAR && onSegment(line1.p1, line2.p1, line1.p2)) {
			return true;
		}
		
		if(o2 == Orientatation.COLINEAR && onSegment(line1.p1, line2.p2, line1.p2)) {
			return true;
		}
		
		if(o3 == Orientatation.COLINEAR && onSegment(line2.p1, line1.p1, line2.p2)) {
			return true;
		}
		
		if(o4 == Orientatation.COLINEAR && onSegment(line2.p1, line1.p2, line2.p2)) {
			return true;
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		Line line1 = new Line(new Point(1,1), new Point(10,1));
		Line line2 = new Line(new Point(1,2), new Point(10,2));
		//System.out.println(doIntersect(line1, line2));
		
		System.out.println(getOrientation(new Point(2,2), new Point(8,8), new Point(5,6)));

	}

}
