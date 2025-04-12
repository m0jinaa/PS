import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final long INF = Long.MIN_VALUE;
	static int n;
	static long[] notes;
	static long[][][] dp;

	static long getMaxScore(int x, int straight, int missed) {
		if (x > n)
			return 0;
		// x번째 노트 차례이고 현재까지 straight번 연속처리, missed번연속 미스일 떼 앞으로 받을 수 있는 최대점수
		if (dp[x][straight][missed] != INF)
			return dp[x][straight][missed];

		long score = INF;

		// 현재 노트 처리
		score = Math.max(score, getMaxScore(x + 1, straight + 1, 0) + (straight + 1) * notes[x]);

		if (missed != 2) {
			// 2번연속 미스가 아니면 현재 노트 미처리 해도 됨.
			score = Math.max(score, getMaxScore(x + 1, 0, missed + 1));
		}

		return dp[x][straight][missed] = score;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		notes = new long[n + 1];
		dp = new long[n + 1][n + 1][3];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			notes[i] = Long.parseLong(st.nextToken());
			for (int j = 0; j <= n; j++) {
				Arrays.fill(dp[i][j], INF);
			}
		}

		long answer = getMaxScore(1, 0, 0);

		// 3번 미만으로 연속으로 쳤을 경우의 최댓값이 0보다 작은 경우 3번 연속으로 쳐서 0점 받는게 더 높은 점수.
		System.out.println(answer < 0 ? 0 : answer);
	}
}