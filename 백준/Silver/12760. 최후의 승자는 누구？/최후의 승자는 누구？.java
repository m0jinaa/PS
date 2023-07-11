import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] scores = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(scores[i]);
		}

		int[] score = new int[n];
		int s;

		for (int j = 0; j < m; j++) {
			s = 0;
			for (int i = 0; i < n; i++) {
				s = Math.max(s, scores[i][j]);
			}

			for (int i = 0; i < n; i++) {
				if (scores[i][j] == s) {
					score[i]++;
				}
			}
		}
		int max = 0;

		for (int x : score) {
			max = Math.max(max, x);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			if (score[i] == max) {
				sb.append(i + 1).append(" ");
			}
		}

		System.out.println(sb.toString());
	}
}