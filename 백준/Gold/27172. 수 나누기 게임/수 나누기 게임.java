import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[] exists = new boolean[1000001];

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] player = new int[n];

		for (int i = 0; i < n; i++) {
			player[i] = Integer.parseInt(st.nextToken());

			exists[player[i]] = true;
		}

		int[] score = new int[1000001];

		for (int p : player) {
			for (int j = p * 2; j < 1000001; j += p) {
				if (!exists[j])
					continue;
				score[p]++;
				score[j]--;
			}
		}

		for (int p : player) {
			sb.append(score[p]).append(" ");
		}

		System.out.println(sb.toString());
	}
}