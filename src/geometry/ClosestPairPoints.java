package geometry;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairPoints {

	static class Point {
		double x, y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static double calculateDistance(Point p1, Point p2) {
		double xDiff = p2.x - p1.x;
		double yDiff = p2.y - p1.y;
		return Math.sqrt(yDiff * yDiff + xDiff * xDiff);

	}

	
	
	static double bruteForceMinDistance(Point[] points, int low, int high) {
		double minDist = Double.MAX_VALUE;
		for (int i = low; i < high; i++) {
			for (int j = i + 1; j <= high; j++) {
				double dist = calculateDistance(points[i], points[j]);
				if (dist < minDist) {
					minDist = dist;
				}
			}
		}
		return minDist;
	}

	static double closestPairRecur(Point[] points, int low, int high) {
		if (high - low <= 3) {
			return bruteForceMinDistance(points, low, high);
		}
		int mid = low + (high - low) / 2;
		double ld = closestPairRecur(points, low, mid);
		double rd = closestPairRecur(points, mid, high);

		double minDist = Math.min(ld, rd);

		Point[] strip = new Point[high - low + 1];
		int index = 0;
		for (int i = low; i <= high; i++) {
			if (Math.abs(points[i].x - points[mid].x) < minDist) {
				strip[index++] = points[i];
			}
		}
		return Math.min(minDist, closestStrip(strip, --index, minDist));
	}

	static double closestStrip(Point[] strip, int high, double min) {
		double minDist = min;
		for (int i = 0; i < high; i++) {
			for (int j = i + 1; j <= high; j++) {
				if (Math.abs(strip[i].y - strip[j].y) < minDist) {
					double dist = calculateDistance(strip[i], strip[j]);
					if (dist < minDist) {
						minDist = dist;
					}
				}
			}
		}
		return minDist;
	}

	public static void main(String[] args) {
		Point[] points = { new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1), new Point(12, 10),
				new Point(3, 4) };
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return (int) (o1.x - o2.x);
			}
		});

		System.out.println(closestPairRecur(points, 0, points.length - 1));
		System.out.println(bruteForceMinDistance(points, 0, points.length - 1));

	}

}
