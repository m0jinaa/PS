import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	static String[] names;

	static class Score implements Comparable<Score> {
		String name;
		int s;

		public Score(String name, int s) {
			super();
			this.name = name;
			this.s = s;
		}

		@Override
		public int compareTo(Score score) {
			if (score.s != this.s)
				return score.s - this.s;
			else {
				return this.name.compareTo(score.name);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int p;
		int[] scores;
		int n, w;
		String name;
		int m;
		Map<String, Integer> cnt = new HashMap<>();
		Map<String, Integer> rank = new HashMap<>();
		Score[] list;
		int r, pending;
		int bef;
		LinkedList<Score> ranking = new LinkedList<>();

		for (int t = 1; t <= tc; t++) {
			ranking.clear();
			cnt.clear();
			rank.clear();

			p = Integer.parseInt(br.readLine());

			scores = new int[p];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < p; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}

			n = Integer.parseInt(br.readLine());

			list = new Score[p * n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				w = Integer.parseInt(st.nextToken());
				for (int j = 0; j < p; j++) {
					name = st.nextToken();

					list[i * p + j] = new Score(name, w * scores[j]);
				}
			}

			Arrays.sort(list);

			m = Integer.parseInt(br.readLine());

			for (Score score : list) {
				if (cnt.getOrDefault(score.name, 0) == m)
					continue;
				cnt.put(score.name, cnt.getOrDefault(score.name, 0) + 1);
				rank.put(score.name, rank.getOrDefault(score.name, 0) + score.s);
			}

			for (Entry<String, Integer> entry : rank.entrySet()) {
				ranking.add(new Score(entry.getKey(), entry.getValue()));
			}

			Collections.sort(ranking);

			r = 0;
			pending = 1;
			bef = 0;

			sb.append("Case #").append(t).append(":\n");

			for (Score score : ranking) {
				if (score.s == bef) {
					pending++;
				} else {
					r += pending;
					pending = 1;
				}

				sb.append(r).append(": ").append(score.name).append("\n");

				bef = score.s;
			}
		}

		System.out.print(sb.toString());
	}
}