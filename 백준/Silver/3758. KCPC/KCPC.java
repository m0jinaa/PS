import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Team implements Comparable<Team> {
		int teamID;
		int[] scores;
		int total;
		int cnt;
		int lastTime;

		public Team(int teamID, int k) {
			super();
			this.teamID = teamID;
			this.scores = new int[k + 1];
			this.total = 0;
			this.cnt = 0;
			this.lastTime = 0;
		}

		public void solve(int p, int score, int time) {
			this.lastTime = time;
			this.cnt++;
			if (this.scores[p] < score) {
				this.total += score - this.scores[p];
				this.scores[p] = score;
			}
		}

		@Override
		public int compareTo(Team team) {
			if (this.total != team.total) {
				return team.total - this.total;
			} else if (this.cnt != team.cnt) {
				return this.cnt - team.cnt;
			} else {
				return this.lastTime - team.lastTime;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		Team[] teams;
		int n, k, t, m, i, j, s;
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken()) - 1;
			m = Integer.parseInt(st.nextToken());

			teams = new Team[n];

			for (int u = 0; u < n; u++) {
				teams[u] = new Team(u, k);
			}

			for (int u = 0; u < m; u++) {
				st = new StringTokenizer(br.readLine(), " ");

				i = Integer.parseInt(st.nextToken()) - 1;
				j = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());

				teams[i].solve(j, s, u);
			}

			Arrays.sort(teams);

			for (int u = 0; u < n; u++) {
				if (teams[u].teamID == t) {
					sb.append(u + 1).append("\n");
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}
}