import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Score implements Comparable<Score> {
		String subject;
		int score;

		public Score(String subject, int score) {
			super();
			this.subject = subject;
			this.score = score;
		}

		@Override
		public int compareTo(Score s) {
			return s.score - this.score;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Set<String> mandatory = new HashSet<>();
		Map<String, Integer> subjects = new HashMap<>();

		Score[] scores = new Score[n];

		String subject;
		int score;
		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			subject = st.nextToken();
			score = Integer.parseInt(st.nextToken());

			scores[i] = new Score(subject, score);
			subjects.put(subject, score);
		}

		int min = 0;
		int max = 0;

		String name;

		for (int i = 0; i < k; i++) {
			name = br.readLine().trim();
			mandatory.add(name);
			min += subjects.get(name);
			max += subjects.get(name);

		}

		Arrays.sort(scores);

		for (int i = 0, c = m - k; i < n && c > 0; i++) {
			if (mandatory.contains(scores[i].subject))
				continue;

			max += scores[i].score;
			c--;
		}

		for (int i = n - 1, c = m - k; i >= 0 && c > 0; i--) {
			if (mandatory.contains(scores[i].subject))
				continue;
			min += scores[i].score;
			c--;
		}

		sb.append(min).append(" ").append(max);

		System.out.println(sb.toString());
	}
}