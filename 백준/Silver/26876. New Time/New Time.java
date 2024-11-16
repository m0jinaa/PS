import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Time {
		int h, m, c;

		public Time(int h, int m, int c) {
			super();
			this.h = h;
			this.m = m;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), ":");

		int sh = Integer.parseInt(st.nextToken());
		int sm = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), ":");

		int eh = Integer.parseInt(st.nextToken());
		int em = Integer.parseInt(st.nextToken());

		LinkedList<Time> q = new LinkedList<>();

		q.add(new Time(sh, sm, 0));

		boolean[][] v = new boolean[24][60];

		v[sh][sm] = true;

		int nh, nm;
		Time now;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.h == eh && now.m == em) {
				answer = now.c;
				break;
			}
			// 1분

			nm = now.m + 1;
			nh = (now.h + (nm / 60)) % 24;
			nm %= 60;

			if (!v[nh][nm]) {
				v[nh][nm] = true;
				q.add(new Time(nh, nm, now.c + 1));
			}
			// 1시간

			nm = now.m;
			nh = (now.h + 1) % 24;

			if (!v[nh][nm]) {
				v[nh][nm] = true;
				q.add(new Time(nh, nm, now.c + 1));
			}
		}

		System.out.println(answer);
	}
}