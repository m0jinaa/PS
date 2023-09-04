import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] cards;
	static int[][] dp;

	static class Node {
		int x;
		String color;

		public Node(int x, String color) {
			super();
			this.x = x;
			this.color = color;
		}

	}

	static ArrayList<Node>[] canGo;

	static int getMax(int ind, int now) {
		if (dp[ind][now] != -1) {
			return dp[ind][now];
		}
		int score = 0;

		for (Node next : canGo[now]) {
			score = Math.max(score, (next.color.equals(cards[ind]) ? 10 : 0) + getMax(ind + 1, next.x));
		}

		return dp[ind][now] = score;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		cards = new String[n];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			cards[i] = st.nextToken();
		}

		int m, k;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		Arrays.fill(dp[n], 0);

		canGo = new ArrayList[m + 1];

		for (int i = 1; i <= m; i++) {
			canGo[i] = new ArrayList<>();
		}

		int a, b;
		String c;
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = st.nextToken();
			canGo[a].add(new Node(b, c));
			canGo[b].add(new Node(a, c));
		}

		int answer = 0;

		answer = Math.max(answer, getMax(0, 1));

		System.out.println(answer);

	}
}