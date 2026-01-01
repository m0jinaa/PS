import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Player {
		int x, y, r, s;

		public Player(int x, int y, int r, int s) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
			this.s = s;
		}

		// 자신의 반경 이하인지 체크
		public boolean canKick(int tx, int ty) {
			int dist = (tx - this.x) * (tx - this.x) + (ty - this.y) * (ty - this.y);

			return dist <= this.r * this.r;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Player[] players = new Player[n];

		int x, y, r, s;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			players[i] = new Player(x, y, r, s);
		}

		boolean missed = false;

		int tx, ty;

		int kicker = -1;
		int kickerS;

		int answer = 0;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			// 바로 이전 공을 놓친 상태라면
			if (missed) {
				missed = false;
				continue;
			}

			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());

			kicker = -1;
			kickerS = 0;

			for (int i = 0; i < n; i++) {
				if (players[i].s > kickerS && players[i].canKick(tx, ty)) {
					kicker = i;
					kickerS = players[i].s;
				}
			}

			// 와니가 공을 찬다면?
			if (kicker == 0) {
				answer++;
			} else if (kicker == -1) {
				// 찰 수 있는 사람이 없다면?
				missed = true;
			}
		}

		System.out.println(answer);
	}
}