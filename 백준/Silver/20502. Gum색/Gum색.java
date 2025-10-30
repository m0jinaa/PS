import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] rank = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			rank[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer>[] keywords = new LinkedList[m + 1];

		for (int i = 1; i <= m; i++) {
			keywords[i] = new LinkedList<>();
		}

		int c, k;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());

			while (c-- > 0) {
				k = Integer.parseInt(st.nextToken());

				keywords[k].add(i);
			}
		}

		for (int i = 1; i <= m; i++) {
			Collections.sort(keywords[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer a, Integer b) {
					return rank[a] - rank[b];
				}
			});
		}

		int q = Integer.parseInt(br.readLine());

		while (q-- > 0) {
			k = Integer.parseInt(br.readLine());

			if (keywords[k].isEmpty()) {
				sb.append("-1\n");
			} else {
				for (int r : keywords[k]) {
					sb.append(r).append(" ");
				}

				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}