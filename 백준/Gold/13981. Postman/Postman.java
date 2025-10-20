import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class House implements Comparable<House> {
		int x, m;

		public House(int x, int m) {
			super();
			this.x = x;
			this.m = m;
		}

		@Override
		public int compareTo(House h) {
			return h.x - this.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int bef = 0;

		LinkedList<House>[] way = new LinkedList[2];

		way[0] = new LinkedList<>();
		way[1] = new LinkedList<>();

		int x, m;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (x < 0) {
				way[0].add(new House(-x, m));
			} else {
				way[1].add(new House(x, m));
			}
		}

		long answer = 0;

		for (int i = 0; i < 2; i++) {
			Collections.sort(way[i]);
			bef = 0;
			for (House h : way[i]) {
				if (bef >= h.m) {
					bef -= h.m;
					continue;
				}
				answer += 2L * (int) (Math.ceil(1.0 * (h.m - bef) / k)) * h.x;
				bef = (k - ((h.m - bef) % k)) % k;
			}
		}

		System.out.println(answer);
	}
}