import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MAX = 200;
		final int INF = 1_000_000_007;

		int tc = Integer.parseInt(br.readLine());

		int n;
		int[] rank;
		int[] score;
		int[] total;
		int[] fifth;
		int[] cnt;
		int r;

		int min;
		int winner;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			rank = new int[n];

			score = new int[MAX + 1];
			fifth = new int[MAX + 1];
			total = new int[MAX + 1];
			cnt = new int[MAX + 1];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				rank[i] = Integer.parseInt(st.nextToken());

				// 팀 당 몇명이서 참가했는지 체크
				total[rank[i]]++;
			}
			r = 1;

			for (int i = 0; i < n; i++) {
				if (total[rank[i]] != 6) {
					continue;
				}
				cnt[rank[i]]++;
				if (cnt[rank[i]] <= 4)
					score[rank[i]] += r;
				else if (cnt[rank[i]] == 5) {
					fifth[rank[i]] = r;
				}
				r++;
			}

			min = INF;
			winner = -1;

			for (int i = 1; i <= MAX; i++) {
				if (total[i] != 6)
					continue;
				if (min > score[i]) {
					min = score[i];
					winner = i;
				} else if (min == score[i] && fifth[winner] > fifth[i]) {
					winner = i;
				}
			}
			sb.append(winner).append("\n");
		}

		System.out.print(sb.toString());
	}
}