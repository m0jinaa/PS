import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point> {
		int x;

		public Point(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(Point p) {
			return Math.abs(this.x) - Math.abs(p.x);
		}
	}
    
    // origin에서 가까운 순으로 방문할 예정
    // 시간이 모자라면 탈출
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int t = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			points[i] = new Point(Integer.parseInt(br.readLine()));
		}

		Arrays.sort(points);

		int now = 0;

		int answer = 0;

		int d;

		for (Point p : points) {
			d = Math.abs(p.x - now);

			if (d > t)
				break;

			answer++;
			t -= d;
			now = p.x;
		}

		System.out.println(answer);
	}
}
