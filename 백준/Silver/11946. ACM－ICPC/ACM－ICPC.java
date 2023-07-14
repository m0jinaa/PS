import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Team implements Comparable<Team> {
		int id;
		int score;
		int cnt;
		boolean[] solved;
		int[] wrong;

		public Team(int id, int p) {
			super();
			this.id = id;
			this.score = 0;
			this.cnt = 0;
			this.solved = new boolean[p + 1];
			this.wrong = new int[p + 1];
		}

		public void fail(int p) {
			if (this.solved[p])
				return;
			this.wrong[p]++;
		}

		public void solve(int t, int p) {
			if (this.solved[p])
				return;
			this.solved[p] = true;
			this.score += wrong[p] * 20 + t;
			this.cnt++;
		}

		@Override
		public int compareTo(Team team) {
			if (this.cnt != team.cnt) {
				return team.cnt - this.cnt;
			} else if (this.score != team.score) {
				return this.score - team.score;
			} else {
				return this.id - team.id;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		Team[] teams = new Team[n];

		for (int i = 1; i <= n; i++) {
			teams[i - 1] = new Team(i, m);
		}

		int t, id, p;
		String result;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			id = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			result = st.nextToken();

			switch (result) {
			case "AC":
				teams[id - 1].solve(t, p);
				break;
			default:
				teams[id - 1].fail(p);
				break;

			}
		}

		Arrays.sort(teams);

		for (Team team : teams) {
			sb.append(team.id).append(" ").append(team.cnt).append(" ").append(team.score).append("\n");
		}

		System.out.print(sb.toString());

	}
}