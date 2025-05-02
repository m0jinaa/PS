import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, t;
	static int[][] dp; // dp[x][c] : 시간 c에 위치 x에 있을 때 앞으로 남은 시간동안 고양이를 만날 수 있는 최대 횟수
	static int[] cat;
	static LinkedList<Integer>[] connectedTo;

	static int getMax(int x, int c) {
		if (c > t) {
			return 0;
		} else if (dp[x][c] != -1) {
			return dp[x][c];
		}

		int cnt = 0;

		// 현재위치 머무르기
		cnt = Math.max(cnt, getMax(x, c + 1));

		// 이동하기
		for (int y : connectedTo[x]) {
			cnt = Math.max(cnt, getMax(y, c + 1));
		}
		if (cat[c] == x)
			cnt++;

		return dp[x][c] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][t + 1];
		connectedTo = new LinkedList[n + 1];
		cat = new int[t + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], -1);
			connectedTo[i] = new LinkedList<>();
		}

		int a, b;

		// 노드 정보 저장
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connectedTo[a].add(b);
			connectedTo[b].add(a);
		}

		// 고양이 위치 저장
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= t; i++) {
			cat[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, getMax(i, 1));
		}

		System.out.println(answer);
	}
}