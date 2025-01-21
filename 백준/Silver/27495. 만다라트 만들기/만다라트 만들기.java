import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Goal implements Comparable<Goal> {
		String subGoal;
		String[] details;
		int ind;

		public Goal() {
			super();
			details = new String[8];
			ind = 0;
		}

		public void setSubGoal(String sub) {
			this.subGoal = sub;
		}

		public void setDetail(String d) {
			details[ind++] = d;
		}

		public void sortDetail() {
			Arrays.sort(details);
		}

		@Override
		public int compareTo(Goal g) {
			return this.subGoal.compareTo(g.subGoal);
		}
	}

	static String[][] map;
	static Goal[] goals;

	static void check(int ind) {
		int c = ind;

		if (ind >= 4)
			c++;

		goals[ind] = new Goal();

		int x = 1 + (c / 3) * 3;
		int y = 1 + (c % 3) * 3;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					goals[ind].setSubGoal(map[x + i][y + j]);
				} else {
					goals[ind].setDetail(map[x + i][y + j]);
				}
			}
		}

		goals[ind].sortDetail();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = 9;

		map = new String[n][n];
		goals = new Goal[n - 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken();
			}
		}

		for (int i = 0; i < n - 1; i++) {
			check(i);
		}

		Arrays.sort(goals);

		for (int i = 0; i < n - 1; i++) {
			sb.append("#").append(i + 1).append(". ").append(goals[i].subGoal).append("\n");

			for (int j = 0; j < n - 1; j++) {
				sb.append("#").append(i + 1).append("-").append(j + 1).append(". ").append(goals[i].details[j])
						.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}