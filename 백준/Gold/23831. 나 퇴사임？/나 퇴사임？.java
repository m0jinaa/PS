import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = -1_000_000_007;
	static int n, A, B;// n: 총자습일, A: 최대요양횟수, B: 정독실,소학습실에서의 필수자습횟수
	static int[] P, Q, R, S;// 각각 정독실,소학습실,휴게실,요양일 때 얻는 만족도
	static int[][][][] dp;

	static int getMaxHappy(int x, int a, int b, int c) {
		// dp[x][a][b][c] => x일 학습했고, 요양 a번, 정독실,소학습식 b번, 연속으로 c번 휴게실일 때 앞으로 얻을 수 있는 최대
		// 만족도값
		if (x == n) {
			if (b < B) // 필수 자습 횟수 채우지 못한 경우
				return INF;
			else
				return 0;
		}
		if (dp[x][a][b][c] != -1)
			return dp[x][a][b][c];

		// 필수 자습횟수 채우지 못해서 return이 INF 경우 고려해서 INF로 해야함.
		int happy = INF;

		// a : 요양
		if (a < A) {
			happy = Math.max(happy, getMaxHappy(x + 1, a + 1, b, 0) + S[x]);
		}

		// b : 정독실&소학습실
		// 정독실과 소학습실 중 만족도가 높은쪽으로
		happy = Math.max(happy, getMaxHappy(x + 1, a, b == B ? b : (b + 1), 0) + Math.max(P[x], Q[x]));

		// c : 휴게실 자습
		// c==0 -> 직전에 휴게실에서 공부 x, c==1 -> 직전에 휴게실에서 공부 o
		if (c != 1) {
			happy = Math.max(happy, getMaxHappy(x + 1, a, b, 1) + R[x]);
		}

		return dp[x][a][b][c] = happy;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		dp = new int[n][A + 1][B + 1][2];
		P = new int[n];
		Q = new int[n];
		R = new int[n];
		S = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			P[i] = Integer.parseInt(st.nextToken());
			Q[i] = Integer.parseInt(st.nextToken());
			R[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= A; j++) {
				for (int k = 0; k <= B; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		int answer = getMaxHappy(0, 0, 0, 0);

		System.out.println(answer);
	}
}
