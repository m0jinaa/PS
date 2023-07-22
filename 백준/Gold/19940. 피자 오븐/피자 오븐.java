import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static Button[] time;
	static boolean[] v;
	static LinkedList<Button> q;

	static class Button {
		int t, addh, addt, mint, addo, mino;

		public Button(int t, int addh, int addt, int mint, int addo, int mino) {
			super();
			this.t = t;
			this.addh = addh;
			this.addt = addt;
			this.mint = mint;
			this.addo = addo;
			this.mino = mino;
		}

	}

	static boolean inRange(int x) {
		if (x < 0 || x > 60)
			return false;
		return true;
	}

	static void bfs() {
		time[0] = new Button(0, 0, 0, 0, 0, 0);
		q.add(time[0]);

		Button now;
		Button nt;

		while (!q.isEmpty()) {

			now = q.poll();

			if (!inRange(now.t) || v[now.t])
				continue;

			v[now.t] = true;
			time[now.t] = now;

			if (inRange(now.t - 1) && !v[now.t - 1]) {
				q.add(new Button(now.t - 1, now.addh, now.addt, now.mint, now.addo, now.mino + 1));
			}

			if (inRange(now.t + 1) && !v[now.t + 1]) {
				q.add(new Button(now.t + 1, now.addh, now.addt, now.mint, now.addo + 1, now.mino));
			}

			if (inRange(now.t - 10) && !v[now.t - 10]) {
				q.add(new Button(now.t - 10, now.addh, now.addt, now.mint + 1, now.addo, now.mino));
			}

			if (inRange(now.t + 10) && !v[now.t + 10]) {
				q.add(new Button(now.t + 10, now.addh, now.addt + 1, now.mint, now.addo, now.mino));
			}

			if (inRange(now.t + 60) && !v[now.t + 60]) {
				q.add(new Button(now.t + 60, now.addh + 1, now.addt, now.mint, now.addo, now.mino));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		q = new LinkedList<>();

		time = new Button[61];
		v = new boolean[61];
		bfs();

		int n;
		int h;
		int r;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			h = n / 60;
			r = n % 60;
			sb.append(time[r].addh + h).append(" ").append(time[r].addt).append(" ").append(time[r].mint).append(" ")
					.append(time[r].addo).append(" ").append(time[r].mino).append("\n");
		}

		System.out.print(sb.toString());
	}
}