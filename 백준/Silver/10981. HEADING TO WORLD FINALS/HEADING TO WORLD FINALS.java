import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Team implements Comparable<Team> {
		String univ, teamName;
		int score, penalty;

		public Team(String univ, String teamName, int score, int penalty) {
			super();
			this.univ = univ;
			this.teamName = teamName;
			this.score = score;
			this.penalty = penalty;
		}

		@Override
		public int compareTo(Team t) {
			if (this.score != t.score) {
				return t.score - this.score;
			} else {
				return this.penalty - t.penalty;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Team[] teams = new Team[n];

		String u, t;
		int s, p;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			u = st.nextToken();
			t = st.nextToken();
			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			teams[i] = new Team(u, t, s, p);
		}

		Arrays.sort(teams);

		Set<String> promoted = new HashSet<>();

		for (int i = 0; i < n && k > 0; i++) {
			if (!promoted.add(teams[i].univ))
				continue;
			k--;
			sb.append(teams[i].teamName).append("\n");
		}

		System.out.print(sb.toString());
	}
}